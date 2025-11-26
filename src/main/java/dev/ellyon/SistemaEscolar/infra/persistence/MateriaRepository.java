package dev.ellyon.SistemaEscolar.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;


// Repositório JPA para a entidade Materia. Fazer operações de CRUD no banco de dados pela interface.
public interface MateriaRepository extends JpaRepository<MateriaEntity, Long> {
    List<MateriaEntity> findByNomeContainingIgnoreCase(String nome);

    List<MateriaEntity> findByCriadoEmBetween(LocalDateTime dataInicio, LocalDateTime dataFim);
}
