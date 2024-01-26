var libyuan = [{}];
// 导航栏实例
var nav = new Vue({
  el: "#nav",
  data() {
    return {
      activeIndex: '1',
      activeIndex2: '1',
      userName: '显示用户名',
      student: {},
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    showStudentName() {
      this.student = my.putStudent();
      this.userName = this.student.userName;
      console.log(this.userName);
    },
    changeSelect() {

      lib.show = false;
      select.show = true;
      result.show = false;
      // 查已选
      // select.getlearningcourse();
      lib.getStudentCourse();

      select.getlearncourese();
      (function () {
        var p = document.getElementsByClassName("footer")[0];
        p.style.position = "initial";
      })();
    },
    changeLib() {
      lib.show = true;
      select.show = false;
      result.show = false;
      (function () {
        var p = document.getElementsByClassName("footer")[0];
        p.style.position = "absolute";
      })();

    },
    changeResult() {

      lib.show = false;
      select.show = false;
      result.show = true;
      result.getScores();

      (function () {
        var p = document.getElementsByClassName("footer")[0];
        p.style.position = "absolute";
      })();
    }
  },

});

// 个人信息实例
var my = new Vue({
  el: "#my",
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass');
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.ruleForm.pass) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    return {
      size: "mini",
      // 学生信息
      student: {
        id: "2121",
        professional: "sdad",
        userName: "gsgsg",
        password: "sada",
        trueName: "sad",
        stuNo: "fdsafd"
      },
      dialogTableVisible: false,
      dialogFormVisible: false,
      ruleForm: {
        pass: '',
        checkPass: '',
        age: ''
      },
      rules: {
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ]
      }

    }
  },
  methods: {
    // 外部可得到student对象
    putStudent() {
      return this.student;
    },
    // 退出系统
    exitSystam() {
      window.location.href = "http://localhost:81/pages/Login.html"
      console.log("退出系统");
    },
    // 弹出对话框
    updataPossword() {
      console.log("修改密码");
      this.dialogFormVisible = true;
    },
    // 提交修改密码
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('修改成功，请重新登录');
          console.log(this.ruleForm);
          my.student.password = this.ruleForm.checkPass;
          // 修改密码 1111
          axios({
            method: 'put',
            url: 'http://localhost:81/studentinfo',
            data: my.student
          }).then((response) => {
            this.selectlib = response.data.data;
            console.log(lib)
          })
            .catch((error) => {
              console.log(error);
            });
          this.exitSystam();
        } else {
          console.log('非法提交');
          alert('非法提交!');
          return false;
        }
      });

    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    // 请求获取学生信息
    getmyAll() {
      // 初始化数据的具体实现
      const queryString = window.location.search;

      // 解析查询字符串，获取参数对象
      const queryParams = new URLSearchParams(queryString);

      // 通过参数名获取参数值
      const id = queryParams.get("id");
      this.student.id = id;
      axios({
        method: 'get',
        url: 'http://localhost:81/studentinfo',
        params: {
          id: this.student.id
        }
      }).then((response) => {
        this.student = response.data.data;
        console.log(this.student)
        this.userName = this.student.userName;
        nav.showStudentName();
      })
        .catch((error) => {
          console.log(error);
        });
    },
  }
})

// 课程信息表格实例
var lib = new Vue({
  el: "#lib",
  data() {
    return {
      lib: libyuan,
      student: {},
      show: "ture",
    }
  },
  methods: {
    tableRowClassName() {
      return 'warning-row';
    },
    // 如需要可调取此方法，获取学生个人信息
    getmystudent() {
      this.student = my.putStudent();
    },
    // 获取课程信息
    getStudentCourse() {
      axios({
        method: 'get',
        url: 'http://localhost:81/student',
        params: {
          id: my.student.id
        }
      }).then((response) => {
        // 原赋值
        // this.lib = response.data.data;
        console.log("查lib")
        console.log("赋值给lib")
        libyuan = response.data.data;
        console.log(libyuan)
        this.lib=libyuan;
        console.log("验证是否被赋值")
        console.log(this.lib)
      }).catch((error) => {
        console.log(error);
      });
    },

    change() {
      this.show = ture;
      select.show = false;

    }
  }
});

// 选择课程实例
var select = new Vue({
  el: "#select",
  data() {
    return {
      // 选择的课程
      selectlib: [{
        id: '1',
        courseName: '数据结构和算法(周一上午8:00-9:30)',
        credit: '5',
      }],
      // 已选择的课程
      selectedlib: lib.lib,
      idArray: [],
      multipleSelection: [],
      student: {},
      show: false,
      idArrayString: '',
    }
  },
  methods: {
    // getlearningcourse() {
    //   this.selectedlib = lib.lib;
    //   console.log("赋值");
    // },
    // 查询未选课程
    getlearncourese() {
      axios({
        method: 'get',
        url: 'http://localhost:81/studentlessonController',
        params: {
          id: my.student.id
        }
      }).then((response) => {
        this.selectlib = response.data.data;
        console.log("查未选")
      }).catch((error) => {
        console.log(error);
      });
    },
    tableRowClassName() {
      return 'warning-row';
    },
    toggleSelection(rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.$refs.multipleTable.clearSelection();
      }
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
      // 字符串置空
      this.idArrayString = '';
      // 定义临时数组变量
      idArray = [];
      val.forEach(currentItem => {
        idArray.push(currentItem.id);
      });
      // 转换为字符串
      this.idArrayString = idArray.join();
      // console.log(this.idArrayString);
      console.log(idArray)
    },
    //添加课程

    isSelect() {
      axios({
        method: 'post',
        url: 'http://localhost:81/studentlessonchoiceController',
        data: idArray,
        params: { stuId: my.student.id }
      }).then((response) => {
        // 查lib
        lib.getStudentCourse();
      }).catch((error) => {
        console.log(error);
      });
      console.log("确定选课");
      // 查未选
      this.getlearncourese();
      // 赋值
      // this.getlearningcourse();

    },
    // 确定退课
    isoutSelect() {
      axios({
        method: 'delete',
        url: 'http://localhost:81/studentlessonchoiceController',
        data: idArray,
        params: { stuId: my.student.id }
      }).then((response) => {
        // 查lib
        lib.getStudentCourse();
        // 赋值
        // this.getlearningcourse();
        console.log("打印已选课表");
        console.log(select.selectedlib);
        // 查未选
        this.getlearncourese();

      })
        .catch((error) => {
          console.log(error);
        });
      console.log("退课");
    }
  },
});

// 查询成绩实例
var result = new Vue({
  el: "#result",
  data() {
    return {
      resultlib: [{
        id: '1',
        courseName: '数据结构和算法(周一上午8:00-9:30)',
        credit: '5',
        teacherName: '哈撒给i',
        score: '200'
      }, {
        id: '2',
        courseName: '数据结构和算法(周一上午8:00-9:30)',
        credit: '5',
        teacherName: '哈撒给i',
        score: '老师暂未打分'
      }, {
        id: '555',
        courseName: '数据结构和算法(周一上午8:00-9:30)',
        credit: '5',
        teacherName: '哈撒给i',
        score: '老师暂未打分'
      }, {
        id: '7',
        courseName: '数据结构和算法(周一上午8:00-9:30)',
        credit: '5',
        teacherName: '哈撒给i',
        score: '老师暂未打分'
      }],
      multipleSelection: [],
      student: {},
      show: false,
      idArrayString: '',
    }
  },
  methods: {
    getScores() {
      axios({
        method: 'get',
        url: 'http://localhost:81/student',
        params: {
          id: my.student.id
        }
      }).then((response) => {
        this.resultlib = response.data.data;
        this.resultlib.forEach(currentItem => {
          if (currentItem.score == null) {
            currentItem.score = "老师暂未打分"
          }
        });
      }).catch((error) => {
        console.log(error);
      });
    }
  },
  mounted() {
    my.getmyAll();
    lib.getStudentCourse();
    nav.showStudentName();
  }

})

// 页面渲染完毕即执行

