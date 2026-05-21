-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2026 at 05:57 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smashmart`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `categoryID` int(11) NOT NULL,
  `categoryName` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`categoryID`, `categoryName`) VALUES
(1, 'High End Racket'),
(2, 'Mid End Racket'),
(3, 'Low End Racket'),
(4, 'High End Shuttlecock'),
(5, 'Mid End Shuttlecock'),
(6, 'Low End Shuttlecock');

-- --------------------------------------------------------

--
-- Table structure for table `orderitems`
--

CREATE TABLE `orderitems` (
  `orderItemID` int(11) NOT NULL,
  `orderID` int(11) DEFAULT NULL,
  `productID` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `createdAt` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orderitems`
--

INSERT INTO `orderitems` (`orderItemID`, `orderID`, `productID`, `quantity`, `subtotal`, `createdAt`) VALUES
(19, 10, 16, 1, 50, '2026-05-19 10:34:19'),
(21, 10, 15, 1, 1100, '2026-05-19 10:34:19'),
(22, 11, 19, 3, 900, '2026-05-19 11:38:55'),
(24, 11, 15, 2, 2200, '2026-05-19 11:38:55'),
(25, 12, 16, 1, 50, '2026-05-20 14:26:38'),
(26, 13, 16, 1, 50, '2026-05-20 15:02:57'),
(27, 13, 19, 1, 300, '2026-05-20 15:02:57'),
(28, 14, 15, 1, 1100, '2026-05-20 16:23:09'),
(29, 15, 16, 1, 50, '2026-05-21 03:46:44'),
(30, 15, 19, 1, 300, '2026-05-21 03:46:44');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `orderID` int(11) NOT NULL,
  `userID` int(11) DEFAULT NULL,
  `totalAmount` double DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `createdAt` timestamp NOT NULL DEFAULT current_timestamp(),
  `updatedAt` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`orderID`, `userID`, `totalAmount`, `status`, `createdAt`, `updatedAt`) VALUES
(1, 2, 520, 'COMPLETED', '2026-05-16 05:57:44', '2026-05-16 05:57:44'),
(2, 3, 150, 'PENDING', '2026-05-16 05:57:44', '2026-05-16 05:57:44'),
(3, 4, 500, 'PENDING', '2026-05-16 08:31:12', '2026-05-16 08:31:12'),
(4, 5, 1480, 'PENDING', '2026-05-16 11:37:43', '2026-05-16 11:37:43'),
(5, 7, 140, 'PENDING', '2026-05-18 13:51:58', '2026-05-18 13:51:58'),
(6, 7, 80, 'PENDING', '2026-05-18 14:05:01', '2026-05-18 14:05:01'),
(7, 7, 1160, 'PENDING', '2026-05-18 16:39:31', '2026-05-18 16:39:31'),
(8, 7, 300, 'PENDING', '2026-05-19 04:25:48', '2026-05-19 04:25:48'),
(9, 7, 12, 'PENDING', '2026-05-19 08:12:29', '2026-05-19 08:12:29'),
(10, 7, 1650, 'PENDING', '2026-05-19 10:34:19', '2026-05-19 10:34:19'),
(11, 7, 3600, 'PENDING', '2026-05-19 11:38:55', '2026-05-19 11:38:55'),
(12, 7, 50, 'PENDING', '2026-05-20 14:26:38', '2026-05-20 14:26:38'),
(13, 11, 350, 'PENDING', '2026-05-20 15:02:57', '2026-05-20 15:02:57'),
(14, 13, 1100, 'PENDING', '2026-05-20 16:23:09', '2026-05-20 16:23:09'),
(15, 14, 350, 'PENDING', '2026-05-21 03:46:44', '2026-05-21 03:46:44');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `productID` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `price` double DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `categoryID` int(11) DEFAULT NULL,
  `createdAt` timestamp NOT NULL DEFAULT current_timestamp(),
  `updatedAt` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`productID`, `name`, `description`, `price`, `brand`, `image`, `categoryID`, `createdAt`, `updatedAt`) VALUES
(15, 'Yonex Astrox 100ZZ', 'lightweight professional black Racket with cover', 1100, 'Yonex', 'Resources/2nd img.jpg', 1, '2026-05-19 09:44:42', '2026-05-19 09:44:42'),
(16, 'Yonex Astrox 100ZZ', 'lightweight beginner Racket', 50, 'Tonex', 'Resources/5 img.jpg', 3, '2026-05-19 09:48:06', '2026-05-19 09:48:06'),
(19, 'Keiro 340', 'orange high tension racket', 300, 'Key', 'Resources/4 img.jpeg', 2, '2026-05-19 10:05:39', '2026-05-19 10:05:39'),
(20, 'Net Shuttle V2', 'fast and plastic', 50, 'Victor', 'Resources/sh 1.jpeg', 6, '2026-05-19 10:12:15', '2026-05-19 10:12:15');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `createdAt` timestamp NOT NULL DEFAULT current_timestamp(),
  `updatedAt` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `name`, `email`, `password`, `role`, `address`, `phone`, `createdAt`, `updatedAt`) VALUES
(2, 'John Doe', 'john@gmail.com', 'password123', 'buyer', 'Pokhara', '9811111111', '2026-05-16 05:57:44', '2026-05-16 05:57:44'),
(3, 'Jane Smith', 'jane@gmail.com', 'password123', 'buyer', 'Lalitpur', '9822222222', '2026-05-16 05:57:44', '2026-05-16 05:57:44'),
(4, 'Admin', 'admin@sm.com', '$2a$10$i7dwTSnBf/afglFR23fJMO1fKGA9lx57zhufmZAcx.hCC73zu8dsW', 'Admin', 'Pkr', '9856020743', '2026-05-16 08:05:51', '2026-05-16 10:26:52'),
(5, 'Tester', 'test@sm.com', '$2a$10$ui4N7xDOLnyNjxZsWJhi1.9ESB4m1Xx9VYZGkhe6WGkAtTclJhkkO', 'Buyer', 'Pokahra', '9856020743', '2026-05-16 11:36:03', '2026-05-16 11:36:03'),
(6, 'Tester', 'test@smashmart.com', '$2a$10$Gmkc9aa.ipOJ3ZxydMUccu7o7l9aHzbmFwtSCKHJXoAYRKwhvEzCG', 'Buyer', 'Pokhara', '9800000000', '2026-05-17 04:18:34', '2026-05-17 04:18:34'),
(7, 'RealAccount', 'Account@smash.com', '$2a$10$uV4XIKMUH38pQxA1YxsEYOuQnCXbrCRgyQVB8BS2QeVIidnNAf6bS', 'Buyer', 'Pokhara', '9812345678', '2026-05-17 04:31:05', '2026-05-20 16:02:23'),
(8, 'DBConnectivityCheck', 'DB@Smashmart.com', '$2a$10$Zr/kiMrs4PuuJs41A0Xr1eFP2.1QMOYRY4UBJypJAWTUoUBc84NgC', 'Buyer', 'Birauta', '9807654321', '2026-05-17 05:08:32', '2026-05-17 05:08:32'),
(10, 'Prasun Buddhacharya', 'b@gmail.com', 'Budd@123', 'Buyer', 'pkr', '9804106673', '2026-05-20 14:50:48', '2026-05-20 14:51:16'),
(11, 'RealAccount', 'pb@gmail.com', '$2a$10$R6AqjYL622Rboaof9mBSveLhjZCFndMQiBi7pfxcNIfcUeAWk67wu', 'Buyer', 'Kathmandu', '9812345670', '2026-05-20 14:55:14', '2026-05-20 16:05:12'),
(12, 'PrasunMan', 'pr@gmail.com', '$2a$10$3XEdPLbz/9gQ6V.xC.tpPesW95/12mC79FGDSIgN1qlzTcAC0ObZ.', 'Buyer', 'Pokhara', '9804106677', '2026-05-20 16:21:20', '2026-05-20 16:21:20'),
(13, 'PrasunMan', 'buddhacharya00000@gmail.com', '$2a$10$7dj0JxbI9EH.ka2.rnnLgeyCoGxo5peqgbxFDSxEu1MoNCwi.vbVi', 'Buyer', 'KTM', '9823456781', '2026-05-20 16:22:49', '2026-05-20 16:22:59'),
(14, 'FinalTest', 'FT@gmail.com', '$2a$10$uSTW7mfKiK7ZgGtg/ouUZe0rJr0u3ST51Q51gMBYe9IqNBk.A8UWm', 'Buyer', 'Pokhara', '9800000001', '2026-05-21 03:45:43', '2026-05-21 03:46:37');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`categoryID`);

--
-- Indexes for table `orderitems`
--
ALTER TABLE `orderitems`
  ADD PRIMARY KEY (`orderItemID`),
  ADD KEY `orderID` (`orderID`),
  ADD KEY `productID` (`productID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderID`),
  ADD KEY `userID` (`userID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`productID`),
  ADD KEY `idx_product_category` (`categoryID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `idx_user_email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `categoryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `orderitems`
--
ALTER TABLE `orderitems`
  MODIFY `orderItemID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `orderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `productID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orderitems`
--
ALTER TABLE `orderitems`
  ADD CONSTRAINT `orderitems_ibfk_1` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`),
  ADD CONSTRAINT `orderitems_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `products` (`productID`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`categoryID`) REFERENCES `categories` (`categoryID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
