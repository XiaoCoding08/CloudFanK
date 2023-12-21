package com.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.dto.AddQuestionDTO;
import com.exam.entity.Question;
import com.exam.mapper.QuestionMapper;
import com.exam.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {
    @Override
    public Long add(AddQuestionDTO addQuestionDTO) {
        Question question = new Question();
        // 属性拷贝
        BeanUtils.copyProperties(addQuestionDTO,question);
        // 插入数据库
        this.save(question);
        return question.getId();
    }
}
