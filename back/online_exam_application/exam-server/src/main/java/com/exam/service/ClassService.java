package com.exam.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.dto.ClassPageQueryDTO;
import com.exam.dto.ClassUpdateDTO;
import com.exam.entity.Classx;
import com.exam.vo.ClassVO;

import java.util.List;

public interface ClassService extends IService<Classx> {
    /**
     * 条件查询器
     * @param classPageQueryDTO
     * @return
     */
    QueryWrapper<Classx> getQueryWrapper(ClassPageQueryDTO classPageQueryDTO);

    /**
     * 获取班级VO列表
     * @param records
     * @return
     */
    List<ClassVO> getQueryVOList(List<Classx> records);
    /**
     * VO转换
     * @param classx
     * @return
     */
    ClassVO getQuestionVO(Classx classx);

    /**
     * 更新班级信息
     * @param classUpdateDTO
     */
    void updateOne(ClassUpdateDTO classUpdateDTO);

    /**
     * 批量查询班级信息
     * @param collect
     * @return
     */
    List<Classx> getBatchByClassIds(List<Long> collect);

    boolean removeByCourseId(Long courseId);
}
