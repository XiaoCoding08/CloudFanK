<template>
  <div class="bodys"></div>
  <div class="container">
    <div class="login-wrapper">
      <div class="header">Student SignUp</div>
      <div class="form-wrapper">
        <el-form-item>
            <el-input v-model="form.name" type="text" placeholder="name" :size="medium"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="form.stuid" type="text" placeholder="stuid" :size="medium"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="form.password" type="password" placeholder="Password" :size="medium"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="form.conformpassword" type="password" placeholder="Conform Password" :size="medium"></el-input>
          </el-form-item>
        <el-button type="primary" class="btn" @click="handlesignup">SignUp</el-button>
      </div>
      <div class="msg">
        Already have account?
        <a href="/student/login">Login</a>
      </div>
    </div>
  </div>

</template>
<script setup>
import {ref} from 'vue'
import httpInstance from '@/utils/http';
import { ElMessage, ElMessageBox } from 'element-plus'

const form = ref(
  { name: '',
   password: '' ,
   conformpassword:'',
   stuid:''
  }
);
const handlesignup = () =>{
  // 首先，对表单进行验证，确保用户输入的数据符合要求
  if (
    form.value.name.trim() === '' ||
    form.value.stuid.trim() === '' ||
    form.value.password.trim() === '' ||
    form.value.conformpassword.trim() === ''
  ) {
    // 如果有任何一个字段为空，可以给出提示或者阻止注册逻辑继续执行
    //console.log('请填写完整的注册信息');
    if( form.value.conformpassword.trim() === '')
    {
      console.log('请填写conformpassword的注册信息');
    }else
    {
        if( form.value.name.trim() === '')
      {
        console.log('请填写name的注册信息');
      }else
      {
          if( form.value.stuid.trim() === '')
        {
          console.log('请填写stuid的注册信息 stuid:  '+ form.value.name);
        }else{
              if(form.value.password.trim() === '')
              {
                console.log('请填写password的注册信息');
              }
        }
      }
    }
    return;
  }

  if (form.value.password !== form.value.conformpassword) {
    // 如果两次输入的密码不一致，可以给出提示或者阻止注册逻辑继续执行
    console.log('两次输入的密码不一致');
    return;
  }

  // 发起注册请求，可以使用 axios 或者你定义的 httpInstance 来发送 POST 请求
  const requestData = {
    name: form.value.name,
    id: form.value.stuid,
    password: form.value.password
  };

  
    httpInstance.post('/student/signUp', requestData)
    .then(response => {
      console.log(response.data);
      // 注册成功，可以根据实际需求进行处理，比如跳转到登录页面
      alert("注册成功");
      window.location.href ='/student/login';
    })
    .catch(error => {
      console.log(error);
      // 注册失败，可以根据实际需求进行处理，比如显示错误提示
      alert("注册失败，请重新注册");
    });


}

</script>
<style scoped>
* {
  margin: 0;
  padding: 0;
}

.container {
  height: 100vh;
  width: 100%;

}
.login-wrapper {
  box-shadow: 1px 2px 12px 12px;
  border: 1px solid #000;
  background-color: #fff;
  width: 358px;
  height: 588px;
  border-radius: 15px;
  padding: 0 50px;
  position: relative;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
.header {
  font-size: 38px;
  font-weight: bold;
  text-align: center;
  line-height: 200px;
}
.input-item {
  display: block;
  width: 100%;
  margin-bottom: 20px;
  border: 0;
  padding: 10px;
  border-bottom: 1px solid rgb(128, 125, 125);
  font-size: 15px;
  outline: none;
}
.input-item::placeholder {
  text-transform: uppercase;
}
.btn {
  text-align: center;
  padding: 10px;
  width: 100%;
  margin-top: 40px;

  color: #fff;
}
.msg {
  text-align: center;
  line-height: 88px;
}
a {
  text-decoration-line: none;
  color: #abc1ee;
}
</style>
