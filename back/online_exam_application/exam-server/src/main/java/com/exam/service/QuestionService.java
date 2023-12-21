package com.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.dto.AddQuestionDTO;
import com.exam.entity.Question;

public interface QuestionService extends IService<Question> {
    Long add(AddQuestionDTO addQuestionDTO);
}
