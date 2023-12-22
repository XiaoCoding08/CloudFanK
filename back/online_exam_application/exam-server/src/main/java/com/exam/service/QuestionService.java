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
    /**
     * 添加单条题目
     * @param addQuestionDTO
     * @return
     */
    Long add(AddQuestionDTO addQuestionDTO);

    /**
     * 删除单条题目
     * @param id
     */
    void del(Long id);

    /**
     * 更新题目
     * @param updateQuestionDTO
     */
    void updateOne(UpdateQuestionDTO updateQuestionDTO);

    /**
     * 条件查询器
     * @param questionPageQueryDTO
     * @return
     */

    QueryWrapper<Question> getQueryWrapper(QuestionPageQueryDTO questionPageQueryDTO);

    /**
     * 获取题目列表
     * @param questionList
     * @return
     */
    List<QuestionVO> getQueryVOList(List<Question> questionList);

    /**
     * VO转换
     * @param question
     * @return
     */
    public QuestionVO  getQuestionVO(Question question);
}
