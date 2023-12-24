package com.exam.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.security.cert.CertPathBuilder;

@Data
@Builder
public class CourseVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 课程号
     */
    @ApiModelProperty(value = "课程号")
    private Long id;
    /**
     * 课程名
     */
    @ApiModelProperty(value = "课程名")
    private String name;
    /**
     * 关联教师号
     */
    @ApiModelProperty(value = "关联教师号")
    private Long teacherId;


}
