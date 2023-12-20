package com.exam.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 班级考试表(ClassExam)实体类
 *
 * @author makejava
 * @since 2023-12-20 20:58:17
 */
@Data
public class ClassExam implements Serializable {
    private static final long serialVersionUID = -56626926424355103L;
    /**
     * 班级号
     */
    private Long classId;
    /**
     * 考试号
     */
    private Long examId;
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

