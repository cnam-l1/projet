-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 18, 2018 at 08:22 PM
-- Server version: 5.7.22-0ubuntu0.16.04.1
-- PHP Version: 7.0.30-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `easy_eat`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id_category` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id_category`, `name`) VALUES
(1, 'butchery'),
(2, 'poultry'),
(3, 'game'),
(4, 'fish'),
(5, 'dairy'),
(6, 'vegetable'),
(7, 'fresh_frozen'),
(8, 'grocery'),
(9, 'cellar');

-- --------------------------------------------------------

--
-- Table structure for table `ingredient`
--

CREATE TABLE `ingredient` (
  `id_ingredient` int(11) NOT NULL,
  `id_hash_ingredient` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_mesure_unit` int(11) NOT NULL,
  `id_category` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ingredient_recipe`
--

CREATE TABLE `ingredient_recipe` (
  `id_ingredient` int(11) NOT NULL,
  `id_recipe` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ingredient_shopping`
--

CREATE TABLE `ingredient_shopping` (
  `id_ingredient` int(11) NOT NULL,
  `id_shopping` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ingredient_user`
--

CREATE TABLE `ingredient_user` (
  `id_ingredient` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `mesure_unit`
--

CREATE TABLE `mesure_unit` (
  `id_mesure_unit` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `mesure_unit`
--

INSERT INTO `mesure_unit` (`id_mesure_unit`, `name`) VALUES
(1, 'gram'),
(2, 'liter'),
(3, 'piece');

-- --------------------------------------------------------

--
-- Table structure for table `recipe`
--

CREATE TABLE `recipe` (
  `id_recipe` int(11) NOT NULL,
  `id_hash_recipe` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nb_person` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `shopping`
--

CREATE TABLE `shopping` (
  `id_shopping` int(11) NOT NULL,
  `id_hash_shopping` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date` date NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `id_hash_user` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `login` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `id_hash_user`, `login`, `password`) VALUES
(1, 'idg3n3r3', 'admin', 'admin'),
(2, 'fa6ce6b5-64e8-4aba-8f9b-a594d5e6895f', 'hugoS', '$2a$10$ffvJgNjJZPPqvfU6ueeRAui4Iht.w6dwlHusXBsdz3goiVBFSHpD6');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id_category`);

--
-- Indexes for table `ingredient`
--
ALTER TABLE `ingredient`
  ADD PRIMARY KEY (`id_ingredient`),
  ADD KEY `Ingredient_MesureUnit_FK` (`id_mesure_unit`),
  ADD KEY `Ingredient_Category0_FK` (`id_category`);

--
-- Indexes for table `ingredient_recipe`
--
ALTER TABLE `ingredient_recipe`
  ADD PRIMARY KEY (`id_ingredient`,`id_recipe`),
  ADD KEY `Composition_Recipe0_FK` (`id_recipe`);

--
-- Indexes for table `ingredient_shopping`
--
ALTER TABLE `ingredient_shopping`
  ADD PRIMARY KEY (`id_ingredient`,`id_shopping`),
  ADD KEY `ShoppingList_Shopping0_FK` (`id_shopping`);

--
-- Indexes for table `ingredient_user`
--
ALTER TABLE `ingredient_user`
  ADD PRIMARY KEY (`id_ingredient`,`id_user`),
  ADD KEY `IngreUser_User0_FK` (`id_user`);

--
-- Indexes for table `mesure_unit`
--
ALTER TABLE `mesure_unit`
  ADD PRIMARY KEY (`id_mesure_unit`);

--
-- Indexes for table `recipe`
--
ALTER TABLE `recipe`
  ADD PRIMARY KEY (`id_recipe`),
  ADD KEY `Recipe_User_FK` (`id_user`);

--
-- Indexes for table `shopping`
--
ALTER TABLE `shopping`
  ADD PRIMARY KEY (`id_shopping`),
  ADD KEY `Shopping_User_FK` (`id_user`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `login` (`login`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id_category` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `ingredient`
--
ALTER TABLE `ingredient`
  MODIFY `id_ingredient` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `mesure_unit`
--
ALTER TABLE `mesure_unit`
  MODIFY `id_mesure_unit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `recipe`
--
ALTER TABLE `recipe`
  MODIFY `id_recipe` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `shopping`
--
ALTER TABLE `shopping`
  MODIFY `id_shopping` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `ingredient`
--
ALTER TABLE `ingredient`
  ADD CONSTRAINT `Ingredient_Category0_FK` FOREIGN KEY (`id_category`) REFERENCES `category` (`id_category`),
  ADD CONSTRAINT `Ingredient_MesureUnit_FK` FOREIGN KEY (`id_mesure_unit`) REFERENCES `mesure_unit` (`id_mesure_unit`);

--
-- Constraints for table `ingredient_recipe`
--
ALTER TABLE `ingredient_recipe`
  ADD CONSTRAINT `Composition_Ingredient_FK` FOREIGN KEY (`id_ingredient`) REFERENCES `ingredient` (`id_ingredient`),
  ADD CONSTRAINT `Composition_Recipe0_FK` FOREIGN KEY (`id_recipe`) REFERENCES `recipe` (`id_recipe`);

--
-- Constraints for table `ingredient_shopping`
--
ALTER TABLE `ingredient_shopping`
  ADD CONSTRAINT `ShoppingList_Ingredient_FK` FOREIGN KEY (`id_ingredient`) REFERENCES `ingredient` (`id_ingredient`),
  ADD CONSTRAINT `ShoppingList_Shopping0_FK` FOREIGN KEY (`id_shopping`) REFERENCES `shopping` (`id_shopping`);

--
-- Constraints for table `ingredient_user`
--
ALTER TABLE `ingredient_user`
  ADD CONSTRAINT `IngreUser_Ingredient_FK` FOREIGN KEY (`id_ingredient`) REFERENCES `ingredient` (`id_ingredient`),
  ADD CONSTRAINT `IngreUser_User0_FK` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `recipe`
--
ALTER TABLE `recipe`
  ADD CONSTRAINT `Recipe_User_FK` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `shopping`
--
ALTER TABLE `shopping`
  ADD CONSTRAINT `Shopping_User_FK` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
