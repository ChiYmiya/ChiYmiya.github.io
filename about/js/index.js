// 获取所有类为item的元素
let items = document.querySelectorAll(".item");
// 添加点击事件
items.forEach((item) => {
    item.addEventListener("click", setActive);
})
// 移除所有active，为当前元素添加active类
function setActive() {
    items.forEach((item) => {
        item.classList.remove("active")
    })
    this.classList.add("active")
}

// 数组储存css的url的位置
var bgs = new Array('url("about/images/bgs/bg01.jpg")', 'url("about/images/bgs/bg02.jpg")', 'url("about/images/bgs/bg04.jpg")', 'url("about/images/bgs/bg05.jpg")', 'url("about/images/bgs/bg08.jpg")', 'url("about/images/bgs/bg25.jpg")', 'url("about/images/bgs/bg09.jpg")', 'url("about/images/bgs/bg10.jpg")', 'url("about/images/bgs/bg12.jpg")', 'url("about/images/bgs/bg13.jpg")', 'url("about/images/bgs/bg25.jpg")', 'url("about/images/bgs/bg15.jpg")', 'url("about/images/bgs/bg17.jpg")', 'url("about/images/bgs/bg19.jpg")', 'url("about/images/bgs/bg20.jpg")', 'url("about/images/bgs/bg21.jpg")', 'url("about/images/bgs/bg22.jpg")', 'url("about/images/bgs/bg23.jpg")', 'url("about/images/bgs/bg25.jpg")', 'url("about/images/bgs/bg26.jpg")', 'url("about/images/bgs/bg27.jpg")', 'url("about/images/bgs/bg28.jpg")', 'url("about/images/bgs/bg29.jpg")', 'url("about/images/bgs/bg30.jpg")', 'url("about/images/bgs/bg31.jpg")', 'url("about/images/bgs/bg32.jpg")', 'url("about/images/bgs/bg33.jpg")', 'url("about/images/bgs/bg34.jpg")', 'url("about/images/bgs/bg35.jpg")', 'url("about/images/bgs/bg36.jpg")', 'url("about/images/bgs/bg37.jpg")', 'url("about/images/bgs/bg38.jpg")', 'url("about/images/bgs/bg39.jpg")', 'url("about/images/bgs/bg40.jpg")', 'url("about/images/bgs/bg41.jpg")', 'url("about/images/bgs/bg42.jpg")', 'url("about/images/bgs/bg43.jpg")', 'url("about/images/bgs/bg44.jpg")', 'url("about/images/bgs/bg45.jpg")', 'url("about/images/bgs/bg46.jpg")', 'url("about/images/bgs/bg47.jpg")', 'url("about/images/bgs/bg48.jpg")', 'url("about/images/bgs/bg49.jpg")', 'url("about/images/bgs/bg50.jpg")', 'url("about/images/bgs/bg51.jpg")', 'url("about/images/bgs/bg52.jpg")', 'url("about/images/bgs/bg53.jpg")', 'url("about/images/bgs/bg54.jpg")', 'url("about/images/bgs/bg55.jpg")', 'url("about/images/bgs/bg56.jpg")', 'url("about/images/bgs/bg57.jpg")', 'url("about/images/bgs/bg58.jpg")', 'url("about/images/bgs/bg59.jpg")', 'url("about/images/bgs/bg60.jpg")', 'url("about/images/bgs/bg61.jpg")');
// 随机更换
function changeBg() {
    document.getElementById('bgid').style.background = bgs[Math.floor(Math.random() * (bgs.length - 1 - 0 + 1)) + 0] + "no-repeat center fixed";
    document.getElementById('bgid').style.backgroundSize = "cover";
}

var lttime = document.getElementById("lttime")
var clock_p = document.getElementById("clock_p")

function timeSetRight() {
    var time = new Date()
    year = time.getFullYear()
    month = time.getMonth()
    day = time.getDate()
    hour = time.getHours()
    minutes = time.getMinutes()
    s = time.getSeconds()
    week = ["日", "月", "火", "水", "木", "金", "土"]
    document.getElementById("rtbox").innerHTML = year + '-' + month + '-' + day + '  ' + week[time.getDay()]
    if (hour < 10) {
        hour = '0' + hour
    }
    if (minutes < 10) {
        minutes = '0' + minutes
    }
    if (s < 10) {
        s = '0' + s
    }
    if (hour < 12) {
        ampm = 'AM'
    } else {
        ampm = 'PM'
    }
    lttime.innerHTML = ampm + '  ' + hour + ':' + minutes + ':' + s
    clock_p.innerHTML = hour + ':' + minutes + ':' + s
}
// 定时刷新时间，更换壁纸
setInterval(timeSetRight, 1000);
setInterval(changeBg, 8000);
// 定义上下转换标志
var getFocus_flag=true;
function getFocus() {
    let nn=document.getElementById("note");
    let tul=document.getElementById("footul");
    let tt=document.getElementById("topbtn");
    let cc = document.querySelector(".change")
    if (getFocus_flag==true) {
        nn.classList.add("stopfoot");
        tul.classList.add("stopfootul");
        tt.classList.add("stopfoot");
        cc.classList.add("topbtnspin");
        getFocus_flag=false;
    }else{
        nn.classList.remove("stopfoot");
        tul.classList.remove("stopfootul");
        tt.classList.remove("stopfoot");
        cc.classList.remove("topbtnspin");
        getFocus_flag=true;
    }
 }

