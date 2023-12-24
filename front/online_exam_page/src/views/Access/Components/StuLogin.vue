<template>
  <div class="bodys"></div>
  <div class="container">
    <div class="login-wrapper">
      <div class="header">Student Login</div>
      <div class="form-wrapper">
        <input type="text" name="stuId" placeholder="StuId" class="input-item">
        <input type="password" name="password" placeholder="Password" class="input-item">
        <div class="btn">Login</div>
      </div>
      <div class="msg">
        Don't have account?
        <a href="/student/signUp">Sign up</a>
      </div>
    </div>
  </div>

</template>

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