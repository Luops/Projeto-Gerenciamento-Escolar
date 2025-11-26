package dev.ellyon.SistemaEscolar.core.gateway;

import dev.ellyon.SistemaEscolar.core.entities.Turma;

public interface TurmaGateway {
    // CRUD
    Turma criarTurma(Turma turma);

    // Exeptions - Infra
    //boolean isMateriaExistentePorId(Long id);
}
