package com.exam.controller.teacher;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.dto.AddClassDTO;
import com.exam.dto.ClassPageQueryDTO;
import com.exam.dto.ClassUpdateDTO;
import com.exam.entity.Classx;
import com.exam.result.Result;
import com.exam.service.ClassService;
import com.exam.vo.ClassVO;
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
public class ClassController {
    @Autowired
    private ClassService classService;
    @PostMapping("/addClass")
    @ApiOperation("新增班级")
    @ApiOperationSupport(order = 9)
    public Result<Long> teacherAddClass(@RequestBody AddClassDTO addClassDTO){
        Classx classx = new Classx();
        BeanUtils.copyProperties(addClassDTO,classx);
        classService.save(classx);
        return Result.success(classx.getId());
    }
    @PostMapping("/delOneClass")
    @ApiOperation("删除班级")
    @ApiOperationSupport(order = 10)
    public Result teacherDelClass(@RequestParam(value = "id") Long id){
        classService.removeById(id);
        return Result.success();
    }
    @PostMapping("/delBatchClass")
    @ApiOperation("批量删除班级")
    @ApiOperationSupport(order = 11)
    public Result teacherDelClass(@RequestParam(value = "idList") List<Long> ids){
        classService.removeByIds(ids);
        return Result.success();
    }
    @PostMapping("/queryOneClass")
    @ApiOperation("查询单个班级")
    @ApiOperationSupport(order = 12)
    public Result<ClassVO> teacherQueryClass(@RequestParam(value = "id") Long id){
        Classx classx = classService.getById(id);
        ClassVO classVO = ClassVO.builder().build();
        BeanUtils.copyProperties(classx,classVO);
        return Result.success(classVO);
    }
    @PostMapping("/queryBatchClass")
    @ApiOperation("分页查询班级")
    @ApiOperationSupport(order = 8)
    public Result<Page<ClassVO>> teacherQueryClass(@RequestBody ClassPageQueryDTO classPageQueryDTO){
        // 获取分页信息
        int current = classPageQueryDTO.getPage();
        int pageSize = classPageQueryDTO.getSize();
        Page<Classx> classxPage = classService.page(new Page<>(current, pageSize),
                classService.getQueryWrapper(classPageQueryDTO));
        Page<ClassVO> userVOPage = new Page<>(current, pageSize, classxPage.getTotal());
        List<ClassVO> userVOList = classService.getQueryVOList(classxPage.getRecords());
        userVOPage.setRecords(userVOList);
        return Result.success(userVOPage);
    }
    @PostMapping("/updateClass")
    @ApiOperation("修改班级")
    @ApiOperationSupport(order = 6)
    public Result teacherUpdateClass(@RequestBody ClassUpdateDTO classUpdateDTO){
        classService.updateOne(classUpdateDTO);
        return Result.success();
    }
}
