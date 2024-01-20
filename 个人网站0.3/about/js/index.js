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

// 展示弹窗函数
var foot_btn = document.querySelectorAll('.foot_btn');
var footul = document.querySelector('.footul');
var topbtn = document.querySelector('.topbtn');
var direction_img = document.querySelector('.direction_img');
var mew = document.querySelector(".menu_wai");
function menu_mian_show() {
    let mm = document.querySelector("#menu_main");
    if (mew.dataset.menu_status == 'off') {
        mew.dataset.menu_status = 'on';
        mew.style.display = "flex";
        setTimeout(() => {
            mm.classList.add("menu_active");
        }, 50);
        footul_style_change('up');
        topbtn.classList.add('topbtn_nocursor');
        if (topbtn.dataset.direction_status == 'Up') {
            direction_style_change('dn')
        }
    } else {
        off_menu();
    }
}

// 封装改变右下方向函数
function direction_style_change(status) {
    if (status == 'dn') {
        topbtn.dataset.direction_status = 'Dn';
        direction_img.classList.add('direction_img_change');
    }else {
        topbtn.dataset.direction_status = 'Up';
        direction_img.classList.remove('direction_img_change');
    }
}

// 封装下部弹窗函数
function footul_style_change(status){
    if (status=='up') {
        foot_btn.forEach((element) => {
            element.classList.add('static_footbtn');
        })
        footul.classList.add('static_footul');
        footul.dataset.direction_status == 'Up'
    } else {
        foot_btn.forEach((element) => {
            element.classList.remove('static_footbtn');
        })
        footul.classList.remove('static_footul');
        footul.dataset.direction_status == 'Dn';
    }
}

// 右下定止弹窗函数
function staic_foot() {
    if (topbtn.dataset.direction_status=='Dn'&&mew.dataset.menu_status == 'on') {
        direction_style_change('dn');
        footul_style_change('up');
    }else if (topbtn.dataset.direction_status=='Up'&&mew.dataset.menu_status == 'off') {
        direction_style_change('dn');
        footul_style_change('up');
    }else if(topbtn.dataset.direction_status=='Dn'&&mew.dataset.menu_status == 'off'){
        direction_style_change('up')
        footul_style_change('dn');
    }
}

// 添加窗口外点击消失的事件
document.querySelector(".menu_wai").addEventListener("click", () => {
    off_menu();
});

// 关闭弹窗函数
function off_menu() {
    setActive(menu_list, typeof id, "menu_active");
    setTimeout(() => {
        mew.style.display = "none";
    }, 300);
    mew.dataset.menu_status = 'off';
    footul_style_change('Dn')
    direction_style_change('up')
    topbtn.classList.remove('topbtn_nocursor');
}

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
    console.log("onmousewheel()函数触发");
}

function show_addwindow() {
    var addpop_box = document.querySelector('.addpop_box');
    addpop_box.classList.add("addpop_box_active");
    setTimeout(() => {
        document.querySelector('.addpop').classList.add("addpop_active");
    }, 100);
}

function off_show_addwindow() {
    document.querySelector('.addpop_box').classList.remove("addpop_box_active");
}

except('addpop');
document.querySelector('.addpop_box').addEventListener('click', () => {
    off_show_addwindow();
})

function show_operate() {
    let jian = document.getElementById('jian');
    var operate_mark_list = [];
    if (jian.dataset.jianoff == 'off') {
        jian.dataset.jianoff = 'on';
        var container_ul_li_list = document.querySelectorAll('.container ul li');
        console.log('这是css选择器下的全部选择结果', container_ul_li_list.length);
        container_ul_li_list = Array.from(container_ul_li_list);
        for (let i = 0; i < container_ul_li_list.length - 2; i++) {
            const operate_mark = document.createElement('div');
            operate_mark.className = 'operate_mark';
            operate_mark.id = `serial_num${i}`;
            operate_mark.addEventListener("click", () => {
                const mark_id = event.target;
                console.log(mark_id.id);
            })
            const element = container_ul_li_list[i];
            element.appendChild(operate_mark);
            element.addEventListener('click', () => {
                const li_element = event.currentTarget;
                li_element.remove();
            })
            operate_mark_list.push(operate_mark);
        }
        setTimeout(() => {
            for (let i = 0; i < operate_mark_list.length; i++) {
                operate_mark_list[i].style.opacity = '1';
            }
        }, 300);
    } else {
        jian.dataset.jianoff = 'off';
        let operate_mark_list = document.querySelectorAll('.operate_mark');
        for (let i = 0; i < operate_mark_list.length; i++) {
            operate_mark_list[i].style.opacity = '0';
        }
        setTimeout(() => {
            operate_mark_list.forEach((item) => {
                item.remove();
            })
        }, 500);
    }
}