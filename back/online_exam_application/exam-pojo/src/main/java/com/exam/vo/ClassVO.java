package com.exam.vo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 班级表(Class) VO
 *
 * @author felix
 * @since 2023-12-20 20:58:46
 */
@Data
@Builder
public class ClassVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 班级号
     */
    @ApiModelProperty(value = "班级号")
    private Long id;
    /**
     * 班级名
     */
    @ApiModelProperty(value = "班级名")
    private String name;
    /**
     * 关联课程号
     */
    @ApiModelProperty(value = "关联课程号")
    private Long courseId;

}

