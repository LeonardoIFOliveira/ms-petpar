-- Criar o banco de dados
CREATE DATABASE PetPar;

-- Usar o banco de dados criado
USE PetPar;

-- Tabela de usuários
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    date_of_birth DATE,
    cpf VARCHAR(14) UNIQUE,
    phone_number VARCHAR(20),
    gender ENUM('MASCULINO', 'FEMININO', 'OUTRO', 'PREFIRO_NAO_DIZER'),
    updated_at TIMESTAMP NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de instituições
CREATE TABLE institutions (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    email VARCHAR(255) NOT NULL UNIQUE,
    cpf_or_cnpj VARCHAR(18) UNIQUE,
    phone_number VARCHAR(20),
    password VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

CREATE TABLE animals (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    gender ENUM('MASCULINO', 'FEMININO', 'OUTRO', 'PREFIRO_NAO_DIZER'),
    birth_date DATE,
    type ENUM('CACHORRO', 'GATO', 'ROEDOR', 'PEIXE', 'OUTRO') NOT NULL,
    status_adoption ENUM('PENDING_ADOPTION', 'IN_PROGRESS', 'PENDING_INSTITUTION_APPROVE','PENDING_TAKE_ANIMAL', 'DONE') DEFAULT 'PENDING_ADOPTION',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL,
    user_id BIGINT,
    institution_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (institution_id) REFERENCES institutions(id)
);

-- Tabela de doações
CREATE TABLE donations (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    amount DECIMAL(10, 2) NOT NULL,
    paymentMethod ENUM('CARTAO', 'PIX'),
    created_at DATE NOT NULL,
    institution_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (institution_id) REFERENCES institutions(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);