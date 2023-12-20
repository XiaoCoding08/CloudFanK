package com.exam.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 教师注册 DTO
 *
 * @author felix
 * @since 2023-12-20 22:48:25
 */
@Data
public class TeacherSignUpDTO {
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
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
}
