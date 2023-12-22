package com.exam.controller.teacher;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.dto.AddQuestionDTO;
import com.exam.dto.QuestionPageQueryDTO;
import com.exam.dto.UpdateQuestionDTO;
import com.exam.entity.Question;
import com.exam.result.Result;
import com.exam.service.QuestionService;
import com.exam.vo.QuestionVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Slf4j
@Api(tags = "1.教师模块")
public class TcQuestionController {
    @Autowired
    private QuestionService questionService;
    @PostMapping("/addQuestion")
    @ApiOperation("新增题目")
    @ApiOperationSupport(order = 3)
    public Result<Long> teacherAddQuestion(@RequestBody AddQuestionDTO addQuestionDTO){
        Long id = questionService.add(addQuestionDTO);
        return Result.success(id);
    }
    @PostMapping("/delOneQuestion")
    @ApiOperation("删除题目")
    @ApiOperationSupport(order = 4)
    public Result teacherDelQuestion(@RequestParam(value = "id") Long id){
        questionService.del(id);
        return Result.success();
    }
    @PostMapping("/delBatchQuestions")
    @ApiOperation("批量删除题目")
    @ApiOperationSupport(order = 5)
    public Result teacherDelQuestion(@RequestParam("idList") List<Long> idList){
        questionService.removeByIds(idList);
        return Result.success();
    }
    @PostMapping("/updateQuestion")
    @ApiOperation("修改题目")
    @ApiOperationSupport(order = 6)
    public Result teacherUpdateQuestion(@RequestBody UpdateQuestionDTO updateQuestionDTO){
        questionService.updateOne(updateQuestionDTO);
        return Result.success();
    }
    @PostMapping("/queryOneQuestion")
    @ApiOperation("查询单个题目")
    @ApiOperationSupport(order = 7)
    public Result<QuestionVO> teacherQueryQuestion(@RequestParam(value = "id") Long id){
        Question question = questionService.getById(id);
        QuestionVO questionVO = QuestionVO.builder()
                .id(question.getId())
                .answer(question.getAnswer())
                .context(question.getContext())
                .courseId(question.getCourseId())
                .createTime(question.getCreateTime())
                .imageUrl(question.getImageUrl())
                .type(question.getType())
                .build();
        return Result.success(questionVO);
    }
    @PostMapping("/queryBatchQuestion")
    @ApiOperation("分页查询题目")
    @ApiOperationSupport(order = 8)
    public Result<Page<QuestionVO>> teacherQueryQuestion(@RequestBody QuestionPageQueryDTO questionPageQueryDTO){
        // 获取分页信息
        int current = questionPageQueryDTO.getPage();
        int pageSize = questionPageQueryDTO.getSize();
        Page<Question> userPage = questionService.page(new Page<>(current, pageSize),
                questionService.getQueryWrapper(questionPageQueryDTO));
        Page<QuestionVO> userVOPage = new Page<>(current, pageSize, userPage.getTotal());
        List<QuestionVO> userVOList = questionService.getQueryVOList(userPage.getRecords());
        userVOPage.setRecords(userVOList);
        return Result.success(userVOPage);
    }
}
