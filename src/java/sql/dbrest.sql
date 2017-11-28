-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-11-2017 a las 00:42:12
-- Versión del servidor: 5.5.34
-- Versión de PHP: 5.4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `dbrest`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

CREATE TABLE IF NOT EXISTS `equipos` (
  `equipo_id` int(11) NOT NULL AUTO_INCREMENT,
  `equipo_cliente` int(11) NOT NULL,
  `equipo_modelo` varchar(50) NOT NULL,
  `equipo_serie` varchar(50) NOT NULL,
  `equipo_diag` varchar(250) NOT NULL,
  `equipo_fechain` varchar(30) NOT NULL,
  `equipo_presup` varchar(50) NOT NULL,
  `equipo_fechaout` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`equipo_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`equipo_id`, `equipo_cliente`, `equipo_modelo`, `equipo_serie`, `equipo_diag`, `equipo_fechain`, `equipo_presup`, `equipo_fechaout`) VALUES
(1, 0, 'pepito', '123', '0', 'undefined', '', '2017-11-21'),
(2, 77, '77', '77', '77', '2017-11-17', '', NULL),
(3, 1, '123', '123', '123', '2017-11-10', '123', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE IF NOT EXISTS `personas` (
  `per_id` int(11) NOT NULL AUTO_INCREMENT,
  `per_nombre` varchar(250) NOT NULL,
  `per_apellido` varchar(250) NOT NULL,
  `per_dni` varchar(50) NOT NULL,
  `per_telefono` varchar(200) NOT NULL,
  `per_email` varchar(250) NOT NULL,
  `per_direccion` varchar(250) NOT NULL,
  PRIMARY KEY (`per_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`per_id`, `per_nombre`, `per_apellido`, `per_dni`, `per_telefono`, `per_email`, `per_direccion`) VALUES
(1, 'julieta', '', '', '', 'juli@gmail', ''),
(3, 'dieguito', '123123', '', '', 'dieguito@gmail', ''),
(16, 'gh', 'fghfg', 'fghfgh', 'fghfgh', 'fghf@', 'sdfadsa'),
(18, 'asdasda', 'asdasd', '234234', '234234', 'asdas@34234.com', 'sadasd 12312');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE IF NOT EXISTS `tipo_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id`, `tipo`) VALUES
(1, 'Admin'),
(2, 'User');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `usr_id` int(11) NOT NULL AUTO_INCREMENT,
  `usr_nombre` varchar(50) NOT NULL,
  `usr_apellido` varchar(50) NOT NULL,
  `usr_alias` varchar(50) NOT NULL,
  `usr_password` varchar(150) NOT NULL,
  `usr_tipo` int(11) NOT NULL,
  PRIMARY KEY (`usr_id`),
  KEY `tipo_usuario_usuarios_relacion_fk` (`usr_tipo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`usr_id`, `usr_nombre`, `usr_apellido`, `usr_alias`, `usr_password`, `usr_tipo`) VALUES
(1, 'pepe', 'perez', 'pepe', 'perez', 1),
(2, 'pepe', 'perez', 'pepe', 'perez', 2);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `tipo_usuario_usuarios_relacion_fk` FOREIGN KEY (`usr_tipo`) REFERENCES `tipo_usuario` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
