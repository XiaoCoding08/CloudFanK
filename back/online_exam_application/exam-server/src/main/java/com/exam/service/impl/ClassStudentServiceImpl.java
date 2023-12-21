package com.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.entity.ClassStudent;
import com.exam.mapper.ClassStudentMapper;
import com.exam.service.ClassStudentService;
import org.springframework.stereotype.Service;

@Service
public class ClassStudentServiceImpl extends ServiceImpl<ClassStudentMapper, ClassStudent> implements ClassStudentService {
}
