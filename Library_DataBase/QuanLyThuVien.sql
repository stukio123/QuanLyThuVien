CREATE DATABASE  IF NOT EXISTS `quanly2` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `quanly2`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: quanly2
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `docgia`
--

DROP TABLE IF EXISTS `docgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docgia` (
  `madocgia` int(11) NOT NULL AUTO_INCREMENT,
  `tendocgia` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `gioitinh` varchar(4) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `namsinh` date DEFAULT NULL,
  `diachi` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sothe` int(11) DEFAULT NULL,
  PRIMARY KEY (`madocgia`),
  KEY `fk_docgia_sothe_idx` (`sothe`),
  CONSTRAINT `fk_docgia_sothe` FOREIGN KEY (`sothe`) REFERENCES `thethuvien` (`sothe`)
) ENGINE=InnoDB AUTO_INCREMENT=1751010161 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docgia`
--

LOCK TABLES `docgia` WRITE;
/*!40000 ALTER TABLE `docgia` DISABLE KEYS */;
INSERT INTO `docgia` VALUES (1751010005,'Trần Nguyễn Ánh','Nữ','2019-11-21','TPHCM',1751010005),(1751010117,'Phạm Trí Quang','Nam','1999-11-01','TPHCM',1751010117),(1751010160,'Trần Viết Tin','Nữ','2019-11-08','Bình Định',1751010160);
/*!40000 ALTER TABLE `docgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `muonsach`
--

DROP TABLE IF EXISTS `muonsach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `muonsach` (
  `mamuon` int(11) NOT NULL AUTO_INCREMENT,
  `mathe` int(11) NOT NULL,
  `masach` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ngaymuon` date DEFAULT NULL,
  `is_tra` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`mamuon`),
  KEY `fk_muon_sach` (`masach`),
  KEY `fk_muon_thethuvien_idx` (`mathe`),
  CONSTRAINT `fk_muon_sach` FOREIGN KEY (`masach`) REFERENCES `sach` (`masach`),
  CONSTRAINT `fk_muon_thethuvien` FOREIGN KEY (`mathe`) REFERENCES `thethuvien` (`sothe`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muonsach`
--

LOCK TABLES `muonsach` WRITE;
/*!40000 ALTER TABLE `muonsach` DISABLE KEYS */;
INSERT INTO `muonsach` VALUES (14,1751010005,'TG01','2019-11-27','-'),(15,1751010005,'TG01','2019-11-27','đã trả'),(16,1751010005,'TG01','2019-11-27','-'),(17,1751010005,'TG01','2019-11-27','đã trả'),(18,1751010005,'TG01','2019-11-27','đã trả'),(19,1751010005,'TG01','2019-11-27','đã trả'),(20,1751010005,'KN01','2019-11-26','-'),(21,1751010005,'KN01','2019-11-26','-');
/*!40000 ALTER TABLE `muonsach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `manv` int(11) NOT NULL AUTO_INCREMENT,
  `hoten` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `gioitinh` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `namsinh` datetime DEFAULT NULL,
  `diachi` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `matk` int(11) DEFAULT NULL,
  PRIMARY KEY (`manv`),
  KEY `fk_tk_nv_idx` (`matk`),
  CONSTRAINT `fk_tk_nv` FOREIGN KEY (`matk`) REFERENCES `taikhoan` (`matk`)
) ENGINE=InnoDB AUTO_INCREMENT=12345679 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Trần Nguyễn Ánh','Nữ','2019-11-29 00:00:00','TPHCM',1),(2,'Phạm Trí Quang','Nam','1999-11-01 00:00:00','TPHCM',1),(3,'Trần Viết Tin','Nam','1999-05-23 00:00:00','TPHCM',1),(4,'Nguyễn Mạnh Hậu','Nam','1999-08-04 00:00:00','Bình Định',2),(123456,'asd','Nữ','2019-11-01 00:00:00','  a asd d  ',4);
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sach` (
  `masach` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tensach` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tacgia` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `theloai` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `nhaxuatban` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  PRIMARY KEY (`masach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sach`
--

LOCK TABLES `sach` WRITE;
/*!40000 ALTER TABLE `sach` DISABLE KEYS */;
INSERT INTO `sach` VALUES ('KN01','Đừng Lựa Chọn An Nhàn Khi Còn Trẻ','Cảnh Thiên','Sách Kỹ Năng','Nhà Xuất Bản Thế Giới',33),('KN02','Bạn Đắt Giá Bao Nhiêu?','Vãn Tình','Sách Kỹ Năng','Nhà Xuất Bản Thế Giới',320),('KT01','Sự kết thúc của thời đại giả kim','Mervyn King','Sách Kinh Tế','Nhà Xuất Bản Thế Giới',368),('TG01','Lập Trình Java','Dương Hữu Thành','Giáo Trình','ĐH Mở',11),('VH01','The Little Prince - Hoàng Tử Bé','Antoine De Saint-Exupéry','Văn Học','Wordsworth Editions Ltd',55);
/*!40000 ALTER TABLE `sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `matk` int(11) NOT NULL AUTO_INCREMENT,
  `tentk` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `matkhau` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `quyen` bit(1) NOT NULL,
  PRIMARY KEY (`matk`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES (1,'admin','admin',_binary ''),(2,'nhanvien1','1',_binary '\0'),(3,'nhanvien2','1',_binary '\0'),(4,'admin','1',_binary '');
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thethuvien`
--

DROP TABLE IF EXISTS `thethuvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thethuvien` (
  `sothe` int(11) NOT NULL AUTO_INCREMENT,
  `ngaybatdau` datetime NOT NULL,
  `ngayhethan` datetime NOT NULL,
  PRIMARY KEY (`sothe`)
) ENGINE=InnoDB AUTO_INCREMENT=1751010161 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thethuvien`
--

LOCK TABLES `thethuvien` WRITE;
/*!40000 ALTER TABLE `thethuvien` DISABLE KEYS */;
INSERT INTO `thethuvien` VALUES (1751010005,'2018-05-04 00:00:00','2020-05-04 00:00:00'),(1751010117,'2919-11-11 00:00:00','2020-11-11 00:00:00'),(1751010160,'2019-05-01 00:00:00','2022-05-01 00:00:00');
/*!40000 ALTER TABLE `thethuvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trasach`
--

DROP TABLE IF EXISTS `trasach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trasach` (
  `matra` int(11) NOT NULL AUTO_INCREMENT,
  `mamuon` int(11) DEFAULT NULL,
  `ngaytra` date DEFAULT NULL,
  `ngaytre` int(11) DEFAULT NULL,
  `tienphat` decimal(11,0) DEFAULT NULL,
  PRIMARY KEY (`matra`),
  KEY `fk_muon_tra_idx` (`mamuon`),
  CONSTRAINT `fk_muon_tra` FOREIGN KEY (`mamuon`) REFERENCES `muonsach` (`mamuon`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trasach`
--

LOCK TABLES `trasach` WRITE;
/*!40000 ALTER TABLE `trasach` DISABLE KEYS */;
INSERT INTO `trasach` VALUES (30,19,'2019-11-25',-2,-10000),(31,17,'2019-11-25',-2,-10000),(32,15,'2019-11-30',0,0),(33,15,'2020-03-19',83,415000),(34,18,'2019-11-29',0,0),(35,19,'2019-11-29',0,0);
/*!40000 ALTER TABLE `trasach` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-20  2:35:48
