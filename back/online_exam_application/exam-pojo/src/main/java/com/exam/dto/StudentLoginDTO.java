package com.exam.dto;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生表(Student) DTO
 *
 * @author felix
 * @since 2023-12-20 20:51:20
 */
@Data
public class StudentLoginDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 学号
     */
    @ApiModelProperty("学号")
    private Long id;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;


}

