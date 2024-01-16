// 获取所有类为item的元素
let items = document.querySelectorAll(".item");
// 添加点击事件
items.forEach((item) => {
    item.addEventListener("click", sethead_Active);
})
// 移除所有active，为当前元素添加active类
function sethead_Active() {
    items.forEach((item) => {
        item.classList.remove("active");
    })
    this.classList.add("active");
}

// 数组储存css的url的位置
var bgs = new Array(
    'url("about/images/bgs/bg01.jpg")',
    'url("about/images/bgs/bg02.jpg")',
    'url("about/images/bgs/bg03.jpg")',
    'url("about/images/bgs/bg04.jpg")',
    'url("about/images/bgs/bg05.jpg")',
    'url("about/images/bgs/bg06.jpg")',
    'url("about/images/bgs/bg07.jpg")',
    'url("about/images/bgs/bg08.jpg")',
    'url("about/images/bgs/bg09.jpg")',
    'url("about/images/bgs/bg10.jpg")',
    'url("about/images/bgs/bg11.jpg")',
    'url("about/images/bgs/bg12.jpg")',
    'url("about/images/bgs/bg13.jpg")',
    'url("about/images/bgs/bg14.jpg")',
    'url("about/images/bgs/bg15.jpg")',
    'url("about/images/bgs/bg16.jpg")',
    'url("about/images/bgs/bg17.jpg")',
    'url("about/images/bgs/bg18.jpg")',
    'url("about/images/bgs/bg19.jpg")',
    'url("about/images/bgs/bg20.jpg")',
    'url("about/images/bgs/bg21.jpg")',
    'url("about/images/bgs/bg22.jpg")',
    'url("about/images/bgs/bg23.jpg")',
    'url("about/images/bgs/bg24.jpg")',
    'url("about/images/bgs/bg25.jpg")',
    'url("about/images/bgs/bg26.jpg")',
    'url("about/images/bgs/bg27.jpg")',
    'url("about/images/bgs/bg28.jpg")',
    'url("about/images/bgs/bg29.jpg")',
    'url("about/images/bgs/bg30.jpg")',
    'url("about/images/bgs/bg31.jpg")',
    'url("about/images/bgs/bg32.jpg")',
    'url("about/images/bgs/bg33.jpg")',
    'url("about/images/bgs/bg34.jpg")',
    'url("about/images/bgs/bg35.jpg")',
    'url("about/images/bgs/bg36.jpg")',
    'url("about/images/bgs/bg37.jpg")',
    'url("about/images/bgs/bg38.jpg")',
    'url("about/images/bgs/bg39.jpg")',
    'url("about/images/bgs/bg40.jpg")',
    'url("about/images/bgs/bg41.jpg")',
    'url("about/images/bgs/bg42.jpg")',
    'url("about/images/bgs/bg43.jpg")',
    'url("about/images/bgs/bg44.jpg")',
    'url("about/images/bgs/bg45.jpg")',
    'url("about/images/bgs/bg46.jpg")',
    'url("about/images/bgs/bg47.jpg")',
    'url("about/images/bgs/bg48.jpg")',
    'url("about/images/bgs/bg49.jpg")',
    'url("about/images/bgs/bg50.jpg")',
    'url("about/images/bgs/bg51.jpg")',
    'url("about/images/bgs/bg52.jpg")',
    'url("about/images/bgs/bg53.jpg")',
    'url("about/images/bgs/bg54.jpg")',
    'url("about/images/bgs/bg55.jpg")',
    'url("about/images/bgs/bg56.jpg")',
    'url("about/images/bgs/bg57.jpg")',
    'url("about/images/bgs/bg58.jpg")',
    'url("about/images/bgs/bg59.jpg")',
    'url("about/images/bgs/bg60.jpg")',
    'url("about/images/bgs/bg61.jpg")',
    'url("about/images/bgs/bg62.jpg")',
    'url("about/images/bgs/bg63.jpg")',
    'url("about/images/bgs/bg64.jpg")',
    'url("about/images/bgs/bg65.jpg")',
    'url("about/images/bgs/bg66.jpg")',
    'url("about/images/bgs/bg67.jpg")'
);
// 设置预加载组
var bgs_ready = [];
var bgs_src = [];
for (let i = 0, j = 0; i < 5; i++) {
    bgs_ready[i] = bgs[Math.floor(Math.random() * (bgs.length - 1 - 0 + 1)) + 0];
    let str = bgs_ready[i];
    let newstr = str.replace(/url\(\"\s*([^)]*)\s*\"\)/, "$1");
    bgs_src.push(newstr);
}
//开始预加载
loadStart();
// promise实现异步加载，异步调用
function loadImg(src) {
    let p = new Promise(function (resolve, reject) {
        let img = new Image();
        img.onload = () => {
            resolve(img);
        }
        img.onerror = () => {
            reject(src);
        }
        img.src = src;
    });
    return p;
}
// 设置async异步函数
async function loadStart() {
    for (let i = 0; i < bgs_src.length; i++) {
        await loadImg(bgs_src[i]);
    }
}

// 随机更换
function changeBg() {
    document.getElementById('bgid').style.background = bgs_ready[Math.floor(Math.random() * (bgs_ready.length - 1 - 0 + 1)) + 0] + "no-repeat center fixed";
    document.getElementById('bgid').style.backgroundSize = "cover";
}

// 右边时间
var lttime = document.getElementById("lttime");
var clock_p = document.getElementById("clock_p");
function timeSetRight() {
    var time = new Date();
    year = time.getFullYear();
    month = time.getMonth();
    day = time.getDate();
    hour = time.getHours();
    minutes = time.getMinutes();
    s = time.getSeconds();
    week = ["日", "月", "火", "水", "木", "金", "土"];
    document.getElementById("rtbox").innerHTML = year + '-' + month + '-' + day + '  ' + week[time.getDay()];
    if (hour < 10) {
        hour = '0' + hour;
    }
    if (minutes < 10) {
        minutes = '0' + minutes;
    }
    if (s < 10) {
        s = '0' + s;
    }
    if (hour < 12) {
        ampm = 'AM';
    } else {
        ampm = 'PM';
    }
    lttime.innerHTML = ampm + '  ' + hour + ':' + minutes + ':' + s;
    clock_p.innerHTML = hour + ':' + minutes + ':' + s;
}

// 定时刷新时间，更换壁纸
setInterval(timeSetRight, 1000);
setInterval(changeBg, 8000);
// 定义上下转换标志,支持菜单点击时锁定。0代表关闭状态，1代表上下箭头，2代表菜单
var getFocus_flag = 'noed';
function getFocus(foid) {
    let nn = document.getElementById("note");
    let tul = document.getElementById("footul");
    let tt = document.getElementById("topbtn");
    let cc = document.querySelector(".change");
    function Focusadd() {
        nn.classList.add("stopfoot");
        tul.classList.add("stopfootul");
        tt.classList.add("stopfoot");
        cc.classList.add("topbtnspin");
    }
    function Focusremove() {
        nn.classList.remove("stopfoot");
        tul.classList.remove("stopfootul");
        tt.classList.remove("stopfoot");
        cc.classList.remove("topbtnspin");
    }
    if (getFocus_flag == 'noed') {
        if (foid == 'p1') {
            Focusadd();
            getFocus_flag = getFocus_flag + foid;
        }
        if (foid == 'p2') {
            Focusadd();
            tt.style.cursor = 'url("about/images/cur/no.cur"),auto';
            getFocus_flag = getFocus_flag + foid;
        }
    }
    else {
        if (getFocus_flag == 'noed' + 'p1' && foid == 'p1' && menu_flag == true) {
            Focusremove();
            getFocus_flag = 'noed';
        }
        if (getFocus_flag == 'noed' + 'p2' && foid == 'p2') {
            Focusremove();
            tt.style.cursor = 'url("about/images/cur/hand.cur"),auto';
            getFocus_flag = 'noed';
        }
    }
}

//  显示菜单弹出框
var menu_flag = true;
function menu_mian_show() {
    let mm = document.querySelector("#menu_main");
    let mew = document.querySelector(".menu_wai");
    if (menu_flag == true) {
        mew.style.display = "flex";
        setTimeout(() => {
            mm.classList.add("menu_active");
            menu_flag = false;
            this.getFocus('p2');
        }, 100);
    } else {
        for (let i = 0; i < menu_list.length; i++) {
            const menu = menu_list[i];
            setTimeout(() => {
                menu.classList.remove("menu_active");
            }, 100);
        }
        menu_flag = true;
        this.getFocus('p2');
        setTimeout(() => {
            mew.style.display = "none";
        }, 200);
    }
    if (menu_flag == false) {
        document.getElementById("topbtn").style.cursor = 'url("about/images/cur/no.cur"),auto';
    }
    else {
        document.getElementById("topbtn").style.cursor = 'url("about/images/cur/hand.cur"),auto';
    }
}

// 添加窗口外点击消失的事件
document.querySelector(".menu_wai").addEventListener("click", () => {
    setTimeout(() => {
        document.getElementById("topbtn").style.cursor = 'url("about/images/cur/hand.cur"),auto';
        document.getElementById("note").classList.remove("stopfoot");
        document.getElementById("footul").classList.remove("stopfootul");
        document.getElementById("topbtn").classList.remove("stopfoot");
        document.querySelector(".change").classList.remove("topbtnspin");
        setActive(menu_list, typeof id, "menu_active");
    }, 100);
    setTimeout(() => {
        document.querySelector(".menu_wai").style.display = "none";
    }, 200);
    menu_flag = true;
    getFocus_flag = 'noed';
})

// 过滤非窗口外的冒泡,封装过滤函数
function except(id) {
    document.getElementById(`${id}`).addEventListener("click", (event) => {
        let e = event || window.event;
        if (e.cancelBubble) {
            e.cancelBubble = true;//ie 阻止事件冒泡
        } else {
            e.stopPropagation();// 其余浏览器 阻止事件冒泡
        }
    })
}
// 获得所有菜单
var menu_list = document.getElementsByClassName("menu");

// 移除所有active，为当前元素添加active类
function setActive(listName, id, activeName) {
    for (let i = 0; i < listName.length; i++) {
        listName[i].classList.remove(`${activeName}`);
    }
    if (id != "undefined") {
        document.getElementById(id).classList.add(`${activeName}`);
    }
}
// 为当前menu获得活动窗口
function show_bgs_list(id) {
    setActive(menu_list, id, "menu_active");
}

// 为所有菜单添加过滤器
function menu_except() {
    for (let i = 0; i < menu_list.length; i++) {
        const menu = menu_list[i].id;
        except(menu);
    }
}
menu_except();

document.getElementById("bgs_list").addEventListener("mousewheel", onmousewheel)
function onmousewheel(event) {
    var event = event || window.event;
}

function show_addwindow() {
    var addpop_box = document.querySelector('.addpop_box');
    addpop_box.classList.add("addpop_box_active");
    setTimeout(()=>{
        document.querySelector('.addpop').classList.add("addpop_active");
    },100);
}

document.getElementById('submit_button').addEventListener("click", ()=>{
    var addpop_box = document.querySelector('.addpop_box');
    addpop_box.classList.remove("addpop_box_active");
    console.log("addpop_box被点击了",addpop_box);
})