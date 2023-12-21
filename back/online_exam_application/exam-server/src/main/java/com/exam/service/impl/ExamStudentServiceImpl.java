package com.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.entity.ExamStudent;
import com.exam.mapper.ExamStudentMapper;
import com.exam.service.ExamStudentService;
import org.springframework.stereotype.Service;

@Service
public class ExamStudentServiceImpl extends ServiceImpl<ExamStudentMapper, ExamStudent> implements ExamStudentService {
}
