package com.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.dto.ClassStudentDTO;
import com.exam.entity.ClassStudent;
import com.exam.mapper.ClassStudentMapper;
import com.exam.service.ClassStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassStudentServiceImpl extends ServiceImpl<ClassStudentMapper, ClassStudent> implements ClassStudentService {


    @Override
    public void delStu(ClassStudentDTO classStudentDelDTO) {
        Long classId = classStudentDelDTO.getClassId();
        Long studentId = classStudentDelDTO.getStudentId();
        QueryWrapper<ClassStudent> queryWrapper = new QueryWrapper<>();
        if (classId!=null && studentId!=null){
            queryWrapper.eq("student_id", studentId);
            queryWrapper.eq("class_id", classId);
            this.remove(queryWrapper);
        }
    }

    @Override
    public void delClass(Long classId) {
        QueryWrapper<ClassStudent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("class_id",classId);
        this.remove(queryWrapper);
    }

    @Override
    public void addStudent(ClassStudentDTO classStudentDTO) {
        ClassStudent classStudent = new ClassStudent();
        BeanUtils.copyProperties(classStudentDTO, classStudent);
        this.save(classStudent);
    }

    @Override
    public List<Long> getStuIdByClassId(Long classId) {
        // 查询班级下所有学生
        QueryWrapper<ClassStudent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("class_id", classId);
        List<ClassStudent> classStudents = this.list(queryWrapper);
        List<Long> stuIds = classStudents.stream().map(ClassStudent::getStudentId).collect(Collectors.toList());
        return stuIds;
    }
}
