-- -----------------------------------------------------
-- Table PRODUTO
-- -----------------------------------------------------
CREATE TABLE PRODUTO 
(
  codigo INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  nome VARCHAR(100) NOT NULL,
  fabricante VARCHAR(50),
  custo FLOAT,
  preco FLOAT,
  descricao VARCHAR(4000) NOT NULL,
  codigo_ean VARCHAR(14) NOT NULL,
  ativo INT(1) NOT NULL DEFAULT 1,
  categoria INT NOT NULL,
  quantidade INT NOT NULL DEFAULT 0,
  genero VARCHAR(45),
  plataforma VARCHAR(45),
  classificacao VARCHAR(45),
  garantia_fornecedor VARCHAR(45),
  PRIMARY KEY (codigo)
);



-- -----------------------------------------------------
-- Table CLIENTE
-- -----------------------------------------------------
CREATE TABLE CLIENTE (
  codigo INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  apelido VARCHAR(50),
  nome VARCHAR(50) NOT NULL,
  sobrenome VARCHAR(100) NOT NULL,
  foto BLOB NULL,
  cpf VARCHAR(11) NOT NULL,
  rg VARCHAR(15),
  sexo CHAR(1) NOT NULL,
  estado_civil INT(1) NOT NULL,
  nascimento DATE NOT NULL,
  email VARCHAR(100),
  preferencia_contato INT(1) NOT NULL,
  ativo INT(1) NOT NULL DEFAULT 1,
  cep VARCHAR(9),
  logradouro VARCHAR(100),
  numero VARCHAR(50),
  complemento VARCHAR(100),
  bairro VARCHAR(100),
  cidade VARCHAR(100),
  uf VARCHAR(2),
  nome_completo VARCHAR(150) NOT NULL,
  PRIMARY KEY (codigo))


CREATE UNIQUE INDEX cpf_UNIQUE ON CLIENTE (cpf ASC);


-- -----------------------------------------------------
-- Table TELEFONE
-- -----------------------------------------------------
CREATE TABLE TELEFONE (
  codigo INT NOT NULL,
  tipo INT NULL,
  ddd VARCHAR(3),
  numero VARCHAR(9),
  codigo_cliente INT NOT NULL,
  PRIMARY KEY (codigo),
  CONSTRAINT fk_TELEFONE_CLIENTE1
    FOREIGN KEY (codigo_cliente)
    REFERENCES CLIENTE (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)


CREATE INDEX fk_TELEFONE_CLIENTE1_idx ON TELEFONE (codigo_cliente ASC);


-- -----------------------------------------------------
-- Table PEDIDO
-- -----------------------------------------------------
CREATE TABLE PEDIDO (
  codigo INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  data DATETIME NOT NULL,
  codigo_cliente INT NOT NULL,
  PRIMARY KEY (codigo),
  CONSTRAINT fk_PEDIDO_CLIENTE1
    FOREIGN KEY (codigo_cliente)
    REFERENCES CLIENTE (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)


CREATE INDEX fk_PEDIDO_CLIENTE1_idx ON PEDIDO (codigo_cliente ASC);


-- -----------------------------------------------------
-- Table PRODUTO_PEDIDO
-- -----------------------------------------------------
CREATE TABLE PRODUTO_PEDIDO (
  codigo_pedido INT NOT NULL,
  codigo_produto INT NOT NULL,
  valor_unitario FLOAT NULL,
  quantidade INT NULL,
  PRIMARY KEY (codigo_pedido, codigo_produto),
  CONSTRAINT fk_produto_pedido_PEDIDO1
    FOREIGN KEY (codigo_pedido)
    REFERENCES PEDIDO (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_produto_pedido_PRODUTO1
    FOREIGN KEY (codigo_produto)
    REFERENCES PRODUTO (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)


CREATE INDEX fk_produto_pedido_PEDIDO1_idx ON PRODUTO_PEDIDO (codigo_pedido ASC);

CREATE INDEX fk_produto_pedido_PRODUTO1_idx ON PRODUTO_PEDIDO (codigo_produto ASC);
