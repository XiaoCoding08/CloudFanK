package com.exam.controller.student;

import com.exam.constant.JwtClaimsConstant;
import com.exam.dto.StudentLoginDTO;
import com.exam.dto.StudentSignUpDTO;
import com.exam.entity.Student;
import com.exam.properties.JwtProperties;
import com.exam.result.Result;
import com.exam.service.StudentService;
import com.exam.utils.JwtUtil;
import com.exam.vo.StudentLoginVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
@Slf4j
@Api(tags = "2.学生模块")
public class StudentController {
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private StudentService studentService;
    /**
     * 教师登陆
     * @param studentLoginDTO
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("学生登陆")
    @ApiOperationSupport(order = 1)
    public Result<StudentLoginVO> studentLogin(@RequestBody StudentLoginDTO studentLoginDTO) {
        log.info("学生登录：{}", studentLoginDTO);
        Student student = studentService.studentLogin(studentLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, student.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        StudentLoginVO studentLoginVO = StudentLoginVO.builder()
                .id(student.getId())
                .name(student.getName())
                .token(token)
                .build();

        return Result.success(studentLoginVO);
    }

    @PostMapping("/signUp")
    @ApiOperation("学生注册")
    @ApiOperationSupport(order = 2)
    public Result<Object> studentSignup(@RequestBody StudentSignUpDTO studentSignUpDTO){
        studentService.studentSignUp(studentSignUpDTO);
        return Result.success();
    }
}
