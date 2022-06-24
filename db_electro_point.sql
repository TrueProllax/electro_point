CREATE DATABASE  IF NOT EXISTS `db_electro_point` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_electro_point`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: db_electro_point
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `machine`
--

DROP TABLE IF EXISTS `machine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `machine` (
  `idMachine` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idMachine`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `machine`
--

LOCK TABLES `machine` WRITE;
/*!40000 ALTER TABLE `machine` DISABLE KEYS */;
INSERT INTO `machine` VALUES (1,'БЕЛАЗ-75710'),(2,'Hitachi Trolley Truck'),(3,'Bell B45E'),(4,'Volvo L260H'),(5,'ЧТЗ Т-800'),(6,'Atlas Copco ROC L8'),(7,'Paus PFL 8 Z'),(8,'Bergmann 5025 HK PLUS'),(9,'Komatsu PC3000');
/*!40000 ALTER TABLE `machine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor`
--

DROP TABLE IF EXISTS `sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sensor` (
  `idSensor` int NOT NULL AUTO_INCREMENT,
  `type` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `accuracyCoordinates` varchar(255) DEFAULT NULL,
  `additionally` varchar(255) DEFAULT NULL,
  `supplier` int DEFAULT NULL,
  PRIMARY KEY (`idSensor`),
  KEY `sensor_supplier_idx` (`supplier`),
  CONSTRAINT `sensor_supplier` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`idSupplier`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor`
--

LOCK TABLES `sensor` WRITE;
/*!40000 ALTER TABLE `sensor` DISABLE KEYS */;
INSERT INTO `sensor` VALUES (1,'GPS-маяк','StarLine M15 Эко','4003297','LBS 100 - 800 м, GPS 5 - 10 м, LBS 0.5 - 30 км вне города, GPS 500 м в условиях слабого сигнала','встроенный микрофон, бесплатный мониторинг, датчик движения/аварии/переворота, определение температуры в салоне, контроль заряда батарей, уведомление о подборе пароля, сигнал подтверждения активности',1),(2,'GPS-трекер','StarLine M66-M ECO','4003438','GPS/ГЛОНАСС до 5 м','мониторинг через приложение',1);
/*!40000 ALTER TABLE `sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor_put`
--

DROP TABLE IF EXISTS `sensor_put`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sensor_put` (
  `idSensorPut` int NOT NULL AUTO_INCREMENT,
  `sensor` int DEFAULT NULL,
  `machine` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`idSensorPut`),
  KEY `sensor_machine_idx` (`machine`),
  KEY `put_idx` (`sensor`),
  CONSTRAINT `put` FOREIGN KEY (`sensor`) REFERENCES `sensor` (`idSensor`),
  CONSTRAINT `sensor_machine` FOREIGN KEY (`machine`) REFERENCES `machine` (`idMachine`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor_put`
--

LOCK TABLES `sensor_put` WRITE;
/*!40000 ALTER TABLE `sensor_put` DISABLE KEYS */;
INSERT INTO `sensor_put` VALUES (3,1,1,NULL);
/*!40000 ALTER TABLE `sensor_put` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `supplier` (
  `idSupplier` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idSupplier`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'StarLine','Russia');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'db_electro_point'
--

--
-- Dumping routines for database 'db_electro_point'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-19 14:18:44
