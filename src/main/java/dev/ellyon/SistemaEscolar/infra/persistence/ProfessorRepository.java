package dev.ellyon.SistemaEscolar.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// Repositório JPA para a entidade Professor. Fazer operações de CRUD no banco de dados pela interface.
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {

}
