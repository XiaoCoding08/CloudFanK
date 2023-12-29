package com.exam.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CoursePageQueryDTO {
    private static final long serialVersionUID = 1L;
    /**
     * 关联教师号
     */
    @ApiModelProperty("关联教师号")
    private Long createUser;
    /**
     * 课程名
     */
    @ApiModelProperty("课程名")
    private String name;

    /**
     * 页码
     */
    @ApiModelProperty("页码")
    private int page;
    /**
     * 页面大小
     */
    @ApiModelProperty("页面大小")
    private int size;
}
