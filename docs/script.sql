```sql
-- MySQL Script generated by MySQL Workbench
-- Tue Dec 29 20:16:27 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS gerenciadorEstoque DEFAULT CHARACTER SET utf8 ;
USE gerenciadorEstoque;

-- -----------------------------------------------------
-- Table Fornecedor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Fornecedor (
  codigo SMALLINT NOT NULL AUTO_INCREMENT,
  razaoSocial VARCHAR(100) NOT NULL,
  cnpj VARCHAR(18) NOT NULL,
  email VARCHAR(100) NOT NULL,
  telefone VARCHAR(14) NOT NULL,
  cep CHAR(9) NOT NULL,
  PRIMARY KEY (codigo, cnpj)
)

INSERT INTO fornecedor(razaoSocial,cnpj,email,telefone,cep) VALUES ('Miguel e Isabella Assessoria Jurídica Ltda',68096466000176,'atendimento@migueleisabellaassessoriajuridicaltda.com.br',6226941155,75134420);
INSERT INTO fornecedor(razaoSocial,cnpj,email,telefone,cep) VALUES ('Nicolas e Daniel Construções Ltda',09467109000108,'ouvidoria@nicolasedanielconstrucoesltda.com.br',6137118817,72926720);
INSERT INTO fornecedor(razaoSocial,cnpj,email,telefone,cep) VALUES ('Antônia e Natália Vidros ME',85774417000164,'pesquisa@antoniaenataliavidrosme.com.br',6225681667,74393010);
INSERT INTO fornecedor(razaoSocial,cnpj,email,telefone,cep) VALUES ('Gabriel e Calebe Limpeza ME',69746128000103,'faleconosco@gabrielecalebelimpezame.com.br',6228835013,74944130);
INSERT INTO fornecedor(razaoSocial,cnpj,email,telefone,cep) VALUES ('Davi e Andrea Vidros Ltda',81655542000102,'financeiro@davieandreavidrosltda.com.br',6235141491,74455540);

-- -----------------------------------------------------
-- Table Categoria
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Categoria (
  codigo SMALLINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (codigo)
)

INSERT INTO categoria (nome) VALUES ('nome');
INSERT INTO categoria (nome) VALUES ('Informática');
INSERT INTO categoria (nome) VALUES ('Livros');
INSERT INTO categoria (nome) VALUES ('Móveis e Decoração');
INSERT INTO categoria (nome) VALUES ('Eletrodomésticos e Casa');
INSERT INTO categoria (nome) VALUES ('Moda');
INSERT INTO categoria (nome) VALUES ('Viagens');

-- -----------------------------------------------------
-- Table Produto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Produto (
  codigo SMALLINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  quantidadeMinima INT NOT NULL,
  validade DATE NOT NULL,
  descricao VARCHAR(255) NULL,
  peso FLOAT NULL,
  cor VARCHAR(45) NULL,
  altura FLOAT NULL,
  largura FLOAT NULL,
  codigoFornecedor SMALLINT NOT NULL,
  cnpjFornecedor VARCHAR(18) NOT NULL,
  codigoCategoria SMALLINT NOT NULL,
  PRIMARY KEY (codigo),
  FOREIGN KEY (codigoFornecedor, cnpjFornecedor) REFERENCES Fornecedor (codigo, cnpj),
  FOREIGN KEY (codigoCategoria) REFERENCES Categoria (codigo)
)

-- -----------------------------------------------------
-- Table Sub_Categoria
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS SubCategoria (
  codigo SMALLINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  codigoCategoria SMALLINT NOT NULL,
  PRIMARY KEY (codigo, codigoCategoria),
  FOREIGN KEY (codigoCategoria) REFERENCES Categoria (codigo)
)

-- -----------------------------------------------------
-- Table Cliente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Cliente (
  codigo SMALLINT NOT NULL AUTO_INCREMENT,
  cpf VARCHAR(11) NOT NULL,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(45) NOT NULL,
  dataNascimento DATE NOT NULL,
  PRIMARY KEY (codigo)
)

-- -----------------------------------------------------
-- Table Transportadora
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Transportadora (
  codigo SMALLINT NOT NULL AUTO_INCREMENT,
  cnpj VARCHAR(18) NOT NULL,
  razaoSocial VARCHAR(100) NULL,
  cep CHAR(9) NOT NULL,
  telefone VARCHAR(14) NOT NULL,
  PRIMARY KEY (codigo, cnpj)
)

-- -----------------------------------------------------
-- Table Pedido
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Pedido (
  codigo SMALLINT NOT NULL AUTO_INCREMENT,
  frete FLOAT NOT NULL,
  dataCompra DATE NOT NULL,
  dataEntrega DATE NOT NULL,
  codigoCliente SMALLINT NOT NULL,
  codigoTransportadora SMALLINT NOT NULL,
  cnpjTransportadora VARCHAR(18) NOT NULL,
  PRIMARY KEY (codigo),
  FOREIGN KEY (codigoCliente) REFERENCES Cliente (codigo),
  FOREIGN KEY (codigoTransportadora, cnpjTransportadora) 
  REFERENCES Transportadora (codigo , cnpj)
)

-- -----------------------------------------------------
-- Table Item_Saida
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ItemSaida (
  codigoProduto SMALLINT NOT NULL,
  codigoPedido SMALLINT NOT NULL,
  quantidade INT NOT NULL,
  PRIMARY KEY (codigoProduto , codigoPedido),
  FOREIGN KEY (codigoProduto) REFERENCES Produto (codigo),
  FOREIGN KEY (codigoPedido ) REFERENCES Pedido (codigo)
)

-- -----------------------------------------------------
-- Table Telefone
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Telefone (
  codigoCliente SMALLINT NOT NULL,
  numero VARCHAR(14) NOT NULL,
  PRIMARY KEY (codigoCliente, number),
  FOREIGN KEY (codigoCliente) REFERENCES Cliente (codigo)
)

-- -----------------------------------------------------
-- Table Encomenda
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Encomenda (
  codigo SMALLINT NOT NULL AUTO_INCREMENT,
  dataPedido DATE NOT NULL,
  dataEntrega DATE NOT NULL,
  frete FLOAT NOT NULL,
  codigoTransportadora SMALLINT NOT NULL,
  cnpjTransportadora VARCHAR(18) NOT NULL,
  PRIMARY KEY (codigo),
  FOREIGN KEY (codigoTransportadora, cnpjTransportadora)
  REFERENCES Transportadora (codigo , cnpj)
)

-- -----------------------------------------------------
-- Table Item_Entrada
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Item_Entrada (
  codigoProduto SMALLINT NOT NULL,
  codigoEncomenda SMALLINT NOT NULL,
  quantidade INT NOT NULL,
  PRIMARY KEY (codigoProduto , codigoEncomenda),
  FOREIGN KEY (codigoProduto) REFERENCES Produto (codigo),
  FOREIGN KEY (codigoEncomenda) REFERENCES Encomenda (codigo)
)

```
