package com.exam.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * 教师表(Teacher)实体类
 *
 * @author felix
 * @since 2023-12-20 20:48:25
 */
@TableName("teacher")
@Data
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 工号
     */
    @ApiModelProperty("工号")
    private Long id;
    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
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

