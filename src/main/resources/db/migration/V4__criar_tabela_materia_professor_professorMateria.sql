-- V4__criar_tabela_materia_professor_professorMateria.sql
CREATE TABLE materia (
    id_materia SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP
);

CREATE TABLE professor (
    id_professor SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    total_alunos INT DEFAULT 0,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP,
    id_usuario INT NOT NULL,
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE professor_materia (
    id_professor_materia SERIAL PRIMARY KEY,
    id_professor INT NOT NULL,
    id_materia INT NOT NULL,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP,
    CONSTRAINT fk_professor FOREIGN KEY (id_professor) REFERENCES professor(id_professor),
    CONSTRAINT fk_materia FOREIGN KEY (id_materia) REFERENCES materia(id_materia)
);