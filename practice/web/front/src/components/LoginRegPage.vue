<template>
    <div class="container">
      <div class="box login" :style="{ transform: loginTransform }">
        <div class="form-content">
          <div class="avatar">
            <div class="pic"><img src="../assets/img/0.png" alt=""></div>
          </div>
          <h1>欢迎回来</h1>
          <form action="#" class="form">
            <div>
              <span class="fa fa-user-o"></span>
              <input type="text" placeholder="用户名" v-model="loginForm.username">
            </div>
            <div>
              <span class="fa fa-key"></span>
              <input type="password" placeholder="密码" v-model="loginForm.password">
            </div>
            <div class="btn">
              <button @click="toggleLoginForm">登录</button>
            </div>
          </form>
          <p class="btn-something">
            没有账号？ <span class="signupbtn" @click="showSignupForm">注册</span>
          </p>
        </div>
      </div>
      <div class="box signup" :style="{ transform: signupTransform }">
        <div class="form-content">
          <div class="avatar">
            <div class="pic"><img src="../assets/img/0.png" alt=""></div>
          </div>
          <form action="#" class="form">
            <div>
              <span class="fa fa-user-o"></span>
              <input type="text" placeholder="用户名" v-model="regForm.username">
            </div>
            <div>
              <span class="fa fa-envelope-o"></span>
              <input type="email" placeholder="邮箱" v-model="regForm.email">
            </div>
            <div>
              <span class="fa fa-key"></span>
              <input type="password" placeholder="密码" v-model="regForm.password">
            </div>
            <div class="btn">
              <button @click="toggleSignupForm">注册</button>
            </div>
          </form>
          <p class="btn-something">
            已有账号？ <span class="loginbtn" @click="showLoginForm">登录</span>
          </p>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        showLogin: true,
        regForm:{
          username:'',
          email:'',
          password:''
        },
        loginForm:{
          username:'',
          password:''
        }
      };
    },
    computed: {
      loginTransform() {
        return this.showLogin ? 'rotateY(0deg)' : 'rotateY(180deg)';
      },
      signupTransform() {
        return this.showLogin ? 'rotateY(-180deg)' : 'rotateY(0deg)';
      },
      
    },
    methods: {
      toggleLoginForm() {
        console.log(this.loginForm);
        this.$axios.post('/login',{
          username: this.loginForm.username,
          password: this.loginForm.password
        }).then(res=>res.data).then(res=>{
          if(res.code === 1){
            this.$message.success(res.msg);
            this.$router.push('/index')
          }
          else if(res.code === 0){
            this.$message.error(res.msg);
          }
          else{
            this.$message.error("服务器异常");
          }
        })

      },
      toggleSignupForm() {
        console.log(this.regForm);
        this.$axios.post('/register',{
          username: this.regForm.username, // 从输入框获取用户名
          email: this.regForm.email, // 从输入框获取邮箱
          password: this.regForm.password // 从输入框获取密码
        }).then(res=>res.data).then(res=>{
          if(res.code === 1){
            this.$message.success(res.msg);
          }
          else if(res.code === 0){
            this.$message.error(res.msg);
          }
          else{
            this.$message.error("服务器异常");
          }
        })
        
        

      },
      showLoginForm() {
        this.showLogin = true;
      },
      showSignupForm() {
        this.showLogin = false;
      },

      goback() {
        window.history.length > 1 ? this.$router.go(-1) : this.$ruter.push('/');
      }
    }
  };
  </script>
  
  <style scoped>
  @import url('../lib/font-awesome-4.7.0/css/font-awesome.min.css');
  @import url('./index.css');
  </style>
  