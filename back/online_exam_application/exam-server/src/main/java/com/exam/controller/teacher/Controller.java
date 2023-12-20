package com.exam.controller.teacher;

import com.exam.constant.JwtClaimsConstant;
import com.exam.dto.TeacherLoginDTO;
import com.exam.dto.TeacherSignUpDTO;
import com.exam.entity.Teacher;
import com.exam.properties.JwtProperties;
import com.exam.result.Result;
import com.exam.service.TeacherService;
import com.exam.utils.JwtUtil;
import com.exam.vo.TeacherLoginVO;
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
@RequestMapping("/teacher")
@Slf4j
@Api(tags = "1.教师模块")
public class Controller {
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private TeacherService teacherService;
    /**
     * 教师登陆
     * @param teacherLoginDTO
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("教师登陆")
    @ApiOperationSupport(order = 1)
    public Result<TeacherLoginVO> teacherLogin(@RequestBody TeacherLoginDTO teacherLoginDTO) {
        log.info("员工登录：{}", teacherLoginDTO);

        Teacher teacher = teacherService.teacherLogin(teacherLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, teacher.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        TeacherLoginVO teacherLoginVO = TeacherLoginVO.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .token(token)
                .build();

        return Result.success(teacherLoginVO);
    }

    @PostMapping("/signUp")
    @ApiOperation("教师注册")
    @ApiOperationSupport(order = 2)
    public Result<Object> teacherSignup(@RequestBody TeacherSignUpDTO teacherSignUpDTO){
        teacherService.teacherSignUp(teacherSignUpDTO);
        return Result.success();
    }
}
