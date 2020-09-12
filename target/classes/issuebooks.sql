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
-- Table structure for table `issuebooks`
--

 IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='issuebooks' and xtype='U')
    CREATE TABLE issuebooks (
		id int  NOT NULL IDENTITY(1,1) PRIMARY KEY,
		bookcallno  varchar(50) NOT NULL,
		studentid  int  NOT NULL,
		studentname  varchar(50) NOT NULL,
		studentcontact  varchar(20) NOT NULL,
		issueddate TIMESTAMP   
		);

--
-- Dumping data for table `issuebooks`
--

INSERT INTO issuebooks  VALUES
( 'A@4', 23, 'kk', '932992932', '2016-07-19 18:43:16'),
( 'A@4', 335, 'Sumedh', '95676565756', '2016-07-19 18:44:34'),
( 'A@4', 87, 'abhishek', '9329882382', '2016-07-19 18:46:12');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
