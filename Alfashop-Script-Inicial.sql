-- MySQL Workbench Synchronization
-- Generated: 2021-08-31 11:28
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Lázaro

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `alfashop` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `alfashop`.`usuarios` (
  `idusuarios` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idusuarios`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `alfashop`.`categorias` (
  `idcategorias` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` TEXT NULL DEFAULT NULL,
  `ativo` CHAR(1) NOT NULL DEFAULT 's',
  PRIMARY KEY (`idcategorias`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `alfashop`.`produtos` (
  `idprodutos` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `descricao` TEXT NULL DEFAULT NULL,
  `maisinfo` TEXT NULL DEFAULT NULL,
  `valor` FLOAT(11) NOT NULL,
  `peso` FLOAT(11) NOT NULL,
  `destaque` CHAR(1) NOT NULL DEFAULT 'n',
  `ativo` CHAR(1) NOT NULL DEFAULT 's',
  `categorias_idcategorias` INT(11) NOT NULL,
  PRIMARY KEY (`idprodutos`),
  INDEX `fk_produtos_categorias_idx` (`categorias_idcategorias` ASC),
  CONSTRAINT `fk_produtos_categorias`
    FOREIGN KEY (`categorias_idcategorias`)
    REFERENCES `alfashop`.`categorias` (`idcategorias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
