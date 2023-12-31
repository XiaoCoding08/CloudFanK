<template>
     <el-menu
        active-text-color="#ffd04b"
        background-color=$menuBg
        class="el-menu-vertical-demo"
        default-active="2"
        text-color="#fff"
        @open="handleOpen"
        @close="handleClose"
        router
      >
        <el-sub-menu index="1">
          <template #title>
            <el-icon><location /></el-icon>
            <span>课程</span>
          </template>
          <el-menu-item-group title="课程">
            <el-menu-item index="/teacher/course">课程管理</el-menu-item>
            <el-menu-item index="/teacher/classinformation">班级管理</el-menu-item>
          </el-menu-item-group>
         
        </el-sub-menu>
        <el-sub-menu index="2">
          <template #title>
            <el-icon><location /></el-icon>
            <span>考试管理</span>
          </template>
          <el-menu-item-group title="考试管理">
            <el-menu-item index="/teacher/exam">考试管理</el-menu-item>
            <el-menu-item index="/teacher/question">试题管理</el-menu-item>
        
          </el-menu-item-group>
         
        </el-sub-menu>

      </el-menu>
      
</template>


<script lang="ts" setup>
import {useRoute} from 'vue-router'
import { ref } from 'vue'
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'
const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>