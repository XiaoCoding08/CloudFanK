package com.exam.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 学生表(Student) DTO
 *
 * @author felix
 * @since 2023-12-20 20:51:20
 */
@Data
public class StudentSignUpDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 学号
     */
    @ApiModelProperty("学号")
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

