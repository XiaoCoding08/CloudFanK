package com.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.dto.ClassExamDTO;
import com.exam.entity.ClassExam;

import java.util.List;

public interface ClassExamService extends IService<ClassExam> {

    /**
     * 删除考试单个班级
     * @param classStudentDelDTO
     */
    public void delClass(ClassExamDTO classStudentDelDTO);

    /**
     * 删除所有考试班级
     * @param examId
     */
    public void delExam(Long examId);

    /**
     * 添加考试班级
     * @param classExamDTO
     */
    public void addClass(ClassExamDTO classExamDTO);

    /**
     * 获取考试班级列表
     * @param examId
     * @return
     */
    public List<Long> getExamIdByClassId(Long examId);


    /**
     * 删除班级id所有考试
     * @param id
     */
    void removeByClassId(Long id);
}
