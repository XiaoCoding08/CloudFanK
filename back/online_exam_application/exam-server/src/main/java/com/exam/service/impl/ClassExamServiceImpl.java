package com.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.dto.ClassExamDTO;
import com.exam.entity.ClassExam;
import com.exam.mapper.ClassExamMapper;
import com.exam.service.ClassExamService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassExamServiceImpl extends ServiceImpl<ClassExamMapper, ClassExam> implements ClassExamService {
    @Override
    public void delClass(ClassExamDTO classStudentDelDTO) {
        //删除班级
        QueryWrapper<ClassExam> queryWrapper = new QueryWrapper<>();
        Long classId = classStudentDelDTO.getClassId();
        Long examId = classStudentDelDTO.getExamId();
        if(classId!=null&&examId!=null){
            queryWrapper.eq("class_id",classId);
            queryWrapper.eq("exam_id",examId);
            this.remove(queryWrapper);
        }
    }

    @Override
    public void delExam(Long examId) {
        //删除考试
        QueryWrapper<ClassExam> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("exam_id",examId);
        this.remove(queryWrapper);
    }

    @Override
    public void addClass(ClassExamDTO classExamDTO) {
        ClassExam classExam = new ClassExam();
        BeanUtils.copyProperties(classExamDTO,classExam);
        this.save(classExam);
    }

    @Override
    public List<Long> getStuIdByClassId(Long examId) {
        QueryWrapper<ClassExam> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("exam_id",examId);
        List<ClassExam> classExamList = this.list(queryWrapper);
        List<Long> classList = classExamList.stream().map(ClassExam::getExamId).collect(Collectors.toList());
        return classList;
    }
}
