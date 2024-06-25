import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import youxibiaoqianList from '../pages/youxibiaoqian/list'
import youxibiaoqianDetail from '../pages/youxibiaoqian/detail'
import youxibiaoqianAdd from '../pages/youxibiaoqian/add'
import youxifenleiList from '../pages/youxifenlei/list'
import youxifenleiDetail from '../pages/youxifenlei/detail'
import youxifenleiAdd from '../pages/youxifenlei/add'
import youxixinxiList from '../pages/youxixinxi/list'
import youxixinxiDetail from '../pages/youxixinxi/detail'
import youxixinxiAdd from '../pages/youxixinxi/add'
import yonghutousuList from '../pages/yonghutousu/list'
import yonghutousuDetail from '../pages/yonghutousu/detail'
import yonghutousuAdd from '../pages/yonghutousu/add'
import tousuchuliList from '../pages/tousuchuli/list'
import tousuchuliDetail from '../pages/tousuchuli/detail'
import tousuchuliAdd from '../pages/tousuchuli/add'
import wangzhangonggaoList from '../pages/wangzhangonggao/list'
import wangzhangonggaoDetail from '../pages/wangzhangonggao/detail'
import wangzhangonggaoAdd from '../pages/wangzhangonggao/add'
import chatmessageList from '../pages/chatmessage/list'
import chatmessageDetail from '../pages/chatmessage/detail'
import chatmessageAdd from '../pages/chatmessage/add'
import friendList from '../pages/friend/list'
import friendDetail from '../pages/friend/detail'
import friendAdd from '../pages/friend/add'
import discussyouxixinxiList from '../pages/discussyouxixinxi/list'
import discussyouxixinxiDetail from '../pages/discussyouxixinxi/detail'
import discussyouxixinxiAdd from '../pages/discussyouxixinxi/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'youxibiaoqian',
					component: youxibiaoqianList
				},
				{
					path: 'youxibiaoqianDetail',
					component: youxibiaoqianDetail
				},
				{
					path: 'youxibiaoqianAdd',
					component: youxibiaoqianAdd
				},
				{
					path: 'youxifenlei',
					component: youxifenleiList
				},
				{
					path: 'youxifenleiDetail',
					component: youxifenleiDetail
				},
				{
					path: 'youxifenleiAdd',
					component: youxifenleiAdd
				},
				{
					path: 'youxixinxi',
					component: youxixinxiList
				},
				{
					path: 'youxixinxiDetail',
					component: youxixinxiDetail
				},
				{
					path: 'youxixinxiAdd',
					component: youxixinxiAdd
				},
				{
					path: 'yonghutousu',
					component: yonghutousuList
				},
				{
					path: 'yonghutousuDetail',
					component: yonghutousuDetail
				},
				{
					path: 'yonghutousuAdd',
					component: yonghutousuAdd
				},
				{
					path: 'tousuchuli',
					component: tousuchuliList
				},
				{
					path: 'tousuchuliDetail',
					component: tousuchuliDetail
				},
				{
					path: 'tousuchuliAdd',
					component: tousuchuliAdd
				},
				{
					path: 'wangzhangonggao',
					component: wangzhangonggaoList
				},
				{
					path: 'wangzhangonggaoDetail',
					component: wangzhangonggaoDetail
				},
				{
					path: 'wangzhangonggaoAdd',
					component: wangzhangonggaoAdd
				},
				{
					path: 'chatmessage',
					component: chatmessageList
				},
				{
					path: 'chatmessageDetail',
					component: chatmessageDetail
				},
				{
					path: 'chatmessageAdd',
					component: chatmessageAdd
				},
				{
					path: 'friend',
					component: friendList
				},
				{
					path: 'friendDetail',
					component: friendDetail
				},
				{
					path: 'friendAdd',
					component: friendAdd
				},
				{
					path: 'discussyouxixinxi',
					component: discussyouxixinxiList
				},
				{
					path: 'discussyouxixinxiDetail',
					component: discussyouxixinxiDetail
				},
				{
					path: 'discussyouxixinxiAdd',
					component: discussyouxixinxiAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
