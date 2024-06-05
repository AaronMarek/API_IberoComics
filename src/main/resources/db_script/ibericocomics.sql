-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-05-2024 a las 22:48:25
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ibericocomics`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `chapters`
--

CREATE TABLE `chapters` (
                            `id` int(11) NOT NULL,
                            `title` varchar(100) NOT NULL,
                            `comic_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comics`
--

CREATE TABLE `comics` (
                          `id` int(11) NOT NULL,
                          `title` varchar(100) NOT NULL,
                          `description` text DEFAULT NULL,
                          `cover_image` varchar(255) DEFAULT NULL,
                          `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pages`
--

CREATE TABLE `pages` (
                         `id` int(11) NOT NULL,
                         `image_url` varchar(255) NOT NULL,
                         `chapter_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
                         `id` bigint(20) NOT NULL,
                         `username` varchar(50) NOT NULL,
                         `password` varchar(100) NOT NULL,
                         `full_name` varchar(100) NOT NULL,
                         `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `full_name`, `email`) VALUES
                                                                             (1, 'user1', 'password1', 'fullName1', 'email@email.com'),
                                                                             (2, 'user2', 'password2', 'fullName2', 'email@email.com'),
                                                                             (3, 'user3', 'password3', 'fullName3', 'email@email.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `chapters`
--
ALTER TABLE `chapters`
    ADD PRIMARY KEY (`id`),
    ADD KEY `comic_id` (`comic_id`);

--
-- Indices de la tabla `comics`
--
ALTER TABLE `comics`
    ADD PRIMARY KEY (`id`),
    ADD KEY `user_id` (`user_id`);

--
-- Indices de la tabla `pages`
--
ALTER TABLE `pages`
    ADD PRIMARY KEY (`id`),
    ADD KEY `chapter_id` (`chapter_id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `chapters`
--
ALTER TABLE `chapters`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `comics`
--
ALTER TABLE `comics`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pages`
--
ALTER TABLE `pages`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `chapters`
--
ALTER TABLE `chapters`
    ADD CONSTRAINT `chapters_ibfk_1` FOREIGN KEY (`comic_id`) REFERENCES `comics` (`id`);

--
-- Filtros para la tabla `comics`
--
ALTER TABLE `comics`
    ADD CONSTRAINT `FKpi6btot4v72gey774y1b1wvmf` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Filtros para la tabla `pages`
--
ALTER TABLE `pages`
    ADD CONSTRAINT `pages_ibfk_1` FOREIGN KEY (`chapter_id`) REFERENCES `chapters` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;