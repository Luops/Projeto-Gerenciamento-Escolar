package dev.ellyon.SistemaEscolar.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// Repositório JPA para a entidade Materia. Fazer operações de CRUD no banco de dados pela interface.
public interface MateriaRepository extends JpaRepository<MateriaEntity, Long> {
    List<MateriaEntity> findByNomeContainingIgnoreCase(String nome);

}
