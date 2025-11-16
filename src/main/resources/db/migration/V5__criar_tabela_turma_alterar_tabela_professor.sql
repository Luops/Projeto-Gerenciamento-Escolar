-- V5__criar_tabela_turma_alterar_tabela_professor.sql
CREATE TABLE turma (
    id_turma SERIAL PRIMARY KEY,
    numero INT NOT NULL,
    qte_alunos INT NOT NULL,
    ano VARCHAR(20) NOT NULL,
    criado_em TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP
);

ALTER TABLE professor
    ADD COLUMN id_turma INT,
    ADD CONSTRAINT fk_turma FOREIGN KEY (id_turma) REFERENCES turma(id_turma)
