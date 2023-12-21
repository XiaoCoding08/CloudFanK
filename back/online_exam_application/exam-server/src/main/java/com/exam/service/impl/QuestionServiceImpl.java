package com.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.dto.AddQuestionDTO;
import com.exam.dto.QuestionPageQueryDTO;
import com.exam.dto.UpdateQuestionDTO;
import com.exam.entity.Question;
import com.exam.mapper.QuestionMapper;
import com.exam.service.QuestionService;
import com.exam.vo.QuestionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public void del(Long id) {
        this.removeById(id);
    }

    @Override
    public void updateOne(UpdateQuestionDTO updateQuestionDTO) {
        Question question = new Question();
        BeanUtils.copyProperties(updateQuestionDTO,question);
        this.updateById(question);
    }

    @Override
    public QueryWrapper<Question> getQueryWrapper(QuestionPageQueryDTO questionPageQueryDTO) {
        Integer type = questionPageQueryDTO.getType();
        Long courseId = questionPageQueryDTO.getCourseId();
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(courseId != null, "course_id", courseId);
        queryWrapper.eq(type != null, "type", type);
        return queryWrapper;
    }

    @Override
    public List<QuestionVO> getQueryVOList(List<Question> questionList) {
        return questionList.stream().map(this::getQuestionVO).collect(Collectors.toList());
    }

    @Override
    public QuestionVO getQuestionVO(Question question) {
        QuestionVO questionVO = QuestionVO.builder().build();
        BeanUtils.copyProperties(question, questionVO);
        return questionVO;
    }
}
