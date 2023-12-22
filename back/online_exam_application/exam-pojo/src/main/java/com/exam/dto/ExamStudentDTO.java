package com.exam.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ExamStudentDTO {
    private static final long serialVersionUID = 1L;
    /**
     * 考试号
     */
    @ApiModelProperty("考试号")
    private Long examId;
    /**
     * 学生学号
     */
    @ApiModelProperty("学生学号")
    private Long studentId;
    /**
     * 答题记录
     */
    @ApiModelProperty("答题记录")
    private String answer;
    /**
     * 分数
     */
    @ApiModelProperty("成绩")
    private Integer scores;
}
