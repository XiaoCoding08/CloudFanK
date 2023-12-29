package com.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.dto.ExamStudentDTO;
import com.exam.entity.ExamQuestion;
import com.exam.entity.ExamStudent;
import com.exam.vo.ExamStudentVO;

import java.util.List;

public interface ExamStudentService extends IService<ExamStudent> {
    /**
     * 删除考试单条学生记录
     */
    public void delStu(ExamStudentDTO examStudentDTO);

    /**
     * 删除考试所有学生记录
     */
    public void delExam(Long examId);

    /**
     * 添加考试记录
     */
    public void addStu(ExamStudentDTO examStudentDTO);

    /**
     * 获取考试学生记录列表
     */
    public List<ExamStudentVO> getStuByExamId(Long examId);

    /**
     * VO转换
     * @param examStudent
     * @return
     */
    public ExamStudentVO getExamStudentVO(ExamStudent examStudent);
    /**
     * 批改试卷
     */
    public int markExam(ExamStudentDTO examStudentDTO);
}
