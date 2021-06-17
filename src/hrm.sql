/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40 : Database - hrm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hrm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hrm`;

/*Table structure for table `dept_inf` */

DROP TABLE IF EXISTS `dept_inf`;

CREATE TABLE `dept_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `dept_inf` */

insert  into `dept_inf`(`ID`,`NAME`,`REMARK`) values (6,'市场部','市场部'),(7,'教学部','教学部'),(9,'9部','9'),(11,'bb部555','aa666'),(16,'a11111','aa666'),(17,'a11111','aa666'),(18,'a11111','aa666'),(19,'a11111','aa666'),(20,'a11111','aa666'),(21,'技术部','技术部'),(22,'运营部','运营部'),(23,'阿斯蒂芬','阿斯蒂芬');

/*Table structure for table `document_inf` */

DROP TABLE IF EXISTS `document_inf`;

CREATE TABLE `document_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(50) NOT NULL,
  `filename` varchar(300) NOT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_DOCUMENT_USER` (`USER_ID`),
  CONSTRAINT `FK_DOCUMENT_USER` FOREIGN KEY (`USER_ID`) REFERENCES `user_inf` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `document_inf` */

insert  into `document_inf`(`ID`,`TITLE`,`filename`,`REMARK`,`CREATE_DATE`,`USER_ID`) values (7,'文件哈','183缺少简介课程列表.xlsx','这是一个文件','2019-04-06 18:33:40',1);

/*Table structure for table `employee_inf` */

DROP TABLE IF EXISTS `employee_inf`;

CREATE TABLE `employee_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPT_ID` int(11) DEFAULT NULL,
  `JOB_ID` int(11) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `CARD_ID` varchar(18) NOT NULL,
  `ADDRESS` varchar(50) NOT NULL,
  `POST_CODE` varchar(50) DEFAULT NULL,
  `TEL` varchar(16) DEFAULT NULL,
  `PHONE` varchar(11) NOT NULL,
  `QQ_NUM` varchar(10) DEFAULT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `SEX` int(11) NOT NULL DEFAULT '1',
  `PARTY` varchar(10) DEFAULT NULL,
  `BIRTHDAY` datetime DEFAULT NULL,
  `RACE` varchar(100) DEFAULT NULL,
  `EDUCATION` varchar(10) DEFAULT NULL,
  `SPECIALITY` varchar(20) DEFAULT NULL,
  `HOBBY` varchar(100) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `FK_EMP_DEPT` (`DEPT_ID`),
  KEY `FK_EMP_JOB` (`JOB_ID`),
  CONSTRAINT `FK_employee_inf` FOREIGN KEY (`DEPT_ID`) REFERENCES `dept_inf` (`ID`) ON DELETE SET NULL,
  CONSTRAINT `FK_EMP_JOB` FOREIGN KEY (`JOB_ID`) REFERENCES `job_inf` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `employee_inf` */

insert  into `employee_inf`(`ID`,`DEPT_ID`,`JOB_ID`,`NAME`,`CARD_ID`,`ADDRESS`,`POST_CODE`,`TEL`,`PHONE`,`QQ_NUM`,`EMAIL`,`SEX`,`PARTY`,`BIRTHDAY`,`RACE`,`EDUCATION`,`SPECIALITY`,`HOBBY`,`REMARK`,`CREATE_DATE`) values (1,NULL,8,'爱丽丝','210203289706320016','广州天河','510000','020-77777777','13902001111','36750066','251425887@qq.com',2,'党员','2019-04-11 00:00:00','满','本科','美声','唱歌','四大天王','2016-03-14 11:35:18'),(2,NULL,1,'杰克','210303198001010018','43234','116021','0411-2727733','13343221110','42424444','251425887@qq.com',2,'团员','2019-04-11 00:00:00','汉','大专','计算机','无','无','2016-03-14 11:35:18');

/*Table structure for table `job_inf` */

DROP TABLE IF EXISTS `job_inf`;

CREATE TABLE `job_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `job_inf` */

insert  into `job_inf`(`ID`,`NAME`,`REMARK`) values (1,'职员','职员'),(2,'Java开发工程师','Java开发工程师'),(3,'Java中级开发工程师','Java中级开发工程师'),(4,'Java高级开发工程师','Java高级开发工程师'),(5,'系统管理员','系统管理员'),(6,'架构师','架构师'),(7,'主管','主管'),(8,'经理','经理'),(9,'总经理','总经理');

/*Table structure for table `notice_inf` */

DROP TABLE IF EXISTS `notice_inf`;

CREATE TABLE `notice_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(50) NOT NULL,
  `CONTENT` text NOT NULL,
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_NOTICE_USER` (`USER_ID`),
  CONSTRAINT `FK_NOTICE_USER` FOREIGN KEY (`USER_ID`) REFERENCES `user_inf` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `notice_inf` */

insert  into `notice_inf`(`ID`,`TITLE`,`CONTENT`,`CREATE_DATE`,`USER_ID`) values (19,'参加会议通知','今天有技术部有会议','2019-04-06 18:24:15',1);

/*Table structure for table `user_inf` */

DROP TABLE IF EXISTS `user_inf`;

CREATE TABLE `user_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) NOT NULL,
  `PASSWORD` varchar(32) NOT NULL,
  `STATUS` int(11) NOT NULL DEFAULT '1',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(20) DEFAULT NULL,
  `faceurl` varchar(255) DEFAULT NULL,
  `facepath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `user_inf` */

insert  into `user_inf`(`ID`,`loginname`,`PASSWORD`,`STATUS`,`createdate`,`username`,`faceurl`,`facepath`) values (1,'songyq2','96e79218965eb72c92a549dd5a330112',2,'2016-03-12 09:34:28','songyq2',NULL,NULL),(2,'aa','1222',1,'2021-06-17 11:12:08','aas',NULL,NULL),(3,'bb','bb',1,'2021-06-17 13:15:09','sss',NULL,NULL),(4,'cc','cc',1,'2021-06-17 13:15:15','ss',NULL,NULL),(5,'dd','dd',1,'2021-06-17 13:15:22','ss',NULL,NULL),(6,'ss3333','ss',1,'2021-06-17 13:17:18','ss3333',NULL,NULL),(9,'wangxh','96e79218965eb72c92a549dd5a330112',1,'2019-04-11 15:34:36','wangxh','',''),(10,'ss33333','E10ADC3949BA59ABBE56E057F20F883E',1,'2021-06-17 14:58:23','tom3333',NULL,NULL),(11,'test121212121','4297F44B13955235245B2497399D7A93',1,'2021-06-17 15:35:21','admin',NULL,NULL),(12,'police','4297F44B13955235245B2497399D7A93',1,'2021-06-17 16:14:27','police',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
