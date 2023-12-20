package com.exam.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 学生表(Student)实体类
 *
 * @author makejava
 * @since 2023-12-20 20:51:20
 */
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = -37122231005235957L;
    /**
     * 学号
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否删除（0 - 未删除，1 - 删除）
     */
    private Integer isDelete;

}

