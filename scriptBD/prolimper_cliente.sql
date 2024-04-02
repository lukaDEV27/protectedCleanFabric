-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: prolimper
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `cpf` varchar(11) DEFAULT NULL,
  `nome` varchar(60) NOT NULL,
  `sobrenome` varchar(100) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cep` varchar(8) DEFAULT NULL,
  `pedido_id` int DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  KEY `pedidos_idx` (`pedido_id`),
  CONSTRAINT `pedido_id` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id_pedido`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'19702433762','Lucas','Luiz da Silva','21977269505','Rua dique 102 fundos','Jardim América','21240800',NULL),(2,'11111111111','Cliente','Teste 1','21111111111','Rua teste 1','Bairro teste 1','11111111',NULL),(3,'22222222222','Cliente','Teste 2','21222222222','Rua teste 2','Bairro teste 2','22222222',NULL),(4,'33333333333','Cliente','Teste 3','21333333333','Rua teste 3','Bairro teste 3','33333333',NULL),(5,'44444444444','Cliente','Teste 4','21444444444','Rua teste 4','Bairro teste 4','44444444',NULL),(6,'55555555555','Cliente','Teste 5','21555555555','Rua teste 5','Bairro teste 5','55555555',NULL),(7,'12345678903','Teste Nome','Teste Sobrenome','21963852741','Rua Teste 98','Bairro Teste','12345689',NULL),(8,'66666666666','Cliente','Teste 6','21666666666','Rua Teste 06','Bairro Teste 06','66666666',NULL),(9,'77777777777','Cliente','Teste alterar','21777777777','rua teste 7','bairro teste 7','77777777',NULL),(11,'02546523655','Samuel João','Luiz da Silva de Souza','21977269505','Rua Dique 102 fundos','Jardim América','21240800',NULL),(12,'19615191516','testando Remarketing','Remarketing','21516854191','rua remarketing','remarketing','15919849',NULL),(14,'14725836913','teste','final','21363636366','teste final','teste final bairro','12351687',NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-02 17:25:33
