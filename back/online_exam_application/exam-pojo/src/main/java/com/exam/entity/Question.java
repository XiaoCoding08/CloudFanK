package com.exam.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 题目表(Question)实体类
 *
 * @author makejava
 * @since 2023-12-20 20:52:11
 */
@Data
public class Question implements Serializable {
    private static final long serialVersionUID = 261844680071564727L;
    /**
     * 题号
     */
    private Long id;
    /**
     * 课程号
     */
    private Long courseId;
    /**
     * 题型
     */
    private Integer type;
    /**
     * 内容
     */
    private String context;
    /**
     * 图片地址
     */
    private String imageUrl;
    /**
     * 答案
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

