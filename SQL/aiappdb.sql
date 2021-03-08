-- MySQL dump 10.13  Distrib 5.7.21, for Win64 (x86_64)
--
-- Host: localhost    Database: aiappdb
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `balance`
--

DROP TABLE IF EXISTS `balance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `balance` (
  `yyyy` varchar(4) NOT NULL,
  `vendcode` varchar(4) NOT NULL,
  `vendname` varchar(20) DEFAULT NULL,
  `preyybalance` int(11) DEFAULT '0',
  `prebalance01` int(11) DEFAULT '0',
  `prebalance02` int(11) DEFAULT '0',
  `prebalance03` int(11) DEFAULT '0',
  `prebalance04` int(11) DEFAULT '0',
  `prebalance05` int(11) DEFAULT '0',
  `prebalance06` int(11) DEFAULT '0',
  `prebalance07` int(11) DEFAULT '0',
  `prebalance08` int(11) DEFAULT '0',
  `prebalance09` int(11) DEFAULT '0',
  `prebalance10` int(11) DEFAULT '0',
  `prebalance11` int(11) DEFAULT '0',
  `prebalance12` int(11) DEFAULT '0',
  `deal01` int(11) DEFAULT '0',
  `deal02` int(11) DEFAULT '0',
  `deal03` int(11) DEFAULT '0',
  `deal04` int(11) DEFAULT '0',
  `deal05` int(11) DEFAULT '0',
  `deal06` int(11) DEFAULT '0',
  `deal07` int(11) DEFAULT '0',
  `deal08` int(11) DEFAULT '0',
  `deal09` int(11) DEFAULT '0',
  `deal10` int(11) DEFAULT '0',
  `deal11` int(11) DEFAULT '0',
  `deal12` int(11) DEFAULT '0',
  `pay01` int(11) DEFAULT '0',
  `pay02` int(11) DEFAULT '0',
  `pay03` int(11) DEFAULT '0',
  `pay04` int(11) DEFAULT '0',
  `pay05` int(11) DEFAULT '0',
  `pay06` int(11) DEFAULT '0',
  `pay07` int(11) DEFAULT '0',
  `pay08` int(11) DEFAULT '0',
  `pay09` int(11) DEFAULT '0',
  `pay10` int(11) DEFAULT '0',
  `pay11` int(11) DEFAULT '0',
  `pay12` int(11) DEFAULT '0',
  `balance01` int(11) DEFAULT '0',
  `balance02` int(11) DEFAULT '0',
  `balance03` int(11) DEFAULT '0',
  `balance04` int(11) DEFAULT '0',
  `balance05` int(11) DEFAULT '0',
  `balance06` int(11) DEFAULT '0',
  `balance07` int(11) DEFAULT '0',
  `balance08` int(11) DEFAULT '0',
  `balance09` int(11) DEFAULT '0',
  `balance10` int(11) DEFAULT '0',
  `balance11` int(11) DEFAULT '0',
  `balance12` int(11) DEFAULT '0',
  `balance` int(11) DEFAULT '0',
  `paytot` int(11) DEFAULT '0',
  `dealtot` int(11) DEFAULT '0',
  PRIMARY KEY (`yyyy`,`vendcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `balance`
--

LOCK TABLES `balance` WRITE;
/*!40000 ALTER TABLE `balance` DISABLE KEYS */;
INSERT INTO `balance` VALUES ('2021','200',NULL,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3300000,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3300000,0,0,0,0,0,0,0,0,0,3300000,0,0),('2021','3000',NULL,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1589761000,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1589761000,0,0,0,0,0,0,0,0,0,1589761000,0,1569661000),('2022','200',NULL,3300000,3300000,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3300000,0,0,0,0,0,0,0,0,0,0,0,3300000,0,0),('2022','3000',NULL,1589761000,1589761000,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1589761000,0,0,0,0,0,0,0,0,0,0,0,1589761000,0,0);
/*!40000 ALTER TABLE `balance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board` (
  `b_seq` int(11) NOT NULL,
  `b_ref` int(11) DEFAULT NULL,
  `b_step` int(3) DEFAULT NULL,
  `b_email` varchar(30) DEFAULT NULL,
  `b_name` varchar(20) DEFAULT NULL,
  `b_title` varchar(200) DEFAULT NULL,
  `b_content` varchar(3000) DEFAULT NULL,
  `b_hit` int(3) DEFAULT NULL,
  `b_attach` varchar(200) DEFAULT NULL,
  `b_inputtime` varchar(50) DEFAULT NULL,
  `b_inputip` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`b_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,1,0,'admin@a.com','관리자','[공지] 여러분 환영합니다.','<p>오늘 부터 게시판이 시작이 되었네요.</p>\r\n<p>앞으로 많은 관심과 글을 부탁드립니다.</p>\r\n<p>감사합니다.</p>',0,NULL,'2021년 02월 18일 10시 50:41','127.0.0.1'),(2,2,0,'aaa@a.com','김한국','오 드디어 시작인가요?','<p>많이 올리도록 할게요 ^^&nbsp;</p>\r\n<p>좋은 하루~~</p>',0,NULL,'2021년 02월 18일 10시 51:28','127.0.0.1'),(3,3,0,'aaa@a.com','김한국','날씨가 쌀쌀하네요','<p>겨울이 끝나는 줄 알았는데 갑자기 추워졌어요</p>\r\n<p>다들 감기 조심~~</p>',0,NULL,'2021년 02월 18일 10시 52:28','127.0.0.1'),(4,4,0,'ddd@d.com','ddd','어머나 생겼네','<p>좋은 기능이네요 ㅎㅎ</p>',0,NULL,'2021년 02월 18일 10시 52:56','127.0.0.1'),(5,5,0,'ddd@d.com','ddd','아침부터 약간 피곤한 듯','<p>힘내세욧ㅎㅎ</p>',0,NULL,'2021년 02월 18일 10시 53:17','127.0.0.1'),(6,6,0,'ggg@g.com','이승윤','감사합니다.','<p>이렇게 좋은 게시판이 생기다니 ㅎㅎ</p>',0,'/uploadattaches/star.png','2021년 02월 18일 10시 53:51','127.0.0.1'),(7,7,0,'ggg@g.com','이승윤','어제도 오늘도 화이팅','<p>내일도 화이팅</p>',0,NULL,'2021년 02월 18일 10시 54:16','127.0.0.1'),(8,8,0,'iamabcd718@gmail.com','jdh','Wow, Great','<p>this borad looks fantastic~~</p>\r\n<p>amazing board. I\'m gonna visit every single day. :)</p>',0,'/uploadattaches/kim.jpg','2021년 02월 18일 10시 55:25','127.0.0.1'),(9,9,0,'iamabcd718@gmail.com','jdh','Tomorrow','<p><span style=\"background-color: #ba372a;\"><strong>Tomorrow is Friday !!~!!!!</strong></span></p>',0,NULL,'2021년 02월 18일 10시 56:27','127.0.0.1'),(10,10,0,'iamabcd718@gmail.com','jdh','Weather is cold outside','<p>hey guys~ stay warm ^^</p>',0,NULL,'2021년 02월 18일 10시 57:00','127.0.0.1'),(11,11,0,'zzz@z.com','요아리','싱어게인이 끝나서 ','<p>볼 게 없음</p>',1,NULL,'2021년 02월 18일 10시 57:34','127.0.0.1'),(12,12,0,'zzz@z.com','요아리','음색이 남달라','<p>요아리</p>',2,NULL,'2021년 02월 18일 10시 57:50','127.0.0.1'),(13,13,0,'zzz@z.com','요아리','1등 할 수 있었는데','<p>음색으로다</p>',3,NULL,'2021년 02월 18일 10시 58:03','127.0.0.1'),(14,14,0,'ttt@t.com','정홍일','나는 락커다.','<p>옷 넣는 락커가 아니라 노래하는 락커다</p>',5,NULL,'2021년 02월 18일 10시 58:44','127.0.0.1'),(15,15,0,'admin@a.com','관리자','가입인사','<h1><span style=\"color: #f1c40f; background-color: #e03e2d;\">안녕하세요</span></h1>\r\n<p><span style=\"color: #f1c40f; background-color: #e03e2d;\">또만나요?</span></p>',0,'/uploadattaches/lee.jpg','2021년 02월 18일 04시 37:23','127.0.0.1'),(16,16,0,'admin@a.com','관리자','가입인사','<h1><span style=\"color: #f1c40f; background-color: #e03e2d;\">안녕하세요</span></h1>\r\n<p><span style=\"color: #f1c40f; background-color: #e03e2d;\">또만나요?</span></p>\r\n<p>&nbsp;</p>\r\n<p><span style=\"color: #f1c40f; background-color: #e03e2d;\">그래요&nbsp;</span></p>',0,NULL,'2021년 02월 19일 11시 27:47','127.0.0.1'),(17,17,0,'ttt@t.com','정홍일','[답글]나는 락커다.','<p>멋지네요 락커</p>',3,NULL,'2021년 02월 19일 02시 59:17','127.0.0.1'),(18,18,0,'admin@a.com','관리자','[답글][답글]나는 락커다.','<p>멋집니다.</p>',0,NULL,'2021년 02월 19일 03시 01:43','127.0.0.1'),(19,19,0,'admin@a.com','관리자','[답글]싱어게인이 끝나서 ','<p>저도 많이 아쉬워요</p>',0,NULL,'2021년 02월 19일 03시 18:54','127.0.0.1'),(20,20,0,'admin@a.com','관리자','[답글][답글]싱어게인이 끝나서 ','<p>저도 아쉽네됴</p>',0,NULL,'2021년 02월 19일 03시 31:21','127.0.0.1'),(21,21,0,'admin@a.com','관리자','[답글][답글][답글]싱어게인이 끝나서 ','<p>네 너무너무 아쉬워요</p>\r\n<p>&nbsp;</p>',0,NULL,'2021년 02월 19일 03시 31:38','127.0.0.1'),(22,14,1,'admin@a.com','관리자','[답글]나는 락커다.1','<p>멋집니다.&nbsp;</p>\r\n<p>저도 락커이고 싶네요</p>',0,NULL,'2021년 02월 19일 03시 35:44','127.0.0.1'),(23,14,2,'admin@a.com','관리자','[답글][답글]나는 락커다.2','<p>한번 더 얘기하고 싶네요</p>\r\n<p>나도 락커가 되고 싶다</p>',0,NULL,'2021년 02월 19일 03시 36:19','127.0.0.1'),(24,24,0,'admin@a.com','관리자','테스트','<p>테스트</p>',0,NULL,'2021년 02월 19일 04시 01:39','127.0.0.1'),(25,25,0,'admin@a.com','관리자','테스트','<p>테스트</p>\r\n<p>안녕하세요</p>',0,NULL,'2021년 02월 19일 04시 02:37','127.0.0.1'),(28,26,1,'admin@a.com','관리자','[답글]adsf','<p>afdsfsd</p>',0,NULL,'2021년 02월 19일 04시 21:10','127.0.0.1');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buy`
--

DROP TABLE IF EXISTS `buy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buy` (
  `seq` int(11) NOT NULL,
  `vendcode` varchar(4) DEFAULT NULL,
  `vendname` varchar(20) DEFAULT NULL,
  `yyyy` varchar(4) DEFAULT NULL,
  `mm` varchar(2) DEFAULT NULL,
  `dd` varchar(2) DEFAULT NULL,
  `no` int(2) DEFAULT '0',
  `hang` int(3) DEFAULT '0',
  `procode` varchar(13) DEFAULT NULL,
  `proname` varchar(30) DEFAULT NULL,
  `price` int(11) DEFAULT '0',
  `qty` int(3) DEFAULT '0',
  `total` int(11) DEFAULT '0',
  `memo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buy`
--

LOCK TABLES `buy` WRITE;
/*!40000 ALTER TABLE `buy` DISABLE KEYS */;
INSERT INTO `buy` VALUES (1,'100','한규테크3','2021','03','02',1,1,'1000','화장지',100,50,5000,'첫 구매'),(2,'100','한규테크3','2021','03','02',2,1,'1100','책상',50000,10,500000,''),(3,'100','한규테크3','2021','03','02',3,1,'1000','화장지',100,10,1000,''),(4,'100','한규테크3','2021','03','02',4,1,'1000','화장지',100,100,10000,''),(5,'200','하율테크','2021','03','02',1,1,'1000','화장지',100,8,800,''),(6,'200','하율테크','2021','03','02',1,1,'1000','화장지',100,0,0,''),(7,'200','하율테크','2021','03','02',1,1,'1000','화장지',100,10,1000,''),(8,'200','하율테크','2021','03','02',1,1,'1100','책상',50000,10,500000,''),(9,'200','하율테크','2021','03','02',2,1,'1000','화장지',100,100,10000,''),(10,'200','','2021','03','02',2,1,'1300','책장',80000,100,8000000,''),(11,'200','','2021','03','02',2,2,'1100','책상',50000,100,5000000,''),(12,'200','','2021','03','02',2,3,'1200','의자',30000,100,3000000,''),(13,'100','한규테크3','2021','03','02',5,1,'1000','화장지',100,100,10000,''),(14,'100','','2021','03','02',5,1,'1000','화장지',100,10,1000,''),(15,'100','','2021','03','02',5,1,'1100','책상',50000,10,500000,''),(16,'200','하율테크','2021','03','02',3,1,'1000','화장지',100,10,1000,''),(17,'200','','2021','03','02',3,1,'1000','화장지',100,1,100,''),(18,'100','한규테크3','2021','03','03',1,1,'1000','화장지',100,1,100,''),(19,'100','','2021','03','03',1,1,'1100','책상',50000,10,500000,''),(20,'100','','2021','03','03',2,1,'1000','화장지',100,10,1000,''),(21,'200','하율테크','2021','03','03',1,1,'1100','책상',50000,10,500000,''),(22,'3000','삼성전자','2021','03','03',1,1,'1100','책상',50000,10,500000,'my desk'),(23,'3000','삼성전자','2021','03','03',2,1,'1400','옷장',150000,10,1500000,''),(24,'3000','삼성전자','2021','03','03',2,1,'1400','옷장',150000,10,1500000,''),(25,'3000','삼성전자','2021','03','03',3,1,'1400','옷장',150000,10,1500000,''),(26,'3000','삼성전자','2021','03','03',4,1,'1300','책장',80000,10,800000,''),(27,'3000','삼성전자','2021','03','03',5,1,'1200','의자',30000,10,300000,''),(28,'3000','삼성전자','2021','03','03',6,1,'1300','책장',80000,90,7200000,'1111'),(29,'100','한규테크3','2021','03','03',3,1,'1200','의자',30000,10,300000,''),(30,'200','하율테크','2021','03','03',2,1,'1200','의자',30000,10,300000,''),(31,'200','하율테크','2021','03','03',3,1,'1300','책장',80000,10,800000,''),(32,'100','한규테크3','2021','03','03',4,1,'1000','화장지',100,110,11000,''),(33,'3000','삼성전자','2021','03','04',1,1,'1000','화장지',100,100,10000,''),(34,'3000','삼성전자','2021','03','03',2,1,'1400','옷장',150000,10,1500000,'테스트'),(35,'3000','삼성전자','2021','03','04',2,1,'1100','책상',50000,10,500000,'구매1'),(36,'3000','삼성전자','2021','03','04',1,1,'1000','화장지',100,100,10000,'구매2'),(37,'3000','삼성전자','2021','03','03',1,1,'1100','책상',50000,10,500000,'내 책상'),(38,'3000','삼성전자','2021','03','03',2,1,'1400','옷장',150000,10,1500000,'내 옷장'),(39,'3000','삼성전자','2021','03','03',5,1,'1200','의자',30000,10,300000,'my desk'),(40,'200','하율테크','2021','03','03',2,1,'1100','책상',50000,10,300000,'변경'),(41,'3000','삼성전자','2021','03','03',1,1,'1100','책상',50000,10,500000,'afewf'),(42,'3000','삼성전자','2021','03','03',1,2,'1200','의자',30000,10,500000,'1111'),(43,'3000','삼성전자','2021','03','03',1,1,'1600','침대',460000,10,500000,'afewf'),(44,'3000','삼성전자','2021','03','05',1,1,'1000','화장지',100,50,5000,''),(45,'3000','삼성전자','2021','03','05',2,1,'5000','아이폰',1000000,10,10000000,''),(46,'3000','삼성전자','2021','03','05',0,0,'5000','아이폰',1000000,10,10000000,''),(47,'100','한규테크3','2021','03','05',1,1,'5000','아이폰',1000000,10,10000000,''),(48,'3000','삼성전자','2021','03','05',3,1,'5000','아이폰',1000000,10,10000000,''),(49,'3000','삼성전자','2021','03','05',4,1,'5000','아이폰',1000000,10,10000000,''),(50,'3000','삼성전자','2021','03','05',5,1,'5000','아이폰',1000000,10,10000000,''),(51,'3000','삼성전자','2021','03','05',6,1,'5000','아이폰',1000000,10,10000000,''),(52,'3000','삼성전자','2021','03','05',7,1,'5000','아이폰',1000000,10,10000000,''),(53,'3000','삼성전자','2021','03','05',8,1,'5000','아이폰',1000000,10,10000000,''),(54,'3000','삼성전자','2021','03','05',9,1,'5000','아이폰',1000000,10,10000000,''),(55,'3000','삼성전자','2021','03','05',10,1,'5000','아이폰',1000000,10,10000000,''),(56,'3000','삼성전자','2021','03','05',11,1,'5000','아이폰',1000000,20,20000000,''),(57,'3000','삼성전자','2021','03','05',12,1,'5000','아이폰',1000000,10,10000000,''),(58,'3000','삼성전자','2021','03','05',13,1,'5000','아이폰',1000000,0,0,''),(59,'100','한규테크3','2021','03','05',2,1,'5000','아이폰',1000000,10,10000000,''),(60,'3000','삼성전자','2021','03','05',14,1,'5000','아이폰',1000000,10,10000000,''),(61,'3000','삼성전자','2021','03','05',15,1,'5000','아이폰',1000000,10,10000000,''),(62,'3000','삼성전자','2021','03','05',16,1,'5000','아이폰',1000000,10,10000000,''),(63,'3000','삼성전자','2021','03','05',17,1,'5000','아이폰',1000000,10,10000000,''),(64,'3000','삼성전자','2021','03','05',18,1,'5000','아이폰',1000000,20,20000000,''),(65,'3000','삼성전자','2021','03','05',19,1,'5000','아이폰',1000000,20,20000000,''),(66,'3000','삼성전자','2021','03','05',20,1,'5000','아이폰',1000000,10,10000000,''),(67,'3000','삼성전자','2021','03','05',21,1,'5000','아이폰',1000000,10,10000000,''),(68,'3000','삼성전자','2021','03','05',22,1,'1200','의자',30000,10,300000,''),(69,'3000','삼성전자','2021','03','05',23,1,'5000','아이폰',1000000,10,10000000,''),(70,'3000','삼성전자','2021','03','05',24,1,'5000','아이폰',1000000,10,10000000,''),(71,'3000','삼성전자','2021','03','05',25,1,'1000','화장지',100,1000,100000,''),(72,'200','하율테크','2021','03','05',1,1,'1200','의자',30000,110,3300000,''),(73,'3000','삼성전자','2021','03','08',1,1,'5000','아이폰',1000000,10,10000000,''),(74,'3000','삼성전자','2021','03','08',2,1,'5000','아이폰',1000000,500,500000000,''),(75,'3000','삼성전자','2021','03','08',0,0,'1600','침대',460000,100,46000000,''),(76,'3000','삼성전자','2021','03','08',3,1,'1000','화장지',100,1000,100000,''),(77,'3000','삼성전자','2021','03','08',4,1,'1600','침대',460000,1000,460000000,''),(78,'3000','삼성전자','2021','03','08',5,1,'1300','책장',80000,1000,80000000,''),(79,'3000','삼성전자','2021','03','08',6,1,'1200','의자',30000,1000,30000000,''),(80,'3000','삼성전자','2021','03','08',7,1,'1000','화장지',100,100,10000,''),(81,'3000','삼성전자','2021','03','08',8,1,'1100','책상',50000,100,5000000,'');
/*!40000 ALTER TABLE `buy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `email` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `phone1` varchar(3) DEFAULT NULL,
  `phone2` varchar(4) DEFAULT NULL,
  `phone3` varchar(4) DEFAULT NULL,
  `memlevel` int(1) DEFAULT '9',
  `photo` varchar(100) DEFAULT 'resources/images/noimage.jpg',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('aaa@a.com','김한국','$2a$10$DAk0jd8T72of3RZGDUMV7uAkp9iTjV5q9FdYjw/.KIWlgcUVIMFhO','01011112222',NULL,NULL,NULL,9,'/images/noimage.jpg'),('admin@a.com','관리자','$2a$10$T5DvaFXFY8GVKac8E6bulORVH.DL1VJFU2BuEwhTEg1yd.rd4RwMK','',NULL,NULL,NULL,1,'/uploadimages/adminlee.jpg'),('atx@a.com','atx','$2a$10$G8zdNmcR0h3NCqxUSvZxCuEWK9frwaFQ1sFU3ASYWLbxHR78ZDhDm','',NULL,NULL,NULL,9,'/images/noimage.jpg'),('ddd@d.com','ddd','$2a$10$hXHz3vsgGkqkryHl0c1AK.X6sTohjJkzJ9bMv6UNE7xpZzzFzgV4e','',NULL,NULL,NULL,9,'/images/noimage.jpg'),('feel@a.com','feel','$2a$10$HdVehdoUM6AWIDW7Qdp0MuUzNnwhqpgfi4dTUkJ.5YxaHJSW5m7aq','',NULL,NULL,NULL,9,'/images/noimage.jpg'),('ggg@g.com','이승윤','$2a$10$i2HwalYlOLe/ZJwGdigGyOTVER1LQGOU0saouuqFcwz9hGueA3KPi','',NULL,NULL,NULL,9,'/images/noimage.jpg'),('iamabcd718@gmail.com','jdh','$2a$10$U8tU2sJMHZPGjzfhX8wNCeDOWDBnGozhEikDEnZnh4MGsqvO4NjxK','',NULL,NULL,NULL,9,'/uploadimages/iamabcd718gong.png'),('ttt@a.com','aaaa','$2a$10$Ykj4WzxVksxdHzUR8y6zK.ebGmI2VX8QyN1Gpnaaeb3z1i6ASA2zy','12',NULL,NULL,NULL,9,'/images/noimage.jpg'),('ttt@t.com','정홍일','$2a$10$ogXA5Zr03lxwIkXGH/INDeviz.l.S33NwIs4uhyCIWgIe0ocSH0cy','',NULL,NULL,NULL,9,'/uploadimages/tttgong.png'),('xuzr@a.com','user','$2a$10$xS/TBe1Hyyh47W97wtgW8uX13tD73sV8ZHqo6A3a/bqroiGW4/qt6','',NULL,NULL,NULL,9,'/images/noimage.jpg'),('zzz@z.com','요아리','$2a$10$TMAiDE1qRfT6GYXlDNRi1eCDd.1O4IUmm9H0E6n0taMK2ld.VuHdW','',NULL,NULL,NULL,9,'/images/noimage.jpg'),('zzzz@a.com','이요상','$2a$10$8ai1I2KkDZmggoe8knrZQeMaxAo9XI/jpQQLigRwYCAJzAeQ1Rq9q','',NULL,NULL,NULL,9,'/images/noimage.jpg');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `seq` int(11) NOT NULL,
  `vendcode` varchar(4) DEFAULT NULL,
  `yyyy` varchar(4) DEFAULT NULL,
  `mm` varchar(2) DEFAULT NULL,
  `dd` varchar(2) DEFAULT NULL,
  `no` int(2) DEFAULT '0',
  `hang` int(3) DEFAULT '0',
  `kindtype` varchar(2) DEFAULT NULL,
  `amount` int(11) DEFAULT '0',
  `memo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `code` varchar(13) NOT NULL,
  `name` varchar(30) NOT NULL,
  `capacity` varchar(30) DEFAULT NULL,
  `buyprice` int(11) DEFAULT '0',
  `saleprice` int(11) DEFAULT '0',
  `preyystock` int(11) DEFAULT '0',
  `premmstock` int(11) DEFAULT '0',
  `preddstock` int(11) DEFAULT '0',
  `buy01` int(7) DEFAULT '0',
  `buy02` int(7) DEFAULT '0',
  `buy03` int(7) DEFAULT '0',
  `buy04` int(7) DEFAULT '0',
  `buy05` int(7) DEFAULT '0',
  `buy06` int(7) DEFAULT '0',
  `buy07` int(7) DEFAULT '0',
  `buy08` int(7) DEFAULT '0',
  `buy09` int(7) DEFAULT '0',
  `buy10` int(7) DEFAULT '0',
  `buy11` int(7) DEFAULT '0',
  `buy12` int(7) DEFAULT '0',
  `sale01` int(7) DEFAULT '0',
  `sale02` int(7) DEFAULT '0',
  `sale03` int(7) DEFAULT '0',
  `sale04` int(7) DEFAULT '0',
  `sale05` int(7) DEFAULT '0',
  `sale06` int(7) DEFAULT '0',
  `sale07` int(7) DEFAULT '0',
  `sale08` int(7) DEFAULT '0',
  `sale09` int(7) DEFAULT '0',
  `sale10` int(7) DEFAULT '0',
  `sale11` int(7) DEFAULT '0',
  `sale12` int(7) DEFAULT '0',
  `stock` int(7) DEFAULT '0',
  `explanation` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('0000','== 상품 선택 ==','',0,0,10,10,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10,''),('1000','화장지','10cm X 10m',100,200,2210,2210,2210,100,100,2100,0,0,0,0,0,0,0,0,0,100,100,0,0,0,0,0,0,0,0,0,0,2210,'3겹 고품격 화장지'),('1100','책상','80',50000,0,110,110,110,0,0,100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,110,''),('1200','의자','60',30000,0,1130,1130,1130,0,0,1120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1130,''),('1300','책장','200',80000,0,1010,1010,1010,0,0,1000,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1010,''),('1400','옷장','200',150000,0,10,10,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10,''),('1600','침대','200',460000,0,1110,1110,1110,0,0,1100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1110,''),('5000','아이폰','',1000000,0,610,610,610,0,0,570,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,610,'');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salary` (
  `empno` varchar(6) NOT NULL,
  `depart` varchar(4) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `partner` int(1) DEFAULT '0',
  `dependent20` int(2) DEFAULT '0',
  `dependent60` int(1) DEFAULT '0',
  `disabled` int(1) DEFAULT '0',
  `womanpower` int(1) DEFAULT '0',
  `pay` int(11) DEFAULT '0',
  `extra` int(11) DEFAULT '0',
  `yn` varchar(1) DEFAULT 'y',
  PRIMARY KEY (`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES ('1000','생산부','요상해',1,2,1,1,0,2000000,600000,'y'),('1100','생산부','박해리',1,1,1,0,0,2000000,200000,'y'),('2000','영업부','길동사',0,0,0,0,0,5000000,600000,'y'),('3000','기획부','요아리',0,0,0,0,0,4000000,300000,'y'),('5000','총무부','현명한',1,2,0,0,0,5000000,1000000,'y'),('6000','총무부','홍길동',0,0,0,0,0,2000000,300000,'y'),('7000','기획부','정홍일',1,0,0,0,0,3000000,1000000,'y'),('9000','기획부','홍만호',1,2,1,0,0,2500000,250000,'y');
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salaryregister`
--

DROP TABLE IF EXISTS `salaryregister`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salaryregister` (
  `yyyy` varchar(4) NOT NULL,
  `mm` varchar(2) NOT NULL,
  `empno` varchar(6) NOT NULL,
  `depart` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `partner` int(1) DEFAULT '0',
  `dependent20` int(2) DEFAULT '0',
  `dependent60` int(1) DEFAULT '0',
  `disabled` int(1) DEFAULT '0',
  `womanpower` int(1) DEFAULT '0',
  `mmpay` int(1) DEFAULT '0',
  `insurance` int(1) DEFAULT '0',
  `tax` int(9) DEFAULT '0',
  `residence` int(9) DEFAULT '0',
  `finalpay` int(11) DEFAULT '0',
  PRIMARY KEY (`yyyy`,`mm`,`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salaryregister`
--

LOCK TABLES `salaryregister` WRITE;
/*!40000 ALTER TABLE `salaryregister` DISABLE KEYS */;
/*!40000 ALTER TABLE `salaryregister` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salaryroll`
--

DROP TABLE IF EXISTS `salaryroll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salaryroll` (
  `yyyy` varchar(4) NOT NULL,
  `mm` varchar(2) NOT NULL,
  `empno` varchar(6) NOT NULL,
  `depart` varchar(4) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `partner` int(11) DEFAULT '0',
  `dependent20` int(11) DEFAULT '0',
  `dependent60` int(11) DEFAULT '0',
  `disabled` int(11) DEFAULT '0',
  `womanpower` int(11) DEFAULT '0',
  `pay12` int(11) DEFAULT '0',
  `sumpay` int(11) DEFAULT '0',
  `incomededuction` int(11) DEFAULT '0',
  `incomeamount` int(11) DEFAULT '0',
  `personaldeduction` int(11) DEFAULT '0',
  `annuityinsurance` int(11) DEFAULT '0',
  `specialdeduction` int(11) DEFAULT '0',
  `standardamount` int(11) DEFAULT '0',
  `calculatedtax` int(11) DEFAULT '0',
  `incometaxdeduction` int(11) DEFAULT '0',
  `decidedtax` int(11) DEFAULT '0',
  `simpletax` int(11) DEFAULT '0',
  `finalpay` int(11) DEFAULT '0',
  PRIMARY KEY (`yyyy`,`mm`,`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salaryroll`
--

LOCK TABLES `salaryroll` WRITE;
/*!40000 ALTER TABLE `salaryroll` DISABLE KEYS */;
INSERT INTO `salaryroll` VALUES ('2021','02','1000','생산부','요상해',1500000,3000000,1500000,1500000,0,24000000,0,7124000,24076000,9000000,1404000,0,13672000,970800,533940,436860,36400,2446600),('2021','02','1100','생산부','박해리',1500000,1500000,1500000,0,0,24000000,0,6848000,19552000,6000000,1188000,0,12364000,774600,426030,348570,29000,2072000),('2021','02','2000','영업부','길동사',0,0,0,0,0,60000000,0,4108000,63092000,1500000,3024000,0,58568000,8836320,660000,8176320,681300,4666700),('2021','02','3000','기획부','요아리',0,0,0,0,0,48000000,0,3874000,47726000,1500000,2322000,0,43904000,5505600,660000,4845600,403800,3702700),('2021','02','5000','총무부','현명한',1500000,3000000,0,0,0,60000000,0,8440000,63560000,6000000,3240000,0,54320000,7816800,500000,7316800,609700,5120300),('2021','02','6000','총무부','홍길동',0,0,0,0,0,24000000,0,4204000,23396000,1500000,1242000,0,20654000,2018100,740000,1278100,106500,2090000),('2021','02','7000','기획부','정홍일',1500000,0,0,0,0,36000000,0,4560000,43440000,3000000,2160000,0,38280000,4662000,660000,4002000,333500,3486500),('2021','02','9000','기획부','홍만호',1500000,3000000,1500000,0,0,30000000,0,7160000,25840000,7500000,1485000,0,16855000,1448250,740000,708250,59000,2567250);
/*!40000 ALTER TABLE `salaryroll` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vender`
--

DROP TABLE IF EXISTS `vender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vender` (
  `code` varchar(4) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `busno1` varchar(3) DEFAULT NULL,
  `busno2` varchar(2) DEFAULT NULL,
  `busno3` varchar(5) DEFAULT NULL,
  `biztype` varchar(20) DEFAULT NULL,
  `ceoname` varchar(20) DEFAULT NULL,
  `zipcode` varchar(5) DEFAULT NULL,
  `newaddr` varchar(100) DEFAULT NULL,
  `oldaddr` varchar(100) DEFAULT NULL,
  `detailaddr` varchar(50) DEFAULT NULL,
  `officeno1` varchar(3) DEFAULT NULL,
  `officeno2` varchar(4) DEFAULT NULL,
  `officeno3` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vender`
--

LOCK TABLES `vender` WRITE;
/*!40000 ALTER TABLE `vender` DISABLE KEYS */;
INSERT INTO `vender` VALUES ('0000','== 거래처 선택 ==','0','0','0','','','0','','','','0','0','0'),('100','한규테크3','100','10','100','게임업체','이한규','0','','','','0','0','0'),('200','하율테크','200','10','123','게임캐릭터','정하율','0','','','','0','0','0'),('3000','삼성전자','123','21','515','대기업','이재용','0','','','','0','0','0');
/*!40000 ALTER TABLE `vender` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-08 16:21:30
