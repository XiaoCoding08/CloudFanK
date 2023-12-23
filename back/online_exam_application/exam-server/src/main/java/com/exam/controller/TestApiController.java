package com.exam.controller;

import com.exam.result.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
@Api(tags = "测试模块")
public class TestApiController {
    @GetMapping
    public Result<String> test(){
        log.info("测试请求成功");
        return  Result.success("success");
    }
}
