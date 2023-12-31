package com.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.dto.CoursePageQueryDTO;
import com.exam.dto.CourseUpdateDTO;
import com.exam.entity.Course;
import com.exam.mapper.CourseMapper;
import com.exam.service.CourseService;
import com.exam.vo.CourseVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public QueryWrapper<Course> getQueryWrapper(CoursePageQueryDTO coursePageQueryDTO) {
        String name = coursePageQueryDTO.getName();
        Long createUser = coursePageQueryDTO.getCreateUser();
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(createUser != null, "create_user", createUser);
        queryWrapper.like(StringUtils.isNoneBlank(name), "name", name);
        return queryWrapper;
    }

    @Override
    public List<CourseVO> getQueryVOList(List<Course> records) {
        return records.stream().map(this::getQuestionVO).collect(Collectors.toList());
    }

    @Override
    public CourseVO getQuestionVO(Course course) {
        CourseVO courseVO = CourseVO.builder().build();
        BeanUtils.copyProperties(course, courseVO);
        return courseVO;
    }

    @Override
    public void updateOne(CourseUpdateDTO courseUpdateDTO) {
        Course course = new Course();
        BeanUtils.copyProperties(courseUpdateDTO,course);
        this.updateById(course);
    }

    @Override
    public List<Course> getBatchByCourseIds(List<Long> collect) {
        List<Course> course = courseMapper.selectBatchIds(collect);
        return course;
    }
}
