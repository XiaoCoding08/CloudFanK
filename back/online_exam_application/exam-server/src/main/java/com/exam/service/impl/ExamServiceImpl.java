package com.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.entity.Exam;
import com.exam.mapper.ExamMapper;
import com.exam.service.ExamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    ExamMapper examMapper;
    @Override
    @Scheduled(fixedRate = 60000)
    public void scheduleExams() {
        log.info("开始执行定时任务:考试开启");
        List<Exam> upcomingExams = examMapper.selectList(null);
        for (Exam exam : upcomingExams) {
            LocalDateTime startTime = exam.getStartTime();
            LocalDateTime endTime = exam.getEndTime();
            Long delayTime = Duration.between(LocalDateTime.now(),startTime).getSeconds();
            // 结束后10分钟内可提交答案
            Long expireTime = Duration.between(startTime, endTime.plusSeconds(600)).getSeconds();
            if (delayTime > 0 && delayTime <= 60) { // 考试将在1分钟内开始
                redisTemplate.opsForValue().set("exam:" + exam.getId(), exam, expireTime, TimeUnit.SECONDS);
            }
        }
    }

}
