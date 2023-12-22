package com.exam.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ExamQuestionVO {
    private static final long serialVersionUID = 1L;
    /**
     * 题号
     */
    @ApiModelProperty("题号")
    private Long questionId;
    /**
     * 考试号
     */
    @ApiModelProperty("考试号")
    private Long examId;
    /**
     * 题序
     */
    @ApiModelProperty("题序")
    private Integer indexs;
    /**
     * 分数
     */
    @ApiModelProperty("分数")
    private Integer scores;
}
