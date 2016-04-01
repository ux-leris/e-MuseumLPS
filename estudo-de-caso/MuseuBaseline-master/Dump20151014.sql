-- MySQL dump 10.13  Distrib 5.6.24, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: lpsmuseumdb
-- ------------------------------------------------------
-- Server version	5.6.26

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
-- Table structure for table `UserDO`
--

DROP TABLE IF EXISTS `UserDO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserDO` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserDO`
--

LOCK TABLES `UserDO` WRITE;
/*!40000 ALTER TABLE `UserDO` DISABLE KEYS */;
/*!40000 ALTER TABLE `UserDO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `annotation`
--

DROP TABLE IF EXISTS `annotation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `annotation` (
  `id_annotation` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `id_museum` bigint(20) DEFAULT NULL,
  `id_object` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_annotation`),
  KEY `FK_b5a56479xr9r485xkefh90x02` (`id_museum`),
  KEY `FK_4bk6qed4kk7uf0su9s092k626` (`id_object`),
  CONSTRAINT `FK_4bk6qed4kk7uf0su9s092k626` FOREIGN KEY (`id_object`) REFERENCES `museological_object` (`id_object`),
  CONSTRAINT `FK_b5a56479xr9r485xkefh90x02` FOREIGN KEY (`id_museum`) REFERENCES `museum` (`id_museum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annotation`
--

LOCK TABLES `annotation` WRITE;
/*!40000 ALTER TABLE `annotation` DISABLE KEYS */;
/*!40000 ALTER TABLE `annotation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer` (
  `id_answer` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id_answer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `challenge`
--

DROP TABLE IF EXISTS `challenge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `challenge` (
  `DTYPE` varchar(31) NOT NULL,
  `id_challenge` bigint(20) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `id_scenario` bigint(20) DEFAULT NULL,
  `id_objectanswer` bigint(20) DEFAULT NULL,
  `id_objectquestion` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_challenge`),
  KEY `FK_d5n0l22v5g91plim7pfouyusf` (`id_scenario`),
  KEY `FK_syheraxs5guij6prfvimbjptf` (`id_objectanswer`),
  KEY `FK_4gihke2uu13dc4j34aq3fjv17` (`id_objectquestion`),
  CONSTRAINT `FK_4gihke2uu13dc4j34aq3fjv17` FOREIGN KEY (`id_objectquestion`) REFERENCES `museological_object` (`id_object`),
  CONSTRAINT `FK_d5n0l22v5g91plim7pfouyusf` FOREIGN KEY (`id_scenario`) REFERENCES `scenario` (`id_scenario`),
  CONSTRAINT `FK_syheraxs5guij6prfvimbjptf` FOREIGN KEY (`id_objectanswer`) REFERENCES `museological_object` (`id_object`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `challenge`
--

LOCK TABLES `challenge` WRITE;
/*!40000 ALTER TABLE `challenge` DISABLE KEYS */;
/*!40000 ALTER TABLE `challenge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `challenge_pastpresent_options`
--

DROP TABLE IF EXISTS `challenge_pastpresent_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `challenge_pastpresent_options` (
  `id_challenge` bigint(20) NOT NULL,
  `id_object` bigint(20) NOT NULL,
  KEY `FK_qhwoymcd2k8pfe30y1s353jgv` (`id_object`),
  KEY `FK_7jbduikt5no46m20f8m75vt1i` (`id_challenge`),
  CONSTRAINT `FK_7jbduikt5no46m20f8m75vt1i` FOREIGN KEY (`id_challenge`) REFERENCES `challenge` (`id_challenge`),
  CONSTRAINT `FK_qhwoymcd2k8pfe30y1s353jgv` FOREIGN KEY (`id_object`) REFERENCES `museological_object` (`id_object`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `challenge_pastpresent_options`
--

LOCK TABLES `challenge_pastpresent_options` WRITE;
/*!40000 ALTER TABLE `challenge_pastpresent_options` DISABLE KEYS */;
/*!40000 ALTER TABLE `challenge_pastpresent_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `museological_object`
--

DROP TABLE IF EXISTS `museological_object`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `museological_object` (
  `DTYPE` varchar(31) NOT NULL,
  `id_object` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `object_type` bit(1) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `urlAddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_object`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `museological_object`
--

LOCK TABLES `museological_object` WRITE;
/*!40000 ALTER TABLE `museological_object` DISABLE KEYS */;
INSERT INTO `museological_object` VALUES ('ImageDO',11,'2015-10-13','A Independência do Brasil. Independence of Brazil, 1888 - Pedro Américo.',NULL,'A Independência é um processo ocorrido de 1821 a 1825 e coloca em violenta oposição os Reinos do Brasil e de Portugal. Depois de anos de conflito armado, Portugal finalmente cedeu, e em 29 de agosto de 1825 foi assinado o Tratado de Amizade e Aliança.','imgs/00_Independence_of_Brazil_1888.jpg'),('ImageDO',12,'2015-10-13','Primeiro reinado. Abdicação de Pedro I do Brasil - Aurélio de Figueiredo.',NULL,'O primeiro reinado do Brasil é o nome dado ao período em que D. Pedro I governou o Brasil como Imperador, entre 1822 e 1831, ano de sua abdicação.  Foi marcado por uma grande crise econômica, financeira, social e política.','imgs/01_Abdicacao_Pedro_I_do_Brasil.jpg'),('ImageDO',13,'2015-10-13','Período regencial. A primeira caricatura do Brasil regência - Manuel de Araújo.',NULL,'O período regencial é como ficou conhecido o decênio de 1831 a 1840. Nele se firmaram a unidade territorial do país e a estruturação das Forças Armadas, além de serem discutidos o grau de autonomia das províncias e a centralização do poder.','imgs/02_1837_first_caricature_in_Brazil_-_Regency.png'),('ImageDO',14,'2015-10-13','Segundo reinado. D. Pedro II na abertura da Assembléia Geral - Pedro Américo.',NULL,'Período que vai do final do regencial (1831-1840) à proclamação da república (1889). Iniciou em 23 de julho de 1840, com a maioridade de Pedro de Alcântara, e teve o seu término em 15 de novembro de 1889, com a proclamação da república brasileira.','imgs/03_800px-Pedro_Americo_-_D._Pedro_II_na_abertura_da_Assembleia_Geral.jpg'),('ImageDO',15,'2015-10-13','Proclamação da República - Benedito Calixto.',NULL,'A Proclamação da República Brasileira foi um levante político-militar ocorrido em 15 de novembro de 1889 que derrubou a monarquia constitucional parlamentarista e, por conseguinte, encerrou a soberania do imperador D. Pedro II.','imgs/04_Proclamação_da_República_by_Benedito_Calixto_1893.jpg'),('ImageDO',16,'2015-10-13','A Bandeira dos Estado Unidos do Brasil.',NULL,'A Primeira República Brasileira, normalmente chamada de República Velha, foi o período da história do Brasil que se estendeu da proclamação da República até a Revolução de 1930.','imgs/05_585px-Flag_of_Brazil_15-19_November.svg.png'),('ImageDO',17,'2015-10-13','Getúlio Vargas aos 27 anos.',NULL,'Era Vargas é o período da história do Brasil entre 1930 e 1945, quando Getúlio Vargas governou o Brasil por 15 anos e de forma contínua. Compreende a Segunda e Terceira República (Estado Novo).','imgs/06_376px-Getúlio-Vargas-aos-27-anos.JPG'),('ImageDO',18,'2015-10-13','Esplanada dos Ministérios de Brasília, em 1959.',NULL,'O período conhecido como República Populista se inicia com a renúncia forçada do Presidente Getúlio Vargas, em outubro de 1945, e termina em 31 de março de 1964, pelas forças militares que iniciaram o regime militar no Brasil.','imgs/07_800px-0741_NOV_B_05_Esplanada_dos_Ministerios_Brasilia_DF_03_09_1959.jpg'),('ImageDO',19,'2015-10-13','Golpe de 1964.',NULL,'A Ditadura militar no Brasil foi o regime instaurado em 1 de abril de 1964, e durou até 15 de março de 1985. De caráter autoritário e nacionalista, acabou quando J. Sarney assumiu a presidência, o que deu início à Nova República.','imgs/08_Golpe_de_1964.jpg'),('ImageDO',20,'2015-10-13','A Constituição de 1988.',NULL,'A Nova República é o nome do período da História do Brasil que se seguiu ao fim da ditadura militar. É caracterizado pela ampla democratização política do Brasil e sua estabilização econômica.','imgs/09_800px-Ulyssesguimaraesconstituicao.jpg');
/*!40000 ALTER TABLE `museological_object` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `museum`
--

DROP TABLE IF EXISTS `museum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `museum` (
  `id_museum` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id_museum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `museum`
--

LOCK TABLES `museum` WRITE;
/*!40000 ALTER TABLE `museum` DISABLE KEYS */;
/*!40000 ALTER TABLE `museum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scenario`
--

DROP TABLE IF EXISTS `scenario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scenario` (
  `DTYPE` varchar(31) NOT NULL,
  `id_scenario` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `id_museum` bigint(20) DEFAULT NULL,
  `id_theme` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_scenario`),
  KEY `FK_1rn40kvfc3g2haavs90ug1h8u` (`id_museum`),
  KEY `FK_dufv0dvjhoiyfpiirc2gc0q9d` (`id_theme`),
  CONSTRAINT `FK_1rn40kvfc3g2haavs90ug1h8u` FOREIGN KEY (`id_museum`) REFERENCES `museum` (`id_museum`),
  CONSTRAINT `FK_dufv0dvjhoiyfpiirc2gc0q9d` FOREIGN KEY (`id_theme`) REFERENCES `theme` (`id_theme`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scenario`
--

LOCK TABLES `scenario` WRITE;
/*!40000 ALTER TABLE `scenario` DISABLE KEYS */;
/*!40000 ALTER TABLE `scenario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scenario_object`
--

DROP TABLE IF EXISTS `scenario_object`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scenario_object` (
  `id_scenario` bigint(20) NOT NULL,
  `id_object` bigint(20) NOT NULL,
  KEY `FK_t2s4xameh5wtk18avl48d3y8b` (`id_object`),
  KEY `FK_l4xpybg71faffnkbg9bj7e33y` (`id_scenario`),
  CONSTRAINT `FK_l4xpybg71faffnkbg9bj7e33y` FOREIGN KEY (`id_scenario`) REFERENCES `scenario` (`id_scenario`),
  CONSTRAINT `FK_t2s4xameh5wtk18avl48d3y8b` FOREIGN KEY (`id_object`) REFERENCES `museological_object` (`id_object`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scenario_object`
--

LOCK TABLES `scenario_object` WRITE;
/*!40000 ALTER TABLE `scenario_object` DISABLE KEYS */;
/*!40000 ALTER TABLE `scenario_object` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theme`
--

DROP TABLE IF EXISTS `theme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theme` (
  `id_theme` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_theme`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theme`
--

LOCK TABLES `theme` WRITE;
/*!40000 ALTER TABLE `theme` DISABLE KEYS */;
/*!40000 ALTER TABLE `theme` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-14  0:27:46
