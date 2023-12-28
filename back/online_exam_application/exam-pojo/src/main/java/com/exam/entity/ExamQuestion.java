package com.exam.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * 考试题目表(ExamQuestion)实体类
 *
 * @author felix
 * @since 2023-12-20 20:54:40
 */
@TableName("exam_question")
@Data
public class ExamQuestion implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 题号
     */
    @ApiModelProperty("题号")
    private Long questionId;
    /**
     * 考试号
     */
    @ApiModelProperty("考试号")
    private Long examId;
    /**
     * 题序
     */
    @ApiModelProperty("题序")
    private Integer indexs;
    /**
     * 分数
     */
    @ApiModelProperty("分数")
    private Integer scores;
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

