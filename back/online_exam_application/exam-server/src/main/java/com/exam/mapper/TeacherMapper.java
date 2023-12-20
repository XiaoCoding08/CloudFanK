package com.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exam.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
}
