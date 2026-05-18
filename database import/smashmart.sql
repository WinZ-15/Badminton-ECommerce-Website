-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2026 at 04:44 PM
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
(1, 1, 1, 1, 500, '2026-05-16 05:59:16'),
(4, 3, 1, 2, 500, '2026-05-16 08:31:12'),
(5, 4, 1, 1, 1000, '2026-05-16 11:37:43'),
(6, 4, 2, 4, 480, '2026-05-16 11:37:43'),
(7, 5, 2, 1, 120, '2026-05-18 13:51:58'),
(8, 5, 8, 1, 20, '2026-05-18 13:51:58'),
(9, 6, 6, 2, 40, '2026-05-18 14:05:01'),
(10, 6, 8, 2, 40, '2026-05-18 14:05:01');

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
(6, 7, 80, 'PENDING', '2026-05-18 14:05:01', '2026-05-18 14:05:01');

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
(1, 'Yonex Astrox 100ZZ', 'Professional high-end racket', 1000, 'Yonex', 'Resources/racket1.jpg', 1, '2026-05-16 05:57:44', '2026-05-16 11:33:20'),
(2, 'Li-Ning Turbo X50', 'Mid range racket', 120, 'Li-Ning', 'Resources/racket2.jpg', 2, '2026-05-16 05:57:44', '2026-05-16 05:57:44'),
(6, 'Practice Shuttle', 'Low cost shuttlecock', 20, 'Generic', 'Resources/shuttle3.jpg', 6, '2026-05-16 05:57:44', '2026-05-16 09:32:53'),
(8, 'Beau 7312', 'Lightweight Yellow colored badminton racket', 20, 'Sister', 'Resources/new racket.jpg', 3, '2026-05-17 05:02:58', '2026-05-17 05:02:58');

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
(7, 'RealAccount', 'Account@smash.com', '$2a$10$HPDPOve7UScSkcfp.Tmt8.9UGtolPKcb95B11jSahM.q7pR8KXG3K', 'Buyer', 'Pokhara', '9812345678', '2026-05-17 04:31:05', '2026-05-17 04:31:05'),
(8, 'DBConnectivityCheck', 'DB@Smashmart.com', '$2a$10$Zr/kiMrs4PuuJs41A0Xr1eFP2.1QMOYRY4UBJypJAWTUoUBc84NgC', 'Buyer', 'Birauta', '9807654321', '2026-05-17 05:08:32', '2026-05-17 05:08:32');

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
  ADD KEY `categoryID` (`categoryID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`),
  ADD UNIQUE KEY `email` (`email`);

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
  MODIFY `orderItemID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `orderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `productID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

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
