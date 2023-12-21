package com.exam.controller.teacher;

import com.exam.dto.AddQuestionDTO;
import com.exam.mapper.QuestionMapper;
import com.exam.result.Result;
import com.exam.service.QuestionService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
@Slf4j
@Api(tags = "1.教师模块")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @PostMapping("/addQuestion")
    @ApiOperation("新增题目")
    @ApiOperationSupport(order = 3)
    public Result<Long> teacherAddQuestion(@RequestBody AddQuestionDTO addQuestionDTO){
        Long id = questionService.add(addQuestionDTO);
        return Result.success(id);
    }
}
