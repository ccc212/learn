<template>
    <div class="container">
      <div class="box login" :style="{ transform: loginTransform }">
        <div class="form-content">
          <div class="avatar">
            <div class="pic"><img src="img/0.png" alt=""></div>
          </div>
          <h1>欢迎回来</h1>
          <form action="#" class="form">
            <div>
              <span class="fa fa-user-o"></span>
              <input type="text" placeholder="用户名">
            </div>
            <div>
              <span class="fa fa-key"></span>
              <input type="password" placeholder="密码">
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
            <div class="pic"><img src="./img/0.png" alt=""></div>
          </div>
          <form action="#" class="form">
            <div>
              <span class="fa fa-user-o"></span>
              <input type="text" placeholder="用户名">
            </div>
            <div>
              <span class="fa fa-envelope-o"></span>
              <input type="email" placeholder="邮箱">
            </div>
            <div>
              <span class="fa fa-key"></span>
              <input type="password" placeholder="密码">
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
        showLogin: true
      };
    },
    computed: {
      loginTransform() {
        return this.showLogin ? 'rotateY(0deg)' : 'rotateY(180deg)';
      },
      signupTransform() {
        return this.showLogin ? 'rotateY(-180deg)' : 'rotateY(0deg)';
      }
    },
    methods: {
      toggleLoginForm() {
        this.showLogin = true;
      },
      toggleSignupForm() {
        this.showLogin = false;
      },
      showLoginForm() {
        this.showLogin = true;
      },
      showSignupForm() {
        this.showLogin = false;
      }
    }
  };
  </script>
  
  <style scoped>
  @import url('../lib/font-awesome-4.7.0/css/font-awesome.min.css');
  @import url('./index.css');
  </style>
  