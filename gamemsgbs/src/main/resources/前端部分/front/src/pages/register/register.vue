<template>
  <div>
    <div class="backg"></div>
    <div class="container">
      <el-form
        class="rgs-form formback"
        v-if="pageFlag == 'register'"
        :style="{
          textAlign: 'center',
          position: 'relative',
          height: 'auto',
        }"
        ref="registerForm"
        :model="registerForm"
        :rules="rules"
      >
        <div
          v-if="true"
          :style="{
            margin: '20px auto 20px',
            color: 'rgb(255 129 166)',
            textAlign: 'center',
            width: '100%',
            lineHeight: '44px',
            fontSize: '40px',
            fontWeight: '500',
            fontFamily: 'STXingkai',
          }"
        >
          宫天弈雪平台注册
        </div>
        <el-form-item
          :style="{ width: '400px', padding: '0', margin: '0 auto 10px', height: 'auto' }"
          v-if="tableName == 'yonghu'"
          prop="zhanghao"
        >
          <div
            v-if="true"
            :style="{
              padding: '0 10px',
              color: '#333',
              textAlign: 'right',
              left: '-150px',
              background: 'none',
              display: 'inline-block',
              width: '150px',
              lineHeight: '36px',
              fontSize: '14px',
              position: 'absolute',
            }"
            :class="changeRules('zhanghao') ? 'required' : ''"
            class="labelc"
          >
            账号：
          </div>
          <el-input v-model="registerForm.zhanghao" placeholder="请输入账号" />
        </el-form-item>
        <el-form-item
          :style="{ width: '400px', padding: '0', margin: '0 auto 10px', height: 'auto' }"
          v-if="tableName == 'yonghu'"
          prop="mima"
        >
          <div
            v-if="true"
            :style="{
              padding: '0 10px',
              color: '#333',
              textAlign: 'right',
              left: '-150px',
              background: 'none',
              display: 'inline-block',
              width: '150px',
              lineHeight: '36px',
              fontSize: '14px',
              position: 'absolute',
            }"
            :class="changeRules('mima') ? 'required' : ''"
            class="labelc"
          >
            密码：
          </div>
          <el-input
            v-model="registerForm.mima"
            type="password"
            placeholder="请输入密码"
          />
        </el-form-item>
        <el-form-item
          :style="{ width: '400px', padding: '0', margin: '0 auto 10px', height: 'auto' }"
          v-if="tableName == 'yonghu'"
          prop="mima2"
        >
          <div
            v-if="true"
            :style="{
              padding: '0 10px',
              color: '#333',
              textAlign: 'right',
              left: '-150px',
              background: 'none',
              display: 'inline-block',
              width: '150px',
              lineHeight: '36px',
              fontSize: '14px',
              position: 'absolute',
            }"
            :class="changeRules('mima') ? 'required' : ''"
            class="labelc"
          >
            确认密码：
          </div>
          <el-input
            v-model="registerForm.mima2"
            type="password"
            placeholder="请再次输入密码"
          />
        </el-form-item>
        <el-form-item
          :style="{ width: '400px', padding: '0', margin: '0 auto 10px', height: 'auto' }"
          v-if="tableName == 'yonghu'"
          prop="nicheng"
        >
          <div
            v-if="true"
            :style="{
              padding: '0 10px',
              color: '#333',
              textAlign: 'right',
              left: '-150px',
              background: 'none',
              display: 'inline-block',
              width: '150px',
              lineHeight: '36px',
              fontSize: '14px',
              position: 'absolute',
            }"
            :class="changeRules('nicheng') ? 'required' : ''"
            class="labelc"
          >
            昵称：
          </div>
          <el-input v-model="registerForm.nicheng" placeholder="请输入昵称" />
        </el-form-item>
        <el-form-item
          :style="{ width: '400px', padding: '0', margin: '0 auto 10px', height: 'auto' }"
          v-if="tableName == 'yonghu'"
          prop="xingbie"
        >
          <div
            v-if="true"
            :style="{
              padding: '0 10px',
              color: '#333',
              textAlign: 'right',
              left: '-150px',
              background: 'none',
              display: 'inline-block',
              width: '150px',
              lineHeight: '36px',
              fontSize: '14px',
              position: 'absolute',
            }"
            :class="changeRules('xingbie') ? 'required' : ''"
            class="labelc"
          >
            性别：
          </div>
          <el-select v-model="registerForm.xingbie" placeholder="请选择性别">
            <el-option
              v-for="(item, index) in yonghuxingbieOptions"
              :key="index"
              :label="item"
              :value="item"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item
          :style="{ width: '400px', padding: '0', margin: '0 auto 10px', height: 'auto' }"
          v-if="tableName == 'yonghu'"
          prop="shouji"
        >
          <div
            v-if="true"
            :style="{
              padding: '0 10px',
              color: '#333',
              textAlign: 'right',
              left: '-150px',
              background: 'none',
              display: 'inline-block',
              width: '150px',
              lineHeight: '36px',
              fontSize: '14px',
              position: 'absolute',
            }"
            :class="changeRules('shouji') ? 'required' : ''"
            class="labelc"
          >
            手机：
          </div>
          <el-input v-model="registerForm.shouji" placeholder="请输入手机" />
        </el-form-item>
        <el-form-item
          :style="{ width: '400px', padding: '0', margin: '0 auto 10px', height: 'auto' }"
          v-if="tableName == 'yonghu'"
          prop="youxiang"
        >
          <div
            v-if="true"
            :style="{
              padding: '0 10px',
              color: '#333',
              textAlign: 'right',
              left: '-150px',
              background: 'none',
              display: 'inline-block',
              width: '150px',
              lineHeight: '36px',
              fontSize: '14px',
              position: 'absolute',
            }"
            :class="changeRules('youxiang') ? 'required' : ''"
            class="labelc"
          >
            邮箱：
          </div>
          <el-input v-model="registerForm.youxiang" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item
          :style="{ width: '400px', padding: '0', margin: '0 auto 10px', height: 'auto' }"
          v-if="tableName == 'yonghu'"
          prop="youxifenlei"
        >
          <div
            v-if="true"
            :style="{
              padding: '0 10px',
              color: '#333',
              textAlign: 'right',
              left: '-150px',
              background: 'none',
              display: 'inline-block',
              width: '150px',
              lineHeight: '36px',
              fontSize: '14px',
              position: 'absolute',
            }"
            :class="changeRules('youxifenlei') ? 'required' : ''"
            class="labelc"
          >
            游戏分类：
          </div>
          <el-select
            v-model="registerForm.youxifenleiArray"
            placeholder="请选择游戏分类"
            @change="yonghuyouxifenleiMulChange"
            multiple
          >
            <el-option
              v-for="(item, index) in yonghuyouxifenleiOptions"
              :key="index"
              :label="item"
              :value="item"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item
          :style="{ width: '400px', padding: '0', margin: '0 auto 10px', height: 'auto' }"
          v-if="tableName == 'yonghu'"
          prop="touxiang"
        >
          <div
            v-if="true"
            :style="{
              padding: '0 10px',
              color: '#333',
              textAlign: 'right',
              left: '-150px',
              background: 'none',
              display: 'inline-block',
              width: '150px',
              lineHeight: '36px',
              fontSize: '14px',
              position: 'absolute',
            }"
            :class="changeRules('touxiang') ? 'required' : ''"
            class="labelc"
          >
            头像：
          </div>
          <file-upload
            tip="点击上传头像"
            action="file/upload"
            :limit="1"
            :multiple="true"
            :fileUrls="registerForm.touxiang ? registerForm.touxiang : ''"
            @change="yonghutouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-button
          :style="{
            border: '0',
            cursor: 'pointer',
            padding: '0 24px',
            margin: '0 auto',
            color: '#fff',
            display: 'block',
            outline: 'none',
            borderRadius: '4px',
            width: '400px',
            fontSize: '16px',
            height: '50px',
            order: '30',
          }"
          type="primary"
          @click="submitForm('registerForm')"
          class="zhuceb"
          >注册</el-button
        >
        <el-button
          :style="{
            border: '0',
            cursor: 'pointer',
            padding: '0 0px',
            margin: '0px auto',
            color: '#999',
            textAlign: 'right',
            display: 'none',
            outline: 'none',
            borderRadius: '4px',
            background: 'none',
            width: '400px',
            fontSize: '14px',
            height: '44px',
            order: '40',
          }"
          @click="resetForm('registerForm')"
          >重置</el-button
        >
        <router-link
          :style="{
            cursor: 'pointer',
            padding: '0 0px',
            margin: '12px auto 20px',
            color: 'rgb(232, 145, 141)',
            textAlign: 'center',
            display: 'block',
            width: '400px',
            lineHeight: '1',
            fontSize: '14px',
            textDecoration: 'none',
            order: '50',
          }"
          to="/login"
          >已有账户登录</router-link
        >
        <div
          class="idea1"
          :style="{ width: '100%', background: 'red', display: 'none', height: '40px' }"
        ></div>
        <div
          class="idea2"
          :style="{ width: '100%', background: 'blue', display: 'none', height: '40px' }"
        ></div>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  //数据集合
  data() {
    return {
      pageFlag: "",
      tableName: "",
      registerForm: {},
      forgetForm: {},
      rules: {},
      requiredRules: {},
      yonghuxingbieOptions: [],
      yonghuyouxifenleiOptions: [],
    };
  },
  mounted() {
    if (this.$route.query.pageFlag == "register") {
      this.tableName = this.$route.query.role;
      if (this.tableName == "yonghu") {
        this.registerForm = {
          zhanghao: "",
          mima: "",
          mima2: "",
          nicheng: "",
          xingbie: "",
          shouji: "",
          youxiang: "",
          youxifenlei: "",
          touxiang: "",
          gerenjianjie: "",
          status: "",
        };
      }
      if ("yonghu" == this.tableName) {
        this.requiredRules.zhanghao = [
          { required: true, message: "请输入账号", trigger: "blur" },
        ];
      }
      if ("yonghu" == this.tableName) {
        this.requiredRules.mima = [
          { required: true, message: "请输入密码", trigger: "blur" },
        ];
      }
      if ("yonghu" == this.tableName) {
        this.requiredRules.nicheng = [
          { required: true, message: "请输入昵称", trigger: "blur" },
        ];
      }
    }
  },
  created() {
    this.pageFlag = this.$route.query.pageFlag;
    if (this.$route.query.pageFlag == "register") {
      if ("yonghu" == this.tableName) {
        this.rules.zhanghao = [
          { required: true, message: "请输入账号", trigger: "blur" },
        ];
      }
      if ("yonghu" == this.tableName) {
        this.rules.mima = [{ required: true, message: "请输入密码", trigger: "blur" }];
      }
      if ("yonghu" == this.tableName) {
        this.rules.nicheng = [{ required: true, message: "请输入昵称", trigger: "blur" }];
      }
      this.yonghuxingbieOptions = "男,女".split(",");
      if ("yonghu" == this.tableName) {
        this.rules.shouji = [
          { required: true, validator: this.$validate.isMobile, trigger: "blur" },
        ];
      }
      if ("yonghu" == this.tableName) {
        this.rules.youxiang = [
          { required: true, validator: this.$validate.isEmail, trigger: "blur" },
        ];
      }
      this.$http({
        url: `option/youxifenlei/youxifenlei`,
        method: "get",
        params: {},
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.yonghuyouxifenleiOptions = data.data;
        }
      });
      if ("yonghu" == this.tableName) {
        this.rules.status = [
          { required: true, validator: this.$validate.isIntNumer, trigger: "blur" },
        ];
      }
    }
  },
  //方法集合
  methods: {
    changeRules(name) {
      if (this.requiredRules[name]) {
        return true;
      }
      return false;
    },
    // 获取uuid
    getUUID() {
      return new Date().getTime();
    },
    // 下二随
    yonghutouxiangUploadChange(fileUrls) {
      this.registerForm.touxiang = fileUrls.replace(
        new RegExp(this.$config.baseUrl, "g"),
        ""
      );
    },

    // 多级联动参数
    yonghuyouxifenleiMulChange(e) {
      this.registerForm.youxifenlei = this.registerForm.youxifenleiArray.join(",");
      this.$forceUpdate();
    },

    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          var url = this.tableName + "/register";
          if (!this.registerForm.zhanghao && `yonghu` == this.tableName) {
            this.$message.error(`账号不能为空`);
            return;
          }
          if (
            `yonghu` == this.tableName &&
            this.registerForm.mima != this.registerForm.mima2
          ) {
            this.$message.error(`两次密码输入不一致`);
            return;
          }
          if (!this.registerForm.mima && `yonghu` == this.tableName) {
            this.$message.error(`密码不能为空`);
            return;
          }
          if (!this.registerForm.nicheng && `yonghu` == this.tableName) {
            this.$message.error(`昵称不能为空`);
            return;
          }
          if (
            `yonghu` == this.tableName &&
            this.registerForm.shouji &&
            !this.$validate.isMobile2(this.registerForm.shouji)
          ) {
            this.$message.error(`手机应输入手机格式`);
            return;
          }
          if (
            `yonghu` == this.tableName &&
            this.registerForm.youxiang &&
            !this.$validate.isEmail2(this.registerForm.youxiang)
          ) {
            this.$message.error(`邮箱应输入邮件格式`);
            return;
          }
          this.$http.post(url, this.registerForm).then((res) => {
            if (res.data.code === 0) {
              this.$message({
                message: "注册成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.$router.push("/login");
                },
              });
            } else {
              this.$message.error(res.data.msg);
            }
          });
        } else {
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.container {
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
  .el-input {
    width: auto;
  }

  .el-date-editor.el-input {
    width: auto;
  }

  .el-form-item /deep/ .el-form-item__content {
    display: flex;
    flex-wrap: wrap;
  }

  .rgs-form .el-input /deep/ .el-input__inner {
    border-radius: 8px;
    padding: 0 10px;
    outline: none;
    color: #666;
    background: #fff;
    width: 400px;
    font-size: 14px;
    border-color: #c6c6c6;
    border-width: 2px;
    border-style: solid;
    height: 50px;
  }

  .rgs-form .el-select /deep/ .el-input__inner {
    border-radius: 8px;
    padding: 0 10px;
    outline: none;
    color: #666;
    background: #fff;
    width: 400px;
    font-size: 14px;
    border-color: #c6c6c6;
    border-width: 2px;
    border-style: solid;
    min-width: 300px;
    height: 50px;
  }

  .rgs-form .el-date-editor /deep/ .el-input__inner {
    border-radius: 8px;
    padding: 0 10px 0 30px;
    outline: none;
    color: #666;
    background: #fff;
    width: 400px;
    font-size: 14px;
    border-color: #c6c6c6;
    border-width: 2px;
    border-style: solid;
    min-width: 300px;
    height: 50px;
  }

  .rgs-form .el-date-editor /deep/ .el-input__inner {
    border-radius: 8px;
    padding: 0 10px 0 30px;
    outline: none;
    color: #666;
    background: #fff;
    width: 400px;
    font-size: 14px;
    border-color: #c6c6c6;
    border-width: 2px;
    border-style: solid;
    min-width: 300px;
    height: 50px;
  }

  .rgs-form /deep/ .el-upload--picture-card {
    background: transparent;
    border: 0;
    border-radius: 0;
    width: auto;
    height: auto;
    line-height: initial;
    vertical-align: middle;
  }

  .rgs-form /deep/ .upload .upload-img {
    cursor: pointer;
    color: #c6c6c6;
    font-weight: 600;
    font-size: 24px;
    border-color: #c6c6c6;
    line-height: 80px;
    border-radius: 4px;
    background: #fff;
    width: 80px;
    border-width: 2px;
    border-style: solid;
    text-align: center;
    height: 80px;
  }

  .rgs-form /deep/ .el-upload-list .el-upload-list__item {
    cursor: pointer;
    color: #c6c6c6;
    font-weight: 600;
    font-size: 24px;
    border-color: #c6c6c6;
    line-height: 80px;
    border-radius: 4px;
    background: #fff;
    width: 80px;
    border-width: 2px;
    border-style: solid;
    text-align: center;
    height: 80px;
  }

  .rgs-form /deep/ .el-upload .el-icon-plus {
    cursor: pointer;
    color: #c6c6c6;
    font-weight: 600;
    font-size: 24px;
    border-color: #c6c6c6;
    line-height: 80px;
    border-radius: 4px;
    background: #fff;
    width: 80px;
    border-width: 2px;
    border-style: solid;
    text-align: center;
    height: 80px;
  }
}
.required {
  position: relative;
}
.required::after {
  color: red;
  left: 140px;
  position: absolute;
  content: "*";
  order: 2;
}
.backg {
  position: fixed;
  background: url("../../assets/backg.jpg");
  width: 100%;
  height: 100%;
  background-size: cover;
  background-repeat: no-repeat;
  filter: blur(10px);
}

.formback {
  background: rgba(0, 0, 0, 0.5);
  padding: 20px 100px;
  border-radius: 60px;
  transform: translateY(95px);
}
.labelc {
  color: #fff !important;
}
.zhuceb {
  background-color: rgb(255, 71, 114);
}
.zhuceb:hover {
  background-color: rgb(232, 112, 107);
}
</style>
