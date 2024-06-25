import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import forum from '@/views/modules/forum/list'
    import youxifenlei from '@/views/modules/youxifenlei/list'
    import tousuchuli from '@/views/modules/tousuchuli/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yonghutousu from '@/views/modules/yonghutousu/list'
    import youxibiaoqian from '@/views/modules/youxibiaoqian/list'
    import wangzhangonggao from '@/views/modules/wangzhangonggao/list'
    import config from '@/views/modules/config/list'
    import discussyouxixinxi from '@/views/modules/discussyouxixinxi/list'
    import youxixinxi from '@/views/modules/youxixinxi/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/forum',
        name: '游戏论坛',
        component: forum
      }
      ,{
	path: '/youxifenlei',
        name: '游戏分类',
        component: youxifenlei
      }
      ,{
	path: '/tousuchuli',
        name: '投诉处理',
        component: tousuchuli
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/yonghutousu',
        name: '用户投诉',
        component: yonghutousu
      }
      ,{
	path: '/youxibiaoqian',
        name: '游戏标签',
        component: youxibiaoqian
      }
      ,{
	path: '/wangzhangonggao',
        name: '网站公告',
        component: wangzhangonggao
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/discussyouxixinxi',
        name: '游戏信息评论',
        component: discussyouxixinxi
      }
      ,{
	path: '/youxixinxi',
        name: '游戏信息',
        component: youxixinxi
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
