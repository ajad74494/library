-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 19, 2016 at 07:40 PM
-- Server version: 5.5.16
-- PHP Version: 5.4.0beta2-dev

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `librarian`
--
 IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='books' and xtype='U')
  CREATE TABLE librarian (
  id int  NOT NULL IDENTITY(1,1) PRIMARY KEY,
   name varchar(100) NOT NULL,
   password varchar(100) NOT NULL,
   email varchar(100) NOT NULL,
   address varchar(200) NOT NULL,
   city varchar(100) NOT NULL,
   contact varchar(20) NOT NULL,
   
)
--
-- Dumping data for table `librarian`
--

INSERT INTO  librarian  VALUES
(  'Prabhakar', 'ppp', 'prabhakar@gmail.com', 'javatpoint', 'noida', '9998328238'),
( 'sumedh', 'sumesh', 'sumesh@gmail.com', 'Kuch Bhi', 'noida', '93823932823'),
( 'abhi', 'abhi', 'abhi@gmail.com', 'javatpoint', 'noida', '92393282323');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
