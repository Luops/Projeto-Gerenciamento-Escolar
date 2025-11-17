-- V6__criar_tabela_aluno_nota_boletim_telefone_alunoResponsavel_endereco_responsavel.sql
CREATE TABLE responsavel (
    id_responsavel SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    role VARCHAR(30) DEFAULT 'RESPONSAVEL',
    email VARCHAR(255) NOT NULL,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP
);

CREATE TABLE telefone (
    id_telefone SERIAL PRIMARY KEY,
    id_responsavel INT,
    numero VARCHAR(255) NOT NULL,
    tipo_entidade VARCHAR(30),  -- 'CELULAR', 'RESIDENCIAL', 'COMERCIAL'
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP,
    CONSTRAINT fk_responsavel FOREIGN KEY (id_responsavel) REFERENCES responsavel(id_responsavel)
);

CREATE TABLE endereco (
    id_endereco SERIAL PRIMARY KEY,
    rua VARCHAR(255) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento VARCHAR(255),
    bairro VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP
);

CREATE TABLE aluno (
    id_aluno SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    ano_nascimento DATE NOT NULL,
    idade INT NOT NULL,
    criado_em TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP,
    id_turma INT,
    id_endereco INT,
    id_responsavel INT,
    id_telefone INT,
    id_usuario INT,
    CONSTRAINT fk_turma FOREIGN KEY (id_turma) REFERENCES turma(id_turma),
    CONSTRAINT fk_endereco FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco),
    CONSTRAINT fk_responsavel FOREIGN KEY (id_responsavel) REFERENCES responsavel(id_responsavel),
    CONSTRAINT fk_telefone FOREIGN KEY (id_telefone) REFERENCES telefone(id_telefone),
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE nota (
    id_nota SERIAL PRIMARY KEY,
    id_aluno INT,
    id_materia INT,
    pontuacao DECIMAL(5,2) NOT NULL,  -- Ex: 8.50
    peso INT DEFAULT 1,  -- Peso da avaliação
    tipo_avaliacao VARCHAR(50),  -- 'PROVA', 'TRABALHO', 'PARTICIPACAO'
    bimestre INT NOT NULL,  -- 1, 2, 3, 4
    ano_letivo INT NOT NULL,  -- 2025
    observacao TEXT,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP,
    CONSTRAINT fk_aluno FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno),
    CONSTRAINT fk_materia FOREIGN KEY (id_materia) REFERENCES materia(id_materia),

    -- Validações
    CONSTRAINT ck_pontuacao CHECK (pontuacao >= 0 AND pontuacao <= 10),
    CONSTRAINT ck_bimestre CHECK (bimestre BETWEEN 1 AND 4),
    CONSTRAINT ck_ano_letivo CHECK (ano_letivo >= 2025)

    -- VIEW para calcular médias por aluno/matéria/bimestre
    --CREATE OR REPLACE VIEW boletim AS
    --SELECT
        --a.id_aluno,
        --a.nome as aluno_nome,
        --m.id_materia,
        --m.nome as materia_nome,
        --n.bimestre,
        --n.ano_letivo,
        --ROUND(AVG(n.pontuacao), 2) as media_bimestre,
        --COUNT(n.id_nota) as total_avaliacoes,
       -- CASE
            --WHEN AVG(n.pontuacao) >= 7.0 THEN 'APROVADO'
            --WHEN AVG(n.pontuacao) >= 5.0 THEN 'RECUPERACAO'
            --ELSE 'REPROVADO'
        --END as situacao
    --FROM aluno a
    --JOIN nota n ON a.id_aluno = n.id_aluno
    --JOIN materia m ON n.id_materia = m.id_materia
    --GROUP BY a.id_aluno, a.nome, m.id_materia, m.nome, n.bimestre, n.ano_letivo;

    -- Consultar boletim
    --SELECT * FROM boletim
    --WHERE aluno_nome = 'João Silva'
    --AND ano_letivo = 2025;*/
);

CREATE TABLE aluno_responsavel (
    id_aluno_responsavel SERIAL PRIMARY KEY,
    id_aluno INT,
    id_responsavel INT,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP,
    CONSTRAINT fk_aluno FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno),
    CONSTRAINT fk_responsavel FOREIGN KEY (id_responsavel) REFERENCES responsavel(id_responsavel)
);
