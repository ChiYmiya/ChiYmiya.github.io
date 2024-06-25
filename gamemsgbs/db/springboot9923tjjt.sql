-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: gamemsgbs
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `gamemsgbs`
--

/*!40000 DROP DATABASE IF EXISTS `gamemsgbs`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `gamemsgbs` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `gamemsgbs`;

--
-- Table structure for table `chatmessage`
--

DROP TABLE IF EXISTS `chatmessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chatmessage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `fid` bigint(20) NOT NULL COMMENT '好友用户ID',
  `content` varchar(200) DEFAULT NULL COMMENT '内容',
  `format` int(11) DEFAULT NULL COMMENT '格式(1:文字，2:图片)',
  `isread` int(11) DEFAULT '0' COMMENT '消息已读(0:未读，1:已读)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chatmessage`
--

LOCK TABLES `chatmessage` WRITE;
/*!40000 ALTER TABLE `chatmessage` DISABLE KEYS */;
/*!40000 ALTER TABLE `chatmessage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  `url` varchar(500) DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/picture1.jpg',NULL),(2,'picture2','upload/picture2.jpg',NULL),(3,'picture3','upload/picture3.jpg',NULL);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussyouxixinxi`
--

DROP TABLE IF EXISTS `discussyouxixinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussyouxixinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext COMMENT '头像',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `score` double DEFAULT NULL COMMENT '评分',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='游戏信息评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussyouxixinxi`
--

LOCK TABLES `discussyouxixinxi` WRITE;
/*!40000 ALTER TABLE `discussyouxixinxi` DISABLE KEYS */;
/*!40000 ALTER TABLE `discussyouxixinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum`
--

DROP TABLE IF EXISTS `forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forum` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) DEFAULT NULL COMMENT '帖子标题',
  `content` longtext NOT NULL COMMENT '帖子内容',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父节点id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `avatarurl` longtext COMMENT '头像',
  `isdone` varchar(200) DEFAULT NULL COMMENT '状态',
  `istop` int(11) DEFAULT '0' COMMENT '是否置顶',
  `toptime` datetime DEFAULT NULL COMMENT '置顶时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8 COMMENT='游戏论坛';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum`
--

LOCK TABLES `forum` WRITE;
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` VALUES (101,'2024-04-07 10:29:44','帖子标题1','帖子内容1',0,1,'用户名1','upload/forum_avatarurl1.jpg,upload/forum_avatarurl2.jpg,upload/forum_avatarurl3.jpg','开放',0,'2024-04-07 18:29:44'),(102,'2024-04-07 10:29:44','帖子标题2','帖子内容2',0,2,'用户名2','upload/forum_avatarurl2.jpg,upload/forum_avatarurl3.jpg,upload/forum_avatarurl4.jpg','开放',0,'2024-04-07 18:29:44'),(103,'2024-04-07 10:29:44','帖子标题3','帖子内容3',0,3,'用户名3','upload/forum_avatarurl3.jpg,upload/forum_avatarurl4.jpg,upload/forum_avatarurl5.jpg','开放',0,'2024-04-07 18:29:44'),(104,'2024-04-07 10:29:44','帖子标题4','帖子内容4',0,4,'用户名4','upload/forum_avatarurl4.jpg,upload/forum_avatarurl5.jpg,upload/forum_avatarurl6.jpg','开放',0,'2024-04-07 18:29:44'),(105,'2024-04-07 10:29:44','帖子标题5','帖子内容5',0,5,'用户名5','upload/forum_avatarurl5.jpg,upload/forum_avatarurl6.jpg,upload/forum_avatarurl7.jpg','开放',0,'2024-04-07 18:29:44'),(106,'2024-04-07 10:29:44','帖子标题6','帖子内容6',0,6,'用户名6','upload/forum_avatarurl6.jpg,upload/forum_avatarurl7.jpg,upload/forum_avatarurl8.jpg','开放',0,'2024-04-07 18:29:44'),(107,'2024-04-07 10:29:44','帖子标题7','帖子内容7',0,7,'用户名7','upload/forum_avatarurl7.jpg,upload/forum_avatarurl8.jpg,upload/forum_avatarurl9.jpg','开放',0,'2024-04-07 18:29:44'),(108,'2024-04-07 10:29:44','帖子标题8','帖子内容8',0,8,'用户名8','upload/forum_avatarurl8.jpg,upload/forum_avatarurl9.jpg,upload/forum_avatarurl10.jpg','开放',0,'2024-04-07 18:29:44');
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend`
--

DROP TABLE IF EXISTS `friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `fid` bigint(20) NOT NULL COMMENT '好友用户ID',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `picture` longtext NOT NULL COMMENT '图片',
  `role` varchar(200) DEFAULT NULL COMMENT '角色',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `alias` varchar(200) DEFAULT NULL COMMENT '别名',
  `type` int(11) DEFAULT '0' COMMENT '类型(0:好友申请，1:好友，2:消息)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend`
--

LOCK TABLES `friend` WRITE;
/*!40000 ALTER TABLE `friend` DISABLE KEYS */;
/*!40000 ALTER TABLE `friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeup`
--

DROP TABLE IF EXISTS `storeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) DEFAULT NULL COMMENT '商品id',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `picture` longtext COMMENT '图片',
  `type` varchar(200) DEFAULT '1' COMMENT '类型',
  `inteltype` varchar(200) DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeup`
--

LOCK TABLES `storeup` WRITE;
/*!40000 ALTER TABLE `storeup` DISABLE KEYS */;
/*!40000 ALTER TABLE `storeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,11,'账号1','yonghu','用户','jhx419u0m4j8fyep3vfh224hbfqeuw1d','2024-04-07 10:32:08','2024-04-07 11:32:09');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tousuchuli`
--

DROP TABLE IF EXISTS `tousuchuli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tousuchuli` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) DEFAULT NULL COMMENT '标题',
  `fengmian` longtext COMMENT '封面',
  `chulimiaoshu` longtext COMMENT '处理描述',
  `chuliriqi` date DEFAULT NULL COMMENT '处理日期',
  `zhanghao` varchar(200) DEFAULT NULL COMMENT '账号',
  `nicheng` varchar(200) DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='投诉处理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tousuchuli`
--

LOCK TABLES `tousuchuli` WRITE;
/*!40000 ALTER TABLE `tousuchuli` DISABLE KEYS */;
INSERT INTO `tousuchuli` VALUES (61,'2024-04-07 10:29:44','标题1','upload/tousuchuli_fengmian1.jpg,upload/tousuchuli_fengmian2.jpg,upload/tousuchuli_fengmian3.jpg','处理描述1','2024-04-07','账号1','昵称1'),(62,'2024-04-07 10:29:44','标题2','upload/tousuchuli_fengmian2.jpg,upload/tousuchuli_fengmian3.jpg,upload/tousuchuli_fengmian4.jpg','处理描述2','2024-04-07','账号2','昵称2'),(63,'2024-04-07 10:29:44','标题3','upload/tousuchuli_fengmian3.jpg,upload/tousuchuli_fengmian4.jpg,upload/tousuchuli_fengmian5.jpg','处理描述3','2024-04-07','账号3','昵称3'),(64,'2024-04-07 10:29:44','标题4','upload/tousuchuli_fengmian4.jpg,upload/tousuchuli_fengmian5.jpg,upload/tousuchuli_fengmian6.jpg','处理描述4','2024-04-07','账号4','昵称4'),(65,'2024-04-07 10:29:44','标题5','upload/tousuchuli_fengmian5.jpg,upload/tousuchuli_fengmian6.jpg,upload/tousuchuli_fengmian7.jpg','处理描述5','2024-04-07','账号5','昵称5'),(66,'2024-04-07 10:29:44','标题6','upload/tousuchuli_fengmian6.jpg,upload/tousuchuli_fengmian7.jpg,upload/tousuchuli_fengmian8.jpg','处理描述6','2024-04-07','账号6','昵称6'),(67,'2024-04-07 10:29:44','标题7','upload/tousuchuli_fengmian7.jpg,upload/tousuchuli_fengmian8.jpg,upload/tousuchuli_fengmian9.jpg','处理描述7','2024-04-07','账号7','昵称7'),(68,'2024-04-07 10:29:44','标题8','upload/tousuchuli_fengmian8.jpg,upload/tousuchuli_fengmian9.jpg,upload/tousuchuli_fengmian10.jpg','处理描述8','2024-04-07','账号8','昵称8');
/*!40000 ALTER TABLE `tousuchuli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `image` varchar(200) DEFAULT NULL COMMENT '头像',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin','upload/image1.jpg','管理员','2024-04-07 10:29:44');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wangzhangonggao`
--

DROP TABLE IF EXISTS `wangzhangonggao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wangzhangonggao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) NOT NULL COMMENT '标题',
  `jianjie` longtext COMMENT '简介',
  `fabushijian` datetime DEFAULT NULL COMMENT '发布时间',
  `fengmian` longtext COMMENT '封面',
  `neirong` longtext COMMENT '内容',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COMMENT='网站公告';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wangzhangonggao`
--

LOCK TABLES `wangzhangonggao` WRITE;
/*!40000 ALTER TABLE `wangzhangonggao` DISABLE KEYS */;
INSERT INTO `wangzhangonggao` VALUES (71,'2024-04-07 10:29:44','标题1','简介1','2024-04-07 18:29:44','upload/wangzhangonggao_fengmian1.jpg,upload/wangzhangonggao_fengmian2.jpg,upload/wangzhangonggao_fengmian3.jpg','内容1','2024-04-07 18:29:44',1),(72,'2024-04-07 10:29:44','标题2','简介2','2024-04-07 18:29:44','upload/wangzhangonggao_fengmian2.jpg,upload/wangzhangonggao_fengmian3.jpg,upload/wangzhangonggao_fengmian4.jpg','内容2','2024-04-07 18:29:44',2),(73,'2024-04-07 10:29:44','标题3','简介3','2024-04-07 18:29:44','upload/wangzhangonggao_fengmian3.jpg,upload/wangzhangonggao_fengmian4.jpg,upload/wangzhangonggao_fengmian5.jpg','内容3','2024-04-07 18:29:44',3),(74,'2024-04-07 10:29:44','标题4','简介4','2024-04-07 18:29:44','upload/wangzhangonggao_fengmian4.jpg,upload/wangzhangonggao_fengmian5.jpg,upload/wangzhangonggao_fengmian6.jpg','内容4','2024-04-07 18:29:44',4),(75,'2024-04-07 10:29:44','标题5','简介5','2024-04-07 18:29:44','upload/wangzhangonggao_fengmian5.jpg,upload/wangzhangonggao_fengmian6.jpg,upload/wangzhangonggao_fengmian7.jpg','内容5','2024-04-07 18:29:44',5),(76,'2024-04-07 10:29:44','标题6','简介6','2024-04-07 18:29:44','upload/wangzhangonggao_fengmian6.jpg,upload/wangzhangonggao_fengmian7.jpg,upload/wangzhangonggao_fengmian8.jpg','内容6','2024-04-07 18:29:44',6),(77,'2024-04-07 10:29:44','标题7','简介7','2024-04-07 18:29:44','upload/wangzhangonggao_fengmian7.jpg,upload/wangzhangonggao_fengmian8.jpg,upload/wangzhangonggao_fengmian9.jpg','内容7','2024-04-07 18:29:44',7),(78,'2024-04-07 10:29:44','标题8','简介8','2024-04-07 18:29:44','upload/wangzhangonggao_fengmian8.jpg,upload/wangzhangonggao_fengmian9.jpg,upload/wangzhangonggao_fengmian10.jpg','内容8','2024-04-07 18:29:44',8);
/*!40000 ALTER TABLE `wangzhangonggao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonghu`
--

DROP TABLE IF EXISTS `yonghu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yonghu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhanghao` varchar(200) NOT NULL COMMENT '账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `nicheng` varchar(200) NOT NULL COMMENT '昵称',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `youxiang` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `youxifenlei` varchar(200) DEFAULT NULL COMMENT '游戏分类',
  `touxiang` longtext COMMENT '头像',
  `gerenjianjie` longtext COMMENT '个人简介',
  `status` int(11) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zhanghao` (`zhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonghu`
--

LOCK TABLES `yonghu` WRITE;
/*!40000 ALTER TABLE `yonghu` DISABLE KEYS */;
INSERT INTO `yonghu` VALUES (11,'2024-04-07 10:29:44','账号1','123456','昵称1','男','13823888881','773890001@qq.com','游戏分类1','upload/yonghu_touxiang1.jpg','个人简介1',0),(12,'2024-04-07 10:29:44','账号2','123456','昵称2','男','13823888882','773890002@qq.com','游戏分类2','upload/yonghu_touxiang2.jpg','个人简介2',0),(13,'2024-04-07 10:29:44','账号3','123456','昵称3','男','13823888883','773890003@qq.com','游戏分类3','upload/yonghu_touxiang3.jpg','个人简介3',0),(14,'2024-04-07 10:29:44','账号4','123456','昵称4','男','13823888884','773890004@qq.com','游戏分类4','upload/yonghu_touxiang4.jpg','个人简介4',0),(15,'2024-04-07 10:29:44','账号5','123456','昵称5','男','13823888885','773890005@qq.com','游戏分类5','upload/yonghu_touxiang5.jpg','个人简介5',0),(16,'2024-04-07 10:29:44','账号6','123456','昵称6','男','13823888886','773890006@qq.com','游戏分类6','upload/yonghu_touxiang6.jpg','个人简介6',0),(17,'2024-04-07 10:29:44','账号7','123456','昵称7','男','13823888887','773890007@qq.com','游戏分类7','upload/yonghu_touxiang7.jpg','个人简介7',0),(18,'2024-04-07 10:29:44','账号8','123456','昵称8','男','13823888888','773890008@qq.com','游戏分类8','upload/yonghu_touxiang8.jpg','个人简介8',0);
/*!40000 ALTER TABLE `yonghu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonghutousu`
--

DROP TABLE IF EXISTS `yonghutousu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yonghutousu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) NOT NULL COMMENT '标题',
  `fengmian` longtext COMMENT '封面',
  `zhuangtai` varchar(200) DEFAULT NULL COMMENT '状态',
  `tousuyuanyin` longtext COMMENT '投诉原因',
  `tousuriqi` date DEFAULT NULL COMMENT '投诉日期',
  `zhanghao` varchar(200) DEFAULT NULL COMMENT '账号',
  `nicheng` varchar(200) DEFAULT NULL COMMENT '昵称',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `userid` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='用户投诉';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonghutousu`
--

LOCK TABLES `yonghutousu` WRITE;
/*!40000 ALTER TABLE `yonghutousu` DISABLE KEYS */;
INSERT INTO `yonghutousu` VALUES (51,'2024-04-07 10:29:44','标题1','upload/yonghutousu_fengmian1.jpg,upload/yonghutousu_fengmian2.jpg,upload/yonghutousu_fengmian3.jpg','已处理','投诉原因1','2024-04-07','账号1','昵称1','手机1',1),(52,'2024-04-07 10:29:44','标题2','upload/yonghutousu_fengmian2.jpg,upload/yonghutousu_fengmian3.jpg,upload/yonghutousu_fengmian4.jpg','已处理','投诉原因2','2024-04-07','账号2','昵称2','手机2',2),(53,'2024-04-07 10:29:44','标题3','upload/yonghutousu_fengmian3.jpg,upload/yonghutousu_fengmian4.jpg,upload/yonghutousu_fengmian5.jpg','已处理','投诉原因3','2024-04-07','账号3','昵称3','手机3',3),(54,'2024-04-07 10:29:44','标题4','upload/yonghutousu_fengmian4.jpg,upload/yonghutousu_fengmian5.jpg,upload/yonghutousu_fengmian6.jpg','已处理','投诉原因4','2024-04-07','账号4','昵称4','手机4',4),(55,'2024-04-07 10:29:44','标题5','upload/yonghutousu_fengmian5.jpg,upload/yonghutousu_fengmian6.jpg,upload/yonghutousu_fengmian7.jpg','已处理','投诉原因5','2024-04-07','账号5','昵称5','手机5',5),(56,'2024-04-07 10:29:44','标题6','upload/yonghutousu_fengmian6.jpg,upload/yonghutousu_fengmian7.jpg,upload/yonghutousu_fengmian8.jpg','已处理','投诉原因6','2024-04-07','账号6','昵称6','手机6',6),(57,'2024-04-07 10:29:44','标题7','upload/yonghutousu_fengmian7.jpg,upload/yonghutousu_fengmian8.jpg,upload/yonghutousu_fengmian9.jpg','已处理','投诉原因7','2024-04-07','账号7','昵称7','手机7',7),(58,'2024-04-07 10:29:44','标题8','upload/yonghutousu_fengmian8.jpg,upload/yonghutousu_fengmian9.jpg,upload/yonghutousu_fengmian10.jpg','已处理','投诉原因8','2024-04-07','账号8','昵称8','手机8',8);
/*!40000 ALTER TABLE `yonghutousu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `youxibiaoqian`
--

DROP TABLE IF EXISTS `youxibiaoqian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `youxibiaoqian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoqian` varchar(200) DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`id`),
  UNIQUE KEY `biaoqian` (`biaoqian`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='游戏标签';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `youxibiaoqian`
--

LOCK TABLES `youxibiaoqian` WRITE;
/*!40000 ALTER TABLE `youxibiaoqian` DISABLE KEYS */;
INSERT INTO `youxibiaoqian` VALUES (21,'2024-04-07 10:29:44','标签1'),(22,'2024-04-07 10:29:44','标签2'),(23,'2024-04-07 10:29:44','标签3'),(24,'2024-04-07 10:29:44','标签4'),(25,'2024-04-07 10:29:44','标签5'),(26,'2024-04-07 10:29:44','标签6'),(27,'2024-04-07 10:29:44','标签7'),(28,'2024-04-07 10:29:44','标签8');
/*!40000 ALTER TABLE `youxibiaoqian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `youxifenlei`
--

DROP TABLE IF EXISTS `youxifenlei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `youxifenlei` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `youxifenlei` varchar(200) DEFAULT NULL COMMENT '游戏分类',
  PRIMARY KEY (`id`),
  UNIQUE KEY `youxifenlei` (`youxifenlei`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='游戏分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `youxifenlei`
--

LOCK TABLES `youxifenlei` WRITE;
/*!40000 ALTER TABLE `youxifenlei` DISABLE KEYS */;
INSERT INTO `youxifenlei` VALUES (31,'2024-04-07 10:29:44','游戏分类1'),(32,'2024-04-07 10:29:44','游戏分类2'),(33,'2024-04-07 10:29:44','游戏分类3'),(34,'2024-04-07 10:29:44','游戏分类4'),(35,'2024-04-07 10:29:44','游戏分类5'),(36,'2024-04-07 10:29:44','游戏分类6'),(37,'2024-04-07 10:29:44','游戏分类7'),(38,'2024-04-07 10:29:44','游戏分类8');
/*!40000 ALTER TABLE `youxifenlei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `youxixinxi`
--

DROP TABLE IF EXISTS `youxixinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `youxixinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `youxibianhao` varchar(200) DEFAULT NULL COMMENT '游戏编号',
  `youximingcheng` varchar(200) NOT NULL COMMENT '游戏名称',
  `youxifenlei` varchar(200) DEFAULT NULL COMMENT '游戏分类',
  `biaoqian` varchar(200) DEFAULT NULL COMMENT '标签',
  `fengmian` longtext COMMENT '封面',
  `shiherenqun` longtext COMMENT '适合人群',
  `pingfen` double DEFAULT NULL COMMENT '评分',
  `pingtai` varchar(200) DEFAULT NULL COMMENT '平台',
  `youxijieshao` longtext COMMENT '游戏介绍',
  `fabushijian` datetime DEFAULT NULL COMMENT '发布时间',
  `zhanghao` varchar(200) DEFAULT NULL COMMENT '账号',
  `nicheng` varchar(200) DEFAULT NULL COMMENT '昵称',
  `sfsh` varchar(200) DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  `discussnum` int(11) DEFAULT '0' COMMENT '评论数',
  `storeupnum` int(11) DEFAULT '0' COMMENT '收藏数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `youxibianhao` (`youxibianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='游戏信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `youxixinxi`
--

LOCK TABLES `youxixinxi` WRITE;
/*!40000 ALTER TABLE `youxixinxi` DISABLE KEYS */;
INSERT INTO `youxixinxi` VALUES (41,'2024-04-07 10:29:44','1111111111','游戏名称1','游戏分类1','标签1','upload/youxixinxi_fengmian1.jpg,upload/youxixinxi_fengmian2.jpg,upload/youxixinxi_fengmian3.jpg','适合人群1',1,'平台1','游戏介绍1','2024-04-07 18:29:44','账号1','昵称1','是','',1,1,'2024-04-07 18:29:44',1,0,1),(42,'2024-04-07 10:29:44','2222222222','游戏名称2','游戏分类2','标签2','upload/youxixinxi_fengmian2.jpg,upload/youxixinxi_fengmian3.jpg,upload/youxixinxi_fengmian4.jpg','适合人群2',2,'平台2','游戏介绍2','2024-04-07 18:29:44','账号2','昵称2','是','',2,2,'2024-04-07 18:29:44',2,0,2),(43,'2024-04-07 10:29:44','3333333333','游戏名称3','游戏分类3','标签3','upload/youxixinxi_fengmian3.jpg,upload/youxixinxi_fengmian4.jpg,upload/youxixinxi_fengmian5.jpg','适合人群3',3,'平台3','游戏介绍3','2024-04-07 18:29:44','账号3','昵称3','是','',3,3,'2024-04-07 18:29:44',3,0,3),(44,'2024-04-07 10:29:44','4444444444','游戏名称4','游戏分类4','标签4','upload/youxixinxi_fengmian4.jpg,upload/youxixinxi_fengmian5.jpg,upload/youxixinxi_fengmian6.jpg','适合人群4',4,'平台4','游戏介绍4','2024-04-07 18:29:44','账号4','昵称4','是','',4,4,'2024-04-07 18:29:44',4,0,4),(45,'2024-04-07 10:29:44','5555555555','游戏名称5','游戏分类5','标签5','upload/youxixinxi_fengmian5.jpg,upload/youxixinxi_fengmian6.jpg,upload/youxixinxi_fengmian7.jpg','适合人群5',5,'平台5','游戏介绍5','2024-04-07 18:29:44','账号5','昵称5','是','',5,5,'2024-04-07 18:29:44',5,0,5),(46,'2024-04-07 10:29:44','6666666666','游戏名称6','游戏分类6','标签6','upload/youxixinxi_fengmian6.jpg,upload/youxixinxi_fengmian7.jpg,upload/youxixinxi_fengmian8.jpg','适合人群6',6,'平台6','游戏介绍6','2024-04-07 18:29:44','账号6','昵称6','是','',6,6,'2024-04-07 18:29:44',6,0,6),(47,'2024-04-07 10:29:44','7777777777','游戏名称7','游戏分类7','标签7','upload/youxixinxi_fengmian7.jpg,upload/youxixinxi_fengmian8.jpg,upload/youxixinxi_fengmian9.jpg','适合人群7',7,'平台7','游戏介绍7','2024-04-07 18:29:44','账号7','昵称7','是','',7,7,'2024-04-07 18:29:44',7,0,7),(48,'2024-04-07 10:29:44','8888888888','游戏名称8','游戏分类8','标签8','upload/youxixinxi_fengmian8.jpg,upload/youxixinxi_fengmian9.jpg,upload/youxixinxi_fengmian10.jpg','适合人群8',8,'平台8','游戏介绍8','2024-04-07 18:29:44','账号8','昵称8','是','',8,8,'2024-04-07 18:29:44',8,0,8);
/*!40000 ALTER TABLE `youxixinxi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-09  9:35:14
