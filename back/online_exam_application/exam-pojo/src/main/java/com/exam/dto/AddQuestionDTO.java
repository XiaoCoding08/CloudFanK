package com.exam.dto;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 新增题目 DTO
 *
 * @author felix
 * @since 2023-12-20 20:52:11
 */
@Data
public class AddQuestionDTO implements Serializable {
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
     * 内容
     */
    @ApiModelProperty("内容")
    private String context;
    /**
     * 图片地址
     */
    @ApiModelProperty("图片地址")
    private String imageUrl;
    /**
     * 答案
     */
    @ApiModelProperty("答案")
    private String answer;

}

