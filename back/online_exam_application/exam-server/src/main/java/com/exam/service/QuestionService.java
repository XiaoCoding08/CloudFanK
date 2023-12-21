package com.exam.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.dto.AddQuestionDTO;
import com.exam.dto.QuestionPageQueryDTO;
import com.exam.dto.UpdateQuestionDTO;
import com.exam.entity.Question;
import com.exam.vo.QuestionVO;

import java.util.List;

public interface QuestionService extends IService<Question> {
    Long add(AddQuestionDTO addQuestionDTO);

    void del(Long id);

    void updateOne(UpdateQuestionDTO updateQuestionDTO);

    QueryWrapper<Question> getQueryWrapper(QuestionPageQueryDTO questionPageQueryDTO);

    List<QuestionVO> getQueryVOList(List<Question> questionList);

    public QuestionVO  getQuestionVO(Question question);
}
