-- MySQL dump 10.13  Distrib 5.1.23-rc, for Win32 (ia32)
--
-- Host: 127.0.0.1    Database: demo
-- ------------------------------------------------------
-- Server version	5.5.28-log

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
-- Current Database: `demo`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `demo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `demo`;

--
-- Table structure for table `obe_sys_log`
--

DROP TABLE IF EXISTS `obe_sys_log`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `obe_sys_log` (
  `LOG_ID` bigint(32) NOT NULL COMMENT '日志编号',
  `TITLE` varchar(200) NOT NULL COMMENT '日志标题',
  `LEVEL` int(2) NOT NULL COMMENT '日志等级',
  `CREATE_USER` varchar(64) DEFAULT NULL COMMENT '操作者',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `REMOTE_ADDR` varchar(32) DEFAULT NULL COMMENT '操作ip地址',
  `REQUEST_URI` varchar(255) DEFAULT NULL COMMENT '请求uri',
  `METHOD` varchar(16) DEFAULT NULL COMMENT '操作方式',
  `PARAMS` longtext COMMENT '提交数据',
  `TIME` mediumtext CHARACTER SET latin1 COMMENT '执行时间',
  `EXCEPTION` longtext COMMENT '异常信息',
  `RETURN_VALUE` longtext COMMENT '返回结果',
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `obe_sys_log`
--

LOCK TABLES `obe_sys_log` WRITE;
/*!40000 ALTER TABLE `obe_sys_log` DISABLE KEYS */;
INSERT INTO `obe_sys_log` VALUES (1,'getOne3',0,NULL,'2024-05-14 11:50:45','127.0.0.1','/getOne3','POST','','510',NULL,'SysUser(id=012345, username=zhangsan, password=202cb962ac59075b964b07152d234b70)',1),(1234,'测试手动控制事务',0,'222',NULL,'','','asgasg','',NULL,'','',0),(1790228230863712257,'getOne3',0,NULL,'2024-05-14 11:50:45','127.0.0.1','/getOne3','POST','','510',NULL,'SysUser(id=012345, username=zhangsan, password=202cb962ac59075b964b07152d234b70)',1);
/*!40000 ALTER TABLE `obe_sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `sys_user` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `params` blob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES ('012345','zhangsan','202cb962ac59075b964b07152d234b70',0,NULL,NULL,NULL),('1','admin','123',0,NULL,NULL,NULL),('2','admin2','123',0,NULL,NULL,NULL),('4567','sdgaga',NULL,0,'2024-06-21 18:18:28','2024-06-21 18:18:28','��\0sr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\r冗余字段1t\0111111111111t\0\r冗余字段2t\02222222222222222x'),('555','66666','5555',1,'2024-06-07 17:36:06','2024-06-07 17:40:02',NULL);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_chunk_info`
--

DROP TABLE IF EXISTS `t_chunk_info`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `t_chunk_info` (
  `id` varchar(64) NOT NULL,
  `chunk_number` decimal(10,0) NOT NULL,
  `chunk_size` decimal(10,0) NOT NULL,
  `current_chunkSize` decimal(10,0) NOT NULL,
  `identifier` varchar(64) NOT NULL,
  `filename` varchar(500) DEFAULT NULL,
  `relative_path` varchar(500) NOT NULL,
  `total_chunks` decimal(10,0) NOT NULL,
  `type` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `t_chunk_info`
--

LOCK TABLES `t_chunk_info` WRITE;
/*!40000 ALTER TABLE `t_chunk_info` DISABLE KEYS */;
INSERT INTO `t_chunk_info` VALUES ('12580725722940702721258072572294070272','1','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725774614528001258072577461452800','2','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725776334192641258072577633419264','3','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725800619212801258072580061921280','4','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725814082928641258072581408292864','6','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725816180080641258072581618008064','5','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725825575321601258072582557532160','7','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725841052303361258072584105230336','8','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725841975050241258072584197505024','9','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725849440911361258072584944091136','10','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725865798696961258072586579869696','11','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725869238026241258072586923802624','12','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725871964323841258072587196432384','13','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725891425894401258072589142589440','14','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725901030850561258072590103085056','16','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725901282508801258072590128250880','15','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725915794800641258072591579480064','17','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725927203307521258072592720330752','18','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725928503541761258072592850354176','19','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725936263004161258072593626300416','20','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725955598745601258072595559874560','22','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725960002764801258072596000276480','21','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725963567923201258072596356792320','23','2048000','2048000','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580725977954385921258072597795438592','24','2048000','2192131','6c4a87f51d57f1b31cd922981e56ea7b','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810331657338881258081033165733888','1','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810361353011201258081036135301120','3','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810366302289921258081036630228992','4','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810368651100161258081036865110016','2','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810375152271361258081037515227136','5','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810389538734081258081038953873408','6','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810396249620481258081039624962048','7','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810401450557441258081040145055744','8','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810409797222401258081040979722240','9','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810419737722881258081041973772288','10','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810426113064961258081042611306496','11','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810430559027201258081043055902720','12','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810438695976961258081043869597696','13','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810454005186561258081045400518656','14','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810459331952641258081045933195264','15','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810462351851521258081046235185152','16','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810472166522881258081047216652288','17','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810481268162561258081048126816256','18','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810485923840001258081048592384000','19','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810493179985921258081049317998592','20','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810506727587841258081050672758784','21','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810507901992961258081050790199296','22','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810527028019201258081052702801920','23','2048000','2048000','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580810563434577921258081056343457792','24','2048000','2192131','713ab354898e39b33f1cbb235ae5b3b4','《用Python学数学》中文PDF+英文PDF+代码.rar','《用Python学数学》中文PDF+英文PDF+代码.rar','24',NULL),('12580871467790499841258087146779049984','1','2048000','2048000','b8d8d49d8178734124c4ff6f3a409d3d','apache-maven-3.5.2-bin.zip','apache-maven-3.5.2-bin.zip','4',NULL),('12580871515731394561258087151573139456','3','2048000','2048000','b8d8d49d8178734124c4ff6f3a409d3d','apache-maven-3.5.2-bin.zip','apache-maven-3.5.2-bin.zip','4',NULL),('12580871525042749441258087152504274944','2','2048000','2048000','b8d8d49d8178734124c4ff6f3a409d3d','apache-maven-3.5.2-bin.zip','apache-maven-3.5.2-bin.zip','4',NULL),('12580871557674434561258087155767443456','4','2048000','2756183','b8d8d49d8178734124c4ff6f3a409d3d','apache-maven-3.5.2-bin.zip','apache-maven-3.5.2-bin.zip','4',NULL);
/*!40000 ALTER TABLE `t_chunk_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_file_info`
--

DROP TABLE IF EXISTS `t_file_info`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `t_file_info` (
  `id` varchar(64) NOT NULL,
  `filename` varchar(500) NOT NULL,
  `identifier` varchar(64) NOT NULL,
  `type` varchar(10) DEFAULT NULL,
  `total_size` decimal(10,0) NOT NULL,
  `location` varchar(200) NOT NULL,
  `del_flag` varchar(2) NOT NULL DEFAULT '0',
  `ref_project_id` varchar(64) NOT NULL,
  `upload_by` varchar(64) DEFAULT NULL,
  `upload_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `t_file_info`
--

LOCK TABLES `t_file_info` WRITE;
/*!40000 ALTER TABLE `t_file_info` DISABLE KEYS */;
INSERT INTO `t_file_info` VALUES ('12580726019561881601258072601956188160','《用Python学数学》中文PDF+英文PDF+代码.rar','6c4a87f51d57f1b31cd922981e56ea7b',NULL,'49296131','D:/temp/uploadFiles/6c4a87f51d57f1b31cd922981e56ea7b/《用Python学数学》中文PDF+英文PDF+代码.rar','0','123456789',NULL,'2024-07-03 06:51:22'),('12580810608397516801258081060839751680','《用Python学数学》中文PDF+英文PDF+代码.rar','713ab354898e39b33f1cbb235ae5b3b4',NULL,'49296131','D:/temp/uploadFiles/713ab354898e39b33f1cbb235ae5b3b4/《用Python学数学》中文PDF+英文PDF+代码.rar','0','123456789',NULL,'2024-07-03 07:24:58'),('12580871588376739841258087158837673984','apache-maven-3.5.2-bin.zip','b8d8d49d8178734124c4ff6f3a409d3d',NULL,'8900183','D:/temp/uploadFiles/b8d8d49d8178734124c4ff6f3a409d3d/apache-maven-3.5.2-bin.zip','0','123456789',NULL,'2024-07-03 07:49:12');
/*!40000 ALTER TABLE `t_file_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-29  7:19:20
