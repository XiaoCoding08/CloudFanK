package com.exam.controller.teacher;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exam.dto.AddClassExamDTO;
import com.exam.dto.ClassExamDTO;
import com.exam.dto.ExamDTO;
import com.exam.dto.ExamQuestionDTO;
import com.exam.entity.ClassExam;
import com.exam.entity.Exam;
import com.exam.entity.ExamQuestion;
import com.exam.entity.Question;
import com.exam.result.Result;
import com.exam.service.ClassExamService;
import com.exam.service.ExamQuestionService;
import com.exam.service.ExamService;
import com.exam.service.QuestionService;
import com.exam.vo.ExamVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teacher")
@Slf4j
@Api(tags = "1.教师模块")
public class TcExamController {
    @Autowired
    private ExamService examService;
    @Autowired
    private ExamQuestionService examQuestionService;
    @Autowired
    private ClassExamService classExamService;
    @Autowired
    private QuestionService questionService;
    /**
     * 添加考试
     * @return
     */
    @PostMapping("/addExam")
    @ApiOperation("添加考试")
    @ApiOperationSupport(order = 21)
    public Result<Long> addExam(@RequestBody AddClassExamDTO addClassExamDTO){
        Exam exam = new Exam();
        exam.setStartTime(addClassExamDTO.getStartTime());
        exam.setEndTime(addClassExamDTO.getEndTime());
        examService.save(exam);
        ClassExam classExam = new ClassExam();
        classExam.setExamId(exam.getId());
        classExam.setClassId(addClassExamDTO.getClassId());
        classExamService.save(classExam);
        return Result.success();
    }
    /**
     * 删除考试
     */
    @PostMapping("/delExam")
    @ApiOperation("删除考试")
    @ApiOperationSupport(order = 22)
    public Result delExam(@RequestBody ExamDTO examDTO){
        examService.removeById(examDTO.getId());
        return Result.success();
    }
    /**
     * 添加试题
     */
    @PostMapping("/addExamQuestion")
    @ApiOperation("添加试题")
    @ApiOperationSupport(order = 23)
    public Result addQuestion(@RequestBody ExamQuestionDTO examQuestionDTO){
        examQuestionService.addQuestion(examQuestionDTO);
        return Result.success();
    }
    /**
     * 删除试题
     */
    @PostMapping("/delQuestion")
    @ApiOperation("删除试题")
    @ApiOperationSupport(order = 24)
    public Result delQuestion(@RequestBody ExamQuestionDTO examQuestionDTO){
        examQuestionService.delQuestion(examQuestionDTO);
        return Result.success();
    }
    /**
     * 删除考试班级
     */
    @PostMapping("/delClassExam")
    @ApiOperation("删除考试班级")
    @ApiOperationSupport(order = 25)
    public Result delClassExam(@RequestBody ClassExamDTO classExamDTO){
        QueryWrapper<ClassExam> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("class_id", classExamDTO.getClassId());
        queryWrapper.eq("exam_id", classExamDTO.getExamId());
        classExamService.remove(queryWrapper);
        return Result.success();
    }
    @PostMapping("/queryClassExam")
    @ApiOperation("查询班级考试")
    @ApiOperationSupport(order = 8)
    public Result<List<Exam>> queryExam(@RequestParam(value = "classId") Long classId){
        List<Long> examList = classExamService.getExamIdByClassId(classId);
        List<Exam> stuExam = new ArrayList<>();
        for (Long i:examList){
            Exam exam = examService.getById(i);
            if (exam == null){
                continue;
            }
            stuExam.add(exam);
        }
        return Result.success(stuExam);
    }
    /**
     * 查询考试班级
     */
    @PostMapping("/queryExamClass")
    @ApiOperation("查询考试班级")
    @ApiOperationSupport(order = 27)
    public Result<List<Long>> queryClassExam(@RequestParam(value = "examId") Long examId){
        List<ClassExam> classExam = classExamService.list(new QueryWrapper<ClassExam>().eq("class_id", examId));
        List<Long> classIds = classExam.stream().map(ClassExam::getClassId).collect(Collectors.toList());
        return Result.success(classIds);
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
}
