package dev.ellyon.SistemaEscolar.core.gateway;

import dev.ellyon.SistemaEscolar.core.entities.Materia;

import java.util.List;

public interface MateriaGateway {
    // CRUD
    Materia criarMateria(Materia materia);
    List<Materia> buscarTodasMaterias();
    Materia editarMateria(Long idMateria, Materia materiaAtualizado);

}
