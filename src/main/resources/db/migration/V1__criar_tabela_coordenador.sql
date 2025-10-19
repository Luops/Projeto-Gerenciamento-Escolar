-- V1_criar_tabela_coordenador.sql
CREATE TABLE Usuario (
    id_usuario SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(30) NOT NULL,
    entidade_id INT NOT NULL,
    role VARCHAR(30) NOT NULL,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Coordenador (
    id_coordenador SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_usuario INT,

    CONSTRAINT fk_usuario_coordenador
        FOREIGN KEY (id_usuario)
        REFERENCES Usuario (id_usuario)
        ON UPDATE CASCADE
        ON DELETE CASCADE

);

