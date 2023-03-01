<template>
  <div class="login-wrap">
    <div class="login-form" style="margin-left: 10%">
      <div class="form-title">信息管理系统</div>
      <el-form
        :model="form"
        :rules="rules"
        class="form-content"
        label-width="0px"
        ref="form"
      >
        <el-form-item prop="swnumber">
          <el-input placeholder="学工号" v-model="form.swnumber">
            <span slot="prepend"><i class="el-icon-user"></i></span>
          </el-input>
        </el-form-item>

        <el-form-item prop="password">
          <el-input
            @keyup.enter.native="submit()"
            placeholder="密码"
            type="password"
            v-model="form.password"
            show-password
          >
            <span slot="prepend"><i class="el-icon-edit"></i></span>
          </el-input>
        </el-form-item>

        <el-form-item>
          <div style="display: flex">
            <el-input
              prefix-icon="el-icon-key"
              v-model="form.validCode"
              style="width: 50%;"
              placeholder="请输入验证码"
            ></el-input>
            <ValidCode @input="createValidCode" />
          </div>
        </el-form-item>

        <el-form-item prop="userType">
          <el-radio-group v-model="form.userType">
            <el-radio label="1">学生</el-radio>
            <el-radio label="2">教师</el-radio>
            <el-radio label="3">管理员</el-radio>
          </el-radio-group>
        </el-form-item>

        <div class="login-btn" v-loading="this.$store.state.loading">
          <el-button @click="submit()" type="primary">登录</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
import { login } from "@/api/user";
import ValidCode from "@/components/ValidCode";
export default {
  components: {
    ValidCode
  },
  data: function() {
    return {
      form: {
        swnumber: "",
        password: "",
        userType: "1"
      },
      rules: {
        swnumber: [
          { required: true, message: "请输入学工号", trigger: "blur" }
        ],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
        userType: [
          { required: true, message: "请选择用户类型", trigger: "blur" }
        ]
      },
      validCode: ""
    };
  },
  methods: {
    // 接收验证码组件提交的 4位验证码
    createValidCode(data) {
      this.validCode = data;
    },
    submit() {
      this.$refs.form.validate(valid => {
        if (valid) {
          if (!this.form.validCode) {
            this.$message.error("请填写验证码");
            return;
          }
          if (
            this.form.validCode.toLowerCase() !== this.validCode.toLowerCase()
          ) {
            this.$message.error("验证码错误");
            return;
          }
          login(
            this.form.swnumber,
            this.form.password,
            this.form.userType
          ).then(res => {
            this.$message.success("登录成功: " + res.swnumber);
            this.$store.commit("login", res);
            this.$router.push({ name: "container" });
          });
        }
      });
    }
  }
};
</script>

<style scoped>
.login-wrap {
  position: relative;
  width: 100%;
  height: 100%;
  background-image: url("../assets/login-background.jpg");
  background-size: 100% 100%;
}

.form-title {
  width: 100%;
  line-height: 50px;
  text-align: center;
  font-size: 20px;
  color: #fff;
  border-bottom: 1px solid #ddd;
}

.login-form {
  position: absolute;
  left: 50%;
  top: 50%;
  width: 350px;
  margin: -190px 0 0 -175px;
  border-radius: 5px;
  background: rgba(0, 0, 0, 0.6);
  overflow: hidden;
}

.form-content {
  padding: 30px 30px;
}

.login-btn {
  text-align: center;
}

.login-btn button {
  width: 100%;
  height: 36px;
}
</style>
