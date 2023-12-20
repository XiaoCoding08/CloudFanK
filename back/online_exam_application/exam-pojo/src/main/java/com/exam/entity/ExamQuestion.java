package com.exam.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 考试题目表(ExamQuestion)实体类
 *
 * @author makejava
 * @since 2023-12-20 20:54:40
 */
@Data
public class ExamQuestion implements Serializable {
    private static final long serialVersionUID = 104755126561725886L;
    /**
     * 题号
     */
    private Long questionId;
    /**
     * 考试号
     */
    private Long examId;
    /**
     * 题序
     */
    private Integer indexs;
    /**
     * 分数
     */
    private Integer scores;
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

