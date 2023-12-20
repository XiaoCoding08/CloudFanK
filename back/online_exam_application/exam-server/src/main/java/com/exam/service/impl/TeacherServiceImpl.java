package com.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.constant.MessageConstant;
import com.exam.dto.TeacherLoginDTO;
import com.exam.dto.TeacherSignUpDTO;
import com.exam.entity.Teacher;
import com.exam.exception.AccountNotFoundException;
import com.exam.exception.PasswordErrorException;
import com.exam.mapper.TeacherMapper;
import com.exam.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Override
    public Teacher teacherLogin(TeacherLoginDTO teacherLoginDTO) {
        Long id = teacherLoginDTO.getId();
        Teacher teacher = this.query().eq("id", id).one();
        if (teacher == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        String password = teacherLoginDTO.getPassword();
        System.out.println(password);
        //密码比对
        // md5加密，然后再进行比对
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(teacher.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        //3、返回实体对象
        return teacher;
    }

    @Override
    public void teacherSignUp(TeacherSignUpDTO teacherSignUpDTO) {
        Teacher teacher = new Teacher();
        //对象属性拷贝
        BeanUtils.copyProperties(teacherSignUpDTO,teacher);
        //设置密码
        String password = teacherSignUpDTO.getPassword();
        teacher.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        this.save(teacher);
    }
}
