<template>
  <div id="poster">
      <el-form :model="loginForm" label-position="left" class="login"
        @keyup.enter.native="login"
      >
        <h2 style="color: #3a91ba;">登录</h2>
        <el-form-item label="用户名">
          <el-input size="small" type="text" v-model="loginForm.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input size="small" type="password" v-model="loginForm.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-button style="padding-right: 10px" type="text" @click="register">还没有账号？</el-button>
        <el-checkbox size="medium" style="padding-left: 90px;color: white" v-model="checked">记住我</el-checkbox>
        <el-form-item style="padding: 10px 50px 0px 50px">
          <el-button  class="submit" size="medium" round type="primary" @click="login">提交</el-button>
        </el-form-item>
        <el-divider></el-divider>
      </el-form>
    </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      checked: false,
      loginForm: {
        username: '',
        password: ''
      },
      responseResult: []
    }
  },
  methods: {
    login () {
      const _this = this
      console.log(this.$store.state)
      // const url = '/login?rememberMe=' + this.checked
      const url = '/user/loginUser'
      this.$axios
        .post(url, {
          username: this.loginForm.username,
          password: this.loginForm.password
        })
        .then(successResponse => {
          if (successResponse.status === 200 && successResponse.data !== '') {
            _this.$store.commit('login', _this.loginForm)
            const path = this.$route.query.redirect
            this.$router.replace({path: path === '/' || path === undefined ? '/' : path})
          }
          if (successResponse.status === 400) {
            // alert(successResponse.data.message)
            alert('账号或密码错误')
          }
        })
        .catch(failResponse => {
          alert(failResponse.data)
        })
    },
    register () {
      this.$router.replace('/register')
    }
  }
}
</script>

<style scoped>

  #poster {
    background: url("../assets/images/login.jpg") no-repeat center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }

  .login {
    margin:100px auto;
    width:300px;
    padding: 10px 20px 0px 20px;
    background: rgba(2, 10, 14, 0.5);
  }

  /deep/ .el-form-item__label {
    color: white;
  }

  .submit.el-button {
    width: 200px;
  }

  a.login-way {
    padding: 23px;
  }

</style>
