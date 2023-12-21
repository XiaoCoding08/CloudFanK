package com.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.entity.ExamQuestion;
import com.exam.mapper.ExamQuestionMapper;
import com.exam.service.ExamQuestionService;
import org.springframework.stereotype.Service;

@Service
public class ExamQuestionServiceImpl extends ServiceImpl<ExamQuestionMapper, ExamQuestion> implements ExamQuestionService {
}
