package com.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.dto.ExamQuestionDTO;
import com.exam.entity.ExamQuestion;
import com.exam.mapper.ExamQuestionMapper;
import com.exam.service.ExamQuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamQuestionServiceImpl extends ServiceImpl<ExamQuestionMapper, ExamQuestion> implements ExamQuestionService {
    @Override
    public void delQuestion(ExamQuestionDTO examQuestionDTO) {
        QueryWrapper<ExamQuestion> queryWrapper = new QueryWrapper<>();
        Long questionId = examQuestionDTO.getQuestionId();
        Long examId = examQuestionDTO.getExamId();
        if (questionId != null && examId != null){
            queryWrapper.eq("question_id",questionId).eq("exam_id",examId);
            this.remove(queryWrapper);
        }
    }

    @Override
    public void delExam(Long examId) {
        QueryWrapper<ExamQuestion> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("exam_id",examId);
        this.remove(queryWrapper);
    }

    @Override
    public void addQuestion(ExamQuestionDTO examQuestionDTO) {
        ExamQuestion examQuestion = new ExamQuestion();
        BeanUtils.copyProperties(examQuestionDTO,examQuestion);
        this.save(examQuestion);
    }

    @Override
    public List<ExamQuestion> getQuestionByExamId(Long examId) {
        QueryWrapper<ExamQuestion> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("exam_id",examId);
        return this.list(queryWrapper);
    }
}
