package dev.ellyon.SistemaEscolar.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorMateriaRepository extends JpaRepository<ProfessorMateriaEntity, Long>{
    // Repositório JPA para a entidade Professor_Materia. Fazer operações de CRUD no banco de dados pela interface.


}
