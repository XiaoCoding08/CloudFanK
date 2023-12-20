package com.exam.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 考试参与表(ExamStudent)实体类
 *
 * @author makejava
 * @since 2023-12-20 20:53:47
 */
@Data
public class ExamStudent implements Serializable {
    private static final long serialVersionUID = 734330958457949648L;
    /**
     * 考试号
     */
    private Long examId;
    /**
     * 学生学号
     */
    private Long studentId;
    /**
     * 答题记录
     */
    private String answer;
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

