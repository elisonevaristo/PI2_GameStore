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
-- Table `gamestore`.`PRODUTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamestore`.`PRODUTO` ;

CREATE TABLE IF NOT EXISTS `gamestore`.`PRODUTO` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `fabricante` VARCHAR(50) NULL,
  `custo` FLOAT NULL,
  `preco` FLOAT NULL,
  `descricao` VARCHAR(4000) NOT NULL,
  `codigo_ean` VARCHAR(14) NOT NULL,
  `ativo` INT(1) NOT NULL DEFAULT 1,
  `categoria` INT NOT NULL,
  `quantidade` INT NOT NULL DEFAULT 0,
  `genero` VARCHAR(45) NULL,
  `plataforma` VARCHAR(45) NULL,
  `classificacao` VARCHAR(45) NULL,
  `garantia_fornecedor` VARCHAR(45) NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamestore`.`CLIENTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamestore`.`CLIENTE` ;

CREATE TABLE IF NOT EXISTS `gamestore`.`CLIENTE` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `apelido` VARCHAR(50) NULL,
  `nome` VARCHAR(50) NOT NULL,
  `sobrenome` VARCHAR(100) NOT NULL,
  `foto` VARCHAR(100) NULL,
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
  `nome_completo` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `cpf_UNIQUE` ON `gamestore`.`CLIENTE` (`cpf` ASC);


-- -----------------------------------------------------
-- Table `gamestore`.`TELEFONE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamestore`.`TELEFONE` ;

CREATE TABLE IF NOT EXISTS `gamestore`.`TELEFONE` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
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


-- -----------------------------------------------------
-- Table `gamestore`.`PEDIDO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamestore`.`PEDIDO` ;

CREATE TABLE IF NOT EXISTS `gamestore`.`PEDIDO` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `data` DATETIME NOT NULL,
  `codigo_cliente` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  CONSTRAINT `fk_PEDIDO_CLIENTE1`
    FOREIGN KEY (`codigo_cliente`)
    REFERENCES `gamestore`.`CLIENTE` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_PEDIDO_CLIENTE1_idx` ON `gamestore`.`PEDIDO` (`codigo_cliente` ASC);


-- -----------------------------------------------------
-- Table `gamestore`.`PRODUTO_PEDIDO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamestore`.`PRODUTO_PEDIDO` ;

CREATE TABLE IF NOT EXISTS `gamestore`.`PRODUTO_PEDIDO` (
  `codigo_pedido` INT NOT NULL,
  `codigo_produto` INT NOT NULL,
  `valor_unitario` FLOAT NULL,
  `quantidade` INT NULL,
  PRIMARY KEY (`codigo_pedido`, `codigo_produto`),
  CONSTRAINT `fk_produto_pedido_PEDIDO1`
    FOREIGN KEY (`codigo_pedido`)
    REFERENCES `gamestore`.`PEDIDO` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_pedido_PRODUTO1`
    FOREIGN KEY (`codigo_produto`)
    REFERENCES `gamestore`.`PRODUTO` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_produto_pedido_PEDIDO1_idx` ON `gamestore`.`PRODUTO_PEDIDO` (`codigo_pedido` ASC);

CREATE INDEX `fk_produto_pedido_PRODUTO1_idx` ON `gamestore`.`PRODUTO_PEDIDO` (`codigo_produto` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
