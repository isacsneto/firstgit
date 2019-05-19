create database projeto;

create table cliente(

nome varchar(50), 
cpf char(14) primary key, 
email varchar(50), 
celular char(15), 
cep char(9), 
rua varchar(100), 
numero varchar(5)

);

create table fornecedor(

nome varchar(100), 
cnpj char(18), 
email varchar(50), 
celular char(15), 
cep char(9), 
rua varchar(100), 
numero varchar(5)

);

create table produtos(

codigo int primary key auto_increment, 
nome varchar(50), 
preco double(15,2), 
qtd int, 
descricao varchar(100), 
data_fabri char(10), 
cnpj_fornec char(18)

);

create table funcionario (

nome varchar(50),  
cpf char(14),  
email varchar(50), 
datanascimento char(10),  
celular char(15),  
cep char(9),  
rua varchar(100), 
numero varchar(5),  
funcao varchar(12), 
senha varchar(16),  
primary key (cpf)

);

create table vendas (

idvenda int not null auto_increment primary key,
clientev char(14),
qtditens int,
datavenda char(10),
valort double,

);

create table vendasprodutos (

codvenda int,
codproduto int not null,
qtdproduto int,
FOREIGN KEY (codvenda)
REFERENCES vendas(idvenda),
FOREIGN KEY (codproduto)
REFERENCES produtos(codigo)

);
