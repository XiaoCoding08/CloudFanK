package com.exam.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 课程表(Course)实体类
 *
 * @author makejava
 * @since 2023-12-20 20:56:15
 */
@Data
public class Course implements Serializable {
    private static final long serialVersionUID = -70891235332138523L;
    /**
     * 课程号
     */
    private Long id;
    /**
     * 课程名
     */
    private String name;
    /**
     * 教师工号
     */
    private Long createUser;
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

