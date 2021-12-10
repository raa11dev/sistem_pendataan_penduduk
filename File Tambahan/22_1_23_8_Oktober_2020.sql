-- MariaDB dump 10.17  Distrib 10.4.14-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: desasindangpakuon
-- ------------------------------------------------------
-- Server version	10.4.14-MariaDB

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
-- Current Database: `desasindangpakuon`
--

/*!40000 DROP DATABASE IF EXISTS `desasindangpakuon`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `desasindangpakuon` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `desasindangpakuon`;

--
-- Table structure for table `agama`
--

DROP TABLE IF EXISTS `agama`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agama` (
  `id_agama` int(11) NOT NULL,
  `agama` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_agama`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agama`
--

LOCK TABLES `agama` WRITE;
/*!40000 ALTER TABLE `agama` DISABLE KEYS */;
INSERT INTO `agama` VALUES (0,'Pilih Agama'),(1,'Islam'),(2,'Kristen'),(3,'Katholik'),(4,'Hindu'),(5,'Budha'),(6,'Khonghuchu'),(7,'Lainnya');
/*!40000 ALTER TABLE `agama` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kedatangan`
--

DROP TABLE IF EXISTS `kedatangan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kedatangan` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `no_kk` varchar(30) DEFAULT NULL,
  `nik` varchar(30) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `jk` int(1) DEFAULT NULL,
  `tl` varchar(255) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `gol_dar` varchar(2) DEFAULT NULL,
  `no_agama` int(11) DEFAULT NULL,
  `no_shdrt` int(11) DEFAULT NULL,
  `ayah` varchar(255) DEFAULT NULL,
  `ibu` varchar(255) DEFAULT NULL,
  `tgl_entry` date DEFAULT NULL,
  `ket` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `no_agama` (`no_agama`),
  KEY `no_shdrt` (`no_shdrt`),
  CONSTRAINT `kedatangan_ibfk_1` FOREIGN KEY (`no_agama`) REFERENCES `agama` (`id_agama`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `kedatangan_ibfk_2` FOREIGN KEY (`no_shdrt`) REFERENCES `shdrt` (`id_shdrt`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kedatangan`
--

LOCK TABLES `kedatangan` WRITE;
/*!40000 ALTER TABLE `kedatangan` DISABLE KEYS */;
INSERT INTO `kedatangan` VALUES (1,'1420023820952','3204254101950053','NINA HARTATI',2,'BANDUNG','1995-03-27','',1,3,'IBAH','EUIS HALIMAH','2020-08-03',''),(2,'1420026820827','3211145601010011','MAESAROH',2,'SUMEDANG','2001-01-16','',1,3,'AJANG','HASANAH','2020-08-06',''),(3,'3211142112100119','3205122610990005','IRFAN TAUPIK',1,'GARUT','1999-10-03','',1,9,'ABAN SOBANDI','OMBAH','2020-08-24',''),(4,'14200224820115','3273052207900001','DANI RISNANDAR',1,'BANDUNG','1990-07-22','',1,1,'EVA HARIS','SURYANI','2020-08-24',''),(5,'142002248201349','3211145707590003','ANI',2,'SUMEDANG','1959-07-17','',1,1,'AHMAD','ANAH','2020-08-25',''),(6,'3211142112100111','3205274506020001','VIA APIANI R',2,'GARUT','2002-06-05','',1,4,'ADE SOPAN SOPIAN','WINDA WATI','2020-08-28','');
/*!40000 ALTER TABLE `kedatangan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kelahiran`
--

DROP TABLE IF EXISTS `kelahiran`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kelahiran` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `no_kk` varchar(30) DEFAULT NULL,
  `nik` varchar(30) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `jk` int(1) DEFAULT NULL,
  `tl` varchar(255) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `gol_dar` varchar(2) DEFAULT NULL,
  `no_agama` int(11) DEFAULT NULL,
  `no_shdrt` int(11) DEFAULT NULL,
  `ayah` varchar(255) DEFAULT NULL,
  `ibu` varchar(255) DEFAULT NULL,
  `tgl_entry` date DEFAULT NULL,
  `ket` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `no_agama` (`no_agama`),
  KEY `no_shdrt` (`no_shdrt`),
  CONSTRAINT `kelahiran_ibfk_1` FOREIGN KEY (`no_agama`) REFERENCES `agama` (`id_agama`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `kelahiran_ibfk_2` FOREIGN KEY (`no_shdrt`) REFERENCES `shdrt` (`id_shdrt`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kelahiran`
--

LOCK TABLES `kelahiran` WRITE;
/*!40000 ALTER TABLE `kelahiran` DISABLE KEYS */;
INSERT INTO `kelahiran` VALUES (1,'3211142807100016','142002882093','MUHAMAD RASYA ADITYA',1,'SUMEDANG','2020-08-08','',1,4,'HERMANSYAH','ERNI KURNIAWATI','2020-08-31',''),(2,'','','MUHAMMAD FATIN',1,'','2020-08-07','',1,4,'M. FIQRI KOSWARA','HERLINA','2020-08-31',''),(3,'','3211142910130006','GHAISAN ZYAN MALIK HIDAYAT',1,'','2020-08-13','',1,4,'DODI','EVI','2020-08-31',''),(4,'','3211142803080025','HAIKAL IBRAHIM SYAMADJ',1,'','2020-08-16','',1,4,'TEDI','ELIN','2020-08-31',''),(6,'','','TUBAGUS ATMAJAYA',1,'SUMEDANG','2020-08-17','',1,4,'ASEP','DINI','2020-08-31',''),(7,'3211142504160007','142002382005','HASNA ROHMATUL HASANAH',2,'SUMEDANG','2020-08-03','',1,4,'TETEN','NELI SUCI LESTARI','2020-08-31',''),(8,'3211140112100017','','RAFAI CHAIRIL ASSHAUQI',1,'SUMEDANG','2020-08-14','',1,4,'ANO K','ENTIN','2020-08-31','');
/*!40000 ALTER TABLE `kelahiran` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kematian`
--

DROP TABLE IF EXISTS `kematian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kematian` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `nik` varchar(30) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `jk` int(1) DEFAULT NULL,
  `tl` varchar(255) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `gol_dar` varchar(2) DEFAULT NULL,
  `no_agama` int(11) DEFAULT NULL,
  `no_shdrt` int(11) DEFAULT NULL,
  `no_pekerjaan` int(11) DEFAULT NULL,
  `ayah` varchar(255) DEFAULT NULL,
  `ibu` varchar(255) DEFAULT NULL,
  `tgl_kematian` date DEFAULT NULL,
  `tgl_lapor` date DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `no_agama` (`no_agama`),
  KEY `no_shdrt` (`no_shdrt`),
  KEY `no_pekerjaan` (`no_pekerjaan`),
  CONSTRAINT `kematian_ibfk_1` FOREIGN KEY (`no_agama`) REFERENCES `agama` (`id_agama`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `kematian_ibfk_2` FOREIGN KEY (`no_shdrt`) REFERENCES `shdrt` (`id_shdrt`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `kematian_ibfk_3` FOREIGN KEY (`no_pekerjaan`) REFERENCES `pekerjaan` (`id_pekerjaan`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kematian`
--

LOCK TABLES `kematian` WRITE;
/*!40000 ALTER TABLE `kematian` DISABLE KEYS */;
INSERT INTO `kematian` VALUES (1,'3211141208630006','WAHYU',1,'SUMEDANG','1963-08-12','',1,1,88,'','ATING','2020-07-31','2020-08-03'),(2,'3211144711190001','SHAKAILA YUMNA',2,'BANDUNG','2019-11-07','',1,4,1,'ARI YUNIAR','HANA FAUZIAH','2020-08-06','2020-08-10'),(3,'3273151112830001','IYOS KOSWARA',1,'SUMEDANG','1983-12-11','',1,1,19,'UYE','SITI KHODIJAH','2020-08-06','2020-08-10'),(4,'3211145505650013','ACAH',2,'SUMEDANG','1965-05-15','',1,1,2,'USUP','EDOH','2020-08-11','2020-08-12'),(5,'3211141708510002','A RAHMAT',1,'SUMEDANG','1951-08-17','',1,1,88,'SUHADA','NENENG','2020-09-09','2020-08-12');
/*!40000 ALTER TABLE `kematian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pekerjaan`
--

DROP TABLE IF EXISTS `pekerjaan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pekerjaan` (
  `id_pekerjaan` int(11) NOT NULL,
  `pekerjaan` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_pekerjaan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pekerjaan`
--

LOCK TABLES `pekerjaan` WRITE;
/*!40000 ALTER TABLE `pekerjaan` DISABLE KEYS */;
INSERT INTO `pekerjaan` VALUES (0,'Pilih Pekerjaan'),(1,'Belum/Tidak bekerja'),(2,'Mengurus Rumah Tangga'),(3,'Pelajar/Mahasiswa'),(4,'Pensiunan'),(5,'Pegawai Negri Sipil'),(6,'TNI'),(7,'POLRI'),(8,'Perdagangan'),(9,'Petani/Pekebun'),(10,'Peternak'),(11,'Nelayan/Perikanan'),(12,'Industri'),(13,'Konstruksi'),(14,'Transportasi'),(15,'Karyawan Swasta'),(16,'Karyawan BUMN'),(17,'Karyawan BUMD'),(18,'Karyawan Honorer'),(19,'Buruh Harian Lepas'),(20,'Buruh Tani/Pekebunan'),(21,'Buruh Nelayan/Perikanan'),(22,'Buruh Pertenakan'),(23,'Pembantu Rumah Tangga'),(24,'Tukang Cukur'),(25,'Tukang Listrik'),(26,'Tukang Batu'),(65,'Dosen'),(66,'Pilot'),(67,'Pengacara'),(68,'Notaris'),(69,'Arsitek'),(70,'Akuntan'),(71,'Konsultan'),(72,'Dokter'),(73,'Bidan'),(74,'Perawat'),(75,'Apoteker'),(76,'Prikiater/Psikolog'),(77,'Penyiar Televisi'),(78,'Penyiar Radio'),(79,'Pelaut'),(80,'Peneliti'),(81,'Sopir'),(82,'Pialang'),(83,'Paranormal'),(84,'Pedagang'),(85,'Perangkat Desa'),(86,'Kepala Desa'),(87,'Biarawati'),(88,'Wiraswasta'),(89,'Jasa Lainnya');
/*!40000 ALTER TABLE `pekerjaan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `petugas`
--

DROP TABLE IF EXISTS `petugas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `petugas` (
  `nip` int(11) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `jabatan` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `petugas`
--

LOCK TABLES `petugas` WRITE;
/*!40000 ALTER TABLE `petugas` DISABLE KEYS */;
INSERT INTO `petugas` VALUES (1,'DIKNA DESTIANA','Petugas Registrasi','admin','admin'),(2,'YUDI HAMDANSYAH S.Pd','Kepala Desa Sindangpakuon',NULL,NULL);
/*!40000 ALTER TABLE `petugas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pindah`
--

DROP TABLE IF EXISTS `pindah`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pindah` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `no_kk` varchar(30) DEFAULT NULL,
  `nik` varchar(30) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `jk` int(1) DEFAULT NULL,
  `tl` varchar(255) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `gol_dar` varchar(2) DEFAULT NULL,
  `no_agama` int(11) DEFAULT NULL,
  `no_shdrt` int(11) DEFAULT NULL,
  `no_pekerjaan` int(11) DEFAULT NULL,
  `ayah` varchar(255) DEFAULT NULL,
  `ibu` varchar(255) DEFAULT NULL,
  `tgl_pindah` date DEFAULT NULL,
  `tgl_update` date DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `no_agama` (`no_agama`),
  KEY `no_shdrt` (`no_shdrt`),
  KEY `no_pekerjaan` (`no_pekerjaan`),
  CONSTRAINT `pindah_ibfk_1` FOREIGN KEY (`no_agama`) REFERENCES `agama` (`id_agama`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pindah_ibfk_2` FOREIGN KEY (`no_shdrt`) REFERENCES `shdrt` (`id_shdrt`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pindah_ibfk_3` FOREIGN KEY (`no_pekerjaan`) REFERENCES `pekerjaan` (`id_pekerjaan`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pindah`
--

LOCK TABLES `pindah` WRITE;
/*!40000 ALTER TABLE `pindah` DISABLE KEYS */;
INSERT INTO `pindah` VALUES (1,'3211141803064434','3211146601950002','RISMAYANI LIDRIYANTY',2,'BANDUNG','1995-01-26','',1,4,15,'AGUS KOSWARA','EUIS SETIAWATI','2020-08-05','1000-01-01'),(2,'3211141008110008','3211141606880008','TARYANA',1,'SUMEDANG','1980-06-16','',1,1,88,'SAIM','MINAH','2020-08-10','1000-01-01'),(3,'3211141803060610','3211146410880000','NUR AFIFAH S',2,'SUMEDANG','1988-10-16','',1,4,15,'SUTIA','AAN ROHANAH','2020-08-11','1000-01-01'),(4,'3211142210150008','3211142307710001','DEDE SUHERMAN',1,'SUMEDANG','1971-07-24','',1,1,88,'IA KARSA','WOWOH','2020-08-11','1000-01-01'),(5,'3211141803066038','3273231602000001','FEBI HILMANSYAH',1,'BANDUNG','2000-02-16','',1,9,3,'OOM KOMARUDIN','SITI KHODIJAH','2020-08-14','1000-01-01'),(6,'3211141703063497','3211145605930008','RIZKA NURUL ZAJIAH',2,'SUMEDANG','1993-05-16','',1,4,1,'OOM KOMARUDIN','SITI KHODIJAH','2020-08-18','1000-01-01'),(7,'','3211142105920007','RAHMAN SOMANTRI',1,'BANDUNG','1988-06-26','',1,1,88,'SUKARNA','EUIS SUHANAH','2020-08-25','1000-01-01'),(8,'142002110191013','3211142606880004','RIDWAN JUNIADI',1,'BANDUNG','1988-06-26','',1,4,3,'RIDWAN JUNAEDI','AI DEWI','2020-08-25','1000-01-01'),(10,'142002110191013','321114490410005','PUTRI WIRIANI',2,'SUMEDANG','2010-04-09','',1,4,3,'RIDWAN JUNAEDI','AI DEWI','2020-08-25','1000-01-01'),(11,'142002110191013','3211147108940005','EFA AGUSTINA',2,'SUMEDANG','1994-08-31','',1,3,88,'DIDIN ROHAENDI','NANI SUMARNI','2020-08-25','1000-01-01'),(12,'3211140612100009','3211144705960015','YAYU MELANI',2,'SUMEDANG','1996-05-07','',1,4,1,'ASEP SUDRAJAT','YULIATI','2020-08-27','1000-01-01');
/*!40000 ALTER TABLE `pindah` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profil_desa`
--

DROP TABLE IF EXISTS `profil_desa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profil_desa` (
  `desa` varchar(255) DEFAULT NULL,
  `kecamatan` varchar(255) DEFAULT NULL,
  `kabupaten` varchar(255) DEFAULT NULL,
  `provinsi` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profil_desa`
--

LOCK TABLES `profil_desa` WRITE;
/*!40000 ALTER TABLE `profil_desa` DISABLE KEYS */;
INSERT INTO `profil_desa` VALUES ('07 SINDANGPAKUON','20 CIMANGGUNG','11 SUMEDANG','32 JAWA BARAT');
/*!40000 ALTER TABLE `profil_desa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shdrt`
--

DROP TABLE IF EXISTS `shdrt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shdrt` (
  `id_shdrt` int(11) NOT NULL,
  `shdrt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_shdrt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shdrt`
--

LOCK TABLES `shdrt` WRITE;
/*!40000 ALTER TABLE `shdrt` DISABLE KEYS */;
INSERT INTO `shdrt` VALUES (0,'Pilih SHDRT'),(1,'Kepala Keluarga'),(2,'Suami'),(3,'Istri'),(4,'Anak'),(5,'Menantu'),(6,'Cucu'),(7,'Orang Tua'),(8,'Mertua'),(9,'Family Lain'),(10,'Pembantu'),(11,'Lainnya');
/*!40000 ALTER TABLE `shdrt` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-08 22:01:24
