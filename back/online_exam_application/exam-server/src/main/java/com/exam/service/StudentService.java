package com.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.dto.StudentLoginDTO;
import com.exam.dto.StudentSignUpDTO;
import com.exam.entity.Student;

public interface StudentService extends IService<Student> {
    /**
     * 学生登录
     * @param studentLoginDTO
     * @return
     */
    Student studentLogin(StudentLoginDTO studentLoginDTO);

    /**
     * 学生注册
     * @param studentSignUpDTO
     */
    void studentSignUp(StudentSignUpDTO studentSignUpDTO);
}
