package com.exam.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CourseUpdateDTO {
    private static final long serialVersionUID = 1L;
    /**
     * 课程号
     */
    @ApiModelProperty(value = "课程号")
    private Long id;
    /**
     * 课程名
     */
    @ApiModelProperty(value = "课程名")
    private String name;
    /**
     * 关联课程号
     */
    @ApiModelProperty(value = "关联教师号")
    private Long createUser;
}
