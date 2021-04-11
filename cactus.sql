-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 11, 2021 at 09:54 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cactus`
--

-- --------------------------------------------------------

--
-- Table structure for table `coffee`
--

CREATE TABLE `coffee` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) COLLATE utf8mb4_persian_ci NOT NULL,
  `price` int(7) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime DEFAULT NULL,
  `removed` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_persian_ci;

--
-- Dumping data for table `coffee`
--

INSERT INTO `coffee` (`id`, `name`, `price`, `created`, `updated`, `removed`) VALUES
(1, 'latte', 5000, '2021-04-10 20:05:26', '2021-04-10 20:05:26', 0),
(2, 'affogatto', 9000, '2021-04-11 16:15:09', '2021-04-11 16:42:01', 1),
(3, 'latte', 18000, '2021-04-11 16:20:02', '2021-04-11 16:38:47', 0),
(4, 'cappuccino', 20000, '2021-04-11 16:38:06', '2021-04-11 16:40:03', 0),
(5, 'coffee', 1500, '2021-04-11 16:43:00', '2021-04-11 16:44:21', 1);

-- --------------------------------------------------------

--
-- Table structure for table `coffeetable`
--

CREATE TABLE `coffeetable` (
  `id` bigint(20) NOT NULL,
  `chairCount` int(2) NOT NULL,
  `VIP` int(1) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `removed` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_persian_ci;

--
-- Dumping data for table `coffeetable`
--

INSERT INTO `coffeetable` (`id`, `chairCount`, `VIP`, `created`, `updated`, `removed`) VALUES
(1, 4, 0, '2021-04-11 22:37:15', '2021-04-11 23:32:53', 1),
(2, 4, 0, '2021-04-11 22:40:12', '2021-04-11 23:27:17', 1),
(3, 2, 1, '2021-04-11 22:41:24', '2021-04-11 23:32:31', 0),
(4, 4, 0, '2021-04-11 22:44:40', '2021-04-11 22:44:40', 0),
(5, 4, 1, '2021-04-11 23:02:03', '2021-04-11 23:02:03', 0);

-- --------------------------------------------------------

--
-- Table structure for table `orderr`
--

CREATE TABLE `orderr` (
  `id` bigint(20) NOT NULL,
  `coffeeId` bigint(20) NOT NULL,
  `tableId` bigint(20) NOT NULL,
  `paid` int(1) NOT NULL,
  `delivered` int(1) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `removed` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_persian_ci;

--
-- Dumping data for table `orderr`
--

INSERT INTO `orderr` (`id`, `coffeeId`, `tableId`, `paid`, `delivered`, `created`, `updated`, `removed`) VALUES
(1, 3, 2, 1, 0, '2021-04-11 23:34:31', '2021-04-11 23:44:18', 1),
(2, 3, 6, 0, 0, '2021-04-11 23:48:58', '2021-04-11 23:48:58', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `coffee`
--
ALTER TABLE `coffee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `coffeetable`
--
ALTER TABLE `coffeetable`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orderr`
--
ALTER TABLE `orderr`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `coffee`
--
ALTER TABLE `coffee`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `coffeetable`
--
ALTER TABLE `coffeetable`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `orderr`
--
ALTER TABLE `orderr`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
