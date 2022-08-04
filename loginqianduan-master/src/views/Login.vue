<template>
  <body id="poster">
    <el-form class="login-container" label-position="left" label-width="0px">
      <h3 class="login_title">
        请登录
        <el-button @click="toRegister()">点击注册</el-button>
      </h3>
      <el-form-item label="">
        <el-input
          type="text"
          v-model="loginForm.loginName"
          autocomplete="off"
          placeholder="账号"
        ></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input
          type="password"
          v-model="loginForm.password"
          autocomplete="off"
          placeholder="密码"
        ></el-input>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button
          type="primary"
          style="width: 100%; background: #505458; boder: none"
          v-on:click="Login()"
          >登录</el-button
        >
      </el-form-item>
    </el-form>
  </body>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      loginForm: {
        loginName: "",
        password: "",
      },
    };
  },
  methods: {
    Login() {
      console.log("submit!", this.loginForm);

      //登录发送的post请求后端端口！！！

      this.axios
        .post("http://localhost:10010/auth/login", this.loginForm)
        .then((resp) => {
          let data = resp.data;
          if (data.success) {
            this.loginForm = {};
            this.$message({
              message: "登录成功",
              type: "success",
            });
            this.$router.push({ path: "/Home" });
          } else {
            this.$message.error("账号或密码错误，登陆失败");
          }
        });

      // this.$message({
      //   message: "登录成功",
      //   type: "success",
      // });
      // this.$router.push({ path: "/Home" });
      // this.$message.error("账号或密码错误，登陆失败");
    },
    toRegister() {
      this.$router.push({ path: "/Register" });
    },
  },
};
</script>

<style>
#poster {
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}
body {
  margin: 0px;
  padding: 0px;
}
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cacac6;
}
.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
</style>