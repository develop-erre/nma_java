-- MySQL Script generated by MySQL Workbench
-- Fri Dec 13 00:05:43 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

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

-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`rol`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`rol` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`rol` (
  `id_rol` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  PRIMARY KEY (`id_rol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`region`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`region` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`region` (
  `id_region` INT NOT NULL AUTO_INCREMENT,
  `nombre_region` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  PRIMARY KEY (`id_region`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`comuna`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`comuna` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`comuna` (
  `id_comuna` INT NOT NULL AUTO_INCREMENT,
  `nombre_comuna` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `id_region_fk` INT NOT NULL,
  PRIMARY KEY (`id_comuna`),
  INDEX `fk_comuna_region1_idx` (`id_region_fk` ASC),
  CONSTRAINT `fk_comuna_region1`
    FOREIGN KEY (`id_region_fk`)
    REFERENCES `no_mas_accidentes`.`region` (`id_region`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`direccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`direccion` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`direccion` (
  `id_direccion` INT NOT NULL AUTO_INCREMENT,
  `nombre_calle` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `numero` VARCHAR(10) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `depto` VARCHAR(10) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL,
  `id_comuna_fk` INT NOT NULL,
  PRIMARY KEY (`id_direccion`),
  INDEX `fk_direccion_comuna1_idx` (`id_comuna_fk` ASC),
  CONSTRAINT `fk_direccion_comuna1`
    FOREIGN KEY (`id_comuna_fk`)
    REFERENCES `no_mas_accidentes`.`comuna` (`id_comuna`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`rubro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`rubro` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`rubro` (
  `id_rubro` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(200) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  PRIMARY KEY (`id_rubro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`empresa` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`empresa` (
  `id_empresa` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `rut` VARCHAR(20) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `sitio_web` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL,
  `telefono` VARCHAR(20) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL,
  `estado` TINYINT NOT NULL,
  `id_rubro_fk` INT NOT NULL,
  PRIMARY KEY (`id_empresa`),
  INDEX `fk_empresa_rubro1_idx` (`id_rubro_fk` ASC),
  CONSTRAINT `fk_empresa_rubro1`
    FOREIGN KEY (`id_rubro_fk`)
    REFERENCES `no_mas_accidentes`.`rubro` (`id_rubro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`sucursal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`sucursal` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`sucursal` (
  `id_sucursal` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `id_direccion_suc_fk` INT NOT NULL,
  `id_empresa_fk` INT NOT NULL,
  `casa_matriz` TINYINT NULL,
  PRIMARY KEY (`id_sucursal`),
  INDEX `fk_sucursal_empresa1_idx` (`id_empresa_fk` ASC),
  INDEX `fk_sucursal_direccion1_idx` (`id_direccion_suc_fk` ASC),
  CONSTRAINT `fk_sucursal_empresa1`
    FOREIGN KEY (`id_empresa_fk`)
    REFERENCES `no_mas_accidentes`.`empresa` (`id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sucursal_direccion1`
    FOREIGN KEY (`id_direccion_suc_fk`)
    REFERENCES `no_mas_accidentes`.`direccion` (`id_direccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`usuario` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `apellidos` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `rut` VARCHAR(20) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `password` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `id_direccion_fk` INT NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `email` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL,
  `telefono` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL,
  `estado` TINYINT NOT NULL,
  `id_rol_fk` INT NOT NULL,
  `id_sucursal_fk` INT NULL,
  PRIMARY KEY (`id_usuario`),
  INDEX `fk_usuario_rol1_idx` (`id_rol_fk` ASC),
  INDEX `fk_usuario_direccion1_idx` (`id_direccion_fk` ASC),
  INDEX `fk_usuario_sucursal1_idx` (`id_sucursal_fk` ASC),
  CONSTRAINT `fk_usuario_rol1`
    FOREIGN KEY (`id_rol_fk`)
    REFERENCES `no_mas_accidentes`.`rol` (`id_rol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_direccion1`
    FOREIGN KEY (`id_direccion_fk`)
    REFERENCES `no_mas_accidentes`.`direccion` (`id_direccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_sucursal1`
    FOREIGN KEY (`id_sucursal_fk`)
    REFERENCES `no_mas_accidentes`.`sucursal` (`id_sucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`tipo_actividad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`tipo_actividad` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`tipo_actividad` (
  `id_tipo_actividad` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  PRIMARY KEY (`id_tipo_actividad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`actividad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`actividad` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`actividad` (
  `id_actividad` INT NOT NULL AUTO_INCREMENT,
  `fecha_act` DATE NULL,
  `hora_act` TIME NULL,
  `estado_act` TINYINT NOT NULL,
  `id_usuario_fk` INT NULL,
  `id_sucursal_empresa_fk` INT NOT NULL,
  `id_tipo_actividad_fk` INT NOT NULL,
  PRIMARY KEY (`id_actividad`),
  INDEX `fk_actividad_usuario1_idx` (`id_usuario_fk` ASC),
  INDEX `fk_actividad_sucursal1_idx` (`id_sucursal_empresa_fk` ASC),
  INDEX `fk_actividad_tipo_actividad1_idx` (`id_tipo_actividad_fk` ASC),
  CONSTRAINT `fk_actividad_usuario1`
    FOREIGN KEY (`id_usuario_fk`)
    REFERENCES `no_mas_accidentes`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actividad_sucursal1`
    FOREIGN KEY (`id_sucursal_empresa_fk`)
    REFERENCES `no_mas_accidentes`.`sucursal` (`id_sucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actividad_tipo_actividad1`
    FOREIGN KEY (`id_tipo_actividad_fk`)
    REFERENCES `no_mas_accidentes`.`tipo_actividad` (`id_tipo_actividad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`tipo_capacitacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`tipo_capacitacion` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`tipo_capacitacion` (
  `id_tipo_capacitacion` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  PRIMARY KEY (`id_tipo_capacitacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`capacitacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`capacitacion` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`capacitacion` (
  `id_capacitacion` INT NOT NULL AUTO_INCREMENT,
  `numero_asistente` INT NULL,
  `id_tipo_capacitacion_fk` INT NOT NULL,
  `id_actividad_fk_c` INT NOT NULL,
  PRIMARY KEY (`id_capacitacion`),
  INDEX `fk_capacitacion_tipo_capacitacion1_idx` (`id_tipo_capacitacion_fk` ASC),
  INDEX `fk_capacitacion_actividad1_idx` (`id_actividad_fk_c` ASC),
  CONSTRAINT `fk_capacitacion_tipo_capacitacion1`
    FOREIGN KEY (`id_tipo_capacitacion_fk`)
    REFERENCES `no_mas_accidentes`.`tipo_capacitacion` (`id_tipo_capacitacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_capacitacion_actividad1`
    FOREIGN KEY (`id_actividad_fk_c`)
    REFERENCES `no_mas_accidentes`.`actividad` (`id_actividad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`contrato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`contrato` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`contrato` (
  `id_contrato` INT NOT NULL AUTO_INCREMENT,
  `fecha_de_contrato` DATE NOT NULL,
  `valor` INT NOT NULL,
  `descripcion` VARCHAR(500) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `id_empresa_fk` INT NOT NULL,
  PRIMARY KEY (`id_contrato`),
  INDEX `fk_contrato_empresa1_idx` (`id_empresa_fk` ASC),
  CONSTRAINT `fk_contrato_empresa1`
    FOREIGN KEY (`id_empresa_fk`)
    REFERENCES `no_mas_accidentes`.`empresa` (`id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`factura` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`factura` (
  `id_pago` INT NOT NULL AUTO_INCREMENT,
  `fecha_pago` DATE NOT NULL,
  `fecha_vencimiento` DATE NOT NULL,
  `estado_pago` TINYINT NOT NULL,
  `valor_plan` INT NOT NULL,
  `id_empresa_fk` INT NOT NULL,
  PRIMARY KEY (`id_pago`),
  INDEX `fk_pago_empresa1_idx` (`id_empresa_fk` ASC),
  CONSTRAINT `fk_pago_empresa1`
    FOREIGN KEY (`id_empresa_fk`)
    REFERENCES `no_mas_accidentes`.`empresa` (`id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`tipo_accidente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`tipo_accidente` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`tipo_accidente` (
  `id_tipo_accidente` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  PRIMARY KEY (`id_tipo_accidente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`reporte_accidente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`reporte_accidente` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`reporte_accidente` (
  `id_reporte_accidente` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `hora` VARCHAR(10) NOT NULL,
  `comentario` VARCHAR(200) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `id_tipo_accidente_fk` INT NOT NULL,
  `id_sucursal_fk` INT NOT NULL,
  PRIMARY KEY (`id_reporte_accidente`),
  INDEX `fk_reporte_accidente_tipo_accidente1_idx` (`id_tipo_accidente_fk` ASC),
  INDEX `fk_reporte_accidente_sucursal1_idx` (`id_sucursal_fk` ASC),
  CONSTRAINT `fk_reporte_accidente_tipo_accidente1`
    FOREIGN KEY (`id_tipo_accidente_fk`)
    REFERENCES `no_mas_accidentes`.`tipo_accidente` (`id_tipo_accidente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reporte_accidente_sucursal1`
    FOREIGN KEY (`id_sucursal_fk`)
    REFERENCES `no_mas_accidentes`.`sucursal` (`id_sucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`tipo_visita`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`tipo_visita` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`tipo_visita` (
  `id_tipo_visita` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  PRIMARY KEY (`id_tipo_visita`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`visita`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`visita` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`visita` (
  `id_visita` INT NOT NULL AUTO_INCREMENT,
  `id_tipo_visita_fk` INT NOT NULL,
  `id_actividad_fk_v` INT NOT NULL,
  `contratos` TINYINT NULL,
  `documentacion` TINYINT NULL,
  `finiquitos` TINYINT NULL,
  `comentario_documentacion` VARCHAR(500) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL,
  `instalacion` TINYINT NULL,
  `baños` TINYINT NULL,
  `comedores` TINYINT NULL,
  `comentarios_faena` VARCHAR(500) CHARACTER SET 'utf8' COLLATE 'utf8_spanish2_ci' NULL,
  `seguridad` TINYINT NULL,
  `peligros` TINYINT NULL,
  `comentarios_seguridad` VARCHAR(500) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL,
  `comentarios_propuesta` VARCHAR(500) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL,
  PRIMARY KEY (`id_visita`),
  INDEX `fk_visita_tipo_visita1_idx` (`id_tipo_visita_fk` ASC),
  INDEX `fk_visita_actividad1_idx` (`id_actividad_fk_v` ASC),
  CONSTRAINT `fk_visita_tipo_visita1`
    FOREIGN KEY (`id_tipo_visita_fk`)
    REFERENCES `no_mas_accidentes`.`tipo_visita` (`id_tipo_visita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_visita_actividad1`
    FOREIGN KEY (`id_actividad_fk_v`)
    REFERENCES `no_mas_accidentes`.`actividad` (`id_actividad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`detalle_factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`detalle_factura` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`detalle_factura` (
  `id_detalle_factura` INT NOT NULL AUTO_INCREMENT,
  `valor_total` INT NOT NULL,
  `factura_id_pago` INT NOT NULL,
  PRIMARY KEY (`id_detalle_factura`),
  INDEX `fk_detalle_factura_factura1_idx` (`factura_id_pago` ASC),
  CONSTRAINT `fk_detalle_factura_factura1`
    FOREIGN KEY (`factura_id_pago`)
    REFERENCES `no_mas_accidentes`.`factura` (`id_pago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`tipo_asesoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`tipo_asesoria` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`tipo_asesoria` (
  `id_tipo_asesoria` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_tipo_asesoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`tipo_estado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`tipo_estado` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`tipo_estado` (
  `id_tipo_estado` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tipo_estado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`asesoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`asesoria` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`asesoria` (
  `id_asesoria` INT NOT NULL AUTO_INCREMENT,
  `comentarios_detectados` VARCHAR(500) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL,
  `comentarios_propuesta` VARCHAR(500) NULL,
  `id_tipo_estado_fk` INT NOT NULL,
  `id_tipo_asesoria_fk` INT NOT NULL,
  `id_actividad_fk_as` INT NOT NULL,
  PRIMARY KEY (`id_asesoria`),
  INDEX `fk_asesoria_tipo_asesoria1_idx` (`id_tipo_asesoria_fk` ASC),
  INDEX `fk_asesoria_actividad1_idx` (`id_actividad_fk_as` ASC),
  INDEX `fk_asesoria_tipo_estado1_idx` (`id_tipo_estado_fk` ASC),
  CONSTRAINT `fk_asesoria_tipo_asesoria1`
    FOREIGN KEY (`id_tipo_asesoria_fk`)
    REFERENCES `no_mas_accidentes`.`tipo_asesoria` (`id_tipo_asesoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_asesoria_actividad1`
    FOREIGN KEY (`id_actividad_fk_as`)
    REFERENCES `no_mas_accidentes`.`actividad` (`id_actividad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_asesoria_tipo_estado1`
    FOREIGN KEY (`id_tipo_estado_fk`)
    REFERENCES `no_mas_accidentes`.`tipo_estado` (`id_tipo_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `no_mas_accidentes`.`actividad_has_detalle_factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `no_mas_accidentes`.`actividad_has_detalle_factura` ;

CREATE TABLE IF NOT EXISTS `no_mas_accidentes`.`actividad_has_detalle_factura` (
  `id_actividad_has` INT NOT NULL,
  `id_detalle_factura_has` INT NOT NULL,
  PRIMARY KEY (`id_actividad_has`, `id_detalle_factura_has`),
  INDEX `fk_actividad_has_detalle_factura_detalle_factura1_idx` (`id_detalle_factura_has` ASC),
  INDEX `fk_actividad_has_detalle_factura_actividad1_idx` (`id_actividad_has` ASC),
  CONSTRAINT `fk_actividad_has_detalle_factura_actividad1`
    FOREIGN KEY (`id_actividad_has`)
    REFERENCES `no_mas_accidentes`.`actividad` (`id_actividad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actividad_has_detalle_factura_detalle_factura1`
    FOREIGN KEY (`id_detalle_factura_has`)
    REFERENCES `no_mas_accidentes`.`detalle_factura` (`id_detalle_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
