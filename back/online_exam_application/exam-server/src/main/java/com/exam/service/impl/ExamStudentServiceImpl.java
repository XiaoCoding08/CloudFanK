package com.exam.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.dto.ExamStudentDTO;
import com.exam.entity.ExamStudent;
import com.exam.mapper.ExamStudentMapper;
import com.exam.service.ExamStudentService;
import com.exam.vo.ExamStudentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamStudentServiceImpl extends ServiceImpl<ExamStudentMapper, ExamStudent> implements ExamStudentService {
    @Override
    public void delStu(ExamStudentDTO examStudentDTO) {
        QueryWrapper<ExamStudent> queryWrapper = new QueryWrapper<>();
        Long studentId = examStudentDTO.getStudentId();
        Long examId = examStudentDTO.getExamId();
        if (studentId!=null&&examId!=null){
            queryWrapper.eq("student_id",studentId);
            queryWrapper.eq("exam_id",examId);
            this.remove(queryWrapper);
        }
    }

    @Override
    public void delExam(Long examId) {
        QueryWrapper<ExamStudent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(examId!=null,"exam_id",examId);
        this.remove(queryWrapper);
    }

    @Override
    public void addStu(ExamStudentDTO examStudentDTO) {
        ExamStudent examStudent = new ExamStudent();
        BeanUtils.copyProperties(examStudentDTO,examStudent);
        this.save(examStudent);
    }

    @Override
    public List<ExamStudentVO> getStuByExamId(Long examId) {
        QueryWrapper<ExamStudent> queryWrapper = new QueryWrapper<>();
        //根据考试id查询
        queryWrapper.eq(examId!=null,"exam_id",examId);
        List<ExamStudent> examStudents = this.list(queryWrapper);
        List<ExamStudentVO> examStudentVOS = examStudents.stream().map(this::getExamStudentVO).collect(Collectors.toList());
        return examStudentVOS;
    }

    @Override
    public ExamStudentVO getExamStudentVO(ExamStudent examStudent) {
        return examStudent==null?null:BeanUtil.copyProperties(examStudent,ExamStudentVO.class);
    }
}
