package com.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.constant.MessageConstant;
import com.exam.dto.StudentLoginDTO;
import com.exam.dto.StudentSignUpDTO;
import com.exam.entity.Student;
import com.exam.exception.AccountNotFoundException;
import com.exam.exception.PasswordErrorException;
import com.exam.mapper.StudentMapper;
import com.exam.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Override
    public Student studentLogin(StudentLoginDTO studentLoginDTO) {
        Long id = studentLoginDTO.getId();
        Student student = this.query().eq("id", id).one();
        if (student == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        String password = studentLoginDTO.getPassword();
        System.out.println(password);
        //密码比对
        // md5加密，然后再进行比对
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(student.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        //3、返回实体对象
        return student;
    }

    @Override
    public void studentSignUp(StudentSignUpDTO studentSignUpDTO) {
        Student student = new Student();
        //对象属性拷贝
        BeanUtils.copyProperties(studentSignUpDTO,student);
        //设置密码
        String password = studentSignUpDTO.getPassword();
        student.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        this.save(student);
    }
}
