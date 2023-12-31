package com.exam.controller.student;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.dto.ClassStudentDTO;
import com.exam.dto.StuClassPageQueryDTO;
import com.exam.entity.ClassStudent;
import com.exam.entity.Classx;
import com.exam.result.Result;
import com.exam.service.ClassService;
import com.exam.service.ClassStudentService;
import com.exam.vo.ClassVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
@Slf4j
@Api(tags = "2.学生模块")
public class StuClassController {
    @Autowired
    ClassStudentService classStudentService;
    @Autowired
    ClassService classService;
    /**
     * 学生加入班级
     * @param classStudentDTO
     * @return
     */
    @PostMapping("/joinClass")
    @ApiOperation("加入班级")
    @ApiOperationSupport(order = 3)
    public Result stuJoinClass(@RequestBody ClassStudentDTO classStudentDTO){
        classStudentService.addStudent(classStudentDTO);
        return Result.success();
    }
    /**
     * 学生加入班级
     * @param classStudentDTO
     * @return
     */
    @PostMapping("/escClass")
    @ApiOperation("退出班级")
    @ApiOperationSupport(order = 4)
    public Result stuEscClass(@RequestBody ClassStudentDTO classStudentDTO){
        classStudentService.delStu(classStudentDTO);
        return Result.success();
    }
    @PostMapping("/getClass")
    @ApiOperation("分页获取班级列表")
    @ApiOperationSupport(order = 5)
    public Result<Page<ClassVO>> stuGetClass(@RequestBody StuClassPageQueryDTO stuClassPageQueryDTO){
        int page = stuClassPageQueryDTO.getPage();
        int size = stuClassPageQueryDTO.getSize();
        //分页查询学生所属班级
        Page<ClassStudent> classStuList = classStudentService.page(new Page<>(page,size),
                new QueryWrapper<ClassStudent>().eq("student_id",stuClassPageQueryDTO.getStudentId()));
        //根据班级Id获取班级信息
        List<Classx> classList = classService.getBatchByClassIds(
                //获取ClassId列表
                classStuList.getRecords()
                            .stream().map(ClassStudent::getClassId)
                            .collect(Collectors.toList())
        );
        Page<ClassVO> classVOPage = new Page<>(page,size,classStuList.getTotal());
        classVOPage.setRecords(classService.getQueryVOList(classList));
        return Result.success(classVOPage);
    }

}
