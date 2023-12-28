package com.exam.vo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 题目表 VO
 *
 * @author felix
 * @since 2023-12-21 20:52:11
 */
@Data
@Builder
public class QuestionVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 题号
     */
    @ApiModelProperty("题号")
    private Long id;
    /**
     * 课程号
     */
    @ApiModelProperty("课程号")
    private Long courseId;
    /**
     * 题型
     */
    @ApiModelProperty("题型")
    private Integer type;
    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String context;
    /**
     * 图片地址
     */
    @ApiModelProperty("图片地址")
    private String imageUrl;
    /**
     * 答案
     */
    @ApiModelProperty("答案")
    private String answer;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
}

