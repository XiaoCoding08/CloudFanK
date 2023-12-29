package com.exam.vo;

import com.exam.entity.Exam;
import com.exam.entity.ExamQuestion;
import com.exam.entity.Question;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ExamVO {
    private static final long serialVersionUID = 1L;
    /**
     * 考题信息
     */
    @ApiModelProperty("考题信息")
    public ExamQuestion examQuestion;

    /**
     * 题目内容
     */
    @ApiModelProperty("题目内容")
    public Question question;
}
