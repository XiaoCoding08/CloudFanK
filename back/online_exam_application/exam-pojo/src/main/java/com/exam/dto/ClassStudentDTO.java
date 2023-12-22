package com.exam.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClassStudentDTO {
    private static final long serialVersionUID = 1L;
    /**
     * 班级号
     */
    @ApiModelProperty("班级号")
    private Long classId;
    /**
     * 学生学号
     */
    @ApiModelProperty("学生学号")
    private Long studentId;
}
