package com.exam.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 教师登陆 VO
 *
 * @author felix
 * @since 2023-12-20 20:48:25
 */
@TableName("teacher")
@Data
public class TeacherLoginVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 工号
     */
    @ApiModelProperty("工号")
    private Long id;

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;

    /**
     * JWT
     */
    @ApiModelProperty("JWT令牌")
    private String token;
}

