package com.exam.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * 题目表(Question)实体类
 *
 * @author felix
 * @since 2023-12-20 20:52:11
 */
@TableName("question")
@Data
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 题号
     */
    @ApiModelProperty("题号")
    private Long id;
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
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;
    /**
     * 是否删除（0 - 未删除，1 - 删除）
     */
    @TableLogic
    @ApiModelProperty("是否删除（0 - 未删除，1 - 删除）")
    private Integer isDelete;

}

