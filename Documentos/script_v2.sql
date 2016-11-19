-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema gamestore
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gamestore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gamestore` DEFAULT CHARACTER SET utf8 ;
USE `gamestore` ;

-- -----------------------------------------------------
-- Table `gamestore`.`JOGO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamestore`.`JOGO` ;

CREATE TABLE IF NOT EXISTS `gamestore`.`JOGO` (
  `codigo` INT NOT NULL,
  `plataforma` VARCHAR(45) NOT NULL,
  `genero` VARCHAR(45) NOT NULL,
  `classificacao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamestore`.`CONSOLE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamestore`.`CONSOLE` ;

CREATE TABLE IF NOT EXISTS `gamestore`.`CONSOLE` (
  `codigo` INT NOT NULL,
  `voltagem` VARCHAR(45) NULL,
  `bundle` VARCHAR(45) NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamestore`.`ACESSORIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamestore`.`ACESSORIO` ;

CREATE TABLE IF NOT EXISTS `gamestore`.`ACESSORIO` (
  `codigo` INT NOT NULL,
  `plataforma` VARCHAR(45) NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamestore`.`PRODUTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamestore`.`PRODUTO` ;

CREATE TABLE IF NOT EXISTS `gamestore`.`PRODUTO` (
  `codigo` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `descricao` VARCHAR(4000) NOT NULL,
  `codigo_ean` VARCHAR(14) NOT NULL,
  `ativo` INT(1) NOT NULL DEFAULT 1,
  `codigo_jogo` INT NULL,
  `codigo_console` INT NULL,
  `codigo_acessorio` INT NULL,
  `categoria` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  CONSTRAINT `fk_PRODUTO_JOGO`
    FOREIGN KEY (`codigo_jogo`)
    REFERENCES `gamestore`.`JOGO` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUTO_CONSOLE1`
    FOREIGN KEY (`codigo_console`)
    REFERENCES `gamestore`.`CONSOLE` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUTO_ACESSORIO1`
    FOREIGN KEY (`codigo_acessorio`)
    REFERENCES `gamestore`.`ACESSORIO` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_PRODUTO_JOGO_idx` ON `gamestore`.`PRODUTO` (`codigo_jogo` ASC);

CREATE INDEX `fk_PRODUTO_CONSOLE1_idx` ON `gamestore`.`PRODUTO` (`codigo_console` ASC);

CREATE INDEX `fk_PRODUTO_ACESSORIO1_idx` ON `gamestore`.`PRODUTO` (`codigo_acessorio` ASC);


-- -----------------------------------------------------
-- Table `gamestore`.`CLIENTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamestore`.`CLIENTE` ;

CREATE TABLE IF NOT EXISTS `gamestore`.`CLIENTE` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `apelido` VARCHAR(50) NULL,
  `nome` VARCHAR(50) NOT NULL,
  `sobrenome` VARCHAR(100) NOT NULL,
  `foto` BLOB NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `rg` VARCHAR(15) NULL,
  `sexo` CHAR(1) NOT NULL,
  `estado_civil` INT(1) NOT NULL,
  `nascimento` DATE NOT NULL,
  `email` VARCHAR(100) NULL,
  `preferencia_contato` INT(1) NOT NULL,
  `ativo` INT(1) NOT NULL DEFAULT 1,
  `cep` VARCHAR(9) NULL,
  `logradouro` VARCHAR(100) NULL,
  `numero` VARCHAR(50) NULL,
  `complemento` VARCHAR(100) NULL,
  `bairro` VARCHAR(100) NULL,
  `cidade` VARCHAR(100) NULL,
  `uf` VARCHAR(2) NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `cpf_UNIQUE` ON `gamestore`.`CLIENTE` (`cpf` ASC);


-- -----------------------------------------------------
-- Table `gamestore`.`TELEFONE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamestore`.`TELEFONE` ;

CREATE TABLE IF NOT EXISTS `gamestore`.`TELEFONE` (
  `codigo` INT NOT NULL,
  `tipo` INT NULL,
  `ddd` VARCHAR(3) NULL,
  `numero` VARCHAR(9) NULL,
  `codigo_cliente` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  CONSTRAINT `fk_TELEFONE_CLIENTE1`
    FOREIGN KEY (`codigo_cliente`)
    REFERENCES `gamestore`.`CLIENTE` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_TELEFONE_CLIENTE1_idx` ON `gamestore`.`TELEFONE` (`codigo_cliente` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
