package com.exam.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.dto.CoursePageQueryDTO;
import com.exam.dto.CourseUpdateDTO;
import com.exam.entity.Course;
import com.exam.vo.CourseVO;

import java.util.List;

public interface CourseService extends IService<Course> {
    /**
     * 条件查询器
     * @param coursePageQueryDTO
     * @return
     */
    QueryWrapper<Course> getQueryWrapper(CoursePageQueryDTO coursePageQueryDTO);

    /**
     * 获取课程VO列表
     * @param records
     * @return
     */
    List<CourseVO> getQueryVOList(List<Course> records);

    /**
     * VO转换
     * @param course
     * @return
     */
    CourseVO getQuestionVO(Course course);

    /**
     * 更新课程信息
     * @param courseUpdateDTO
     */
    void updateOne(CourseUpdateDTO courseUpdateDTO);

    /**
     * 批量查询课程信息
     * @param collect
     * @return
     */
    List<Course> getBatchByCourseIds(List<Long> collect);
}
