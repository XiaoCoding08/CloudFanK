package com.exam.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClassPageQueryDTO {
    /**
     * 关联课程号
     */
    @ApiModelProperty("关联课程号")
    private Long courseId;
    /**
     * 班级名
     */
    @ApiModelProperty("班级名")
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
