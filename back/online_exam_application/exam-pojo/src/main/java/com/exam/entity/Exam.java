package com.exam.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 考试表(Exam)实体类
 *
 * @author felix
 * @since 2023-12-20 20:55:29
 */
@TableName("exam")
@Data
public class Exam implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 考试号
     */
    @ApiModelProperty(value = "考试号")
    private Long id;
    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * 是否删除（0 - 未删除，1 - 删除）
     */
    @TableLogic
    @ApiModelProperty(value = "是否删除（0 - 未删除，1 - 删除）")
    private Integer isDelete;

}

