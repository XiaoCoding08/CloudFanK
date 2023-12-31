package com.exam.controller.student;

import com.aliyuncs.kms.transform.v20160120.CreateAliasResponseUnmarshaller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exam.dto.ExamStudentDTO;
import com.exam.entity.Exam;
import com.exam.entity.ExamQuestion;
import com.exam.entity.ExamStudent;
import com.exam.entity.Question;
import com.exam.result.Result;
import com.exam.service.*;
import com.exam.vo.ExamVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
@Slf4j
@Api(tags = "2.学生模块")
public class StuExamController {
    @Autowired
    private ExamStudentService examStudentService;
    @Autowired
    private ClassExamService classExamService;
    @Autowired
    private ExamQuestionService examQuestionService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private ExamService examService;
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 考试提交
     */
    @PostMapping("/submit")
    @ApiOperation("考试提交")
    @ApiOperationSupport(order = 6)
    public void submit(@RequestBody ExamStudentDTO examStudentDTO) {
        if(examStudentDTO.getStudentId() ==null||examStudentDTO.getExamId()==null){
            return;
        }
        QueryWrapper<ExamStudent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id", examStudentDTO.getStudentId())
               .eq("exam_id", examStudentDTO.getExamId());
        if(examStudentService.list(queryWrapper)!=null){
            examStudentService.addStu(examStudentDTO);
        }
    }
    /**
     * 查询考试是否开始
     */
    @PostMapping("/queryExamIsStart")
    @ApiOperation("查询考试是否开始")
    @ApiOperationSupport(order = 5)
    public Result queryExamIsStart(@RequestParam(value = "id") Long examId) {
        //查询考试是否开始
        Object start = redisTemplate.opsForValue().get("Exam:"+examId);
        if(start==null){
            return Result.error("考试已经结束或未开始");
        }else{
            return Result.success();
        }
    }
    /**
     * 获取考试内容
     */
    @PostMapping("/getExamInfo")
    @ApiOperation("获取考试内容")
    @ApiOperationSupport(order = 7)
    public Result<List<ExamVO>> getExamInfo(Long examId) {
        QueryWrapper<ExamQuestion> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("exam_id", examId);
        List<ExamQuestion> examQuestionList = examQuestionService.list(queryWrapper);
        List<ExamVO> examVOList = new ArrayList<>();
        for(ExamQuestion examQuestion:examQuestionList){
            ExamVO examVO = new ExamVO();
            if(examQuestion.getQuestionId()==null){
                continue;
            }
            Question question = questionService.getById(examQuestion.getQuestionId());
            examVO.setExamQuestion(examQuestion);
            examVO.setQuestion(question);
            examVOList.add(examVO);
        }
        return Result.success(examVOList);
    }
    /**
     * 查询班级考试
     */
    @PostMapping("/queryClassExam")
    @ApiOperation("查询班级考试")
    @ApiOperationSupport(order = 8)
    public Result<List<Exam>> queryExam(@RequestParam(value = "classId") Long classId){
        List<Long> examList = classExamService.getExamIdByClassId(classId);
        List<Exam> stuExam = new ArrayList<>();
        for (Long i:examList){
            Exam exam = examService.getById(i);
            stuExam.add(exam);
        }
        return Result.success(stuExam);
    }
    /**
     * 查询考试结果详情
     */
    @PostMapping("/queryExamsScore")
    @ApiOperation("查询考试结果详情")
    @ApiOperationSupport(order = 9)
    public Result<ExamStudent> queryScore(@RequestBody ExamStudentDTO examStudentDTO){
        QueryWrapper <ExamStudent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id", examStudentDTO.getStudentId())
                .eq("exam_id", examStudentDTO.getExamId());
        ExamStudent examStudent = examStudentService.getOne(queryWrapper);
        return Result.success(examStudent);
    }
}
