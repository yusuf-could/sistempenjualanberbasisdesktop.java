-- MariaDB dump 10.17  Distrib 10.4.8-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: db_inventory
-- ------------------------------------------------------
-- Server version	10.4.8-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `barang`
--

DROP TABLE IF EXISTS `barang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `barang` (
  `id_barang` varchar(20) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `jenis_barang` varchar(50) NOT NULL,
  `stock` int(20) NOT NULL,
  `satuan_barang` varchar(30) NOT NULL,
  `harga_barang` double NOT NULL,
  PRIMARY KEY (`id_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barang`
--

LOCK TABLES `barang` WRITE;
/*!40000 ALTER TABLE `barang` DISABLE KEYS */;
INSERT INTO `barang` VALUES ('ID-0001','Valve','Alat industri',0,'pcs',1000000),('ID-0002','Stud Bolt','Alat industri',10,'pcs',200000),('ID-0003','Arbor BT','Alat industri',10,'pcs',300000),('ID-0005','Cutter champer','Alat industri',15,'pcs',350000),('ID-0006','dies','Alat Industri',15,'pcs',200000),('ID-0007','Jig','Alat alat industri',10,'pcs',200000);
/*!40000 ALTER TABLE `barang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id_customer` varchar(20) NOT NULL,
  `nama_customer` varchar(50) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `no_telpon` varchar(20) NOT NULL,
  PRIMARY KEY (`id_customer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('ID-0001','PT Yamaha','Cikarang','0212345789'),('ID-0002','PT Aisin','Cikarang','0217888344'),('ID-0003','PT Enkei','Cikarang','02187776666'),('ID-0004','PT Astra Honda Motor','Cikarang','02177777');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jurnal`
--

DROP TABLE IF EXISTS `jurnal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jurnal` (
  `kode_jurnal` varchar(11) NOT NULL,
  `tanggal` date NOT NULL,
  `keterangan` varchar(50) NOT NULL,
  `kode_akun` varchar(20) NOT NULL,
  `nama_akun` varchar(50) NOT NULL,
  `sebesar` double NOT NULL,
  `debit` varchar(20) NOT NULL,
  `kredit` varchar(20) NOT NULL,
  PRIMARY KEY (`kode_jurnal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jurnal`
--

LOCK TABLES `jurnal` WRITE;
/*!40000 ALTER TABLE `jurnal` DISABLE KEYS */;
INSERT INTO `jurnal` VALUES ('JR-0001','2020-08-28','Penjualan','411','Pendaptan Jasa/Usaha',770000,'','Kredit'),('JR-0002','2020-08-28','Penjualan','411','Pendaptan Jasa/Usaha',3300000,'','Kredit'),('JR-0003','2020-08-29','Penjualan','411','Pendaptan Jasa/Usaha',3300000,'','Kredit'),('JR-0004','2020-08-29','Penjualan','411','Pendaptan Jasa/Usaha',16500000,'','Kredit');
/*!40000 ALTER TABLE `jurnal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `username` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `jenkel` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `hak_akses` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('admin','admin@gmail.com','laki-laki','1111','Admin'),('fajar','fajar@gmail.com','laki-laki','2222','Manager'),('Yusuf','saputra@gmail.com','Laki-laki','4444','Admin');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_akun`
--

DROP TABLE IF EXISTS `master_akun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `master_akun` (
  `kode_akun` varchar(11) NOT NULL,
  `nama_akun` varchar(50) NOT NULL,
  `debit` varchar(11) NOT NULL,
  `kredit` varchar(11) NOT NULL,
  PRIMARY KEY (`kode_akun`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_akun`
--

LOCK TABLES `master_akun` WRITE;
/*!40000 ALTER TABLE `master_akun` DISABLE KEYS */;
INSERT INTO `master_akun` VALUES ('100','Aktiva Lancar','','Kredit'),('111','Kas','','Kredit'),('112','Piutang Usaha','',''),('114','Surat-surat Berharga','Debit',''),('411','Pendaptan Jasa/Usaha','','Kredit'),('513','Beban Pajak','','Kredit');
/*!40000 ALTER TABLE `master_akun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `penerimakas`
--

DROP TABLE IF EXISTS `penerimakas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `penerimakas` (
  `no_kas` varchar(11) NOT NULL,
  `tanggal` date NOT NULL,
  `keterangan` varchar(50) NOT NULL,
  `penerima` varchar(20) NOT NULL,
  `no_faktur` varchar(11) NOT NULL,
  `terima` varchar(50) NOT NULL,
  `sebesar` double NOT NULL,
  PRIMARY KEY (`no_kas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `penerimakas`
--

LOCK TABLES `penerimakas` WRITE;
/*!40000 ALTER TABLE `penerimakas` DISABLE KEYS */;
INSERT INTO `penerimakas` VALUES ('KM-0001','2020-08-28','Penjualan','Yusuf saputra','FP-0001','ID-0005',770000),('KM-0002','2020-08-28','Penjualan','Andri','FP-0002','ID-0006',3300000),('KM-0003','2020-08-28','Penjualan','Yusuf saputra','FP-0003','ID-0003',3300000),('KM-0004','2020-08-28','Penjualan','Yusuf saputra','FP-0004','ID-0001',16500000);
/*!40000 ALTER TABLE `penerimakas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pengiriman`
--

DROP TABLE IF EXISTS `pengiriman`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pengiriman` (
  `no_dokumen` varchar(11) NOT NULL,
  `tanggal` date NOT NULL,
  `nama_customer` varchar(50) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `quantity` int(20) NOT NULL,
  `keterangan` varchar(100) NOT NULL,
  PRIMARY KEY (`no_dokumen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pengiriman`
--

LOCK TABLES `pengiriman` WRITE;
/*!40000 ALTER TABLE `pengiriman` DISABLE KEYS */;
INSERT INTO `pengiriman` VALUES ('DK-0001','2020-07-09','PT Yamaha','Valve',5,'pengiriman'),('DK-0002','2020-07-10','PT Aisin','Arbor BT',10,'selesai'),('DK-0003','2020-07-07','PT Aisin','Cutter champer',5,'Barang');
/*!40000 ALTER TABLE `pengiriman` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `penjualan`
--

DROP TABLE IF EXISTS `penjualan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `penjualan` (
  `no_faktur` varchar(11) NOT NULL,
  `tanggal` date NOT NULL,
  `nama_customer` varchar(50) NOT NULL,
  `id_barang` varchar(11) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `harga_barang` double NOT NULL,
  `quantity` int(15) NOT NULL,
  `harga` double NOT NULL,
  `ppn` int(20) NOT NULL,
  `total_harga` double NOT NULL,
  PRIMARY KEY (`no_faktur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `penjualan`
--

LOCK TABLES `penjualan` WRITE;
/*!40000 ALTER TABLE `penjualan` DISABLE KEYS */;
/*!40000 ALTER TABLE `penjualan` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `penjualan_barang` AFTER INSERT ON `penjualan` FOR EACH ROW BEGIN
 UPDATE barang SET stock=stock-NEW.quantity
 WHERE id_barang = NEW.id_barang;
 END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `pesanan`
--

DROP TABLE IF EXISTS `pesanan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pesanan` (
  `no_pesanan` varchar(11) NOT NULL,
  `tanggal` date NOT NULL,
  `nama_customer` varchar(50) NOT NULL,
  `id_barang` varchar(11) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `harga_barang` double NOT NULL,
  `quantity` int(15) NOT NULL,
  `ppn` int(20) NOT NULL,
  `total_harga` double NOT NULL,
  PRIMARY KEY (`no_pesanan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pesanan`
--

LOCK TABLES `pesanan` WRITE;
/*!40000 ALTER TABLE `pesanan` DISABLE KEYS */;
INSERT INTO `pesanan` VALUES ('PO-0001','2020-07-07','PT Yamaha','ID-0001','Valve',1000000,5,500000,5500000),('PO-0003','2020-07-07','PT Aisin','ID-0005','Cutter champer',350000,5,175000,1925000),('PO-0004','2020-08-01','PT Aisin','ID-0006','dies',200000,2,40000,440000),('PO-0005','2020-08-07','PT Aisin','ID-0006','dies',200000,3,60000,660000);
/*!40000 ALTER TABLE `pesanan` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `pesanan_barang` AFTER INSERT ON `pesanan` FOR EACH ROW BEGIN
 UPDATE barang SET stock=stock-NEW.quantity
 WHERE id_barang = NEW.id_barang;
 END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `return_penjualan`
--

DROP TABLE IF EXISTS `return_penjualan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return_penjualan` (
  `no_return` varchar(15) NOT NULL,
  `id_customer` varchar(20) NOT NULL,
  `id_barang` varchar(20) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `harga_barang` double NOT NULL,
  `jumlah` int(20) NOT NULL,
  `harga` double NOT NULL,
  PRIMARY KEY (`no_return`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_penjualan`
--

LOCK TABLES `return_penjualan` WRITE;
/*!40000 ALTER TABLE `return_penjualan` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_penjualan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-20 17:27:55
