package com.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.entity.ClassExam;
import com.exam.mapper.ClassExamMapper;
import com.exam.service.ClassExamService;
import org.springframework.stereotype.Service;

@Service
public class ClassExamServiceImpl extends ServiceImpl<ClassExamMapper, ClassExam> implements ClassExamService {
}
