package com.exam.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 教师登陆 DTO
 *
 * @author felix
 * @since 2023-12-20 20:48:25
 */
@TableName("teacher")
@Data
public class TeacherLoginDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 工号
     */
    @ApiModelProperty("工号")
    private Long id;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
}

