package com.exam.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StuClassPageQueryDTO {
    /**
     * 学生学号
     */
    @ApiModelProperty("学生学号")
    private Long studentId;
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
