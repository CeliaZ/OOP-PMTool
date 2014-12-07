CREATE database if not exists oop;
use oop;
# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.21)
# Database: oop
# Generation Time: 2014-12-07 02:56:24 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table budgets
# ------------------------------------------------------------

DROP TABLE IF EXISTS `budgets`;

CREATE TABLE `budgets` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `projected` int(11) DEFAULT '0',
  `actual` int(11) DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `budgets` WRITE;
/*!40000 ALTER TABLE `budgets` DISABLE KEYS */;

INSERT INTO `budgets` (`id`, `project_id`, `projected`, `actual`, `created_at`, `updated_at`, `description`)
VALUES
	(1,24,1500,10,NULL,NULL,'');

INSERT INTO `budgets` (`id`, `project_id`, `projected`, `actual`, `created_at`, `updated_at`, `description`)
VALUES
	(2,24,155,100,NULL,NULL,'Unspecified  sdf');

/*!40000 ALTER TABLE `budgets` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table messages
# ------------------------------------------------------------

DROP TABLE IF EXISTS `messages`;

CREATE TABLE `messages` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `task_id` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `content` text,
  `sender_id` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(11,80,24,'created this task.',14,'2014-12-02 22:23:34','2014-12-04 11:38:34');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(12,80,NULL,'needs to have due day',27,'2014-12-02 22:24:04','2014-12-04 11:44:03');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(13,80,NULL,'new new new',27,'2014-12-02 22:25:39','2014-12-04 11:44:04');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(14,20,40,'created this task.',27,'2014-12-03 00:36:22','2014-12-04 11:44:05');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(15,81,NULL,'try to comment under task 6',27,'2014-12-03 00:40:32','2014-12-04 11:44:06');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(16,82,24,'created this task.',14,'2014-12-03 00:52:03','2014-12-04 11:38:37');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(17,83,40,'created this task.',27,'2014-12-03 00:52:54','2014-12-04 11:44:07');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(18,84,24,'created this task.',14,'2014-12-03 00:56:46','2014-12-04 11:38:38');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(19,85,40,'created this task.',27,'2014-12-03 01:11:45','2014-12-04 11:44:21');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(20,86,40,'created this task.',27,'2014-12-03 22:53:48','2014-12-04 11:44:22');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(21,86,NULL,'comment',27,'2014-12-03 22:54:02','2014-12-04 11:44:24');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(22,87,40,'created this task.',27,'2014-12-03 22:54:35','2014-12-04 11:44:25');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(23,87,NULL,'test updated',27,'2014-12-04 00:34:32','2014-12-04 11:44:26');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(24,84,NULL,'dafaeft',27,'2014-12-04 11:10:23','2014-12-04 11:44:27');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(25,84,NULL,'datet',14,'2014-12-04 11:45:06','2014-12-04 11:50:32');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(26,84,NULL,'datet',14,'2014-12-04 11:45:31','2014-12-04 11:50:33');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(27,82,NULL,'reata',14,'2014-12-04 11:45:48','2014-12-04 11:50:35');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(28,84,NULL,'testafter merge',14,'2014-12-04 11:51:02','2014-12-04 11:53:05');

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(29,84,NULL,'testnew',14,'2014-12-04 11:53:26',NULL);

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(30,88,24,'created this task.',14,'2014-12-04 11:53:52',NULL);

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(31,89,24,'created this task.',14,'2014-12-04 12:34:00',NULL);

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(32,89,NULL,'testtaskaftermerge',14,'2014-12-04 12:34:20',NULL);

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(33,88,NULL,'teate',14,'2014-12-04 13:28:33',NULL);

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(34,90,24,'created this task.',14,'2014-12-04 18:23:12',NULL);

INSERT INTO `messages` (`id`, `task_id`, `project_id`, `content`, `sender_id`, `created_at`, `updated_at`)
VALUES
	(35,90,NULL,'test other owner comment',14,'2014-12-04 18:23:41',NULL);

/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table projects
# ------------------------------------------------------------

DROP TABLE IF EXISTS `projects`;

CREATE TABLE `projects` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `project_name` varchar(50) NOT NULL DEFAULT '',
  `pm_id` int(11) DEFAULT NULL,
  `description` text,
  `status` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `budget` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `project_name` (`project_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;

INSERT INTO `projects` (`id`, `project_name`, `pm_id`, `description`, `status`, `category`, `created_at`, `updated_at`, `budget`)
VALUES
	(1,'project1',2,'2rsfdafrgggggffgghagfdd','in Process',NULL,'2014-12-04 18:25:49','2014-12-04 18:25:49',NULL);

INSERT INTO `projects` (`id`, `project_name`, `pm_id`, `description`, `status`, `category`, `created_at`, `updated_at`, `budget`)
VALUES
	(18,'Team1',14,'','Initialezed','COMP SCIENCE','2014-12-04 08:52:33','2014-12-04 08:52:33',NULL);

INSERT INTO `projects` (`id`, `project_name`, `pm_id`, `description`, `status`, `category`, `created_at`, `updated_at`, `budget`)
VALUES
	(19,'Team2',32,'','Initialezed','COMP SCIENCE','2014-12-04 08:55:23','2014-12-04 08:55:23',NULL);

INSERT INTO `projects` (`id`, `project_name`, `pm_id`, `description`, `status`, `category`, `created_at`, `updated_at`, `budget`)
VALUES
	(20,'Team3',27,'','Initialezed','COMP SCIENCE','2014-12-04 08:58:30','2014-12-04 08:58:30',NULL);

INSERT INTO `projects` (`id`, `project_name`, `pm_id`, `description`, `status`, `category`, `created_at`, `updated_at`, `budget`)
VALUES
	(21,'Team4',27,'','Initialezed','ROBOTICS','2014-12-04 08:59:03','2014-12-04 08:59:03',NULL);

INSERT INTO `projects` (`id`, `project_name`, `pm_id`, `description`, `status`, `category`, `created_at`, `updated_at`, `budget`)
VALUES
	(22,'Team5',31,'','Initialezed','ROBOTICS','2014-12-04 09:06:49','2014-12-04 09:06:49',NULL);

INSERT INTO `projects` (`id`, `project_name`, `pm_id`, `description`, `status`, `category`, `created_at`, `updated_at`, `budget`)
VALUES
	(24,'Team6',27,'','Initialezed','COMP SCIENCE','2014-12-04 11:01:59','2014-12-04 11:01:59',NULL);

INSERT INTO `projects` (`id`, `project_name`, `pm_id`, `description`, `status`, `category`, `created_at`, `updated_at`, `budget`)
VALUES
	(25,'Team7',37,'','Initialezed','MECHANICAL','2014-12-04 12:24:17','2014-12-04 12:24:17',NULL);

INSERT INTO `projects` (`id`, `project_name`, `pm_id`, `description`, `status`, `category`, `created_at`, `updated_at`, `budget`)
VALUES
	(26,'Team8',38,'','Initialezed','COMP SCIENCE','2014-12-04 12:32:33','2014-12-04 12:32:33',NULL);

/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table projects_users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `projects_users`;

CREATE TABLE `projects_users` (
  `id` int(11) unsigned NOT NULL,
  `project_id` int(11) unsigned NOT NULL,
  `user_id` int(11) unsigned NOT NULL,
  `role` varchar(32) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`project_id`,`user_id`),
  KEY `user_key_idx` (`user_id`),
  CONSTRAINT `pid_key` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_key` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `projects_users` WRITE;
/*!40000 ALTER TABLE `projects_users` DISABLE KEYS */;

INSERT INTO `projects_users` (`id`, `project_id`, `user_id`, `role`, `created_at`, `updated_at`)
VALUES
	(0,1,1,'student','2014-12-04 18:26:25','2014-12-04 18:26:25');

INSERT INTO `projects_users` (`id`, `project_id`, `user_id`, `role`, `created_at`, `updated_at`)
VALUES
	(1,18,14,'ProjManager',NULL,NULL);

INSERT INTO `projects_users` (`id`, `project_id`, `user_id`, `role`, `created_at`, `updated_at`)
VALUES
	(1,19,32,'ProjManager','2014-12-04 08:55:23','2014-12-04 08:55:23');

INSERT INTO `projects_users` (`id`, `project_id`, `user_id`, `role`, `created_at`, `updated_at`)
VALUES
	(1,20,27,'ProjManager','2014-12-04 08:58:30','2014-12-04 08:58:30');

INSERT INTO `projects_users` (`id`, `project_id`, `user_id`, `role`, `created_at`, `updated_at`)
VALUES
	(1,21,27,'ProjManager','2014-12-04 08:59:03','2014-12-04 08:59:03');

INSERT INTO `projects_users` (`id`, `project_id`, `user_id`, `role`, `created_at`, `updated_at`)
VALUES
	(1,22,31,'ProjManager','2014-12-04 09:06:49','2014-12-04 09:06:49');

INSERT INTO `projects_users` (`id`, `project_id`, `user_id`, `role`, `created_at`, `updated_at`)
VALUES
	(1,24,27,'ProjManager','2014-12-04 11:01:59','2014-12-04 11:01:59');

INSERT INTO `projects_users` (`id`, `project_id`, `user_id`, `role`, `created_at`, `updated_at`)
VALUES
	(1,25,37,'ProjManager','2014-12-04 12:24:17','2014-12-04 12:24:17');

INSERT INTO `projects_users` (`id`, `project_id`, `user_id`, `role`, `created_at`, `updated_at`)
VALUES
	(1,26,38,'ProjManager','2014-12-04 12:32:33','2014-12-04 12:32:33');

/*!40000 ALTER TABLE `projects_users` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tasks
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tasks`;

CREATE TABLE `tasks` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `task_name` varchar(256) DEFAULT NULL,
  `description` text,
  `start_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(11) DEFAULT 'open',
  `dependency` int(11) DEFAULT NULL,
  `closed_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(64,42,'test1','ddd',NULL,NULL,2,NULL,'2014-12-01 16:08:56',NULL,NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(65,42,'test2','333',NULL,NULL,2,NULL,'2014-12-03 01:27:52',NULL,NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(66,42,'test3','33',NULL,NULL,2,NULL,'2014-12-03 01:27:49',NULL,NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(67,42,'test4','224',NULL,NULL,1,NULL,'2014-12-03 01:27:53',NULL,NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(68,42,'test5','dsf',NULL,NULL,1,NULL,'2014-12-03 01:27:55',NULL,NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(69,42,'test6','3435',NULL,NULL,1,NULL,'2014-12-03 01:27:56',NULL,NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(75,40,'vbw','',NULL,NULL,2,NULL,'2014-12-03 01:27:58',NULL,NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(77,40,'vxzcsdf','',NULL,NULL,1,NULL,'2014-12-03 01:27:59',NULL,NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(78,40,'vcdfad','',NULL,NULL,2,NULL,'2014-12-03 01:28:01',NULL,NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(79,40,'with comments','',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(80,24,'testtt','adfa',NULL,NULL,14,NULL,'2014-12-04 11:34:42',NULL,NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(81,40,'testcherry','adfa',NULL,NULL,2,NULL,NULL,NULL,NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(82,24,'testlongtext','adfadfadsfadsfadfadfadfdfadfadfadfadfadfadfadfasdfadfadfadfadfadfadfasdfa\nfasdfadsadfewfe\nddd\n1','2014-12-01 00:00:00','2014-12-01 00:00:00',14,NULL,'2014-12-04 20:41:50',NULL,NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(83,40,'testnewline','dafdafadfadfadfadfadsfadqgr;oafkjsvaerfo;jwarhitfhqjrtoifhqareh	42eptoakrwero2i34jraow;iejrio	j24iotrfrq;tqijtowejtoiajroqtjfaiorejgaejgoiqerjoijtorejptqjorjtqoirjetioajrgjapqjrtiojqpoijtpqorjitjpoqirjeoiqjtriqoejtqorjoqejtpqjreotjqijreptjqpiro\n11',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(84,24,'testcreatedAt','dafa',NULL,NULL,14,'2014-12-03 00:56:46','2014-12-06 18:51:24','closed',NULL,'2014-12-06 18:51:24');

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(85,0,'test322','23',NULL,NULL,1,'2014-12-03 01:11:45','2014-12-03 10:46:27',NULL,NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(86,40,'rtste','hftighv',NULL,NULL,2,'2014-12-03 22:53:48',NULL,NULL,NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(87,40,'testdh','descri',NULL,'2015-01-12 00:00:00',2,'2014-12-03 22:54:35',NULL,NULL,NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(88,24,'testafter merge','erqewrq','2014-12-02 00:00:00','2014-12-03 00:00:00',14,'2014-12-04 11:53:52','2014-12-06 18:50:19','open',NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(89,24,'testafterM','adfa','2014-12-04 00:00:00','2014-12-07 00:00:00',14,'2014-12-04 12:34:00','2014-12-06 18:51:04','open',NULL,NULL);

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(90,24,'test other owner','erw','2014-12-01 00:00:00','2014-12-20 00:00:00',27,'2014-12-04 18:23:12','2014-12-06 18:51:23','closed',NULL,'2014-12-06 18:51:23');

INSERT INTO `tasks` (`id`, `project_id`, `task_name`, `description`, `start_time`, `end_time`, `owner_id`, `created_at`, `updated_at`, `status`, `dependency`, `closed_at`)
VALUES
	(91,0,NULL,NULL,NULL,NULL,NULL,'2014-12-04 18:26:42','2014-12-04 18:26:42',NULL,NULL,NULL);

/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(64) NOT NULL DEFAULT '',
  `last_name` varchar(64) DEFAULT '',
  `password_hash` varchar(256) NOT NULL DEFAULT '',
  `password_salt` varchar(10) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT '',
  `is_admin` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`id`, `first_name`, `last_name`, `password_hash`, `password_salt`, `email`, `is_admin`, `created_at`, `updated_at`)
VALUES
	(1,'Cherry','Zhang','','','yzhang@scu.edu',0,'2014-12-04 18:24:21','2014-12-04 18:25:03');

INSERT INTO `users` (`id`, `first_name`, `last_name`, `password_hash`, `password_salt`, `email`, `is_admin`, `created_at`, `updated_at`)
VALUES
	(2,'Yunxia','Zhang','','','yzhan@scu.edu',0,'2014-12-04 18:24:55','2014-12-04 18:24:55');

INSERT INTO `users` (`id`, `first_name`, `last_name`, `password_hash`, `password_salt`, `email`, `is_admin`, `created_at`, `updated_at`)
VALUES
	(14,'Tanmay','Kuruvilla','admin0000','random','tkuru@scu.edu',0,'2014-12-01 11:27:11','2014-12-01 11:27:11');

INSERT INTO `users` (`id`, `first_name`, `last_name`, `password_hash`, `password_salt`, `email`, `is_admin`, `created_at`, `updated_at`)
VALUES
	(27,'Shruti1','Saxena1','password15','random','ssaxena@scu.edu1',0,'2014-12-01 19:24:37','2014-12-01 19:24:37');

INSERT INTO `users` (`id`, `first_name`, `last_name`, `password_hash`, `password_salt`, `email`, `is_admin`, `created_at`, `updated_at`)
VALUES
	(31,'Cherry','Yuaxi','password15','random','cherry@scu.edu',0,'2014-12-03 09:53:28','2014-12-03 09:53:28');

INSERT INTO `users` (`id`, `first_name`, `last_name`, `password_hash`, `password_salt`, `email`, `is_admin`, `created_at`, `updated_at`)
VALUES
	(32,'Manish','Kuruvilla','admin0000','random','mkuru@scu.edu',0,'2014-12-04 08:54:57','2014-12-04 08:54:57');

INSERT INTO `users` (`id`, `first_name`, `last_name`, `password_hash`, `password_salt`, `email`, `is_admin`, `created_at`, `updated_at`)
VALUES
	(34,'PlzWork','Kuruvilla','admin0000','random','m4u@scu.edu',0,'2014-12-04 10:57:52','2014-12-04 10:57:52');

INSERT INTO `users` (`id`, `first_name`, `last_name`, `password_hash`, `password_salt`, `email`, `is_admin`, `created_at`, `updated_at`)
VALUES
	(37,'Shftermerge','Saxena1','password15','random','ssaxena@scu.edu15',0,'2014-12-04 12:21:47','2014-12-04 12:21:47');

INSERT INTO `users` (`id`, `first_name`, `last_name`, `password_hash`, `password_salt`, `email`, `is_admin`, `created_at`, `updated_at`)
VALUES
	(38,'PlzWorkafM','Kuruvilla','admin0000','random','m41u@scu.edu',0,'2014-12-04 12:32:22','2014-12-04 12:32:22');

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
