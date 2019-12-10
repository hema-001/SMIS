-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.13 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for student_management_system
CREATE DATABASE IF NOT EXISTS `student_management_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `student_management_system`;

-- Dumping structure for table student_management_system.courses
CREATE TABLE IF NOT EXISTS `courses` (
  `course_code` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `teacher` varchar(50) DEFAULT NULL,
  `semester` varchar(5) DEFAULT NULL,
  `day` varchar(20) DEFAULT NULL,
  `period` varchar(10) DEFAULT NULL,
  `credits` varchar(5) DEFAULT NULL,
  `room` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`course_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table student_management_system.courses: ~6 rows (approximately)
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` (`course_code`, `name`, `teacher`, `semester`, `day`, `period`, `credits`, `room`) VALUES
	(80600536, 'OBJECT ORIENTED JAVA PROGRAMMING', 'PEN', '3', 'THURSDAY', '1-4', '3', '29-206'),
	(80600550, 'GAME DESIGN & DEVELOPMENT', 'LANFANF MIAO', '5', 'WEDNESDAY', '3-5', '2.5', '20-104'),
	(80600555, 'COMPUTER HARDWARE', 'DAMU', '5', 'WEDNESDAY', '1-2', '2.5', '23-105'),
	(80600563, 'OPERATING SYSTEM', 'XiangbinZhu', '5', 'WEDNESDAY', '1-2', '2.5', '25-307'),
	(80600691, 'OBJECT ORIENTED ANALYSIS & DESIGN', 'LAN HUI', '5', 'MONDAY', '5-6', '2.5', '25-307'),
	(210000039, 'CHINESE OVERVIEW', 'IBRAHIM', '5', 'FRIDAY', '3-5', '3', '24-102');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;

-- Dumping structure for table student_management_system.notifications
CREATE TABLE IF NOT EXISTS `notifications` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `issue_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `author` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table student_management_system.notifications: ~2 rows (approximately)
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` (`id`, `title`, `content`, `issue_date`, `author`) VALUES
	(1, 'Test', 'Test Text', '2019-11-29 01:25:54', 'IBRAHIM'),
	(2, 'Operating Systems', 'Operating systems are an essential part of any computer system. Similarly,\na course on operating systems is an essential part of any computer science\neducation. This field is undergoing rapid change, as computers are now\nprevalent in virtually every arena of day-to-day life—from embedded devices\nin automobiles through the most sophisticated planning tools for governments\nand multinational firms. Yet the fundamental concepts remain fairly clear, and\nit is on these that we base this book.\nWe wrote this book as a text for an introductory course in operating systems\nat the junior or senior undergraduate level or at the first-year graduate level. We\nhope that practitioners will also find it useful. It provides a clear description of\nthe concepts that underlie operating systems. As prerequisites, we assume that\nthe reader is familiar with basic data structures, computer organization, and\na high-level language, such as C or Java. The hardware topics required for an\nunderstanding of operating systems are covered in Chapter 1. In that chapter,\nwe also include an overview of the fundamental data structures that are\nprevalent in most operating systems. For code examples, we use predominantly\nC, with some Java, but the reader can still understand the algorithms without\na thorough knowledge of these languages.\nConcepts are presented using intuitive descriptions. Important theoretical\nresults are covered, but formal proofs are largely omitted. The bibliographical\nnotes at the end of each chapter contain pointers to research papers in which\nresults were first presented and proved, as well as references to recent material\nfor further reading. In place of proofs, figures and examples are used to suggest\nwhy we should expect the result in question to be true.\nThe fundamental concepts and algorithms covered in the book are often\nbased on those used in both commercial and open-source operating systems.\nOur aim is to present these concepts and algorithms in a general setting that\nis not tied to one particular operating system. However, we present a large\nnumber of examples that pertain to the most popular and the most innovative\noperating systems, including Linux, Microsoft Windows, Apple Mac OS X, and\nSolaris. We also include examples of both Android and iOS, currently the two\ndominant mobile operating systems.\nThe organization of the text reflects our many years of teaching courses on\noperating systems, as well as curriculum guidelines published by the IEEE', '2019-11-29 01:28:46', 'IBRAHIM M.I. ISMAIL'),
	(3, 'OO and Human mind', 'How do the principles of OO fit this model? First,\nthere appears to be a natural fit with encapsulation.\nEncapsulation lets us think about an object in isolation and can thus be related to the notion of manipulating something in short-term memory exclusively. Further, the finite size of short-term memory\nsuggests that objects should also be of limited size. However, encapsulation does not explicitly recognize the need to use short-term memory most effi-\nciently by keeping it nearly full, which corresponds\nto the development of components in the medium sized range. Programmers express surprising agreement about when they should use formal meth- ods—that point at which a problem becomes\nsufficiently complex to require formal notational\nsupport. We can speculate that this indicates the\npoint at which short-term memory overflows. It is less easy to see how inheritance fits our\nmemory model. The functions of long-term memory provide the best comparison. If an object has\nalready been transferred to long-term memory,the\ntransfer mechanism will have encoded important\nobject properties in a more compact representation. If an object is then manipulated in short-term\nmemory that possesses inherited properties previously encoded more efficiently in long-term memory, the properties’recall from long-term memory\nwill be more efficient.However, access to long-term\nmemory breaks the train of thought and is inherently less accurate. So this property of OO seems\nlikely to be problematic. This is supported by a detailed study11 of a large commercial C++ system\nconsisting of some 133,000 lines. The study’s results\nshowed that components involved in inheritance contained six times more defects than components\nnot thus involved, even though this system contained single inheritance only. The third property,that of polymorphism, is po- tentially even more damaging. Objects with\nchameleon-like properties are intrinsically more dif- ficult to manipulate, as they will by necessity involve\npattern-matching similar behavior in long-term\nmemory. The crossover of properties in short- and\nlong-term memory relates to the apparently nonlocal relationship between cause and effect observed in an OO implementation,such as the complex set of matching rules that take place invisibly\nwith function overloading in C++ through the\nmechanism of implicit actions. This mechanism has\ncaused programmers difficulty in program comprehension and reading.\n5 2 IEEE Softwar e May / June 1998\nFigure 5. A simple schematic of the physiological properties of the human memory system.\n.\nOverall, it seems that encapsulation at least partially fits how we think, but neither inheritance nor\npolymorphism do so as well or as naturally. The\nworld may well be described conveniently in terms\nof objects and their properties. But OO is not natu- rally and self-evidently associated with the least\nerror-prone way of reasoning about the world and\nshould not be considered a primary candidate for a\nmore effective programming paradigm. Given the\nsimple model I’ve described, any paradigm that fa- vors the natural behavior of the relationship be- tween short-term and long-term memory, by exploiting the U curve in inspections for example, will\nlikely lead to a significant reduction in defects, although this must still be tested experimentally.', '2019-11-29 01:34:59', 'Les Hutton');
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;

-- Dumping structure for table student_management_system.select_course
CREATE TABLE IF NOT EXISTS `select_course` (
  `id` bigint(20) DEFAULT NULL,
  `course_code` bigint(20) DEFAULT NULL,
  KEY `id` (`id`),
  KEY `course_code` (`course_code`),
  CONSTRAINT `select_course_ibfk_1` FOREIGN KEY (`id`) REFERENCES `student` (`id`) ON DELETE CASCADE,
  CONSTRAINT `select_course_ibfk_2` FOREIGN KEY (`course_code`) REFERENCES `courses` (`course_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table student_management_system.select_course: ~4 rows (approximately)
/*!40000 ALTER TABLE `select_course` DISABLE KEYS */;
INSERT INTO `select_course` (`id`, `course_code`) VALUES
	(201732120165, 80600536),
	(201732120165, 80600691),
	(201732120165, 210000039),
	(201732120165, 80600555);
/*!40000 ALTER TABLE `select_course` ENABLE KEYS */;

-- Dumping structure for table student_management_system.staff
CREATE TABLE IF NOT EXISTS `staff` (
  `emp_id` int(10) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `join_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table student_management_system.staff: ~1 rows (approximately)
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` (`emp_id`, `first_name`, `last_name`, `email`, `phone`, `role`, `password`, `join_date`) VALUES
	(20192101, 'IBRAHIM', 'ISMAIL', 'ibrahim@zjnu.edu.cn', '15558696865', 'administrator', '124536', '2019-11-26 20:43:59');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;

-- Dumping structure for table student_management_system.student
CREATE TABLE IF NOT EXISTS `student` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `passport` varchar(10) DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  `college` varchar(100) DEFAULT NULL,
  `major` varchar(100) DEFAULT NULL,
  `phone` bigint(15) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table student_management_system.student: ~2 rows (approximately)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`, `name`, `date_of_birth`, `gender`, `passport`, `nationality`, `college`, `major`, `phone`, `address`, `password`, `email`) VALUES
	(201732120159, 'IBRAHIM MOHAMED IBRAHIM ISMAIL', '1994-04-07', 'MALE', 'P00640516', 'SOMALI', 'MATHEMATICS AND COMPUTER SCIENCE', 'SOFTWARE ENGINEERING', 15558696865, 'ZJNU,NORTH GATE', 'p640516', 'IBRAHIM@zjnu.edu.cn'),
	(201732120165, 'MOHAMED JIFRY HAZZALY MOHAMED', '1993-03-04', 'MALE', 'A1234567', 'SRILANKA', 'COLLEGE OF MATHEMATICS & COMPUTER SCIENCE', 'SOFTWARE ENGINEERING', 15521019145, '224, CENTRAL ROAD, TRINCOMALEE', '123456', 'MOHAMED@zjnu.edu.cn');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- Dumping structure for table student_management_system.teacher
CREATE TABLE IF NOT EXISTS `teacher` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `date_of_birth` varchar(12) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `college` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `degree` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table student_management_system.teacher: ~1 rows (approximately)
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`id`, `name`, `date_of_birth`, `gender`, `college`, `phone`, `address`, `password`, `degree`, `email`) VALUES
	(201032120165, 'pen', '1982-02-10', 'male', 'COLLEGE OF MATHEMATICS & COMPUTER SCIENCE', '13105893921', '25, first inner ring road, jinhua, zhejiang', '123456', 'PHD', 'pen@zjnu.edu.cn');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

-- Dumping structure for table student_management_system.teacher_select_course
CREATE TABLE IF NOT EXISTS `teacher_select_course` (
  `id` bigint(20) DEFAULT NULL,
  `course_code` bigint(20) DEFAULT NULL,
  KEY `id` (`id`),
  KEY `course_code` (`course_code`),
  CONSTRAINT `teacher_select_course_ibfk_1` FOREIGN KEY (`id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `teacher_select_course_ibfk_2` FOREIGN KEY (`course_code`) REFERENCES `courses` (`course_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table student_management_system.teacher_select_course: ~2 rows (approximately)
/*!40000 ALTER TABLE `teacher_select_course` DISABLE KEYS */;
INSERT INTO `teacher_select_course` (`id`, `course_code`) VALUES
	(201032120165, 80600536),
	(201032120165, 80600550);
/*!40000 ALTER TABLE `teacher_select_course` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
