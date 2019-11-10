-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-11-2019 a las 18:37:55
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.9


SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema no_mas_accidentes
-- -----------------------------------------------------
-- utf8-unicode
-- 
DROP SCHEMA IF EXISTS `no_mas_accidentes` ;

-- -----------------------------------------------------
-- Schema no_mas_accidentes
--
-- utf8-unicode
-- 
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `no_mas_accidentes` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `no_mas_accidentes` ;



SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `no_mas_accidentes`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllAsesoriasAsignadas` (IN `idUsu` INT)  BEGIN
SELECT 
    usuario.id_usuario
    ,CONCAT(usuario.nombre, " ", usuario.apellidos) AS nombre_apellido
    ,actividad.id_actividad
    ,actividad.fecha_act
    ,actividad.hora_act
    ,asesoria.id_asesoria
    ,asesoria.comentarios_detectados
    ,asesoria.comentarios_propuesta
    ,sucursal.nombre as nombre_sucursal
    ,tipo_asesoria.descripcion as tipo_asesoria
FROM USUARIO
    JOIN ACTIVIDAD on actividad.id_usuario_fk = usuario.id_usuario
    JOIN asesoria ON asesoria.id_actividad_fk_as = actividad.id_actividad
    JOIN sucursal ON sucursal.id_sucursal = actividad.id_sucursal_empresa_fk
    JOIN tipo_asesoria ON tipo_asesoria.id_tipo_asesoria = asesoria.id_tipo_asesoria_fk
WHERE id_rol_fk = 2 and actividad.estado_act=0 and id_usuario= idUsu 
ORDER BY 4 ASC;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllAsesoriasFinalizadas` (IN `idEmp` INT)  BEGIN
SELECT 
    usuario.id_usuario
    ,CONCAT(usuario.nombre, " ", usuario.apellidos) AS nombre_apellido
    ,actividad.id_actividad
    ,actividad.fecha_act
    ,actividad.hora_act
    ,asesoria.id_asesoria
    ,asesoria.comentarios_detectados
    ,asesoria.comentarios_propuesta
    ,sucursal.nombre as nombre_sucursal
    ,tipo_asesoria.descripcion as tipo_asesoria
FROM USUARIO
    JOIN ACTIVIDAD on actividad.id_usuario_fk = usuario.id_usuario
    JOIN asesoria ON asesoria.id_actividad_fk_as = actividad.id_actividad
    JOIN sucursal ON sucursal.id_sucursal = actividad.id_sucursal_empresa_fk
    JOIN tipo_asesoria ON tipo_asesoria.id_tipo_asesoria = asesoria.id_tipo_asesoria_fk
WHERE actividad.id_tipo_actividad_fk = 3 and actividad.estado_act=1 and sucursal.id_empresa_fk = idEmp
ORDER BY 4;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllCapacitacion` (IN `idUsuario` INT)  BEGIN
SELECT
    actividad.id_actividad
    ,capacitacion.id_capacitacion
    ,usuario.id_usuario
    ,CONCAT(usuario.nombre, " ", usuario.apellidos) AS nombre_apellido
    ,actividad.fecha_act 
    ,actividad.hora_act
    ,capacitacion.numero_asistente
    ,sucursal.nombre as nombre_sucursal
    ,tipo_capacitacion.descripcion
FROM USUARIO
    JOIN ACTIVIDAD on actividad.id_usuario_fk = usuario.id_usuario
    JOIN capacitacion ON capacitacion.id_actividad_fk_c = actividad.id_actividad
    JOIN sucursal ON sucursal.id_sucursal = actividad.id_sucursal_empresa_fk
    JOIN tipo_capacitacion ON tipo_capacitacion.id_tipo_capacitacion = capacitacion.id_tipo_capacitacion_fk
WHERE usuario.id_rol_fk = 2 and actividad.estado_act=0 and usuario.id_usuario= idUsuario
ORDER BY 5 ASC;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllReporteAccidente` (IN `idEmpresa` INT)  BEGIN
SELECT 
    reporte_accidente.id_reporte_accidente
    ,sucursal.id_sucursal
    ,empresa.id_empresa
    ,reporte_accidente.fecha as fecha_accidente
    ,reporte_accidente.hora as hora_accidente
    ,reporte_accidente.comentario
    ,tipo_accidente.descripcion
    ,sucursal.nombre as nombre_sucursal
FROM reporte_accidente
    JOIN tipo_accidente ON reporte_accidente.id_tipo_accidente_fk = tipo_accidente.id_tipo_accidente
    JOIN sucursal ON reporte_accidente.id_sucursal_fk = sucursal.id_sucursal
    JOIN empresa ON empresa.id_empresa = sucursal.id_empresa_fk
WHERE empresa.id_empresa =idEmpresa
ORDER BY 4 DESC;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividad`
--

CREATE TABLE `actividad` (
  `id_actividad` int(11) NOT NULL,
  `fecha_act` date DEFAULT NULL,
  `hora_act` time DEFAULT NULL,
  `estado_act` tinyint(4) NOT NULL,
  `id_usuario_fk` int(11) DEFAULT NULL,
  `id_sucursal_empresa_fk` int(11) NOT NULL,
  `id_tipo_actividad_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `actividad`
--

INSERT INTO `actividad` (`id_actividad`, `fecha_act`, `hora_act`, `estado_act`, `id_usuario_fk`, `id_sucursal_empresa_fk`, `id_tipo_actividad_fk`) VALUES
(1, '2019-11-12', '14:00:00', 1, 3, 1, 3),
(2, NULL, NULL, 0, NULL, 4, 3),
(3, '2019-11-13', '14:00:00', 0, 3, 1, 3),
(4, '2019-11-20', '11:00:00', 1, 5, 2, 3),
(5, NULL, NULL, 0, NULL, 2, 3),
(6, '2019-11-14', '15:00:00', 1, 5, 3, 3),
(7, '2019-11-20', '12:00:00', 0, 5, 3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asesoria`
--

CREATE TABLE `asesoria` (
  `id_asesoria` int(11) NOT NULL,
  `comentarios_detectados` varchar(500) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentarios_propuesta` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_tipo_estado_fk` int(11) NOT NULL,
  `id_tipo_asesoria_fk` int(11) NOT NULL,
  `id_actividad_fk_as` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `asesoria`
--

INSERT INTO `asesoria` (`id_asesoria`, `comentarios_detectados`, `comentarios_propuesta`, `id_tipo_estado_fk`, `id_tipo_asesoria_fk`, `id_actividad_fk_as`) VALUES
(1, 'Neque molestiae, amet itaque placeat earum rem alias culpa, mollitia quo perferendis voluptatem est praesentium ipsa voluptatum dicta totam voluptas odit, quam tempora iusto quibusdam saepe architecto ipsum assumenda accusamus. Dicta nulla at quo consequatur vero eum, placeat, deleniti voluptate nam voluptatum excepturi. Eum magni velit soluta dolorem vero, quaerat aperiam quasi temporibus. Praesentium libero, voluptates velit enim quasi distinctio! Iusto itaque quo aliquam asperiores,', 'Neque molestiae, amet itaque placeat earum rem alias culpa, mollitia quo perferendis voluptatem est praesentium ipsa voluptatum dicta totam voluptas odit, quam tempora iusto quibusdam saepe architecto ipsum assumenda accusamus. Dicta nulla at quo consequatur vero eum, placeat, deleniti voluptate nam voluptatum excepturi. Eum magni velit soluta dolorem vero, quaerat aperiam quasi temporibus. Praesentium libero, voluptates velit enim quasi distinctio! Iusto itaque quo aliquam asperiores,', 3, 1, 1),
(2, NULL, NULL, 1, 8, 2),
(3, NULL, NULL, 2, 3, 3),
(4, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Expedita, sint nam debitis nihil provident aperiam, nisi iste aliquid aut quos doloribus voluptatum asperiores, delectus sunt quia, laboriosam voluptates excepturi suscipit sit est beatae officia enim! Voluptatem reiciendis iusto, recusandae optio explicabo quidem quibusdam eos debitis distinctio, deserunt maxime ipsam, dolores maiores ut repellendus minima ipsa nostrum accusantium eligendi porro, quaerat voluptatibus temporibus', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Expedita, sint nam debitis nihil provident aperiam, nisi iste aliquid aut quos doloribus voluptatum asperiores, delectus sunt quia, laboriosam voluptates excepturi suscipit sit est beatae officia enim! Voluptatem reiciendis iusto, recusandae optio explicabo quidem quibusdam eos debitis distinctio, deserunt maxime ipsam, dolores maiores ut repellendus minima ipsa nostrum accusantium eligendi porro, quaerat voluptatibus temporibus', 3, 8, 4),
(5, NULL, NULL, 1, 4, 5),
(6, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Neque molestiae, amet itaque placeat earum rem alias culpa, mollitia quo perferendis voluptatem est praesentium ipsa voluptatum dicta totam voluptas odit, quam tempora iusto quibusdam saepe architecto ipsum assumenda accusamus. Dicta nulla at quo consequatur vero eum, placeat, deleniti voluptate nam voluptatum excepturi. Eum magni velit soluta dolorem vero, quaerat aperiam quasi temporibus. Praesentium libero, voluptates velit e', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Neque molestiae, amet itaque placeat earum rem alias culpa, mollitia quo perferendis voluptatem est praesentium ipsa voluptatum dicta totam voluptas odit, quam tempora iusto quibusdam saepe architecto ipsum assumenda accusamus. Dicta nulla at quo consequatur vero eum, placeat, deleniti voluptate nam voluptatum excepturi. Eum magni velit soluta dolorem vero, quaerat aperiam quasi temporibus. Praesentium libero, voluptates velit e', 3, 7, 6),
(7, NULL, NULL, 2, 8, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `capacitacion`
--

CREATE TABLE `capacitacion` (
  `id_capacitacion` int(11) NOT NULL,
  `numero_asistente` int(11) DEFAULT NULL,
  `id_tipo_capacitacion_fk` int(11) NOT NULL,
  `id_actividad_fk_c` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comuna`
--

CREATE TABLE `comuna` (
  `id_comuna` int(11) NOT NULL,
  `nombre_comuna` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `id_region_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `comuna`
--

INSERT INTO `comuna` (`id_comuna`, `nombre_comuna`, `id_region_fk`) VALUES
(1, 'ARICA', 1),
(2, 'CAMARONES', 1),
(3, 'PUTRE', 1),
(4, 'GENERAL LAGOS', 1),
(5, 'IQUIQUE', 2),
(6, 'CAMIÑA', 2),
(7, 'COLCHANE', 2),
(8, 'HUARA', 2),
(9, 'PICA', 2),
(10, 'POZO ALMONTE', 2),
(11, 'ALTO HOSPICIO', 2),
(12, 'ANTOFAGASTA', 3),
(13, 'MEJILLONES', 3),
(14, 'SIERRA GORDA', 3),
(15, 'TALTAL', 3),
(16, 'CALAMA', 3),
(17, 'OLLAGÜE', 3),
(18, 'SAN PEDRO DE ATACAMA', 3),
(19, 'TOCOPILLA', 3),
(20, 'MARÍA ELENA', 3),
(21, 'COPIAPÓ', 4),
(22, 'CALDERA', 4),
(23, 'TIERRA AMARILLA', 4),
(24, 'CHAÑARAL', 4),
(25, 'DIEGO DE ALMAGRO', 4),
(26, 'VALLENAR', 4),
(27, 'ALTO DEL CARMEN', 4),
(28, 'FREIRINA', 4),
(29, 'HUASCO', 4),
(30, 'LA SERENA', 5),
(31, 'COQUIMBO', 5),
(32, 'ANDACOLLO', 5),
(33, 'LA HIGUERA', 5),
(34, 'PAIGUANO', 5),
(35, 'VICUÑA', 5),
(36, 'ILLAPEL', 5),
(37, 'CANELA', 5),
(38, 'LOS VILOS', 5),
(39, 'SALAMANCA', 5),
(40, 'OVALLE', 5),
(41, 'COMBARBALÁ', 5),
(42, 'MONTE PATRIA', 5),
(43, 'PUNITAQUI', 5),
(44, 'RÍO HURTADO', 5),
(45, 'VALPARAÍSO', 6),
(46, 'CASABLANCA', 6),
(47, 'CONCÓN', 6),
(48, 'JUAN FERNÁNDEZ', 6),
(49, 'PUCHUNCAVÍ', 6),
(50, 'QUILPUÉ', 6),
(51, 'QUINTERO', 6),
(52, 'VILLA ALEMANA', 6),
(53, 'VIÑA DEL MAR', 6),
(54, 'ISLA  DE PASCUA', 6),
(55, 'LOS ANDES', 6),
(56, 'CALLE LARGA', 6),
(57, 'RINCONADA', 6),
(58, 'SAN ESTEBAN', 6),
(59, 'LA LIGUA', 6),
(60, 'CABILDO', 6),
(61, 'PAPUDO', 6),
(62, 'PETORCA', 6),
(63, 'ZAPALLAR', 6),
(64, 'QUILLOTA', 6),
(65, 'CALERA', 6),
(66, 'HIJUELAS', 6),
(67, 'LA CRUZ', 6),
(68, 'LIMACHE', 6),
(69, 'NOGALES', 6),
(70, 'OLMUÉ', 6),
(71, 'SAN ANTONIO', 6),
(72, 'ALGARROBO', 6),
(73, 'CARTAGENA', 6),
(74, 'EL QUISCO', 6),
(75, 'EL TABO', 6),
(76, 'SANTO DOMINGO', 6),
(77, 'SAN FELIPE', 6),
(78, 'CATEMU', 6),
(79, 'LLAILLAY', 6),
(80, 'PANQUEHUE', 6),
(81, 'PUTAENDO', 6),
(82, 'SANTA MARÍA', 6),
(83, 'RANCAGUA', 7),
(84, 'CODEGUA', 7),
(85, 'COINCO', 7),
(86, 'COLTAUCO', 7),
(87, 'DOÑIHUE', 7),
(88, 'GRANEROS', 7),
(89, 'LAS CABRAS', 7),
(90, 'MACHALÍ', 7),
(91, 'MALLOA', 7),
(92, 'MOSTAZAL', 7),
(93, 'OLIVAR', 7),
(94, 'PEUMO', 7),
(95, 'PICHIDEGUA', 7),
(96, 'QUINTA DE TILCOCO', 7),
(97, 'RENGO', 7),
(98, 'REQUÍNOA', 7),
(99, 'SAN VICENTE', 7),
(100, 'PICHILEMU', 7),
(101, 'LA ESTRELLA', 7),
(102, 'LITUECHE', 7),
(103, 'MARCHIHUE', 7),
(104, 'NAVIDAD', 7),
(105, 'PAREDONES', 7),
(106, 'SAN FERNANDO', 7),
(107, 'CHÉPICA', 7),
(108, 'CHIMBARONGO', 7),
(109, 'LOLOL', 7),
(110, 'NANCAGUA', 7),
(111, 'PALMILLA', 7),
(112, 'PERALILLO', 7),
(113, 'PLACILLA', 7),
(114, 'PUMANQUE', 7),
(115, 'SANTA CRUZ', 7),
(116, 'TALCA', 8),
(117, 'CONSTITUCIÓN', 8),
(118, 'CUREPTO', 8),
(119, 'EMPEDRADO', 8),
(120, 'MAULE', 8),
(121, 'PELARCO', 8),
(122, 'PENCAHUE', 8),
(123, 'RÍO CLARO', 8),
(124, 'SAN CLEMENTE', 8),
(125, 'SAN RAFAEL', 8),
(126, 'CAUQUENES', 8),
(127, 'CHANCO', 8),
(128, 'PELLUHUE', 8),
(129, 'CURICÓ', 8),
(130, 'HUALAÑÉ', 8),
(131, 'LICANTÉN', 8),
(132, 'MOLINA', 8),
(133, 'RAUCO', 8),
(134, 'ROMERAL', 8),
(135, 'SAGRADA FAMILIA', 8),
(136, 'TENO', 8),
(137, 'VICHUQUÉN', 8),
(138, 'LINARES', 8),
(139, 'COLBÚN', 8),
(140, 'LONGAVÍ', 8),
(141, 'PARRAL', 8),
(142, 'RETIRO', 8),
(143, 'SAN JAVIER', 8),
(144, 'VILLA ALEGRE', 8),
(145, 'YERBAS BUENAS', 8),
(146, 'CONCEPCIÓN', 9),
(147, 'CORONEL', 9),
(148, 'CHIGUAYANTE', 9),
(149, 'FLORIDA', 9),
(150, 'HUALQUI', 9),
(151, 'LOTA', 9),
(152, 'PENCO', 9),
(153, 'SAN PEDRO DE LA PAZ', 9),
(154, 'SANTA JUANA', 9),
(155, 'TALCAHUANO', 9),
(156, 'TOMÉ', 9),
(157, 'HUALPÉN', 9),
(158, 'LEBU', 9),
(159, 'ARAUCO', 9),
(160, 'CAÑETE', 9),
(161, 'CONTULMO', 9),
(162, 'CURANILAHUE', 9),
(163, 'LOS ÁLAMOS', 9),
(164, 'TIRÚA', 9),
(165, 'LOS ÁNGELES', 9),
(166, 'ANTUCO', 9),
(167, 'CABRERO', 9),
(168, 'LAJA', 9),
(169, 'MULCHÉN', 9),
(170, 'NACIMIENTO', 9),
(171, 'NEGRETE', 9),
(172, 'QUILACO', 9),
(173, 'QUILLECO', 9),
(174, 'SAN ROSENDO', 9),
(175, 'SANTA BÁRBARA', 9),
(176, 'TUCAPEL', 9),
(177, 'YUMBEL', 9),
(178, 'ALTO BIOBÍO', 9),
(179, 'CHILLÁN', 9),
(180, 'BULNES', 9),
(181, 'COBQUECURA', 9),
(182, 'COELEMU', 9),
(183, 'COIHUECO', 9),
(184, 'CHILLÁN VIEJO', 9),
(185, 'EL CARMEN', 9),
(186, 'NINHUE', 9),
(187, 'ÑIQUÉN', 9),
(188, 'PEMUCO', 9),
(189, 'PINTO', 9),
(190, 'PORTEZUELO', 9),
(191, 'QUILLÓN', 9),
(192, 'QUIRIHUE', 9),
(193, 'RÁNQUIL', 9),
(194, 'SAN CARLOS', 9),
(195, 'SAN FABIÁN', 9),
(196, 'SAN IGNACIO', 9),
(197, 'SAN NICOLÁS', 9),
(198, 'TREGUACO', 9),
(199, 'YUNGAY', 9),
(200, 'TEMUCO', 10),
(201, 'CARAHUE', 10),
(202, 'CUNCO', 10),
(203, 'CURARREHUE', 10),
(204, 'FREIRE', 10),
(205, 'GALVARINO', 10),
(206, 'GORBEA', 10),
(207, 'LAUTARO', 10),
(208, 'LONCOCHE', 10),
(209, 'MELIPEUCO', 10),
(210, 'NUEVA IMPERIAL', 10),
(211, 'PADRE LAS CASAS', 10),
(212, 'PERQUENCO', 10),
(213, 'PITRUFQUÉN', 10),
(214, 'PUCÓN', 10),
(215, 'SAAVEDRA', 10),
(216, 'TEODORO SCHMIDT', 10),
(217, 'TOLTÉN', 10),
(218, 'VILCÚN', 10),
(219, 'VILLARRICA', 10),
(220, 'CHOLCHOL', 10),
(221, 'ANGOL', 10),
(222, 'COLLIPULLI', 10),
(223, 'CURACAUTÍN', 10),
(224, 'ERCILLA', 10),
(225, 'LONQUIMAY', 10),
(226, 'LOS SAUCES', 10),
(227, 'LUMACO', 10),
(228, 'PURÉN', 10),
(229, 'RENAICO', 10),
(230, 'TRAIGUÉN', 10),
(231, 'VICTORIA', 10),
(232, 'VALDIVIA', 11),
(233, 'CORRAL', 11),
(234, 'FUTRONO', 11),
(235, 'LA UNIÓN', 11),
(236, 'LAGO RANCO', 11),
(237, 'LANCO', 11),
(238, 'LOS LAGOS', 11),
(239, 'MÁFIL', 11),
(240, 'MARIQUINA', 11),
(241, 'PAILLACO', 11),
(242, 'PANGUIPULLI', 11),
(243, 'RÍO BUENO', 11),
(244, 'PUERTO MONTT', 12),
(245, 'CALBUCO', 12),
(246, 'COCHAMÓ', 12),
(247, 'FRESIA', 12),
(248, 'FRUTILLAR', 12),
(249, 'LOS MUERMOS', 12),
(250, 'LLANQUIHUE', 12),
(251, 'MAULLÍN', 12),
(252, 'PUERTO VARAS', 12),
(253, 'CASTRO', 12),
(254, 'ANCUD', 12),
(255, 'CHONCHI', 12),
(256, 'CURACO DE VÉLEZ', 12),
(257, 'DALCAHUE', 12),
(258, 'PUQUELDÓN', 12),
(259, 'QUEILÉN', 12),
(260, 'QUELLÓN', 12),
(261, 'QUEMCHI', 12),
(262, 'QUINCHAO', 12),
(263, 'OSORNO', 12),
(264, 'PUERTO OCTAY', 12),
(265, 'PURRANQUE', 12),
(266, 'PUYEHUE', 12),
(267, 'RÍO NEGRO', 12),
(268, 'SAN JUAN DE LA COSTA', 12),
(269, 'SAN PABLO', 12),
(270, 'CHAITÉN', 12),
(271, 'FUTALEUFÚ', 12),
(272, 'HUALAIHUÉ', 12),
(273, 'PALENA', 12),
(274, 'COIHAIQUE', 13),
(275, 'LAGO VERDE', 13),
(276, 'AISÉN', 13),
(277, 'CISNES', 13),
(278, 'GUAITECAS', 13),
(279, 'COCHRANE', 13),
(280, 'O\'HIGGINS', 13),
(281, 'TORTEL', 13),
(282, 'CHILE CHICO', 13),
(283, 'RÍO IBÁÑEZ', 13),
(284, 'PUNTA ARENAS', 14),
(285, 'LAGUNA BLANCA', 14),
(286, 'RÍO VERDE', 14),
(287, 'SAN GREGORIO', 14),
(288, 'CABO DE HORNOS', 14),
(289, 'ANTÁRTICA', 14),
(290, 'PORVENIR', 14),
(291, 'PRIMAVERA', 14),
(292, 'TIMAUKEL', 14),
(293, 'NATALES', 14),
(294, 'TORRES DEL PAINE', 14),
(295, 'SANTIAGO', 15),
(296, 'CERRILLOS', 15),
(297, 'CERRO NAVIA', 15),
(298, 'CONCHALÍ', 15),
(299, 'EL BOSQUE', 15),
(300, 'ESTACIÓN CENTRAL', 15),
(301, 'HUECHURABA', 15),
(302, 'INDEPENDENCIA', 15),
(303, 'LA CISTERNA', 15),
(304, 'LA FLORIDA', 15),
(305, 'LA GRANJA', 15),
(306, 'LA PINTANA', 15),
(307, 'LA REINA', 15),
(308, 'LAS CONDES', 15),
(309, 'LO BARNECHEA', 15),
(310, 'LO ESPEJO', 15),
(311, 'LO PRADO', 15),
(312, 'MACUL', 15),
(313, 'MAIPÚ', 15),
(314, 'ÑUÑOA', 15),
(315, 'PEDRO AGUIRRE CERDA', 15),
(316, 'PEÑALOLÉN', 15),
(317, 'PROVIDENCIA', 15),
(318, 'PUDAHUEL', 15),
(319, 'QUILICURA', 15),
(320, 'QUINTA NORMAL', 15),
(321, 'RECOLETA', 15),
(322, 'RENCA', 15),
(323, 'SAN JOAQUÍN', 15),
(324, 'SAN MIGUEL', 15),
(325, 'SAN RAMÓN', 15),
(326, 'VITACURA', 15),
(327, 'PUENTE ALTO', 15),
(328, 'PIRQUE', 15),
(329, 'SAN JOSÉ DE MAIPO', 15),
(330, 'COLINA', 15),
(331, 'LAMPA', 15),
(332, 'TILTIL', 15),
(333, 'SAN BERNARDO', 15),
(334, 'BUIN', 15),
(335, 'CALERA DE TANGO', 15),
(336, 'PAINE', 15),
(337, 'MELIPILLA', 15),
(338, 'ALHUÉ', 15),
(339, 'CURACAVÍ', 15),
(340, 'MARÍA PINTO', 15),
(341, 'SAN PEDRO', 15),
(342, 'TALAGANTE', 15),
(343, 'EL MONTE', 15),
(344, 'ISLA DE MAIPO', 15),
(345, 'PADRE HURTADO', 15),
(346, 'PEÑAFLOR', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contrato`
--

CREATE TABLE `contrato` (
  `id_contrato` int(11) NOT NULL,
  `fecha_de_contrato` date NOT NULL,
  `valor` int(11) NOT NULL,
  `descripcion` varchar(500) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `id_empresa_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `contrato`
--

INSERT INTO `contrato` (`id_contrato`, `fecha_de_contrato`, `valor`, `descripcion`, `id_empresa_fk`) VALUES
(1, '2019-11-09', 200000, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Expedita, sint nam debitis nihil provident aperiam, nisi iste aliquid aut quos doloribus voluptatum asperiores, delectus sunt quia, laboriosam voluptates excepturi suscipit sit est beatae officia enim! Voluptatem reiciendis iusto, recusandae optio explicabo quidem quibusdam eos debitis distinctio, deserunt maxime ipsam, dolores maiores ut repellendus minima ipsa nostrum accusantium eligend', 1),
(2, '2019-11-09', 300000, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Neque molestiae, amet itaque placeat earum rem alias culpa, mollitia quo perferendis voluptatem est praesentium ipsa voluptatum dicta totam voluptas odit, quam tempora iusto quibusdam saepe architecto ipsum assumenda accusamus. Dicta nulla at quo consequatur vero eum, placeat, deleniti voluptate nam voluptatum excepturi. Eum magni velit soluta dolorem vero, quaerat aperiam quasi temporibus', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_factura`
--

CREATE TABLE `detalle_factura` (
  `id_detalle_factura` int(11) NOT NULL,
  `detalle_facturacol` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `id_empresa` int(11) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `rut` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `sitio_web` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` tinyint(4) NOT NULL,
  `id_rubro_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`id_empresa`, `nombre`, `rut`, `sitio_web`, `telefono`, `estado`, `id_rubro_fk`) VALUES
(1, 'FARMACIA BUENAVENTURA', '9988774455', 'WWW.FARMACIABA.CL', '221144774', 0, 15),
(2, 'AQM MINERALS', '9966332255', 'WWW.AQM.CL', '2255885', 0, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `id_pago` int(11) NOT NULL,
  `fecha_pago` date NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `total` int(11) NOT NULL,
  `estado_pago` tinyint(4) NOT NULL,
  `id_empresa_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `region`
--

CREATE TABLE `region` (
  `id_region` int(11) NOT NULL,
  `nombre_region` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `region`
--

INSERT INTO `region` (`id_region`, `nombre_region`) VALUES
(1, 'ARICA Y PARINACOTA'),
(2, 'TARAPACÁ'),
(3, 'ANTOFAGASTA'),
(4, 'ATACAMA'),
(5, 'COQUIMBO'),
(6, 'VALPARAÍSO'),
(7, 'LIBERTADOR B. O\'HIGGINS'),
(8, 'MAULE'),
(9, 'BÍOBÍO'),
(10, 'LA ARAUCANÍA'),
(11, 'LOS RÍOS'),
(12, 'LOS LAGOS'),
(13, 'AISÉN DEL GRAL. C. IBÁÑEZ DEL CAMPO'),
(14, 'MAGALLANES Y DE LA ANTÁRTICA CHILENA'),
(15, 'REGIÓN METROPOLITANA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reporte_accidente`
--

CREATE TABLE `reporte_accidente` (
  `id_reporte_accidente` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `comentario` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `id_tipo_accidente_fk` int(11) NOT NULL,
  `id_sucursal_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `reporte_accidente`
--

INSERT INTO `reporte_accidente` (`id_reporte_accidente`, `fecha`, `hora`, `comentario`, `id_tipo_accidente_fk`, `id_sucursal_fk`) VALUES
(1, '2019-11-05', '15:20', 'adipisicing elit. Expedita unde quam explicabo, quae quibusdam magni ad. Corporis id dolorum totam ', 2, 1),
(2, '2019-11-08', '08:05', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sit et illum iusto voluptatum ', 8, 1),
(3, '2019-11-07', '15:50', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Expedita unde quam explicabo, quae quibus', 7, 4),
(4, '2019-11-07', '14:25', 'Voluptatem reiciendis iusto, recusandae optio explicabo quidem quibusdam eos debitis distinctio, de', 5, 2),
(5, '2019-11-03', '15:25', 'Voluptatem reiciendis iusto, recusandae optio explicabo quidem quibusdam eos debitis distinctio, de', 8, 2),
(6, '2019-11-02', '20:15', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Neque molestiae, amet itaque placeat earu', 1, 3),
(7, '2019-11-05', '08:00', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Neque molestiae, amet itaque placeat earu', 8, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL,
  `descripcion` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_rol`, `descripcion`) VALUES
(1, 'ADMINISTRADOR'),
(2, 'PROFESIONAL'),
(3, 'CLIENTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rubro`
--

CREATE TABLE `rubro` (
  `id_rubro` int(11) NOT NULL,
  `descripcion` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `rubro`
--

INSERT INTO `rubro` (`id_rubro`, `descripcion`) VALUES
(1, 'AGRICULTURA, GANADERÍA, CAZA Y SILVICULTURA'),
(2, 'PESCA'),
(3, 'EXPLOTACIÓN DE MINAS Y CANTERAS'),
(4, 'INDUSTRIAS MANUFACTURERAS NO METÁLICAS'),
(5, 'INDUSTRIAS MANUFACTURERAS METÁLICAS'),
(6, 'SUMINISTRO DE ELECTRICIDAD, GAS Y AGUA'),
(7, 'CONSTRUCCIÓN'),
(8, 'COMERCIO AL POR MAYOR Y MENOR, REP. VEH. AUTOMOTORES / ENSERES DOMÉSTICOS'),
(9, 'HOTELES Y RESTAURANTES'),
(10, 'TRANSPORTE, ALMACENAMIENTO Y COMUNICACIONES'),
(11, 'AGRICULTURA, GANADERÍA, CAZA Y SILVICULTURA'),
(12, 'ACTIVIDADES INMOBILIARIAS, EMPRESARIALES Y DE ALQUILER'),
(13, 'ADM. PÚBLICA Y DEFENSA, PLANES DE SEG. SOCIAL AFILIACIÓN OBLIGATORIA'),
(14, 'ENSEÑANZA'),
(15, 'SERVICIOS SOCIALES Y DE SALUD'),
(16, 'AGRICULTURA, OTRAS ACTIVIDADES DE SERVICIOS COMUNITARIAS, SOCIALES Y PERSONALES'),
(17, 'CONSEJO DE ADMINISTRACIÓN DE EDIFICIOS Y CONDOMINIOS'),
(18, 'ORGANIZACIONES Y ÓRGANOS EXTRATERRITORIALES'),
(19, 'SIN INFORMACIÓN'),
(20, 'TOTAL GENERAL');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

CREATE TABLE `sucursal` (
  `id_sucursal` int(11) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `id_empresa_fk` int(11) NOT NULL,
  `id_comuna_suc_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `sucursal`
--

INSERT INTO `sucursal` (`id_sucursal`, `nombre`, `direccion`, `id_empresa_fk`, `id_comuna_suc_fk`) VALUES
(1, 'CASA MATRIZ FARMACIA BUENAVENTURA', 'AV. QUILÍN #4587', 1, 312),
(2, 'CASA MATRIZ AQM MINERALS', 'AV. MANQUEHUE SUR #147', 2, 308),
(3, 'AQM MINERALS - ANTOFAGASTA', 'CARMEN SUR #3652', 2, 16),
(4, 'FARMACIA BUENAVENTURA - QUILICURA', 'LO MARCOLETA #12365', 1, 319);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_accidente`
--

CREATE TABLE `tipo_accidente` (
  `id_tipo_accidente` int(11) NOT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipo_accidente`
--

INSERT INTO `tipo_accidente` (`id_tipo_accidente`, `descripcion`) VALUES
(1, 'CAÍDAS AL MISMO NIVEL'),
(2, 'CAÍDAS DE ALTURA'),
(3, 'CONTACTOS ELÉCTRICOS'),
(4, 'CORTES Y PINCHAZOS'),
(5, 'GOLPES CON ESTANTERÍAS O ARMARIOS'),
(6, 'INCENDIOS'),
(7, 'FATIGA POSTURAL'),
(8, 'OTROS ACCIDENTES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_actividad`
--

CREATE TABLE `tipo_actividad` (
  `id_tipo_actividad` int(11) NOT NULL,
  `descripcion` varchar(80) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipo_actividad`
--

INSERT INTO `tipo_actividad` (`id_tipo_actividad`, `descripcion`) VALUES
(1, 'CAPACITACION'),
(2, 'VISITA'),
(3, 'ASESORIA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_asesoria`
--

CREATE TABLE `tipo_asesoria` (
  `id_tipo_asesoria` int(11) NOT NULL,
  `descripcion` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipo_asesoria`
--

INSERT INTO `tipo_asesoria` (`id_tipo_asesoria`, `descripcion`) VALUES
(1, 'SEGURIDAD LABORAL'),
(2, 'GESTIÓN DOCUMENTAL'),
(3, 'DIAGNÓSTICO DE PELIGROS Y RIESGOS EN SU ORGAN'),
(4, 'PROCEDIMIENTOS FRENTE A TODO TIPO DE ACCIDENT'),
(5, 'SEGURIDAD EN VIALIDAD'),
(6, 'DIAGNÓSTICO, RECOMENDACIÓN, USO Y RECAMBIO DE'),
(7, 'DIAGNOSTICO E IMPLEMENTACIÓN DE SEÑALÉTICA DE'),
(8, 'EMERGENCIA Y EVACUACIÓN');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_capacitacion`
--

CREATE TABLE `tipo_capacitacion` (
  `id_tipo_capacitacion` int(11) NOT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipo_capacitacion`
--

INSERT INTO `tipo_capacitacion` (`id_tipo_capacitacion`, `descripcion`) VALUES
(1, 'ADMINISTRACIÓN DE RIESGOS Y COMPETITIVIDAD'),
(2, 'APRENDIENDO SOBRE COMITÉS PARITARIOS'),
(3, 'CÓMO IMPLEMENTAR PROTOCOLO PLANESI EN MI EMPRESA'),
(4, 'CONOCIENDO LOS RIESGOS LABORALES EN NUESTRO TRABAJO'),
(5, 'MANEJO DE SUSTANCIAS Y RESIDUOS PELIGROSOS'),
(6, 'MANEJO MANUAL DE CARGAS'),
(7, 'MONITORES DE EMERGENCIA'),
(8, 'MONITORES EN SEGURIDAD Y SALUD OCUPACIONAL PARA EMPRESAS PYME'),
(9, 'MUTUAL OHSAS 18001'),
(10, 'ORIENTACIÓN EN PREVENCIÓN DE RIESGOS'),
(11, 'PREVENCIÓN DE RIESGO EN LA CONDUCCIÓN'),
(12, 'PROTOCOLO DE VIGILANCIA DE RIESGOS PSICOSOCIALES EN EL TRABAJO'),
(13, 'TRASTORNOS MUSCULO ESQUELÉTICOS DE EXTREMIDADES SUPERIORES EN EL TRABAJO'),
(14, 'USO Y MANEJO DE EXTINTORES PORTÁTILES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_estado`
--

CREATE TABLE `tipo_estado` (
  `id_tipo_estado` int(11) NOT NULL,
  `descripcion` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipo_estado`
--

INSERT INTO `tipo_estado` (`id_tipo_estado`, `descripcion`) VALUES
(1, 'SOLICITADO'),
(2, 'ASIGNADO'),
(3, 'FINALIZADO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_visita`
--

CREATE TABLE `tipo_visita` (
  `id_tipo_visita` int(11) NOT NULL,
  `descripcion` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipo_visita`
--

INSERT INTO `tipo_visita` (`id_tipo_visita`, `descripcion`) VALUES
(1, 'REVICIÓN DE INSTALACIONES'),
(2, 'REVICIÓN DE DOCUMENTACIÓN');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `rut` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(80) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` tinyint(4) NOT NULL,
  `id_comuna_us_fk` int(11) NOT NULL,
  `id_rol_fk` int(11) NOT NULL,
  `id_empresa_fk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `apellidos`, `rut`, `password`, `direccion`, `fecha_nacimiento`, `email`, `telefono`, `estado`, `id_comuna_us_fk`, `id_rol_fk`, `id_empresa_fk`) VALUES
(1, 'JUAN ANDRÉS', 'MARCUS GUTIERREZ', '11111', 'MTExMTE=', 'AVENIDA PEDRO MONTT #350', '1980-08-05', NULL, '988775566', 0, 295, 1, NULL),
(2, 'FELIPE EDUARDO', 'FUENTES MANRIQUEZ', 'admin', 'YWRtaW4=', 'AVENIDA PEDRO MONTT #350', '1980-08-05', NULL, '988775566', 0, 295, 1, NULL),
(3, 'ALFONSO ANDRÉS', 'ARAYA GUITIERREZ', '20123456k', 'YWxmLmFyYSM5OS0wNQ==', 'AV. FERMÍN VIVACETA #600', '1999-05-04', 'ALFONSOARAYA@GMAIL.COM', '98877665', 0, 302, 2, NULL),
(4, 'MARCOS ULISES', 'GONZALES MENESES', '189654122', 'bWFyLmdvbiM5Mi0wOA==', 'CARMEN  #124', '1992-08-13', 'MGONZALES@GMAIL.COM', '98877445', 1, 295, 2, NULL),
(5, 'SAMUEL DAVID', 'FIGUEROA LÓPEZ', '154213654', 'c2FtLmZpZyM4Mi0xMA==', 'AV. EL OBSERVATORIO #5632', '1982-10-24', 'SAMUELFIGUEROA@GMAIL.COM', '22789654', 0, 299, 2, NULL),
(6, 'CARLOS EMILIANO', 'PARRA ARAVENA', '185566332', 'Y2FyLnBhciM5My0xMQ==', 'SAN PABLO  #1785', '1993-11-02', 'CARLOSPARRA@GMAIL.COM', '99665588', 0, 320, 3, 1),
(7, 'RICARDO SALVADOR', 'SANCHEZ VIDAL', '152233665', 'cmljLnNhbiM4MS0wNA==', 'SAN FRANCISCO #253', '1981-04-08', 'RSANCHEZ@GMAIL.COM', '66335522', 0, 318, 3, 1),
(8, 'EDUARDO HECTOR', 'MIRANDA ENRIQUEZ', '17050500k', 'ZWR1Lm1pciM4OS0wNw==', 'PEDRO DONOSO VERGARA #1425', '1989-07-12', 'EDUARDOMIRANDA@GMAIL.COM', '2233665', 0, 321, 3, 2),
(9, 'FRANCISCO LUIS', 'URRUTIA JARA', '190205544', 'ZnJhLnVyciM5My0wNQ==', 'LAS TORRES #520', '1993-05-29', 'FURRUTIA20@GMAIL.COM', '98877445', 0, 16, 3, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `visita`
--

CREATE TABLE `visita` (
  `id_visita` int(11) NOT NULL,
  `id_tipo_visita_fk` int(11) NOT NULL,
  `id_actividad_fk_v` int(11) NOT NULL,
  `contratos` tinyint(4) DEFAULT NULL,
  `documentacion` tinyint(4) DEFAULT NULL,
  `finiquitos` tinyint(4) DEFAULT NULL,
  `comentario_documentacion` varchar(500) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `instalacion` tinyint(4) DEFAULT NULL,
  `baños` tinyint(4) DEFAULT NULL,
  `comedores` tinyint(4) DEFAULT NULL,
  `comentarios_faena` varchar(500) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL,
  `seguridad` tinyint(4) DEFAULT NULL,
  `peligros` tinyint(4) DEFAULT NULL,
  `comentarios_seguridad` varchar(500) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentarios_propuesta` varchar(500) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_lista_empresas`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_lista_empresas` (
`id` int(11)
,`nombre` varchar(100)
,`rut` varchar(20)
,`nombre_sucursal` varchar(100)
,`direccion_empresa` varchar(256)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_lista_empresas_des`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_lista_empresas_des` (
`id` int(11)
,`nombre` varchar(100)
,`rut` varchar(20)
,`nombre_sucursal` varchar(100)
,`direccion_empresa` varchar(256)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_region_comuna`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_region_comuna` (
`id_comuna` int(11)
,`nombre_comuna` varchar(203)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_solicitud_asesorias`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_solicitud_asesorias` (
`id_actividad` int(11)
,`id_asesoria` int(11)
,`id_sucursal` int(11)
,`nombre` varchar(100)
,`descripcion` varchar(45)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_lista_empresas`
--
DROP TABLE IF EXISTS `vista_lista_empresas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_lista_empresas`  AS  select `empresa`.`id_empresa` AS `id`,`empresa`.`nombre` AS `nombre`,`empresa`.`rut` AS `rut`,`sucursal`.`nombre` AS `nombre_sucursal`,concat(`sucursal`.`direccion`,' - ',`comuna`.`nombre_comuna`,' - ',`region`.`nombre_region`) AS `direccion_empresa` from (((`empresa` join `sucursal` on(`sucursal`.`id_empresa_fk` = `empresa`.`id_empresa`)) join `comuna` on(`sucursal`.`id_comuna_suc_fk` = `comuna`.`id_comuna`)) join `region` on(`comuna`.`id_region_fk` = `region`.`id_region`)) where `sucursal`.`nombre` like 'CASA MATRIZ%' and `empresa`.`estado` = 0 order by 2 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_lista_empresas_des`
--
DROP TABLE IF EXISTS `vista_lista_empresas_des`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_lista_empresas_des`  AS  select `empresa`.`id_empresa` AS `id`,`empresa`.`nombre` AS `nombre`,`empresa`.`rut` AS `rut`,`sucursal`.`nombre` AS `nombre_sucursal`,concat(`sucursal`.`direccion`,' - ',`comuna`.`nombre_comuna`,' - ',`region`.`nombre_region`) AS `direccion_empresa` from (((`empresa` join `sucursal` on(`sucursal`.`id_empresa_fk` = `empresa`.`id_empresa`)) join `comuna` on(`sucursal`.`id_comuna_suc_fk` = `comuna`.`id_comuna`)) join `region` on(`comuna`.`id_region_fk` = `region`.`id_region`)) where `sucursal`.`nombre` like 'CASA MATRIZ%' and `empresa`.`estado` = 1 order by 2 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_region_comuna`
--
DROP TABLE IF EXISTS `vista_region_comuna`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_region_comuna`  AS  select `comuna`.`id_comuna` AS `id_comuna`,concat(`region`.`nombre_region`,' - ',`comuna`.`nombre_comuna`) AS `nombre_comuna` from (`comuna` join `region` on(`comuna`.`id_region_fk` = `region`.`id_region`)) order by 1 desc ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_solicitud_asesorias`
--
DROP TABLE IF EXISTS `vista_solicitud_asesorias`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_solicitud_asesorias`  AS  select `actividad`.`id_actividad` AS `id_actividad`,`asesoria`.`id_asesoria` AS `id_asesoria`,`sucursal`.`id_sucursal` AS `id_sucursal`,`sucursal`.`nombre` AS `nombre`,`tipo_asesoria`.`descripcion` AS `descripcion` from ((((`actividad` join `sucursal` on(`sucursal`.`id_sucursal` = `actividad`.`id_sucursal_empresa_fk`)) join `asesoria` on(`asesoria`.`id_actividad_fk_as` = `actividad`.`id_actividad`)) join `tipo_asesoria` on(`asesoria`.`id_tipo_asesoria_fk` = `tipo_asesoria`.`id_tipo_asesoria`)) join `tipo_estado` on(`asesoria`.`id_tipo_estado_fk` = `tipo_estado`.`id_tipo_estado`)) where `actividad`.`id_tipo_actividad_fk` = 3 and `actividad`.`estado_act` = 0 and `tipo_estado`.`id_tipo_estado` = 1 order by 1 ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD PRIMARY KEY (`id_actividad`),
  ADD KEY `fk_actividad_usuario1_idx` (`id_usuario_fk`),
  ADD KEY `fk_actividad_sucursal1_idx` (`id_sucursal_empresa_fk`),
  ADD KEY `fk_actividad_tipo_actividad1_idx` (`id_tipo_actividad_fk`);

--
-- Indices de la tabla `asesoria`
--
ALTER TABLE `asesoria`
  ADD PRIMARY KEY (`id_asesoria`),
  ADD KEY `fk_asesoria_tipo_asesoria1_idx` (`id_tipo_asesoria_fk`),
  ADD KEY `fk_asesoria_actividad1_idx` (`id_actividad_fk_as`),
  ADD KEY `fk_asesoria_tipo_estado1_idx` (`id_tipo_estado_fk`);

--
-- Indices de la tabla `capacitacion`
--
ALTER TABLE `capacitacion`
  ADD PRIMARY KEY (`id_capacitacion`),
  ADD KEY `fk_capacitacion_tipo_capacitacion1_idx` (`id_tipo_capacitacion_fk`),
  ADD KEY `fk_capacitacion_actividad1_idx` (`id_actividad_fk_c`);

--
-- Indices de la tabla `comuna`
--
ALTER TABLE `comuna`
  ADD PRIMARY KEY (`id_comuna`),
  ADD KEY `fk_comuna_region1_idx` (`id_region_fk`);

--
-- Indices de la tabla `contrato`
--
ALTER TABLE `contrato`
  ADD PRIMARY KEY (`id_contrato`),
  ADD KEY `fk_contrato_empresa1_idx` (`id_empresa_fk`);

--
-- Indices de la tabla `detalle_factura`
--
ALTER TABLE `detalle_factura`
  ADD PRIMARY KEY (`id_detalle_factura`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`id_empresa`),
  ADD KEY `fk_empresa_rubro1_idx` (`id_rubro_fk`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`id_pago`),
  ADD KEY `fk_pago_empresa1_idx` (`id_empresa_fk`);

--
-- Indices de la tabla `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`id_region`);

--
-- Indices de la tabla `reporte_accidente`
--
ALTER TABLE `reporte_accidente`
  ADD PRIMARY KEY (`id_reporte_accidente`),
  ADD KEY `fk_reporte_accidente_tipo_accidente1_idx` (`id_tipo_accidente_fk`),
  ADD KEY `fk_reporte_accidente_sucursal1_idx` (`id_sucursal_fk`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `rubro`
--
ALTER TABLE `rubro`
  ADD PRIMARY KEY (`id_rubro`);

--
-- Indices de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD PRIMARY KEY (`id_sucursal`),
  ADD KEY `fk_sucursal_empresa1_idx` (`id_empresa_fk`),
  ADD KEY `fk_sucursal_comuna1_idx` (`id_comuna_suc_fk`);

--
-- Indices de la tabla `tipo_accidente`
--
ALTER TABLE `tipo_accidente`
  ADD PRIMARY KEY (`id_tipo_accidente`);

--
-- Indices de la tabla `tipo_actividad`
--
ALTER TABLE `tipo_actividad`
  ADD PRIMARY KEY (`id_tipo_actividad`);

--
-- Indices de la tabla `tipo_asesoria`
--
ALTER TABLE `tipo_asesoria`
  ADD PRIMARY KEY (`id_tipo_asesoria`);

--
-- Indices de la tabla `tipo_capacitacion`
--
ALTER TABLE `tipo_capacitacion`
  ADD PRIMARY KEY (`id_tipo_capacitacion`);

--
-- Indices de la tabla `tipo_estado`
--
ALTER TABLE `tipo_estado`
  ADD PRIMARY KEY (`id_tipo_estado`);

--
-- Indices de la tabla `tipo_visita`
--
ALTER TABLE `tipo_visita`
  ADD PRIMARY KEY (`id_tipo_visita`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_usuario_rol1_idx` (`id_rol_fk`),
  ADD KEY `fk_usuario_comuna1_idx` (`id_comuna_us_fk`),
  ADD KEY `fk_usuario_empresa1_idx` (`id_empresa_fk`);

--
-- Indices de la tabla `visita`
--
ALTER TABLE `visita`
  ADD PRIMARY KEY (`id_visita`),
  ADD KEY `fk_visita_tipo_visita1_idx` (`id_tipo_visita_fk`),
  ADD KEY `fk_visita_actividad1_idx` (`id_actividad_fk_v`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actividad`
--
ALTER TABLE `actividad`
  MODIFY `id_actividad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `asesoria`
--
ALTER TABLE `asesoria`
  MODIFY `id_asesoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `capacitacion`
--
ALTER TABLE `capacitacion`
  MODIFY `id_capacitacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `comuna`
--
ALTER TABLE `comuna`
  MODIFY `id_comuna` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=347;

--
-- AUTO_INCREMENT de la tabla `contrato`
--
ALTER TABLE `contrato`
  MODIFY `id_contrato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `detalle_factura`
--
ALTER TABLE `detalle_factura`
  MODIFY `id_detalle_factura` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `id_empresa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `id_pago` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `region`
--
ALTER TABLE `region`
  MODIFY `id_region` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `reporte_accidente`
--
ALTER TABLE `reporte_accidente`
  MODIFY `id_reporte_accidente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `rubro`
--
ALTER TABLE `rubro`
  MODIFY `id_rubro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  MODIFY `id_sucursal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipo_accidente`
--
ALTER TABLE `tipo_accidente`
  MODIFY `id_tipo_accidente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tipo_actividad`
--
ALTER TABLE `tipo_actividad`
  MODIFY `id_tipo_actividad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo_asesoria`
--
ALTER TABLE `tipo_asesoria`
  MODIFY `id_tipo_asesoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tipo_capacitacion`
--
ALTER TABLE `tipo_capacitacion`
  MODIFY `id_tipo_capacitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `tipo_estado`
--
ALTER TABLE `tipo_estado`
  MODIFY `id_tipo_estado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo_visita`
--
ALTER TABLE `tipo_visita`
  MODIFY `id_tipo_visita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `visita`
--
ALTER TABLE `visita`
  MODIFY `id_visita` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD CONSTRAINT `fk_actividad_sucursal1` FOREIGN KEY (`id_sucursal_empresa_fk`) REFERENCES `sucursal` (`id_sucursal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_actividad_tipo_actividad1` FOREIGN KEY (`id_tipo_actividad_fk`) REFERENCES `tipo_actividad` (`id_tipo_actividad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_actividad_usuario1` FOREIGN KEY (`id_usuario_fk`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `asesoria`
--
ALTER TABLE `asesoria`
  ADD CONSTRAINT `fk_asesoria_actividad1` FOREIGN KEY (`id_actividad_fk_as`) REFERENCES `actividad` (`id_actividad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_asesoria_tipo_asesoria1` FOREIGN KEY (`id_tipo_asesoria_fk`) REFERENCES `tipo_asesoria` (`id_tipo_asesoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_asesoria_tipo_estado1` FOREIGN KEY (`id_tipo_estado_fk`) REFERENCES `tipo_estado` (`id_tipo_estado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `capacitacion`
--
ALTER TABLE `capacitacion`
  ADD CONSTRAINT `fk_capacitacion_actividad1` FOREIGN KEY (`id_actividad_fk_c`) REFERENCES `actividad` (`id_actividad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_capacitacion_tipo_capacitacion1` FOREIGN KEY (`id_tipo_capacitacion_fk`) REFERENCES `tipo_capacitacion` (`id_tipo_capacitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `comuna`
--
ALTER TABLE `comuna`
  ADD CONSTRAINT `fk_comuna_region1` FOREIGN KEY (`id_region_fk`) REFERENCES `region` (`id_region`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `contrato`
--
ALTER TABLE `contrato`
  ADD CONSTRAINT `fk_contrato_empresa1` FOREIGN KEY (`id_empresa_fk`) REFERENCES `empresa` (`id_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD CONSTRAINT `fk_empresa_rubro1` FOREIGN KEY (`id_rubro_fk`) REFERENCES `rubro` (`id_rubro`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `fk_pago_empresa1` FOREIGN KEY (`id_empresa_fk`) REFERENCES `empresa` (`id_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `reporte_accidente`
--
ALTER TABLE `reporte_accidente`
  ADD CONSTRAINT `fk_reporte_accidente_sucursal1` FOREIGN KEY (`id_sucursal_fk`) REFERENCES `sucursal` (`id_sucursal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_reporte_accidente_tipo_accidente1` FOREIGN KEY (`id_tipo_accidente_fk`) REFERENCES `tipo_accidente` (`id_tipo_accidente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD CONSTRAINT `fk_sucursal_comuna1` FOREIGN KEY (`id_comuna_suc_fk`) REFERENCES `comuna` (`id_comuna`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_sucursal_empresa1` FOREIGN KEY (`id_empresa_fk`) REFERENCES `empresa` (`id_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_comuna1` FOREIGN KEY (`id_comuna_us_fk`) REFERENCES `comuna` (`id_comuna`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuario_empresa1` FOREIGN KEY (`id_empresa_fk`) REFERENCES `empresa` (`id_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuario_rol1` FOREIGN KEY (`id_rol_fk`) REFERENCES `rol` (`id_rol`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `visita`
--
ALTER TABLE `visita`
  ADD CONSTRAINT `fk_visita_actividad1` FOREIGN KEY (`id_actividad_fk_v`) REFERENCES `actividad` (`id_actividad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_visita_tipo_visita1` FOREIGN KEY (`id_tipo_visita_fk`) REFERENCES `tipo_visita` (`id_tipo_visita`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
