package com.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.dto.TeacherLoginDTO;
import com.exam.dto.TeacherSignUpDTO;
import com.exam.entity.Teacher;

public interface TeacherService extends IService<Teacher> {
    /**
     * 教师登录
     * @param teacherLoginDTO
     * @return
     */
    Teacher teacherLogin(TeacherLoginDTO teacherLoginDTO);

    /**
     * 教师注册
     * @param teacherSignUpDTO
     */
    void teacherSignUp(TeacherSignUpDTO teacherSignUpDTO);
}
