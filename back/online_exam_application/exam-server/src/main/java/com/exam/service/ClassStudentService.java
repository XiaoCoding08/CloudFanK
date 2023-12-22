package com.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.dto.ClassStudentDTO;
import com.exam.entity.ClassStudent;

import java.util.List;

public interface ClassStudentService extends IService<ClassStudent> {
    /**
     * 删除班级单个学生
     * @param classStudentDelDTO
     */
    public void delStu(ClassStudentDTO classStudentDelDTO);

    /**
     * 删除整个班级学生
     * @param classId
     */
    public void delClass(Long classId);

    /**
     * 添加班级学生
     * @param classStudentDTO
     */
    public void addStudent(ClassStudentDTO classStudentDTO);

    /**
     * 获取班级学生列表
     * @param classId
     * @return
     */
    public List<Long> getStuIdByClassId(Long classId);

    /**
     * 获取学生班级列表
     * @param classId
     * @return
     */
    public List<Long> getClassIdByStuId(Long classId);
}
