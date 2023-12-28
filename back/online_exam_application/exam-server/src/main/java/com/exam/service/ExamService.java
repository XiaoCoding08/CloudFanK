package com.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.entity.Exam;
import org.springframework.scheduling.annotation.Scheduled;

public interface ExamService extends IService<Exam> {
    /**
     * 每60s查询是否有考试开始
     */
    public void scheduleExams();
}
