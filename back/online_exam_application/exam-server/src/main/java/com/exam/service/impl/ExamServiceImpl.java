package com.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.entity.Exam;
import com.exam.mapper.ExamMapper;
import com.exam.service.ExamService;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {
}
