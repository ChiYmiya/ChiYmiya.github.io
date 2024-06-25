<template>
  <div
    class="center-preview"
    :style="{
      padding: '20px 12% 40px',
      margin: '0 auto',
      color: '#999',
      flexWrap: 'wrap',
      background: '#edeff1',
      display: 'block',
      width: '100%',
      fontSize: '14px',
      position: 'relative',
      justifyContent: 'space-between',
    }"
  >
    <div
      class="title"
      :style="{
        padding: '12px 0 0',
        margin: '0px auto',
        color: '#333',
        textAlign: 'center',
        background: 'none',
        width: '100%',
        fontSize: '24px',
        fontWeight: '600',
        height: '60px',
      }"
    >
      {{ title }}
    </div>

    <div
      class="info"
      :style="{
        padding: '80px 60px 80px 200px',
        margin: '20px 0 0 0',
        borderColor: '#28890b20',
        alignItems: 'center',
        display: 'flex',
        borderRadius: '0px',
        flexWrap: 'wrap',
        background: '#fff',
        borderWidth: '0px',
        width: 'calc(100% - 0px)',
        position: 'relative',
        borderStyle: 'solid',
        height: 'auto',
        order: '2',
      }"
    >
      <div
        :style="{
          padding: '8px 30px',
          borderColor: '#eee',
          margin: '0 20px 0 0',
          color: '#333',
          letterSpacing: '0px',
          borderRadius: '0px',
          top: '20px',
          left: '170px',
          borderWidth: '0px',
          background: 'none',
          width: 'auto',
          lineHeight: '1.5',
          fontSize: '18px',
          position: 'absolute',
          borderStyle: 'solid',
          fontWeight: '600',
          height: 'auto',
        }"
      >
        个人信息
      </div>
      <div
        :style="{
          borderColor: '#1abc9e20',
          left: '20px',
          borderWidth: '0 0 0px 0',
          width: 'auto',
          fontSize: 0,
          position: 'absolute',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'yonghu'"
      >
        <el-image
          :style="{
            margin: '10px auto',
            borderColor: '#efefef',
            objectFit: 'cover',
            borderRadius: '100%',
            borderWidth: '0 0 1px 0',
            display: 'block',
            width: '150px',
            borderStyle: 'solid',
            height: '150px',
          }"
          :src="
            sessionForm.touxiang
              ? baseUrl + sessionForm.touxiang
              : require('@/assets/avator.png')
          "
          fit="cover"
        ></el-image>
      </div>
      <div
        :style="{
          padding: '0 0px',
          borderColor: '#1abc9e20',
          margin: '0 5% 0 0',
          borderWidth: '0 0 0px 0',
          display: 'block',
          width: 'auto',
          lineHeight: '1.5',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'yonghu'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ padding: '0 5px', fontSize: '14px', color: '#333', display: 'none' }"
        ></span>
        <div
          :style="{
            width: '100%',
            margin: '0 10px 0 0',
            fontSize: 'inherit',
            color: 'inherit',
          }"
        >
          账号
        </div>
        <div
          :style="{ fontSize: 'inherit', color: 'inherit', textAlign: 'left', flex: 1 }"
        >
          {{ sessionForm.zhanghao }}
        </div>
      </div>
      <div
        :style="{
          padding: '0 0px',
          borderColor: '#1abc9e20',
          margin: '0 5% 0 0',
          borderWidth: '0 0 0px 0',
          display: 'block',
          width: 'auto',
          lineHeight: '1.5',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'yonghu'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ padding: '0 5px', fontSize: '14px', color: '#333', display: 'none' }"
        ></span>
        <div :style="{ color: 'inherit', margin: '0 10px 0 0', fontSize: 'inherit' }">
          昵称
        </div>
        <div
          :style="{ fontSize: 'inherit', color: 'inherit', textAlign: 'left', flex: 1 }"
        >
          {{ sessionForm.nicheng }}
        </div>
      </div>
      <div
        :style="{
          padding: '0 0px',
          borderColor: '#1abc9e20',
          margin: '0 5% 0 0',
          borderWidth: '0 0 0px 0',
          display: 'block',
          width: 'auto',
          lineHeight: '1.5',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'yonghu'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ padding: '0 5px', fontSize: '14px', color: '#333', display: 'none' }"
        ></span>
        <div :style="{ color: 'inherit', margin: '0 10px 0 0', fontSize: 'inherit' }">
          性别
        </div>
        <div
          :style="{ fontSize: 'inherit', color: 'inherit', textAlign: 'left', flex: 1 }"
        >
          {{ sessionForm.xingbie }}
        </div>
      </div>
      <div
        :style="{
          padding: '0 0px',
          borderColor: '#1abc9e20',
          margin: '0 5% 0 0',
          borderWidth: '0 0 0px 0',
          display: 'block',
          width: 'auto',
          lineHeight: '1.5',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'yonghu'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ padding: '0 5px', fontSize: '14px', color: '#333', display: 'none' }"
        ></span>
        <div :style="{ color: 'inherit', margin: '0 10px 0 0', fontSize: 'inherit' }">
          手机
        </div>
        <div
          :style="{ fontSize: 'inherit', color: 'inherit', textAlign: 'left', flex: 1 }"
        >
          {{ sessionForm.shouji }}
        </div>
      </div>
      <div
        :style="{
          padding: '0 0px',
          borderColor: '#1abc9e20',
          margin: '0 5% 0 0',
          borderWidth: '0 0 0px 0',
          display: 'block',
          width: 'auto',
          lineHeight: '1.5',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'yonghu'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ padding: '0 5px', fontSize: '14px', color: '#333', display: 'none' }"
        ></span>
        <div :style="{ color: 'inherit', margin: '0 10px 0 0', fontSize: 'inherit' }">
          邮箱
        </div>
        <div
          :style="{ fontSize: 'inherit', color: 'inherit', textAlign: 'left', flex: 1 }"
        >
          {{ sessionForm.youxiang }}
        </div>
      </div>
      <div
        :style="{
          padding: '0 0px',
          borderColor: '#1abc9e20',
          margin: '0',
          borderWidth: '0 0 0px 0',
          display: 'block',
          width: 'auto',
          lineHeight: '1.5',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'yonghu'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ padding: '0 5px', fontSize: '14px', color: '#333', display: 'none' }"
        ></span>
        <div :style="{ color: 'inherit', margin: '0 10px 0 0', fontSize: 'inherit' }">
          游戏分类
        </div>
        <div
          :style="{ fontSize: 'inherit', color: 'inherit', textAlign: 'left', flex: 1 }"
        >
          {{ sessionForm.youxifenlei }}
        </div>
      </div>
    </div>

    <el-tabs
      tab-position="left"
      :style="{
        width: '100%',
        margin: '20px 0 0',
        alignItems: 'flex-start',
        flexWrap: 'wrap',
        background: 'none',
        display: 'flex',
      }"
      @tab-click="handleClick"
    >
      <el-tab-pane label="个人中心">
        <el-form
          class="center-preview-pv"
          ref="sessionForm"
          :model="sessionForm"
          :rules="rules"
          label-width="100px"
        >
          <el-form-item
            :style="{
              width: '100%',
              padding: '0px',
              margin: '0 0 20px',
              background: 'none',
              display: 'inline-block',
            }"
            v-if="userTableName == 'yonghu'"
            label="账号"
            prop="zhanghao"
          >
            <el-input
              v-model="sessionForm.zhanghao"
              placeholder="账号"
              readonly
            ></el-input>
          </el-form-item>
          <el-form-item
            :style="{
              width: '100%',
              padding: '0px',
              margin: '0 0 20px',
              background: 'none',
              display: 'inline-block',
            }"
            v-if="userTableName == 'yonghu'"
            label="昵称"
            prop="nicheng"
          >
            <el-input v-model="sessionForm.nicheng" placeholder="昵称"></el-input>
          </el-form-item>
          <el-form-item
            :style="{
              width: '100%',
              padding: '0px',
              margin: '0 0 20px',
              background: 'none',
              display: 'inline-block',
            }"
            v-if="userTableName == 'yonghu'"
            label="性别"
            prop="xingbie"
          >
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别">
              <el-option
                v-for="(item, index) in dynamicProp.xingbie"
                :key="index"
                :label="item"
                :value="item"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item
            :style="{
              width: '100%',
              padding: '0px',
              margin: '0 0 20px',
              background: 'none',
              display: 'inline-block',
            }"
            v-if="userTableName == 'yonghu'"
            label="手机"
            prop="shouji"
          >
            <el-input v-model="sessionForm.shouji" placeholder="手机"></el-input>
          </el-form-item>
          <el-form-item
            :style="{
              width: '100%',
              padding: '0px',
              margin: '0 0 20px',
              background: 'none',
              display: 'inline-block',
            }"
            v-if="userTableName == 'yonghu'"
            label="邮箱"
            prop="youxiang"
          >
            <el-input v-model="sessionForm.youxiang" placeholder="邮箱"></el-input>
          </el-form-item>
          <el-form-item
            :style="{
              width: '100%',
              padding: '0px',
              margin: '0 0 20px',
              background: 'none',
              display: 'inline-block',
            }"
            v-if="userTableName == 'yonghu'"
            label="游戏分类"
            prop="youxifenlei"
          >
            <el-select
              v-model="sessionForm.youxifenleiArray"
              placeholder="请选择游戏分类"
              multiple
              @change="yonghuyouxifenleiMulChange"
            >
              <el-option
                v-for="(item, index) in dynamicProp.youxifenlei"
                :key="index"
                :label="item"
                :value="item"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item
            :style="{
              width: '100%',
              padding: '0px',
              margin: '0 0 20px',
              background: 'none',
              display: 'inline-block',
            }"
            v-if="userTableName == 'yonghu'"
            label="头像"
            prop="touxiang"
          >
            <file-upload
              tip="点击上传头像"
              action="file/upload"
              :limit="1"
              :multiple="true"
              :fileUrls="sessionForm.touxiang ? sessionForm.touxiang : ''"
              @change="yonghutouxiangHandleAvatarSuccess"
            ></file-upload>
          </el-form-item>
          <el-form-item
            :style="{
              width: '100%',
              padding: '0px',
              margin: '0 0 20px',
              background: 'none',
              display: 'inline-block',
            }"
            v-if="userTableName == 'yonghu'"
            label="个人简介"
          >
            <editor
              :style="{
                minHeight: '250px',
                border: '0px solid #1abc9e30',
                outline: 'none',
                color: '#333',
                borderRadius: '4px',
                background: '#fff',
                width: '100%',
                lineHeight: '32px',
                fontSize: '14px',
              }"
              v-model="sessionForm.gerenjianjie"
              class="editor"
              action="file/upload"
            >
            </editor>
          </el-form-item>
          <el-form-item :style="{ padding: '0', margin: '0' }">
            <el-button
              :style="{
                border: '0',
                cursor: 'pointer',
                padding: '0',
                margin: '0 20px 0 0',
                outline: 'none',
                color: 'rgba(255, 255, 255, 1)',
                borderRadius: '30px',
                background: 'rgb(255, 133, 161)',
                width: '120px',
                lineHeight: '50px',
                fontSize: '14px',
                height: '50px',
              }"
              type="primary"
              @click="onSubmit('sessionForm')"
              >更新信息</el-button
            >
            <el-button
              :style="{
                border: '1px solid rgb(255, 133, 161)',
                cursor: 'pointer',
                padding: '0',
                margin: '0',
                outline: 'none',
                color: 'rgb(255, 133, 161)',
                borderRadius: '30px',
                background: '#fff',
                width: '110px',
                lineHeight: '50px',
                fontSize: '14px',
                height: '50px',
              }"
              type="danger"
              @click="logout"
              >退出登录</el-button
            >
          </el-form-item>
        </el-form>
      </el-tab-pane>
      <el-tab-pane label="修改密码">
        <el-form
          class="center-preview-pv"
          ref="passwordForm"
          :model="passwordForm"
          :rules="passwordRules"
          label-width="100px"
        >
          <el-form-item
            :style="{
              width: '100%',
              padding: '0px',
              margin: '0 0 20px',
              background: 'none',
              display: 'inline-block',
            }"
            label="原密码"
            prop="password"
          >
            <el-input
              type="password"
              v-model="passwordForm.password"
              placeholder="原密码"
            ></el-input>
          </el-form-item>
          <el-form-item
            :style="{
              width: '100%',
              padding: '0px',
              margin: '0 0 20px',
              background: 'none',
              display: 'inline-block',
            }"
            label="新密码"
            prop="newpassword"
          >
            <el-input
              type="password"
              v-model="passwordForm.newpassword"
              placeholder="新密码"
            ></el-input>
          </el-form-item>
          <el-form-item
            :style="{
              width: '100%',
              padding: '0px',
              margin: '0 0 20px',
              background: 'none',
              display: 'inline-block',
            }"
            label="确认密码"
            prop="repassword"
          >
            <el-input
              type="password"
              v-model="passwordForm.repassword"
              placeholder="确认密码"
            ></el-input>
          </el-form-item>
          <el-form-item :style="{ padding: '0', margin: '0' }">
            <el-button
              :style="{
                border: '0',
                cursor: 'pointer',
                padding: '0',
                margin: '0 20px 0 0',
                outline: 'none',
                color: 'rgba(255, 255, 255, 1)',
                borderRadius: '30px',
                background: 'rgb(255, 133, 161)',
                width: '120px',
                lineHeight: '50px',
                fontSize: '14px',
                height: '50px',
              }"
              type="primary"
              @click="updatePassword"
              >修改密码</el-button
            >
          </el-form-item>
        </el-form>
      </el-tab-pane>
      <el-tab-pane label="聊天记录" style="width: 100%" v-if="changeHasChat()">
        <div class="z-box" :style="{ width: '70%', padding: '20px', margin: '0 auto' }">
          <div
            class="section-content"
            v-for="item in recordList"
            :key="item.id"
            @click="chatClick(item)"
          >
            <img
              :src="
                item.picture ? baseUrl + item.picture : require('@/assets/avator.png')
              "
              style="width: 60px; border-radius: 50%"
              alt=""
            />
            <div
              style="
                margin: 0 0 0 10px;
                display: flex;
                flex-direction: column;
                align-items: flex-start;
              "
            >
              <div
                :style="{
                  fontSize: '14px',
                  color: '#000',
                  flex: '1',
                  fontWeight: 'bold',
                }"
                class="item-style"
              >
                {{ item.name }}
              </div>
              <div
                :style="{
                  color: '#666',
                  flex: '1',
                  fontSize: '14px',
                  lineHeight: '1.5',
                  display: 'flex',
                  alignItems: 'center',
                }"
                class="item-style"
              >
                <div
                  v-if="item.notreadnum"
                  style="
                    padding: 0 5px;
                    height: 16px;
                    border-radius: 50%;
                    text-align: center;
                    line-height: 16px;
                    font-size: 12px;
                    background: #f00;
                    color: #fff;
                    width: auto;
                    margin: 0 2px 0 0;
                  "
                >
                  {{ item.notreadnum }}
                </div>
                {{
                  item.content.split("/").length && item.content.split("/")[0] == "upload"
                    ? "[图片]"
                    : item.content
                }}
              </div>
            </div>
          </div>
          <div class="noList" v-if="!recordList.length">暂无聊天记录</div>
        </div>
      </el-tab-pane>
      <el-tab-pane
        v-for="(item, index) in menuList"
        :key="index"
        v-if="hasBack(item.menu)"
        :label="item.child[0].menu"
        :name="item.child[0].tableName"
      ></el-tab-pane>
      <el-tab-pane label="我的发布"></el-tab-pane>
      <el-tab-pane label="我的收藏"></el-tab-pane>
      <el-tab-pane label="我的关注"></el-tab-pane>
    </el-tabs>

    <el-dialog :visible.sync="chatVisible" @close="clearChat" :title="nowname">
      <div class="chat-content" id="chat-content">
        <div v-bind:key="item.id" v-for="item in chatList">
          <div v-if="item.uid == sessionForm.id" class="right-content">
            <el-alert
              v-if="item.format == 1"
              class="text-content"
              :title="item.content"
              :closable="false"
              type="warning"
            ></el-alert>
            <el-image
              v-else
              fit="cover"
              :src="item.content ? baseUrl + item.content : ''"
              style="width: 100px; height: 100px"
              :preview-src-list="[item.content ? baseUrl + item.content : '']"
            ></el-image>
            <img
              :src="mypic ? baseUrl + mypic : require('@/assets/avator.png')"
              alt=""
              style="width: 30px; border-radius: 50%; height: 30px; margin: 0 0 0 10px"
            />
          </div>
          <div v-else class="left-content">
            <img
              :src="nowfpic ? baseUrl + nowfpic : require('@/assets/avator.png')"
              alt=""
              style="width: 30px; border-radius: 50%; height: 30px; margin: 0 10px 0 0"
            />
            <el-alert
              v-if="item.format == 1"
              class="text-content"
              :title="item.content"
              :closable="false"
              type="success"
            ></el-alert>
            <el-image
              v-else
              fit="cover"
              :src="item.content ? baseUrl + item.content : ''"
              style="width: 100px; height: 100px"
              :preview-src-list="[item.content ? baseUrl + item.content : '']"
            ></el-image>
          </div>
          <div class="clear-float"></div>
        </div>
      </div>
      <div slot="footer" class="dialog-footer">
        <el-input
          @keydown.enter.native="addChat"
          v-model="chatForm.content"
          placeholder="请输入内容"
          style="width: calc(100% - 180px); float: left"
        >
        </el-input>
        <el-button
          :disabled="chatForm.content ? false : true"
          type="primary"
          @click="addChat"
          >发送</el-button
        >
        <el-upload
          style="display: inline-block; margin: 0 0 0 6px"
          class="upload-demo"
          :action="uploadUrl"
          :on-success="uploadSuccess"
          :show-file-list="false"
        >
          <el-button type="success">上传图片</el-button>
        </el-upload>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import config from "@/config/config";
import menu from "@/config/menu";
import Vue from "vue";
export default {
  //数据集合
  data() {
    return {
      title: "个人中心",
      baseUrl: config.baseUrl,
      sessionForm: {},
      passwordForm: {},
      passwordRules: {
        password: [
          {
            required: true,
            message: "密码不能为空",
            trigger: "blur",
          },
        ],
        newpassword: [
          {
            required: true,
            message: "新密码不能为空",
            trigger: "blur",
          },
        ],
        repassword: [
          {
            required: true,
            message: "确认密码不能为空",
            trigger: "blur",
          },
        ],
      },
      rules: {},
      menuList: [],
      disabled: false,
      uploadUrl: config.baseUrl + "file/upload",
      imageUrl: "",
      headers: { Token: localStorage.getItem("frontToken") },
      userTableName: localStorage.getItem("UserTableName"),
      dynamicProp: {},
      recordList: [],
      chatVisible: false,
      nowfid: 0,
      nowfpic: "",
      nowname: "",
      mypic: localStorage.getItem("frontHeadportrait"),
      chatList: [],
      chatForm: {
        content: "",
      },
      chatTimer: null,
      hasChatList: ["yonghu"],
    };
  },
  created() {
    let menus = menu.list();
    for (let x in menus) {
      if (menus[x].tableName == this.userTableName) {
        this.menuList = menus[x].backMenu;
      }
    }
    if ("yonghu" == this.userTableName) {
      this.$set(this.sessionForm, "zhanghao", null);
    }
    if ("yonghu" == this.userTableName) {
      this.$set(this.sessionForm, "mima", null);
    }
    if ("yonghu" == this.userTableName) {
      this.$set(this.sessionForm, "nicheng", null);
    }
    if ("yonghu" == this.userTableName) {
      this.$set(this.sessionForm, "xingbie", null);
    }
    if ("yonghu" == this.userTableName) {
      this.$set(this.sessionForm, "shouji", null);
    }
    if ("yonghu" == this.userTableName) {
      this.$set(this.sessionForm, "youxiang", null);
    }
    if ("yonghu" == this.userTableName) {
      this.$set(this.sessionForm, "youxifenlei", null);
    }
    if ("yonghu" == this.userTableName) {
      this.$set(this.sessionForm, "touxiang", null);
    }
    if ("yonghu" == this.userTableName) {
      this.$set(this.sessionForm, "gerenjianjie", null);
    }
    if ("yonghu" == this.userTableName) {
      this.$set(this.sessionForm, "status", null);
    }

    if ("yonghu" == this.userTableName && this.rules["zhanghao"]) {
      this.rules["zhanghao"].push({
        required: true,
        message: "请输入账号",
        trigger: "blur",
      });
    } else if ("yonghu" == this.userTableName && !this.rules["zhanghao"]) {
      this.$set(this.rules, "zhanghao", [
        { required: true, message: "请输入账号", trigger: "blur" },
      ]);
    }
    if ("yonghu" == this.userTableName && this.rules["mima"]) {
      this.rules["mima"].push({ required: true, message: "请输入密码", trigger: "blur" });
    } else if ("yonghu" == this.userTableName && !this.rules["mima"]) {
      this.$set(this.rules, "mima", [
        { required: true, message: "请输入密码", trigger: "blur" },
      ]);
    }
    if ("yonghu" == this.userTableName && this.rules["nicheng"]) {
      this.rules["nicheng"].push({
        required: true,
        message: "请输入昵称",
        trigger: "blur",
      });
    } else if ("yonghu" == this.userTableName && !this.rules["nicheng"]) {
      this.$set(this.rules, "nicheng", [
        { required: true, message: "请输入昵称", trigger: "blur" },
      ]);
    }
    if ("yonghu" == this.userTableName) {
      this.$set(this.rules, "shouji", [
        { required: false, validator: this.$validate.isMobile, trigger: "blur" },
      ]);
    }
    if ("yonghu" == this.userTableName) {
      this.$set(this.rules, "youxiang", [
        { required: false, validator: this.$validate.isEmail, trigger: "blur" },
      ]);
    }
    if ("yonghu" == this.userTableName) {
      this.$set(this.rules, "status", [
        { required: false, validator: this.$validate.isIntNumer, trigger: "blur" },
      ]);
    }

    this.init();
    this.sessionForm = JSON.parse(localStorage.getItem("sessionForm"));
  },
  //方法集合
  methods: {
    init() {
      if ("yonghu" == this.userTableName) {
        this.dynamicProp.xingbie = "男,女".split(",");
      }
      if ("yonghu" == this.userTableName) {
        this.$http
          .get("option/youxifenlei/youxifenlei", { emulateJSON: true })
          .then((res) => {
            if (res.data.code == 0) {
              this.dynamicProp.youxifenlei = res.data.data;
              this.$forceUpdate();
            }
          });
      }
    },
    setSession() {
      localStorage.setItem("sessionForm", JSON.stringify(this.sessionForm));
    },
    yonghuyouxifenleiMulChange(e) {
      this.sessionForm.youxifenlei = this.sessionForm.youxifenleiArray.join(",");
    },
    onSubmit(formName) {
      if (`yonghu` == this.userTableName && this.sessionForm.touxiang != null) {
        this.sessionForm.touxiang = this.sessionForm.touxiang.replace(
          new RegExp(this.$config.baseUrl, "g"),
          ""
        );
      }
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$http
            .post(this.userTableName + "/update", this.sessionForm)
            .then((res) => {
              if (res.data.code == 0) {
                this.setSession();
                this.$message({
                  message: "更新成功",
                  type: "success",
                  duration: 1500,
                });
              }
            });
        } else {
          return false;
        }
      });
    },
    yonghutouxiangHandleAvatarSuccess(fileUrls) {
      this.sessionForm.touxiang = fileUrls;
    },
    handleClick(tab, event) {
      switch (event.target.outerText) {
        case "个人中心":
          tab.$router.push("/index/center");
          break;
        case "修改密码":
          this.passwordForm = {
            password: "",
            newpassword: "",
            repassword: "",
          };
          this.$forceUpdate();
          break;
        case "聊天记录":
          this.getRecordList();
          break;
        case "我的发布":
          tab.$router.push("/index/myForumList");
          break;
        case "我的收藏":
          localStorage.setItem("storeupType", 1);
          tab.$router.push("/index/storeup");
          break;
        case "我的关注":
          localStorage.setItem("storeupType", 41);
          tab.$router.push("/index/storeup");
          break;
        default:
          tab.$router.push(`/index/${tab.name}?centerType=1`);
      }

      this.title = event.target.outerText;
    },
    changeHasChat() {
      let table = localStorage.getItem("frontSessionTable");
      console.log(table);
      for (let x in this.hasChatList) {
        if (this.hasChatList[x] == table) {
          return true;
        }
      }
      return false;
    },
    getRecordList() {
      this.$http
        .get("friend/page2", {
          params: {
            uid: localStorage.getItem("frontUserid"),
            type: 2,
          },
        })
        .then((res) => {
          if (res.data && res.data.code == 0) {
            this.recordList = res.data.data.list;
          }
        });
    },
    chatClick(row) {
      this.nowfid = row.fid;
      this.nowfpic = row.picture;
      this.nowname = row.name;
      this.getChatList();
      this.chatVisible = true;
    },
    getChatList() {
      this.$http
        .get("chatmessage/mlist", {
          params: {
            page: 1,
            limit: 1000,
            uid: localStorage.getItem("frontUserid"),
            fid: this.nowfid,
          },
        })
        .then((res) => {
          if (res.data && res.data.code == 0) {
            this.chatList = res.data.data.list;
            let div = document.getElementsByClassName("chat-content")[0];
            setTimeout(() => {
              if (div) div.scrollTop = div.scrollHeight;
            }, 0);
            this.chatTimer = setTimeout(() => {
              this.getChatList();
            }, 5000);
          }
        });
    },
    clearChat() {
      clearTimeout(this.chatTimer);
      this.chatList = [];
      this.getRecordList();
    },
    uploadSuccess(res) {
      if (res.code == 0) {
        clearTimeout(this.chatTimer);
        this.$http
          .post("chatmessage/add", {
            uid: localStorage.getItem("frontUserid"),
            fid: this.nowfid,
            content: "upload/" + res.file,
            format: 2,
          })
          .then((res2) => {
            this.chatForm = {
              content: "",
            };
            this.getChatList();
          });
      }
    },
    addChat() {
      clearTimeout(this.chatTimer);
      let sensitiveWords =
        "台独,黄,毒,赌,黑鬼,重男轻女,滚粗,算命,抢,装13,大男人,小女人,洋鬼子,回回,高丽棒子,杂种,男尊女卑,东亚病夫,xx天见效";
      let sensitiveWordsArr = [];
      if (sensitiveWords) {
        sensitiveWordsArr = sensitiveWords.split(",");
      }
      for (var i = 0; i < sensitiveWordsArr.length; i++) {
        //全局替换
        var reg = new RegExp(sensitiveWordsArr[i], "g");
        //判断内容中是否包括敏感词
        if (this.chatForm.content.indexOf(sensitiveWordsArr[i]) > -1) {
          // 将敏感词替换为 **
          this.chatForm.content = this.chatForm.content.replace(reg, "**");
        }
      }
      this.$http
        .post("chatmessage/add", {
          uid: localStorage.getItem("frontUserid"),
          fid: this.nowfid,
          content: this.chatForm.content,
          format: 1,
        })
        .then((res2) => {
          this.chatForm = {
            content: "",
          };
          this.getChatList();
        });
    },
    async updatePassword() {
      this.$refs["passwordForm"].validate(async (valid) => {
        if (valid) {
          var password = "";
          if (this.sessionForm.mima) {
            password = this.sessionForm.mima;
          } else if (this.sessionForm.password) {
            password = this.sessionForm.password;
          }
          if (this.passwordForm.password != password) {
            this.$message.error("原密码错误");
            return;
          }
          if (this.passwordForm.newpassword != this.passwordForm.repassword) {
            this.$message.error("两次密码输入不一致");
            return;
          }
          if (this.passwordForm.newpassword == this.passwordForm.password) {
            this.$message.error("新密码与原密码相同！");
            return;
          }
          if (this.userTableName == "yonghu") {
          }
          this.sessionForm.password = this.passwordForm.newpassword;
          this.sessionForm.mima = this.passwordForm.newpassword;
          this.$http
            .post(`${this.userTableName}/update`, this.sessionForm)
            .then(({ data }) => {
              if (data && data.code === 0) {
                this.$message({
                  message: "修改密码成功,下次登录系统生效",
                  type: "success",
                  duration: 1500,
                  onClose: () => {},
                });
                this.setSession();
              } else {
                this.$message.error(data.msg);
              }
            });
        }
      });
    },
    logout() {
      localStorage.clear();
      Vue.http.headers.common["Token"] = "";
      this.$router.push("/index/home");
      this.activeIndex = "0";
      localStorage.setItem("keyPath", this.activeIndex);
      this.$forceUpdate();
      this.$message({
        message: "登出成功",
        type: "success",
        duration: 1500,
      });
    },
    hasBack(name) {
      switch (name) {
        case "我的收藏管理":
          return false;
          break;
        case "我的关注管理":
          return false;
          break;
        // case "游戏信息管理":
        //   return false;
        //   break;
        default:
          return true;
      }
    },
  },
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.center-preview {
  .el-tabs {
    & /deep/ .el-tabs__header {
      .el-tabs__nav {
        overflow: auto;
      }
      ::-webkit-scrollbar {
        -webkit-appearance: none;
        width: 6px;
        height: 6px;
      }
      ::-webkit-scrollbar-track {
        background: rgba(0, 0, 0, 0.1);
        border-radius: 0;
      }
      ::-webkit-scrollbar-thumb {
        cursor: pointer;
        border-radius: 5px;
        background: rgba(0, 0, 0, 0.15);
        transition: color 0.2s ease;
      }
      ::-webkit-scrollbar-thumb:hover {
        background: rgba(0, 0, 0, 0.3);
      }
      .el-tabs__nav-wrap {
        margin: 0;

        &::after {
          content: none;
        }
      }

      .el-tabs__active-bar {
        display: none !important;
      }
    }

    .center-preview-pv {
      .el-date-editor.el-input {
        width: auto;
      }

      .balance {
        .el-input {
          width: auto;
        }
      }
    }
  }
}

.center-preview .el-tabs /deep/ .el-tabs__header {
  padding: 0 60px;
  margin: 20px 0 30px;
  background: #fff;
  width: 100%;
  border-color: #28890b20;
  border-width: 0 0 0px;
  position: relative;
  border-style: solid;
  text-align: center;
  height: auto;
}

.center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item {
  padding: 0 10px;
  margin: 0 10px;
  color: #666;
  font-weight: 500;
  display: block;
  font-size: 16px;
  line-height: 60px;
  float: left;
  background: none;
  width: auto;
  position: relative;
  text-align: center;
  min-width: 100px;
  height: 60px;
}

.center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  padding: 0 10px;
  color: #fff;
  background: rgb(255, 133, 161);
  font-weight: 600;
  font-size: 16px;
  line-height: 60px;
  position: relative;
  text-align: center;
  height: 60px;
}

.center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
  padding: 0 10px;
  margin: 0 10px 0 0;
  color: #fff;
  font-weight: 600;
  display: block;
  font-size: 16px;
  line-height: 60px;
  float: left;
  background: rgb(255, 133, 161);
  width: auto;
  position: relative;
  text-align: center;
  min-width: 100px;
  height: 60px;
}

.center-preview .el-tabs /deep/ .el-tabs__content {
  padding: 0px;
  margin: 0px 0 0;
  background: none;
  width: calc(100% - 20px);
}
.center-preview .el-tabs /deep/ .el-tabs__content .el-tab-pane {
  width: 100%;
}

.center-preview-pv .el-form-item /deep/ .el-form-item__label {
  padding: 0 10px 0 0;
  color: #666;
  font-weight: 500;
  width: 100px;
  font-size: 14px;
  line-height: 40px;
  text-align: right;
}

.center-preview-pv .el-form-item .el-form-item__content {
  margin-left: 100px;
}

.center-preview-pv .el-input /deep/ .el-input__inner {
  padding: 0 12px;
  color: #666;
  font-size: 14px;
  border-color: #eee;
  border-radius: 4px;
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
  outline: none;
  background: #fff;
  width: auto;
  border-width: 0px;
  border-style: solid;
  min-width: 300px;
  height: 40px;
}

.center-preview-pv .el-select /deep/ .el-input__inner {
  padding: 0 12px;
  color: #666;
  font-size: 14px;
  border-color: #eee;
  border-radius: 4px;
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
  outline: none;
  background: #fff;
  width: auto;
  border-width: 0px;
  border-style: solid;
  min-width: 300px;
  height: 40px;
}

.center-preview-pv .el-date-editor /deep/ .el-input__inner {
  padding: 0 10px 0 30px;
  color: #666;
  font-size: 14px;
  border-color: #eee;
  border-radius: 4px;
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
  outline: none;
  background: #fff;
  width: auto;
  border-width: 0px;
  border-style: solid;
  min-width: 300px;
  height: 40px;
}

.center-preview-pv /deep/ .avatar-uploader-icon {
  cursor: pointer;
  color: #666;
  font-weight: 600;
  font-size: 24px;
  border-color: #eee;
  line-height: 80px;
  border-radius: 4px;
  background: #fff;
  width: 120px;
  border-width: 0px;
  border-style: solid;
  text-align: center;
  height: 80px;
}

.center-preview-pv .el-form-item.balance /deep/ .el-input__inner {
  border-radius: 4px;
  padding: 0 12px;
  color: #666;
  background: #fff;
  display: inline-block;
  width: auto;
  font-size: 14px;
  border-color: #eee;
  border-width: 0px;
  border-style: solid;
  min-width: 300px;
  height: 40px;
}
.section-content {
  cursor: pointer;
  padding: 20px;
  box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3);
  margin: 0 0 20px;
  color: #333;
  background: #fff;
  display: flex;
  width: 100%;
  border-color: #efefef;
  border-width: 0;
  align-items: center;
  border-style: solid;
  position: relative;
}

.section-content:hover {
  color: #fff;
  background: #df847f10;
}
.chat-content {
  padding-bottom: 20px;
  width: 100%;
  margin-bottom: 10px;
  max-height: 300px;
  height: 300px;
  overflow-y: scroll;
  border: 1px solid #eeeeee;
  background: #fff;

  .left-content {
    float: left;
    margin-bottom: 10px;
    padding: 10px;
    max-width: 80%;
    display: flex;
    align-items: center;
  }

  .right-content {
    float: right;
    margin-bottom: 10px;
    padding: 10px;
    max-width: 80%;
    display: flex;
    align-items: center;
  }
}

.clear-float {
  clear: both;
}
.noList {
  color: #9e9e9e;
  width: 100%;
  text-align: center;
  padding: 60px 0;
}

/deep/ .is-left {
  margin: 0 5px !important;
}
/deep/ .el-tabs__header {
  margin-bottom: 20px !important;
}
</style>
