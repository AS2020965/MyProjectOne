-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 11, 2023 at 07:20 AM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotelm`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `nationality` varchar(200) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `email` varchar(200) NOT NULL,
  `id_proof` varchar(200) NOT NULL,
  `address` varchar(500) NOT NULL,
  `check_in` varchar(50) NOT NULL,
  `roomNo` varchar(10) NOT NULL,
  `bed` varchar(200) NOT NULL,
  `room_type` varchar(200) NOT NULL,
  `price_per_day` int(10) NOT NULL,
  `number_of_day` int(10) DEFAULT NULL,
  `total_amount` varchar(200) DEFAULT NULL,
  `check_out` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `mobile`, `nationality`, `gender`, `email`, `id_proof`, `address`, `check_in`, `roomNo`, `bed`, `room_type`, `price_per_day`, `number_of_day`, `total_amount`, `check_out`) VALUES
(1, 'dulith', '0768062921', 'sinhala', 'Male', 'dahanayakad22@gmail.com', '200017701170', 'matara', '2023/03/08', '5', 'single', 'Ac', 30000, 8, '240000', '2023/03/16'),
(2, 'kamal', '0716411485', 'sinhala', 'Male', 'kamal@gmail.com', '4568734333', 'colombo', '2023/03/17', '6', 'double', 'Non-Ac', 45000, 1, '45000', '2023/03/17'),
(3, '', '', '', 'Male', '', '', '', '2023/03/18', '6', 'double', 'Non-Ac', 45000, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `manage`
--

DROP TABLE IF EXISTS `manage`;
CREATE TABLE IF NOT EXISTS `manage` (
  `r_number` int(10) NOT NULL,
  `r_type` varchar(255) NOT NULL,
  `b_type` varchar(255) NOT NULL,
  `price` int(10) NOT NULL,
  `STATUS` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manage`
--

INSERT INTO `manage` (`r_number`, `r_type`, `b_type`, `price`, `STATUS`) VALUES
(1, 'Ac', 'single', 24000, 'not book'),
(2, 'Ac', 'double', 34000, 'book'),
(3, 'Ac', 'single', 567777, 'book'),
(4, 'Non-Ac', 'single', 34000, 'not book'),
(5, 'Ac', 'single', 30000, 'not book'),
(6, 'Non-Ac', 'double', 45000, 'book'),
(121, 'Ac', 'double', 45000, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

DROP TABLE IF EXISTS `signup`;
CREATE TABLE IF NOT EXISTS `signup` (
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `security` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `signup`
--

INSERT INTO `signup` (`name`, `email`, `password`, `security`, `answer`, `address`, `status`) VALUES
('dulith', 'dahanayakad22@gmail.com', 'dulithgo', 'What is name your first pet', 'blacky', 'matara', 'false'),
('nimal', 'nimal@gmail.com', 'asdfre', 'What was your first car', 'honda', 'galle', 'false'),
('avishka', 'avishka@gmail.com', 'avi123', 'What is name your first pet', 'piti', 'galle', 'false');

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
CREATE TABLE IF NOT EXISTS `test` (
  `id` int(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`id`, `name`) VALUES
(1, 'dulith'),
(2, 'nimal');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
