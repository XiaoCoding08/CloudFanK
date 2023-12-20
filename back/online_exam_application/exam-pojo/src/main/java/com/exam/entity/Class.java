package com.exam.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 班级表(Class)实体类
 *
 * @author makejava
 * @since 2023-12-20 20:58:46
 */
@Data
public class Class implements Serializable {
    private static final long serialVersionUID = -58149187841532998L;
    /**
     * 班级号
     */
    private Long id;
    /**
     * 班级名
     */
    private String name;
    /**
     * 关联课程号
     */
    private Long courseId;
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

