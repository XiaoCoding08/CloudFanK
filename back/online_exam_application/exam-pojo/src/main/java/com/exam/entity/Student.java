package com.exam.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 学生表(Student)实体类
 *
 * @author felix
 * @since 2023-12-20 20:51:20
 */
@TableName("student")
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 学号
     */
    @ApiModelProperty("学号")
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
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;
    /**
     * 是否删除（0 - 未删除，1 - 删除）
     */
    @TableLogic
    @ApiModelProperty("是否删除（0 - 未删除，1 - 删除）")
    private Integer isDelete;

}

