-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 04, 2020 at 07:11 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET GLOBAL time_zone = '+00:00';


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `seminarski_ors1`
--
CREATE DATABASE IF NOT EXISTS `seminarski_ors1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `seminarski_ors1`;

-- --------------------------------------------------------

--
-- Table structure for table `artikal_narudzbe`
--

DROP TABLE IF EXISTS `artikal_narudzbe`;
CREATE TABLE IF NOT EXISTS `artikal_narudzbe` (
  `narudzba_id` int(11) NOT NULL,
  `proizvod_id` int(15) NOT NULL,
  `kolicina` int(11) NOT NULL DEFAULT 1,
  `cijena_po_komadu` decimal(10,2) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=425 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `artikal_narudzbe`
--

INSERT INTO `artikal_narudzbe` (`narudzba_id`, `proizvod_id`, `kolicina`, `cijena_po_komadu`, `id`) VALUES
(10100, 1, 2, '136.00', 1),
(10100, 3, 1, '55.09', 2),
(10100, 4, 1, '75.46', 3),
(10102, 4, 2, '108.06', 4),
(10102, 7, 1, '60.00', 5),
(10103, 13, 1, '260.50', 6),
(10104, 5, 2, '123.50', 7),
(10105, 2, 3, '95.55', 8),
(10105, 8, 1, '143.10', 9),
(10106, 10, 2, '74.00', 10),
(10106, 11, 1, '32.50', 11),
(10108, 1, 2, '121.64', 12),
(10108, 2, 1, '94.50', 13),
(10110, 14, 1, '58.34', 14),
(10111, 8, 2, '92.19', 15),
(10111, 9, 3, '42.12', 16),
(10116, 4, 1, '86.92', 17),
(10116, 5, 1, '186.31', 18),
(10116, 6, 1, '54.50', 19),
(10117, 10, 1, '40.75', 20),
(10119, 9, 1, '42.35', 21),
(10119, 8, 2, '88.62', 22),
(10119, 3, 3, '92.46', 23),
(10120, 14, 1, '63.35', 24),
(10120, 8, 2, '194.07', 25),
(10121, 13, 1, '268.90', 26),
(10122, 2, 2, '111.39', 27),
(10122, 3, 2, '65.90', 28),
(10123, 6, 1, '55.00', 29),
(10123, 8, 2, '165.95', 30),
(10125, 1, 2, '119.20', 31),
(10131, 7, 1, '52.02', 32),
(10131, 4, 1, '134.25', 33),
(10132, 5, 2, '296.45', 34),
(10133, 5, 1, '402.30', 35),
(10134, 8, 2, '203.60', 36),
(10135, 13, 1, '298.00', 37),
(10135, 5, 1, '220.50', 38),
(10142, 1, 3, '127.84', 39),
(10142, 5, 2, '205.72', 40),
(10142, 13, 1, '241.88', 41);

-- --------------------------------------------------------

--
-- Table structure for table `kupac`
--

DROP TABLE IF EXISTS `kupac`;
CREATE TABLE IF NOT EXISTS `kupac` (
  `id` int(11) NOT NULL,
  `korisnicko_ime` varchar(50) NOT NULL,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `lozinka` varchar(50) NOT NULL,
  `telefon` varchar(50) DEFAULT NULL,
  `adresa` varchar(50) DEFAULT NULL,
  `grad` varchar(50) NOT NULL,
  `drzava` varchar(50) DEFAULT NULL,
  `postanski_broj` varchar(15) DEFAULT NULL,
  `pol` varchar(50) DEFAULT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kupac`
--

INSERT INTO `kupac` (`id`, `korisnicko_ime`, `ime`, `prezime`, `lozinka`, `telefon`, `adresa`, `grad`, `drzava`, `postanski_broj`, `pol`, `email`) VALUES
(103, 'Milos', 'Miloš', 'Lekić', 'd324e075a64b676698d58f0e14b9a766', '+381 64 124 542', NULL, 'Šabac', 'Srbija', '158889', 'M', 'Milos@webshop-yu.org'),
(112, 'Janko', 'Janko', 'Mandić', '8682f4f1ac9cb9a1cb31a49591b7dc36', '+381 63 789 789', NULL, 'Loznica', 'Srbija', '101801', 'M', 'Janko@webshop-yu.org'),
(114, 'Marko', 'Marko', 'Mandić', '2e6c740729c44c12663c973965cbf698', NULL, NULL, 'Beograd', 'Srbija', '101801', 'M', 'Marko@webshop-yu.org'),
(119, 'Vukasin', 'Vukašin', 'Rađen', '49008b2ade41771ed011bba9b20b65ea', '+381 63 259 323', NULL, 'Niš', 'Srbija', '101801', 'M', 'Vukasin@webshop-yu.org'),
(121, 'Jovana', 'Jovana', 'Račić', 'd8095e8d0ba7a74d983eb3ad50c9f273', NULL, NULL, 'Šabac', 'Srbija', '158889', 'Ž', 'Jovana@webshop-yu.org'),
(124, 'Danilo', 'Danilo', 'Kovač', 'fd3491dfb4ecab569ea39ba956133486', '+381 65 112 003', NULL, 'Beograd', 'Srbija', '101801', 'M', 'Danilo@webshop-yu.org'),
(125, 'Ranko', 'Ranko', 'Raić', '5086ff6a235a9115d51f013988040bee', NULL, NULL, 'Kraljevo', 'Srbija', '101801', 'M', 'Ranko@webshop-yu.org'),
(128, 'Nemanja', 'Nemanja', 'Karić', 'ae8199d66990a6a495488f26f9abf2ef', NULL, NULL, 'Beograd', 'Srbija', '101801', 'M', 'Nemanja@webshop-yu.org'),
(129, 'Nikola', 'Nikola', 'Jokić', 'e8f8b0cf7e6f4267e0bce864db0ac20c', '+381 63 589 320', NULL, 'Beograd', 'Srbija', '101801', 'M', 'Nikola@webshop-yu.org'),
(131, 'Teodor', 'Teodor', 'Troicki', 'ff2075c4ef973319ec264fac0e1a15d8', '+381 64 829 782', NULL, 'Beograd', 'Srbija', '101801', 'Ž', 'Teodor@webshop-yu.org'),
(141, 'JovanaM', 'Jovana', 'Mihić', '1474b10c81598dc025dd68cceb34e9e7', '+381 62 546 915', NULL, 'Šabac', 'Srbija', '158889', 'Ž', 'JovanaM@webshop-yu.org'),
(144, 'NikolaP', 'Nikola', 'Požgaj', 'd38671d8ee2a80cef970ae06a4035bd1', NULL, NULL, 'Šabac', 'Srbija', '158889', 'M', 'NikolaP@webshop-yu.org'),
(145, 'Kristina', 'Kristina', 'Kovač', '7d6d9a2dab380fc7c6ecee113b2562a0', NULL, NULL, 'Loznica', 'Srbija', '101801', 'Ž', 'Kristina@webshop-yu.org'),
(146, 'Ivana', 'Ivana', 'Đoković', 'c547430737d5bb2bc12c9d61567b6ab2', NULL, NULL, 'Niš', 'Srbija', '101801', 'Ž', 'Ivana@webshop-yu.org'),
(148, 'Danijel', 'Danijel', 'Đoković', '067b3ed9ef94876af7a7f62536baa20a', NULL, NULL, 'Užice', 'Srbija', '101801', 'M', 'Danijel@webshop-yu.org'),
(151, 'Zeljana', 'Željana', 'Lučić', '15130186d60696e11e63b97979175982', NULL, NULL, 'Požarevac', 'Srbija', '101801', 'Ž', 'Zeljana@webshop-yu.org'),
(157, 'Aleksandar', 'Aleksandar', 'Kralj', '482146cab416307300a499b65eecd025', '+381 64 776 234', NULL, 'Prizren', 'Srbija', '101801', 'M', 'Aleksandar@webshop-yu.org'),
(161, 'Radenko', 'Radenko', 'Opačić', '3ca58bedc9f6c399350932c10c5fdd52', '+381 63 875 012', NULL, 'Šabac', 'Srbija', '158889', 'M', 'Radenko@webshop-yu.org'),
(166, 'Vlatko', 'Vlatko', 'Kovačević', 'd958ad48a84d97f7c4cafc3fbca9143b', '+381 61 007 333', NULL, 'Kraljevo', 'Srbija', '101801', 'M', 'Vlatko@webshop-yu.org'),
(167, 'Ratka', 'Ratka', 'Mlinarić', '2587e1c0013242cad0b69c06af8b7e7f', '+381 64 887 654', NULL, 'Šabac', 'Srbija', '158889', 'Ž', 'Ratka@webshop-yu.org'),
(168, 'Gordana', 'Gordana', 'Perić', 'f4750b8e6e898d32f5ce4244099f6a38', '+381 63 570 009', NULL, 'Zrenjanin', 'Srbija', '101801', 'Ž', 'Gordana@webshop-yu.org'),
(169, 'Mirko', 'Mirko', 'Avrić', 'c28e2dfdfcd8722cb1f3c495b495dbe7', '+381 61 345 542', NULL, 'Beograd', 'Srbija', '101801', 'M', 'Mirko@webshop-yu.org'),
(171, 'Dragan', 'Dragan', 'Golubić', 'c2b5cc4201d1af39e9c3dc9b0b23b3d8', '+381 64 009 122', NULL, 'Šabac', 'Srbija', '101801', 'M', 'Dragan@webshop-yu.org'),
(172, 'Srdjan', 'Srđan', 'Ružić', 'a12e114b16cf9331c3a0a4d420bd6316', '+381 62 009 983', NULL, 'Kraljevo', 'Srbija', '101801', 'M', 'Srdjan@webshop-yu.org'),
(173, 'Petar', 'Petar', 'Petrić', '1bee14873b8562630d208c678b3c45e7', NULL, NULL, 'Niš', 'Srbija', '101801', 'M', 'Petar@webshop-yu.org'),
(175, 'Mihajlo', 'Mihajlo', 'Kesić', '3d2b7cc8360e1c078d6f859547d86b80', NULL, NULL, 'Užice', 'Srbija', '101801', 'M', 'Mihajlo@webshop-yu.org'),
(177, 'Mileva', 'Mileva', 'Aničić', '6deb09ea8b09158b7565f80f603c9c9c', NULL, NULL, 'Subotica', 'Srbija', '101801', 'Ž', 'Mileva@webshop-yu.org'),
(181, 'Mirjana', 'Mirjana', 'Perkovič', '74b70d5d5ff5086b3f67435c58f4efd5', NULL, NULL, 'Gornji Milanovac', 'Srbija', '101801', 'Ž', 'Mirjana@webshop-yu.org'),
(186, 'NikolaM', 'Nikola', 'Majačić', '14276e255361620df046fa98cde66842', NULL, NULL, 'Beograd', 'Srbija', '101801', 'M', 'NikolaM@webshop-yu.org'),
(187, 'Ognjen', 'Ognjen', 'Petrović', 'b22f19d8c0a13ad6155feb941c7370af', NULL, NULL, 'Niš', 'Srbija', '101801', 'M', 'Ognjen@webshop-yu.org'),
(189, 'Radovan', 'Radovan', 'Đoković', 'f69dbd28d4c741e4122fa46e03a230df', NULL, NULL, 'Novi Sad', 'Srbija', '101801', 'M', 'Radovan@webshop-yu.org'),
(198, 'Marijana', 'Marijana', 'Stefanović', 'ccb85b25f0b4c0aaccfb5d16bc21b242', NULL, NULL, 'Šabac', 'Srbija', '158889', 'Ž', 'Marijana@webshop-yu.org'),
(201, 'Svetlana', 'Svetlana', 'Lučić', 'c3d636bce8c725b5f2f9a20db7821c12', NULL, NULL, 'Prizren', 'Srbija', '101801', 'Ž', 'Svetlana@webshop-yu.org'),
(202, 'Nikolina', 'Nikolina', 'Perić', '756a399f3f5b5e8aa6bd01a174a3586c', NULL, NULL, 'Beograd', 'Srbija', '101801', 'Ž', 'Nikolina@webshop-yu.org'),
(204, 'Radovan', 'Radovan', 'Lučić', 'f69dbd28d4c741e4122fa46e03a230df', NULL, NULL, 'Dimitrovgrad', 'Srbija', '101801', 'M', 'Radovan@webshop-yu.org'),
(205, 'Luka', 'Luka', 'Sušić', '41cd8012060774402caef35e261bc90c', NULL, NULL, 'Beograd', 'Srbija', '101801', 'M', 'Luka@webshop-yu.org'),
(206, 'Stevan', 'Stevan', 'Đoković', 'c7efff912a581937d5dd4d3988fa13ac', NULL, NULL, 'Beograd', 'Srbija', '101801', 'M', 'Stevan@webshop-yu.org'),
(209, 'Vesko', 'Vesko', 'Đoković', '8aaa816a98ea8160bc7f4966540bacab', '+381 65 333 872', NULL, 'Šabac', 'Srbija', '158889', 'M', 'Vesko@webshop-yu.org'),
(211, 'Radivije', 'Radivije', 'Perić', '5b49866691f116709399fec3521f5166', '+381 61 345 654', NULL, 'Šabac', 'Srbija', '158889', 'M', 'Radivije@webshop-yu.org'),
(216, 'Milan', 'Milan', 'Sever', 'daae616a8c3c5e2a8f28829653efcf4b', '+381 66 653 111', NULL, 'Loznica', 'Srbija', '101801', 'M', 'Milan@webshop-yu.org'),
(219, 'Natasa', 'Nataša', 'Bertović', 'da5730a8a51a280493cefca42c3e910a', '+381 63 456 876', NULL, 'Niš', 'Srbija', '101801', 'Ž', 'Natasa@webshop-yu.org'),
(223, 'Radmila', 'Radmila', 'Petrić', '1396b4802e9fe38fafc1a8dfcc2b848e', '+381 61 864 234', NULL, 'Šabac', 'Srbija', '158889', 'Ž', 'Radmila@webshop-yu.org'),
(227, 'Vidosava', 'Vidosava', 'Kolić', 'ed2e7464d425926d344382439af1c90b', NULL, NULL, 'Loznica', 'Srbija', '101801', 'Ž', 'Vidosava@webshop-yu.org'),
(233, 'DaniloL', 'Danilo', 'Lulić', 'd4467ac25018032dfd6c33c3d680c723', NULL, NULL, 'Gornji Milanovac', 'Srbija', '101801', 'M', 'DaniloL@webshop-yu.org'),
(237, 'MarkoR', 'Marko', 'Rokić', '5761302146ec4026b79e86b2adabf182', NULL, NULL, 'Beograd', 'Srbija', '101801', 'M', 'MarkoR@webshop-yu.org'),
(239, 'RadenkoM', 'Radenko', 'Marinković', '16090a8552aa1d8bd4e63121dcb771f4', NULL, NULL, 'Niš', 'Srbija', '101801', 'M', 'RadenkoM@webshop-yu.org'),
(240, 'NikolaP2', 'Nikola', 'Petrović', '9f300df216b15b08bce9bb9b66c3beb6', NULL, NULL, 'Novi Sad', 'Srbija', '101801', 'M', 'NikolaP2@webshop-yu.org'),
(242, 'VukasinK', 'Vukašin', 'Kovač', '28e5991d1e59bcbb3c4a56385dbb1e3b', NULL, NULL, 'Šabac', 'Srbija', '158889', 'M', 'VukasinK@webshop-yu.org'),
(247, 'LukaA', 'Luka', 'Anić', 'f9f07665bab7409aefc847cdf35629cf', NULL, NULL, 'Prizren', 'Srbija', '101801', 'M', 'LukaA@webshop-yu.org'),
(249, 'Zarko', 'Žarko', 'Erić', '7146640f15d2401f2708b9a9409b29ea', NULL, NULL, 'Beograd', 'Srbija', '101801', 'M', 'Zarko@webshop-yu.org'),
(250, 'Maladen', 'Maladen', 'Petrović', '23738fa68ea71bd4046c31ead906b4b0', NULL, NULL, 'Gornji Milanovac', 'Srbija', '101801', 'M', 'Maladen@webshop-yu.org'),
(256, 'RankoDj', 'Ranko', 'Đoković', 'cab196c0afa7f8fb3efd35e80a92d84d', NULL, NULL, 'Beograd', 'Srbija', '101801', 'M', 'RankoDj@webshop-yu.org'),
(259, 'MilanT', 'Milan', 'Troicki', '9553a1972afd6234cec6d3e6f3579a77', NULL, NULL, 'Niš', 'Srbija', '101801', 'M', 'MilanT@webshop-yu.org'),
(260, 'Vladimir', 'Vladimir', 'Papić', '1a09554a01c24fd6c63e0ccaf3892dcf', NULL, NULL, 'Novi Sad', 'Srbija', '101801', 'M', 'Vladimir@webshop-yu.org'),
(273, 'MilosS', 'Miloš', 'Sušić', '5530d5d53641b3cbbeb9d0f526f05ffb', NULL, NULL, 'Šabac', 'Srbija', '158889', 'M', 'MilosS@webshop-yu.org'),
(276, 'Ratko', 'Ratko', 'Dragić', '32ed58dee763a224b56480f89b2ca8b1', NULL, NULL, 'Prizren', 'Srbija', '101801', 'M', 'Ratko@webshop-yu.org'),
(278, 'RadenkoD', 'Radenko', 'Dragić', '5c92066a238142209fd99673c18d962d', NULL, NULL, 'Beograd', 'Srbija', '101801', 'M', 'RadenkoD@webshop-yu.org'),
(282, 'Vladan', 'Vladan', 'Ivić', 'c43f7966c73b64d2ed63455bc3ec6489', NULL, NULL, 'Dimitrovgrad', 'Srbija', '101801', 'M', 'Vladan@webshop-yu.org'),
(286, 'Dusko', 'Duško', 'Mirić', '320e5bf079bd732bd7b71d5afe2bf0a1', NULL, NULL, 'Beograd', 'Srbija', '101801', 'M', 'Dusko@webshop-yu.org'),
(293, 'Miroslav', 'Miroslav', 'Barić', '826f0140bad84c1e3b6cd54e8c2b9358', NULL, NULL, 'Beograd', 'Srbija', '101801', 'M', 'Miroslav@webshop-yu.org'),
(298, 'Boris', 'Boris', 'Karadakić', 'd51791a8ae859cf3d598691ec9c84a7e', NULL, NULL, 'Gornji Milanovac', 'Srbija', '101801', 'M', 'Boris@webshop-yu.org'),
(299, 'Milinko', 'Milinko', 'Jukić', '52931ed8c45c5d8a0dafa3597bf5b86a', '+381 64 178 008', NULL, 'Beograd', 'Srbija', '101801', 'M', 'Milinko@webshop-yu.org'),
(303, 'Novak', 'Novak', 'Damjanović', 'c46c385d59d2e3d29149849e1580c964', '+381 63 092 979', NULL, 'Niš', 'Srbija', '101801', 'M', 'Novak@webshop-yu.org'),
(307, 'AleksandarP', 'Aleksandar', 'Petrić', 'f1e98f32315564f9334b0a8ae7bc2b3e', '+381 64 124 653', NULL, 'Novi Sad', 'Srbija', '101801', 'M', 'AleksandarP@webshop-yu.org'),
(311, 'Novica', 'Novica', 'Dobranić', 'fa85887ac2362ee8e2bb3e6462056259', '+381 62 431 991', NULL, 'Šabac', 'Srbija', '158889', 'M', 'Novica@webshop-yu.org'),
(314, 'Danijela', 'Danijela', 'Strefanović', '41749e505426d02af11cc5b11e44f5f3', NULL, NULL, 'Prizren', 'Srbija', '101801', 'Ž', 'Danijela@webshop-yu.org'),
(319, 'PetarR', 'Petar', 'Rončević', '010db591a964cc906241e23408e02c15', NULL, NULL, 'Beograd', 'Srbija', '101801', 'M', 'PetarR@webshop-yu.org'),
(320, 'Djordje', 'Đorđe', 'Mihić', '5e203c9b4ce2c28e691982ff0bef5fb3', NULL, NULL, 'Gornji Milanovac', 'Srbija', '101801', 'M', 'Djordje@webshop-yu.org'),
(321, 'DraganM', 'Dragan', 'Mihić', 'd42cb6752f99e84a69656f74f126ab7a', NULL, NULL, 'Beograd', 'Srbija', '101801', 'M', 'DraganM@webshop-yu.org'),
(323, 'Stefan', 'Stefan', 'Strefanović', '7da816581a2c54d43939e79e34899083', NULL, NULL, 'Nikišić', 'Crna Gora', '96487', 'M', 'Stefan@webshop-yu.org'),
(324, 'Zeljko', 'Željko', 'Kovač', '620201aeff44b1651eacf7e17b9a00f9', NULL, NULL, 'Novi Sad', 'Srbija', '101801', 'M', 'Zeljko@webshop-yu.org'),
(328, 'Rajko', 'Rajko', 'Stefanović', 'ce55e837ba3d1d3bf3b01d0ef41dc537', NULL, NULL, 'Šabac', 'Srbija', '158889', 'M', 'Rajko@webshop-yu.org'),
(333, 'Branislav', 'Branislav', 'Petrović', '61bfb4fbcf0d5d7d431f0a35ae06fb73', NULL, NULL, 'Prizren', 'Srbija', '101801', 'M', 'Branislav@webshop-yu.org'),
(334, 'Radoslav', 'Radoslav', 'Jukić', '79be39baf983fd0e4b2e7670fc5f1676', NULL, NULL, 'Beograd', 'Srbija', '101801', 'M', 'Radoslav@webshop-yu.org'),
(335, 'Vidoje', 'Vidoje', 'Mihić', '75ae1e228dc7d5fcda3dd13492dfa69a', NULL, NULL, 'Dimitrovgrad', 'Srbija', '101801', 'M', 'Vidoje@webshop-yu.org'),
(339, 'Bojana', 'Bojana', 'Petrić', '59144c7223d0406dd4c440a23f5b2d24', NULL, NULL, 'Beograd', 'Srbija', '101801', 'Ž', 'Bojana@webshop-yu.org'),
(344, 'BojanaI', 'Bojana', 'Ivanić', 'd7bff553923ec14d9bbac2aa07a991f9', NULL, NULL, 'Banja Luka', 'Bosna i Hercegovina', '79000', 'M', 'BojanaI@webshop-yu.org'),
(347, 'MarkoS', 'Marko', 'Simić', 'c68fe4c0866d144c853ffa0623754767', NULL, NULL, 'Beograd', 'Srbija', '101801', 'M', 'MarkoS@webshop-yu.org'),
(348, 'Miladin', 'Miladin', 'Perić', 'c46c778953ba14fe9e07bef869b14f18', NULL, NULL, 'Niš', 'Srbija', '101801', 'M', 'Miladin@webshop-yu.org'),
(350, 'Ognjenka', 'Ognjenka', 'Dragić', 'b69b47d1cec2ede74fe39a40d2c6f672', NULL, NULL, 'Novi Sad', 'Srbija', '101801', 'Ž', 'Ognjenka@webshop-yu.org'),
(353, 'Aleksandra', 'Aleksandra', 'Perić', '0cbfa4956e4d0c2a43caae219b5f2850', NULL, NULL, 'Šabac', 'Srbija', '158889', 'Ž', 'Aleksandra@webshop-yu.org'),
(356, 'JovanaM2', 'Jovana', 'Milanović', '3631e7eede9b9d05c26a6ff6f4d4a90a', NULL, NULL, 'Prizren', 'Srbija', '101801', 'Ž', 'JovanaM2@webshop-yu.org'),
(357, 'Tijana', 'Tijana', 'Opačić', '1941bec7a79607177fd49cea42fecea6', NULL, NULL, 'Beograd', 'Srbija', '101801', 'Ž', 'Tijana@webshop-yu.org'),
(361, 'Dijana', 'Dijana', 'Ivić', '7f21b530178e0f148c414c36fef8aa0a', NULL, NULL, 'Gornji Milanovac', 'Srbija', '101801', 'Ž', 'Dijana@webshop-yu.org'),
(362, 'Teodora', 'Teodora', 'Opačić', '1b594ed3d2a9d268c20c86878fbb08fc', NULL, NULL, 'Trebinje', 'Bosna i Hercegovina', '79840', 'Ž', 'Teodora@webshop-yu.org'),
(363, 'Sanja', 'Sanja', 'Petrović', '5e6842ec7ad10af99c5362694ac88678', NULL, NULL, 'Niš', 'Srbija', '101801', 'Ž', 'Sanja@webshop-yu.org'),
(369, 'Tanja', 'Tanja', 'Milanović', '8d29a7b1a324155019a886f738c95951', NULL, NULL, 'Novi Sad', 'Srbija', '101801', 'Ž', 'Tanja@webshop-yu.org'),
(376, 'MarkoA', 'Marko', 'Anić', '16ebfcf243b0d03e09d6165045d39307', NULL, NULL, 'Šabac', 'Srbija', '158889', 'M', 'MarkoA@webshop-yu.org'),
(379, 'DanijelK', 'Danijel', 'Kostić', 'ae74e5df1e363377f57355e264cf49f9', NULL, NULL, 'Prizren', 'Srbija', '101801', 'M', 'DanijelK@webshop-yu.org'),
(381, 'Marina', 'Marina', 'Kostić', '6baa03186995fea68d5f33c80124b226', '+381 62 653 871', NULL, 'Beograd', 'Srbija', '101801', 'Ž', 'Marina@webshop-yu.org'),
(382, 'BojanaO', 'Bojana', 'Opačić', '5ede9d8223d9945f475072eabab3fb6f', '+381 64 123 982', NULL, 'Dimitrovgrad', 'Srbija', '101801', 'Ž', 'BojanaO@webshop-yu.org'),
(385, 'Milka', 'Milka', 'Okanović', '24cd271bde5a9f5c85372a1d3ffd79d0', '+381 64 124 005', NULL, 'Beograd', 'Srbija', '101801', 'Ž', 'Milka@webshop-yu.org'),
(386, 'Dunja', 'Dunja', 'Ivić', 'f9b837e64b334bd93f494d0b67b55fcc', '+381 64 124 211', NULL, 'Beograd', 'Srbija', '101801', 'Ž', 'Dunja@webshop-yu.org'),
(398, 'Predrag', 'Predrag', 'Okanović', '622dbdd86b0efb6d19b9c0c713d1b16b', '+381 64 124 909', NULL, 'Prizren', 'Srbija', '101801', 'M', 'Predrag@webshop-yu.org'),
(406, 'Milovan', 'Milovan', 'Dragić', '9ec4e336fe65ecafaed8bbdb3c21180f', '+381 61 543 542', NULL, 'Beograd', 'Srbija', '101801', 'M', 'Milovan@webshop-yu.org'),
(409, 'PetarP', 'Petar', 'Perić', 'efd88550f64614b0c7fc55647a237421', '+381 64 107 542', NULL, 'Beograd', 'Srbija', '101801', 'M', 'PetarP@webshop-yu.org'),
(412, 'Mladen', 'Mladen', 'Ivanić', '654d89194c0febc394be34a3e115ffd7', '+381 64 124 542', NULL, 'Beograd', 'Srbija', '101801', 'M', 'Mladen@webshop-yu.org'),
(415, 'JovanaP', 'Jovana', 'Perić', '0f339eed49d93e4f9dacd91e31cd1659', '+381 64 143 542', NULL, 'Novi Sad', 'Srbija', '101801', 'Ž', 'JovanaP@webshop-yu.org'),
(424, 'Jovan', 'Jovan', 'Bašić', '059ba7cfae3c5e5caadeb469608378b8', '+381 63 124 542', NULL, 'Šabac', 'Srbija', '158889', 'M', 'Jovan@webshop-yu.org');

-- --------------------------------------------------------

--
-- Table structure for table `narudzba`
--

DROP TABLE IF EXISTS `narudzba`;
CREATE TABLE IF NOT EXISTS `narudzba` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kupac_id` int(11) NOT NULL,
  `trgovac_id` int(11) NOT NULL,
  `datum_narudzbe` date NOT NULL,
  `datum_isporuke` date DEFAULT NULL,
  `napomena` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10143 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `narudzba`
--

INSERT INTO `narudzba` (`id`, `kupac_id`, `trgovac_id`, `datum_narudzbe`, `datum_isporuke`, `napomena`) VALUES
(10100, 328, 2, '2003-01-06', '2003-01-13', NULL),
(10102, 298, 4, '2003-01-10', '2003-01-18', NULL),
(10103, 386, 1, '2003-01-29', '2003-02-07', NULL),
(10104, 256, 3, '2003-01-31', '2003-02-09', NULL),
(10105, 333, 2, '2003-02-11', '2003-02-21', NULL),
(10106, 323, 5, '2003-02-17', '2003-02-24', NULL),
(10108, 201, 6, '2003-03-03', '2003-03-12', NULL),
(10110, 103, 8, '2003-03-18', '2003-03-24', NULL),
(10111, 187, 8, '2003-03-25', '2003-03-31', NULL),
(10116, 103, 1, '2003-04-11', '2003-04-19', NULL),
(10117, 201, 7, '2003-04-16', '2003-04-24', NULL),
(10119, 227, 5, '2003-04-28', NULL, NULL),
(10120, 175, 4, '2003-04-29', NULL, NULL),
(10121, 386, 8, '2003-05-07', NULL, NULL),
(10122, 386, 4, '2003-05-08', '2003-05-16', NULL),
(10123, 187, 1, '2003-05-20', '2003-05-29', NULL),
(10125, 273, 2, '2003-05-21', '2003-05-27', NULL),
(10131, 282, 4, '2005-06-16', NULL, 'Tehnički problemi'),
(10132, 323, 2, '2003-06-25', NULL, 'Tehnički problemi'),
(10133, 202, 4, '2003-06-27', '2003-07-04', NULL),
(10134, 187, 5, '2003-07-01', '2003-07-10', NULL),
(10135, 119, 6, '2003-07-02', '2003-07-12', NULL),
(10142, 406, 1, '2004-08-08', NULL, 'Vraćena roba');

-- --------------------------------------------------------

--
-- Table structure for table `prodajno_mjesto`
--

DROP TABLE IF EXISTS `prodajno_mjesto`;
CREATE TABLE IF NOT EXISTS `prodajno_mjesto` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `grad` varchar(50) NOT NULL,
  `drzava` varchar(50) NOT NULL,
  `adresa` varchar(50) DEFAULT NULL,
  `telefon` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `prodajno_mjesto`
--

INSERT INTO `prodajno_mjesto` (`id`, `grad`, `drzava`, `adresa`, `telefon`) VALUES
(1, 'Beograd', 'Srbija', 'Bulevar oslobodjenja', '+381 44 986 112'),
(2, 'Beograd', 'Srbija', 'Bulevar Cara Dušana', '+381 42 221 345'),
(3, 'Novi Sad', 'Srbija', 'Bulevar oslobodjenja', '+381 36 002 346'),
(4, 'Banja Luka', 'Bosna i Hercegovina', 'Mladena Stojanovica', '+387 51 782 451'),
(5, 'Podgorica', 'Grna Gora', 'Ulica kralja Nikole', '+382 67 002 357');

-- --------------------------------------------------------

--
-- Table structure for table `proizvod`
--

DROP TABLE IF EXISTS `proizvod`;
CREATE TABLE IF NOT EXISTS `proizvod` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) NOT NULL,
  `opis` text DEFAULT NULL,
  `cijena` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `proizvod`
--

INSERT INTO `proizvod` (`id`, `naziv`, `opis`, `cijena`) VALUES
(1, 'Trenerka - komplet', NULL, '159.60'),
(2, 'Trenerka - gornji dio', NULL, '97.50'),
(3, 'Trenerka - donji dio', NULL, '65.00'),
(4, 'Jakna za planinarenje', NULL, '156.00'),
(5, 'Cipele za planinarenje', NULL, '352.50'),
(6, 'Štapovi za planinarenje', NULL, '62.20'),
(7, 'Ranac za planinarenje', NULL, '76.00'),
(8, 'Sportske parike', NULL, '202.30'),
(9, 'Majica za trčanje', NULL, '35.80'),
(10, 'Skije', NULL, '65.65'),
(11, 'Sanke', NULL, '35.50'),
(12, 'Jakna za skijanje', NULL, '136.00'),
(13, 'Šator', NULL, '226.90'),
(14, 'Vreća za spavanje', NULL, '85.70');

-- --------------------------------------------------------

--
-- Table structure for table `trgovac`
--

DROP TABLE IF EXISTS `trgovac`;
CREATE TABLE IF NOT EXISTS `trgovac` (
  `id` int(11) NOT NULL,
  `korisnicko_ime` varchar(50) NOT NULL,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `lozinka` varchar(50) NOT NULL,
  `pol` varchar(50) DEFAULT NULL,
  `telefon` varchar(50) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `prodajno_mjesto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trgovac`
--

INSERT INTO `trgovac` (`id`, `korisnicko_ime`, `ime`, `prezime`, `lozinka`, `pol`, `telefon`, `email`, `prodajno_mjesto_id`) VALUES
(1, 'Aleksa', 'Aleksa', 'Matić', '2006b4f9e028c898729d4140805ef2d3', 'M', '', 'Aleksa.Maric@webshop-yu.org', 1),
(2, 'Tatjana', 'Tatjana', 'Mirić', '783c296ae96ea34a72810415ce07c84f', 'Ž', '+381 68 011 220', 'Tatjana.Miric@webshop-yu.org', 2),
(3, 'Marko', 'Marko', 'Aleksić', '2e6c740729c44c12663c973965cbf698', 'M', '', 'Marko.Aleksic@webshop-yu.org', 1),
(4, 'Nikola', 'Nikola', 'Aleksić', 'e8f8b0cf7e6f4267e0bce864db0ac20c', 'M', '+382 69 785 120', 'Nikola.Aleksic@webshop-yu.org', 5),
(5, 'Marina', 'Marina', 'Tašić', '6baa03186995fea68d5f33c80124b226', 'Ž', '', 'Marina.Tasic@webshop-yu.org', 4),
(6, 'Luka', 'Luka', 'Nikolić', '41cd8012060774402caef35e261bc90c', 'M', '+381 69 736 003', 'Luka.Nikolic@webshop-yu.org', 3),
(7, 'Veselin', 'Veselin', 'Jovanović', '3693b69bff271cdbaf0ddf224e20e014', 'M', '', 'Veselin.Jovanovic@webshop-yu.org', 2),
(8, 'MarinaM', 'Marina', 'Milaković', '3d1b7120a8074cf880dd1797b1fae3b9', 'Ž', '', 'Marina.Milakovic@webshop-yu.org', 4);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
