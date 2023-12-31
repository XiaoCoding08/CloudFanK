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
            <span>班级</span>
          </template>
          <el-menu-item-group title="班级">
            <el-menu-item index="/student/class">班级信息</el-menu-item>
            <el-menu-item index="/student/test">班级考试</el-menu-item>
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