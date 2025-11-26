package dev.ellyon.SistemaEscolar.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


// Repositório JPA para a entidade Turma. Fazer operações de CRUD no banco de dados pela interface.
public interface TurmaRepository extends JpaRepository<TurmaEntity, Long> {
}
