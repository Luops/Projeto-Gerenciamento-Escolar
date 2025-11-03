-- V2_alterar_tipo_entidade_id_para_bigint.sql
ALTER TABLE usuario
ALTER COLUMN entidade_id TYPE BIGINT
USING entidade_id::bigint;
