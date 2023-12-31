<template>
  <div class="app-container">
    <el-container  class="head-container">
      <el-header ><h1>线上考试系统</h1></el-header>
      <el-container>
        <el-aside width="250px" class="sidebar-container"><Menu /></el-aside>
        <el-container class="main-container">
          <el-main> <el-scrollbar><router-view /></el-scrollbar></el-main>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>
<script setup>
import Menu from './Menu/index.vue'
</script>
<style lang="scss" scoped>

.app-container {
  
  width: 100vw;
  height: 100vh;
  position: fixed;
  top: 0;
  left: 0;
  color: $menuText;
}
.container {
  width: calc(100% - $sideBarWidth);
  height: 100%;

  position: fixed;
  top: 0;
  right: 0;
  z-index: 9;
  transition: all 0.28s;
  &.hidderContainer {
    width: calc(100% - $hideSideBarWidth);
  }
}
.sidebar-container {
  color: $menuText;
  background-color: $menuBg;
  height: 100vh;
}
.head-container{
  background-color: $menuBg;
}
.main-container{
  background: aliceblue;
}
</style>
