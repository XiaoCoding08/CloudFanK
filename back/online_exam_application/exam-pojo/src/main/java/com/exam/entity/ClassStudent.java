package com.exam.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 班级学生表(ClassStudent)实体类
 *
 * @author makejava
 * @since 2023-12-20 20:57:29
 */
@Data
public class ClassStudent implements Serializable {
    private static final long serialVersionUID = 280426871160438338L;
    /**
     * 班级号
     */
    private Long classId;
    /**
     * 学生学号
     */
    private Long studentId;
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

