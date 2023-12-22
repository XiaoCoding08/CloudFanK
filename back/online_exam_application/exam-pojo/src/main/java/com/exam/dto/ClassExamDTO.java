package com.exam.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClassExamDTO {
    private static final long serialVersionUID = 1L;
    /**
     * 班级号
     */
    @ApiModelProperty(value = "班级号")
    private Long classId;
    /**
     * 考试号
     */
    @ApiModelProperty(value = "考试号")
    private Long examId;
}
