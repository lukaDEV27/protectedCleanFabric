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
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `num_pedido` varchar(25) NOT NULL,
  `cliente_id` int NOT NULL,
  `vendedor` varchar(255) DEFAULT NULL,
  `loja_vendedor` varchar(100) DEFAULT NULL,
  `intermediador` varchar(100) DEFAULT NULL,
  `valor` decimal(10,2) NOT NULL,
  `data_agendamento` date NOT NULL,
  `num_pedido_vendedor` varchar(45) DEFAULT NULL,
  `observacao` text,
  `id_pedido` int NOT NULL AUTO_INCREMENT,
  `data_pedido` date DEFAULT NULL,
  `tipo_servico` varchar(100) DEFAULT NULL,
  `mercadoria` varchar(100) NOT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `cliente_id_idx` (`cliente_id`),
  CONSTRAINT `cliente_id` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES ('245232',1,'Danielle Queiroz','Protected Clean Fabric',NULL,300.50,'2024-04-01',NULL,'Teste de observação, o cliente mora nos fundos então será necesário ligar para o mesmo no momento em que o funcionário chegar no local para realizar o serviço.',1,'2024-03-25','',''),('22222',2,'Vendedor Teste 2','Loja Teste 2','Passado por teste 2',200.00,'2024-06-03','222v','Observação teste 2',3,'2024-03-26','serviço teste 2, teste 3',''),('33333',1,'Vendedor Teste 3','Loja Teste 3','Passado por teste 3',300.00,'2024-05-04','333v','Observação teste 3',4,'2024-03-26','serviço teste 1, teste 3',''),('44444',4,'Vendedor Teste 4','Loja Teste 4','Passado por teste 4',400.00,'2024-06-07','444v','Observação teste 4',5,'2024-03-26','serviço teste 2, teste 3',''),('55555',5,'Vendedor Teste 5','Loja Teste 5','Passado por teste 5',500.00,'2024-06-09','555v','Observação teste 5',6,'2024-03-26','serviço teste 1, teste 2',''),('2135416',1,'Vendedor Teste',NULL,'',250.00,'2024-03-30','','teste',7,NULL,NULL,''),('5191916',5,'vendedor testando',NULL,'teste passado',350.00,'2024-04-08','5619','teste',8,NULL,NULL,''),('1981',7,'ubfiwa2',NULL,'adfsasf',151541.00,'2024-04-17','918',NULL,9,'2024-03-23','L, I, H',''),('15965195',12,'remarketing',NULL,'',300.00,'2023-02-27','','adfasfsa',14,'2023-02-15',NULL,''),('617376',5,'carlos',NULL,'',200.00,'2023-03-02','7641672','o carlos esqueceu de tirar a mercadoria de cliente ',15,'2024-04-02','L, I, H','sofa, poltrona, cadeira'),('123456',14,'teste final',NULL,'',200.00,'2023-04-02','7641672','teste final ',16,'2023-03-02','L, I, H','teste final'),('1981',7,'ubfiwa',NULL,'adfsasf',151541.00,'2024-04-01','918','teste alterar',17,'2024-02-26','L, I, H','');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
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
