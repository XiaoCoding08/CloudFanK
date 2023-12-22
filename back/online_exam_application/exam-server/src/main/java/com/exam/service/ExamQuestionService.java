package com.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.dto.ExamQuestionDTO;
import com.exam.entity.ExamQuestion;
import com.exam.vo.ExamQuestionVO;

import java.util.List;

public interface ExamQuestionService extends IService<ExamQuestion> {
    /**
     * 删除考试单条题目
     */
    public void delQuestion(ExamQuestionDTO examQuestionDTO);

    /**
     * 删除考试所有题目
     */
    public void delExam(Long examId);

    /**
     * 添加考试题目
     */
    public void addQuestion(ExamQuestionDTO examQuestionDTO);

    /**
     * 获取考试题目列表
     */
    public List<ExamQuestion> getQuestionByExamId(Long examId);
}
