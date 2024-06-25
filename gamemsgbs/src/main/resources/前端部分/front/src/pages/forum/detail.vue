<template>
  <!-- 论坛外框 -->
  <div
    :style="{
      width: '100%',
      padding: '20px 12%',
      margin: '0 auto',
      position: 'relative',
      background: '#edeff1',
    }"
  >
    <div
      :style="{
        width: '100%',
        padding: '12px 0 0',
        margin: '0 auto',
        textAlign: 'center',
        background: 'none',
        height: '60px',
      }"
    >
      <div
        :style="{
          padding: '0 20px 0 0',
          color: '#333',
          textAlign: 'left',
          background: 'none',
          display: 'inline-block',
          width: 'auto',
          fontSize: '22px',
          fontWeight: '600',
        }"
      >
        游戏论坛
      </div>
    </div>
    <div
      :style="{
        padding: '16px 12%',
        margin: '0px auto',
        borderColor: '#d8d8d8',
        borderRadius: '0px',
        background: 'none',
        borderWidth: '0 0 3px',
        width: '100%',
        borderStyle: 'solid',
      }"
    >
      <el-button size="mini" style="" @click="backClick">返回</el-button>
    </div>
    <div
      class="section-content"
      :style="{
        border: '0px solid #f6f6f6',
        width: '100%',
        padding: '40px 40px 120px',
        margin: '20px auto',
        position: 'relative',
        background: '#fff',
      }"
    >
      <div
        class="content-title"
        :style="{
          padding: '0 0px',
          margin: '0 0 10px',
          color: '#333',
          textAlign: 'center',
          width: '100%',
          lineHeight: '32px',
          fontSize: '18px',
          fontWeight: '600',
          height: '32px',
        }"
      >
        {{ detail.title }}
      </div>
      <div
        :style="{
          width: '100%',
          alignItems: 'center',
          justifyContent: 'flex-end',
          display: 'flex',
        }"
      >
        <div
          :style="{
            margin: '0 10px 0 0',
            fontSize: '14px',
            color: '#999',
            textAlign: 'right',
          }"
        >
          发布人：{{ detail.username }}
        </div>
        <div :style="{ color: '#999', textAlign: 'left', fontSize: '14px' }">
          发布时间：{{ detail.addtime }}
        </div>
      </div>
      <div
        class="operate"
        :style="{
          padding: '0px',
          alignItems: 'center',
          borderRadius: '0px',
          textAlign: 'right',
          left: '47.3%',
          background: 'rgb(255, 133, 161)',
          bottom: '40px',
          display: 'inline-block',
          width: 'auto',
          position: 'absolute',
          justifyContent: 'flex-end',
        }"
      >
        <div
          @click="zanClick"
          :style="{
            border: '0px solid #1abc9e20',
            cursor: 'pointer',
            padding: '0 10px',
            margin: '0 20px',
            alignItems: 'center',
            background: 'none',
            display: 'flex',
            justifyContent: 'center',
          }"
        >
          <span
            class="icon iconfont icon-zan19"
            :style="{
              margin: '0 6px 0 0',
              lineHeight: '30px',
              fontSize: '16px',
              color: '#fff',
              display: 'none',
            }"
          ></span>
          <span :style="{ color: '#fff', lineHeight: '36px', fontSize: '14px' }"
            >{{ zanType ? "取消赞" : "点赞" }}({{ allZan }})</span
          >
        </div>
      </div>
      <div
        :style="{
          border: '0px solid #ddd',
          padding: '20px 0px',
          fontSize: '14px',
          color: '#999',
        }"
        class="content-detail"
        v-html="detail.content"
      ></div>

      <div
        :style="{
          border: '0px solid #eee',
          width: '100%',
          padding: '0',
          margin: '20px auto',
          background: 'none',
        }"
      >
        <div
          :style="{
            padding: '0 0 10px 0',
            borderColor: '#d8d8d8',
            alignItems: 'center',
            borderWidth: '0 0 3px 0',
            display: 'flex',
            width: '100%',
            position: 'relative',
            borderStyle: 'solid',
          }"
        >
          <div :style="{ color: '#333', fontSize: '18px', fontWeight: '600' }">
            评论列表
          </div>
          <el-button
            class="pub"
            type="primary"
            :style="{
              cursor: 'pointer',
              border: '1px solid #1abc9e20',
              padding: '0px 30px',
              margin: '0 10px 0 40px',
              outline: 'none',
              color: '#fff',
              borderRadius: '0px',
              background: 'rgb(255, 133, 161)',
              width: 'auto',
              fontSize: '14px',
              lineHeight: '44px',
              height: '44px',
            }"
            @click="addComment"
          >
            <span
              class="icon iconfont icon-xiugai10"
              :style="{
                margin: '0 4px 0 0',
                fontSize: '14px',
                color: '#fff',
                display: 'none',
              }"
            ></span>
            点击评论
          </el-button>
        </div>
        <div
          class="comment"
          :style="{ width: '100%', padding: '20px 0 0', background: 'none' }"
        >
          <template v-if="commentList && commentList.length">
            <div
              class="item"
              :style="{
                border: '0px solid #1e3c4f',
                padding: '20px 20px 30px',
                margin: '20px 0 40px',
                alignItems: 'center',
                color: '#666',
                background: '#fff',
                width: '100%',
                height: 'auto',
              }"
              v-for="(item, index) in commentList"
              :key="item.id"
              @mouseenter="commentEnter(item.id)"
              @mouseleave="commentLeave"
            >
              <div
                class="user"
                :style="{
                  border: '0px solid #f6f6f6',
                  padding: '4px',
                  alignItems: 'center',
                  borderRadius: '4px',
                  background: '#fff',
                  display: 'flex',
                  width: '100%',
                  height: 'auto',
                }"
              >
                <img
                  v-if="item.avatarurl"
                  :style="{
                    width: '36px',
                    margin: '0 10px 0 0',
                    borderRadius: '100%',
                    objectFit: 'cover',
                    height: '36px',
                  }"
                  :src="baseUrl + item.avatarurl"
                />
                <img
                  v-if="!item.avatarurl"
                  :style="{
                    width: '36px',
                    margin: '0 10px 0 0',
                    borderRadius: '100%',
                    objectFit: 'cover',
                    height: '36px',
                  }"
                  :src="require('@/assets/touxiang.png')"
                />
                <div :style="{ color: '#666', fontSize: '16px' }" class="name">
                  用户：{{ item.username }}
                </div>
              </div>
              <div
                :style="{
                  border: '0px solid #eee',
                  padding: '10px',
                  margin: '10px 0px 0px',
                  color: '#666',
                  borderRadius: '4px',
                  background: 'none',
                  lineHeight: '24px',
                  fontSize: '14px',
                }"
                v-html="item.content"
              ></div>
              <div
                class="btn"
                :style="{
                  width: '100%',
                  margin: '12px 0 0 0',
                  alignItems: 'center',
                  justifyContent: 'flex-start',
                  display: 'flex',
                  height: '20px',
                }"
              >
                <el-button
                  :style="{
                    border: '0px solid #ddd',
                    cursor: 'pointer',
                    padding: '0 20px',
                    margin: '0 10px',
                    outline: 'none',
                    color: '#fff',
                    borderRadius: '20px',
                    background: 'rgb(255, 133, 161)',
                    width: 'auto',
                    lineHeight: '30px',
                    fontSize: '14px',
                    height: '30px',
                  }"
                  v-if="true"
                  @click="replyClick(item.id)"
                  >回复</el-button
                >
                <el-button
                  :style="{
                    border: '1px solid rgb(255, 133, 161)',
                    cursor: 'pointer',
                    padding: '0 20px',
                    margin: '0 10px',
                    outline: 'none',
                    color: 'rgb(255, 133, 161)',
                    borderRadius: '20px',
                    background: 'none',
                    width: 'auto',
                    lineHeight: '30px',
                    fontSize: '14px',
                    height: '30px',
                  }"
                  v-if="true && userid == item.userid"
                  @click="commentDel(item.id)"
                  >删除</el-button
                >
                <div @click="fanyi(item.content, index)">
                  <svg
                    t="1713012712646"
                    class="icon yiyi"
                    id="yiyi"
                    viewBox="0 0 1033 1024"
                    version="1.1"
                    xmlns="http://www.w3.org/2000/svg"
                    p-id="3476"
                    width="32"
                    height="32"
                  >
                    <path
                      d="M726.109091 76.8c128 0 230.4 102.4 230.4 230.4v409.6c0 128-102.4 230.4-230.4 230.4H316.509091c-128 0-230.4-102.4-230.4-230.4V307.2c0-128 102.4-230.4 230.4-230.4h409.6m0-76.8H316.509091C148.945455 0 9.309091 137.309091 9.309091 307.2v409.6c0 169.890909 139.636364 307.2 307.2 307.2h409.6c169.890909 0 307.2-137.309091 307.2-307.2V307.2C1033.309091 137.309091 896 0 726.109091 0z"
                      p-id="3477"
                      fill="#8a8a8a"
                    ></path>
                    <path
                      d="M751.709091 314.181818c30.254545-2.327273 30.254545 39.563636 2.327273 41.890909-27.927273 2.327273-162.909091 9.309091-269.963637 11.636364-2.327273 25.6-2.327273 53.527273-4.654545 83.781818 27.927273-4.654545 60.509091-11.636364 90.763636-11.636364h30.254546c2.327273-11.636364 0-4.654545 9.309091-34.90909s48.872727-20.945455 39.563636 9.30909c-9.309091 27.927273-4.654545 23.272727-9.309091 34.909091 23.272727 4.654545 41.890909 16.290909 62.836364 30.254546 41.890909 30.254545 65.163636 74.472727 65.163636 128 0 58.181818-16.290909 100.072727-53.527273 130.327273-34.909091 27.927273-109.381818 51.2-151.272727 58.181818-39.563636 4.654545-39.563636-37.236364-13.963636-39.563637 23.272727-2.327273 100.072727-23.272727 130.327272-48.872727s46.545455-60.509091 46.545455-102.4c0-39.563636-16.290909-74.472727-51.2-97.745454-13.963636-9.309091-27.927273-13.963636-41.890909-20.945455-16.290909 53.527273-37.236364 102.4-65.163637 151.272727-53.527273 86.109091-116.363636 128-193.163636 128-27.927273 0-51.2-11.636364-67.490909-27.927272-20.945455-16.290909-27.927273-41.890909-27.927273-76.8 0-60.509091 27.927273-111.709091 83.781818-153.6 23.272727-20.945455 48.872727-34.909091 76.8-46.545455 0-30.254545 2.327273-62.836364 4.654546-93.090909h-153.6c-30.254545 0-30.254545-41.890909 0-41.890909h160.581818c2.327273-25.6 4.654545-48.872727 11.636364-79.127273 4.654545-30.254545 48.872727-25.6 41.890909 11.636364-4.654545 34.909091-9.309091 46.545455-11.636364 67.490909 104.727273-2.327273 225.745455-6.981818 258.327273-11.636364z m-162.909091 169.890909h-20.945455c-30.254545 0-62.836364 2.327273-90.763636 11.636364v9.309091c0 62.836364 2.327273 116.363636 11.636364 165.236363 13.963636-13.963636 25.6-30.254545 37.236363-48.872727 23.272727-41.890909 46.545455-86.109091 62.836364-137.309091zM435.2 512c-16.290909 9.309091-30.254545 16.290909-46.545455 27.927273-46.545455 37.236364-67.490909 76.8-67.490909 123.345454 0 41.890909 16.290909 65.163636 51.2 65.163637 27.927273 0 58.181818-9.309091 83.781819-25.6-16.290909-55.854545-20.945455-118.690909-20.945455-190.836364z"
                      p-id="3478"
                      fill="#8a8a8a"
                    ></path>
                  </svg>
                </div>
              </div>

              <template v-if="item.childs && item.childs.length">
                <div class="comment" :style="{ width: '100%', padding: '0 0px' }">
                  <div
                    class="item"
                    :style="{
                      padding: '10px',
                      margin: '20px 0 0 0',
                      borderColor: '#edeff1',
                      alignItems: 'center',
                      color: '#666',
                      background: '#fff',
                      borderWidth: '2px 0 0',
                      width: '100%',
                      borderStyle: 'solid',
                      height: 'auto',
                    }"
                    v-for="items in item.childs"
                    :key="items.id"
                    @mouseenter="commentEnter1(items.id)"
                    @mouseleave="commentLeave1"
                  >
                    <div
                      class="user"
                      :style="{
                        border: '0px solid #f6f6f6',
                        padding: '4px',
                        alignItems: 'center',
                        borderRadius: '4px',
                        background: 'none',
                        display: 'flex',
                        width: '100%',
                        height: 'auto',
                      }"
                    >
                      <img
                        v-if="items.avatarurl"
                        :style="{
                          width: '36px',
                          margin: '0 10px 0 0',
                          borderRadius: '100%',
                          objectFit: 'cover',
                          height: '36px',
                        }"
                        :src="baseUrl + items.avatarurl"
                      />
                      <img
                        v-if="!items.avatarurl"
                        :style="{
                          width: '36px',
                          margin: '0 10px 0 0',
                          borderRadius: '100%',
                          objectFit: 'cover',
                          height: '36px',
                        }"
                        :src="require('@/assets/touxiang.png')"
                      />
                      <div :style="{ color: '#333', fontSize: '16px' }" class="name">
                        用户：{{ items.username }}
                      </div>
                    </div>
                    <div
                      :style="{
                        padding: '0px',
                        margin: '4px 0 0',
                        color: '#666',
                        borderRadius: '4px',
                        background: 'none',
                        lineHeight: '30px',
                        fontSize: '14px',
                        textIndent: '2em',
                      }"
                      v-html="items.content"
                    ></div>
                    <div
                      class="btn"
                      :style="{
                        width: '100%',
                        margin: '10px 0 0 0',
                        alignItems: 'center',
                        justifyContent: 'flex-start',
                        display: 'flex',
                        height: 'auto',
                      }"
                    >
                      <el-button
                        :style="{
                          border: '1px solid rgb(255, 133, 161)',
                          cursor: 'pointer',
                          padding: '0 20px',
                          margin: '0 10px',
                          outline: 'none',
                          color: 'rgb(255, 133, 161)',
                          borderRadius: '20px',
                          background: 'none',
                          width: 'auto',
                          lineHeight: '30px',
                          fontSize: '14px',
                          height: '30px',
                        }"
                        v-if="true && userid == items.userid"
                        @click="commentDel(items.id)"
                        >删除</el-button
                      >
                    </div>
                  </div>
                </div>
              </template>
            </div>
          </template>
        </div>
      </div>
    </div>

    <el-dialog title="添加评论" :visible.sync="dialogFormVisible">
      <el-form :model="form" :rules="rules" ref="form">
        <el-form-item label="评论" label-width="60px" prop="content">
          <editor
            :style="{
              minHeight: '200px',
              border: '0',
              outline: 'none',
              color: '#333',
              borderRadius: '4px',
              width: '100%',
              lineHeight: '32px',
              fontSize: '14px',
            }"
            v-model="form.content"
            class="editor"
            action="file/upload"
          >
          </editor>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addForum('form')">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  //数据集合
  data() {
    return {
      baseUrl: "",
      id: "",
      detail: {},
      commentList: [],
      dialogFormVisible: false,
      form: {
        content: "",
        parentid: "",
        userid: localStorage.getItem("frontUserid"),
        username: localStorage.getItem("username"),
        avatarurl: "",
      },
      userid: localStorage.getItem("frontUserid"),
      editorOption: {
        modules: {
          toolbar: [
            ["bold", "italic", "underline", "strike"],
            ["blockquote", "code-block"],
            [{ header: 1 }, { header: 2 }],
            [{ list: "ordered" }, { list: "bullet" }],
            [{ script: "sub" }, { script: "super" }],
            [{ indent: "-1" }, { indent: "+1" }],
            [{ direction: "rtl" }],
            [{ size: ["small", false, "large", "huge"] }],
            [{ header: [1, 2, 3, 4, 5, 6, false] }],
            [{ color: [] }, { background: [] }],
            [{ font: [] }],
            [{ align: [] }],
            ["clean"],
            ["image", "video"],
          ],
        },
      },
      rules: {
        content: [{ required: true, message: "请输入评论", trigger: "blur" }],
      },
      zanType: false,
      zanForm: {},
      showIndex: -1,
      showIndex1: -1,
      allZan: 0,
    };
  },
  created() {
    this.baseUrl = this.$config.baseUrl;
    this.id = this.$route.query.id;
    this.getDetail();
  },
  //方法集合
  methods: {
    // 返回按钮
    backClick() {
      history.back();
    },
    onEditorReady(editor) {
      editor.root.setAttribute("data-placeholder", "请输入内容...");
    },
    getDetail() {
      this.$http.get(`forum/list/${this.id}`).then((res) => {
        if (res.data.code == 0) {
          res.data.data.content = res.data.data.content.replace(
            /img src/gi,
            'img style="width:100%;" src'
          );
          this.detail = res.data.data;
          this.commentList = res.data.data.childs;
          this.getZan();
          this.getAllZan();
        }
      });
    },
    fanyi(text, index) {
      const regex = /<p>(.*?)<\/p>/;
      const match = text.match(regex);
      const textContent = match[1]; // 提取第一个捕获组中的内容
      // console.log(textContent); // 输出文本
      this.$http.post("forum/translate", textContent).then((res) => {
        if (res.data.code === 0 && res.data.res) {
          let htmlps = "<p>";
          let htmlpd = "</p>";
          this.commentList[index].content = htmlps + res.data.res + htmlpd;
        }
      });
    },
    getZan() {
      this.$http
        .get("storeup/list", {
          params: {
            page: 1,
            limit: 1,
            type: 21,
            userid: localStorage.getItem("frontUserid"),
            tablename: "forum",
            refid: this.id,
          },
        })
        .then((res) => {
          if (res.data && res.data.code == 0) {
            if (res.data.data.list.length) {
              this.zanType = true;
              this.zanForm = res.data.data.list[0];
            } else {
              this.zanType = false;
            }
          }
        });
    },
    getAllZan() {
      this.$http
        .get("storeup/list", {
          params: {
            page: 1,
            type: 21,
            tablename: "forum",
            refid: this.id,
          },
        })
        .then((res) => {
          if (res.data && res.data.code == 0) {
            this.allZan = Number(res.data.data.total);
          }
        });
    },
    zanClick() {
      if (this.zanType) {
        this.$http.post("storeup/delete", [this.zanForm.id]).then((res) => {
          if (res.data && res.data.code == 0) {
            this.$message.success("取消成功");
            this.getZan();
            this.getAllZan();
          }
        });
      } else {
        let data = {
          name: this.detail.title,
          picture: "1",
          refid: this.detail.id,
          type: 21,
          tablename: "forum",
          userid: localStorage.getItem("frontUserid"),
        };
        this.$http.post("storeup/add", data).then((res) => {
          if (res.data && res.data.code == 0) {
            this.$message.success("点赞成功");
            this.getZan();
            this.getAllZan();
          }
        });
      }
    },
    // 新增评论
    addComment() {
      this.form.parentid = this.detail.id;
      this.dialogFormVisible = true;
    },
    // 鼠标移入
    commentEnter(index) {
      this.showIndex = index;
    },
    // 鼠标移出
    commentLeave() {
      this.showIndex = -1;
    },
    // 二级评论鼠标移入
    commentEnter1(index) {
      this.showIndex1 = index;
    },
    // 二级评论鼠标移出
    commentLeave1() {
      this.showIndex1 = -1;
    },
    // 删除评论
    commentDel(id) {
      this.$confirm("是否删除此评论？")
        .then((_) => {
          this.$http.post("forum/delete", [id]).then((res) => {
            if (res.data && res.data.code == 0) {
              this.$message({
                type: "success",
                message: "删除成功!",
                duration: 1500,
                onClose: () => {
                  this.getDetail();
                },
              });
            }
          });
        })
        .catch((_) => {});
    },
    // 回复评论
    replyClick(id) {
      this.form.parentid = id;
      this.dialogFormVisible = true;
    },
    addForum(formName) {
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
        if (this.form.content.indexOf(sensitiveWordsArr[i]) > -1) {
          // 将敏感词替换为 **
          this.form.content = this.form.content.replace(reg, "**");
        }
      }
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.form.avatarurl = localStorage.getItem("frontHeadportrait")
            ? localStorage.getItem("frontHeadportrait")
            : "";
          this.$http.post("forum/add", this.form).then((res) => {
            if (res.data.code == 0) {
              this.$message({
                type: "success",
                message: "评论成功!",
                duration: 1500,
                onClose: () => {
                  this.form.content = "";
                  this.getDetail();
                  this.dialogFormVisible = false;
                },
              });
            }
          });
        } else {
          return false;
        }
      });
    },
  },
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.section {
  width: 900px;
  margin: 0 auto;
}

.section-content {
  margin-top: 30px;
}
.content-title {
  text-align: center;
  font-size: 22px;
  font-weight: bold;
}
.content-sub-title {
  text-align: center;
  margin-top: 20px;
  color: #888888;
  font-size: 14px;
}
.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}
.header-block {
  height: 50px;
  line-height: 50px;
  display: flex;
}
.userinfo {
  align-self: center;
  margin-left: 15px;
}
.content-block-ask {
  margin: 15px 0 20px 65px;
}
.content-detail img {
  max-width: 900px;
  height: auto;
}
.operate {
  display: flex;
  align-items: center;
  justify-content: flex-start;
  padding: 0 40px;
}

#yiyi {
  transform: translate(10px, 2px);
  cursor: pointer;
}

#yiyi:hover {
  transform: scale(0.8) translate(10px, 2px);
  transition: all 0.3s;
}
#yiyi:active {
  transform: scale(0.7) translate(10px, 2px);
  transition: all 0.1s;
}
</style>
