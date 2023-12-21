package com.exam.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.dto.ClassPageQueryDTO;
import com.exam.dto.ClassUpdateDTO;
import com.exam.entity.Classx;
import com.exam.vo.ClassVO;

import java.util.List;

public interface ClassService extends IService<Classx> {

    QueryWrapper<Classx> getQueryWrapper(ClassPageQueryDTO classPageQueryDTO);

    List<ClassVO> getQueryVOList(List<Classx> records);

    ClassVO getQuestionVO(Classx classx);

    void updateOne(ClassUpdateDTO classUpdateDTO);
}
