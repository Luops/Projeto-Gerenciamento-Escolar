package dev.ellyon.SistemaEscolar.infra.dtos;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.enums.RoleEnum;

import java.time.LocalDateTime;

public class CoordenadorDto extends Coordenador {
    public CoordenadorDto(Long id, String nome, String email, String senha, Long entidadeId, RoleEnum role, LocalDateTime criadoEm, LocalDateTime atualizadoEm, String sobrenome) {
        super();
    }
}
