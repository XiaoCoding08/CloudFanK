<script setup>

</script>

<template>
  <div class="main">
    <ul>
      <li><a href="/" target="_self">首页</a></li>
      <li><a href="http://localhost:5173/teacher/login" target="_self">教师</a></li>
      <li><a href="http://localhost:5173/student/login" target="_self">学生</a></li>
    </ul>
  </div>
  <!-- 二级路由出口 -->
  <router-view/>
</template>

<style scoped>
*{
  padding: 0;
  margin: 0;
}

ul{
  float: right;
  list-style-type: none;
  margin: 15px;

}
ul li{
  display: inline-block;
}

ul li a{
  text-decoration: none;
  color: #ffffff;
  padding: 5px 20px;
  border: 1px solid transparent;
  transition: .6s ease;
  border-radius: 20px;
  background-color: #000000;
}

ul li a:hover{
  background-color: rgba(255,0,0,1);
  color: #000000;
}
ul li.active a{
  background-color: #fff;
  color: #000;
}
.title{
  position: absolute;
  top:50%;
  left:50%;
  transform: translate(-50%,-50%);
}
.title h1{
  color: #fff;
  font-size: 70px;
}
</style>