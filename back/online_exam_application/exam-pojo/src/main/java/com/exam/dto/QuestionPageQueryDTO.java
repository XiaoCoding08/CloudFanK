package com.exam.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QuestionPageQueryDTO {
    private static final long serialVersionUID = 1L;
    /**
     * 课程号
     */
    @ApiModelProperty("课程号")
    private Long courseId;
    /**
     * 题型
     */
    @ApiModelProperty("题型")
    private Integer type;

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
