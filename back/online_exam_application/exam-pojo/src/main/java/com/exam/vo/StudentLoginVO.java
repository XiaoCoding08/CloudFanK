package com.exam.vo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生表(Student) VO
 *
 * @author felix
 * @since 2023-12-20 20:51:20
 */
@Builder
@Data
public class StudentLoginVO implements Serializable {
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
     * JWT
     */
    @ApiModelProperty("JWT令牌")
    private String token;

}

