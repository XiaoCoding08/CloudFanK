package com.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exam.entity.ExamStudent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamStudentMapper extends BaseMapper<ExamStudent> {
}
