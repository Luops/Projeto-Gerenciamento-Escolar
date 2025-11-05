-- V3_corrigir_timestamps_coordenador_usuario.sql

-- Remover DEFAULT de atualizado_em (deve ser controlado pela aplicação)
ALTER TABLE usuario
    ALTER COLUMN criado_em SET DEFAULT CURRENT_TIMESTAMP,
    ALTER COLUMN atualizado_em DROP DEFAULT;

ALTER TABLE coordenador
    ALTER COLUMN criado_em SET DEFAULT CURRENT_TIMESTAMP,
    ALTER COLUMN atualizado_em DROP DEFAULT;