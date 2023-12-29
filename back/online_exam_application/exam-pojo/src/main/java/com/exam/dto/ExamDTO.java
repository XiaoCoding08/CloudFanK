package com.exam.dto;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * 考试表(Exam)实体类
 *
 * @author felix
 * @since 2023-12-20 20:55:29
 */
@Data
public class ExamDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 考试id
     */
    @ApiModelProperty(value = "考试id")
    private Long id;
    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private LocalDateTime startTime;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private LocalDateTime endTime;

}

