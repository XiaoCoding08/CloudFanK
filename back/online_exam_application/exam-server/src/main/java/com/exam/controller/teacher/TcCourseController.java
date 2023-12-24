package com.exam.controller.teacher;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.dto.*;
import com.exam.entity.Course;
import com.exam.result.Result;
import com.exam.service.ClassService;
import com.exam.service.CourseService;
import com.exam.vo.CourseVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Slf4j
@Api(tags = "1.教师模块")
public class TcCourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private ClassService classService;

    @PostMapping("/addCourse")
    @ApiOperation("新增课程")
    @ApiOperationSupport(order = 9)
    public Result<Long> teacherAddCourse(@RequestBody AddCourseDTO addCourseDTO){
        Course course = new Course();
        BeanUtils.copyProperties(addCourseDTO,course);
        System.out.println(course);
        courseService.save(course);
        return Result.success(course.getId());
    }
    @PostMapping("/delOneCourse")
    @ApiOperation("删除课程")
    @ApiOperationSupport(order = 10)
    public Result teacherDelClass(@RequestParam(value = "id") Long id){
        // todo 删除班级
        courseService.removeById(id);
        return Result.success();
    }
    @PostMapping("/delBatchCourse")
    @ApiOperation("批量删除课程")
    @ApiOperationSupport(order = 11)
    public Result teacherDelClass(@RequestParam(value = "idList") List<Long> ids){
        courseService.removeByIds(ids);
        return Result.success();
    }
    @PostMapping("/queryOneCourse")
    @ApiOperation("查询单个课程")
    @ApiOperationSupport(order = 12)
    public Result<CourseVO> teacherQueryCourse(@RequestParam(value = "id") Long id){
        Course course = courseService.getById(id);
        CourseVO courseVO = CourseVO.builder().build();
        BeanUtils.copyProperties(course,courseVO);
        return Result.success(courseVO);
    }
    @PostMapping("/queryBatchCourse")
    @ApiOperation("分页查询课程")
    @ApiOperationSupport(order = 8)
    public Result<Page<CourseVO>> teacherQueryCourse(@RequestBody CoursePageQueryDTO coursePageQueryDTO){
        // 获取分页信息
        int current = coursePageQueryDTO.getPage();
        int pageSize = coursePageQueryDTO.getSize();
        Page<Course> coursePage = courseService.page(new Page<>(current, pageSize),
                courseService.getQueryWrapper(coursePageQueryDTO));
        Page<CourseVO> courseVOPage = new Page<>(current, pageSize, coursePage.getTotal());
        List<CourseVO> courseVOList = courseService.getQueryVOList(coursePage.getRecords());
        courseVOPage.setRecords(courseVOList);
        return Result.success(courseVOPage);
    }
    @PostMapping("/updateCourse")
    @ApiOperation("修改课程")
    @ApiOperationSupport(order = 6)
    public Result teacherUpdateClass(@RequestBody CourseUpdateDTO courseUpdateDTO){
        courseService.updateOne(courseUpdateDTO);
        return Result.success();
    }
}
