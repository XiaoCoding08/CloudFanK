package com.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.dto.ClassPageQueryDTO;
import com.exam.dto.ClassUpdateDTO;
import com.exam.entity.Classx;
import com.exam.mapper.ClassMapper;
import com.exam.service.ClassService;
import com.exam.vo.ClassVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Classx> implements ClassService {
    @Autowired
    private ClassMapper classMapper;
    @Override
    public QueryWrapper<Classx> getQueryWrapper(ClassPageQueryDTO classPageQueryDTO) {
        String name = classPageQueryDTO.getName();
        Long courseId = classPageQueryDTO.getCourseId();
        QueryWrapper<Classx> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(courseId != null, "course_id", courseId);
        queryWrapper.like(StringUtils.isNoneBlank(name), "name", name);
        return queryWrapper;
    }

    @Override
    public List<ClassVO> getQueryVOList(List<Classx> records) {
        return records.stream().map(this::getQuestionVO).collect(Collectors.toList());
    }

    @Override
    public ClassVO getQuestionVO(Classx classx) {
        ClassVO classVO = ClassVO.builder().build();
        BeanUtils.copyProperties(classx, classVO);
        return classVO;
    }

    @Override
    public void updateOne(ClassUpdateDTO classUpdateDTO) {
        Classx classx = new Classx();
        BeanUtils.copyProperties(classUpdateDTO,classx);
        this.updateById(classx);
    }

    @Override
    public List<Classx> getBatchByClassIds(List<Long> collect) {
        List<Classx> classxes = classMapper.selectBatchIds(collect);
        return classxes;
    }

    public boolean removeByCourseId(Long courseId) {
        return this.remove(new QueryWrapper<Classx>().eq("course_id", courseId));
    }
}
