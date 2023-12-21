package com.exam.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddClassDTO {
    /**
     * 班级名
     */
    @ApiModelProperty(value = "班级名")
    private String name;
    /**
     * 关联课程号
     */
    @ApiModelProperty(value = "关联课程号")
    private Long courseId;
}
