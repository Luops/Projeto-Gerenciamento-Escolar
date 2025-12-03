package dev.ellyon.SistemaEscolar.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


// Repositório JPA para a entidade Turma. Fazer operações de CRUD no banco de dados pela interface.
public interface TurmaRepository extends JpaRepository<TurmaEntity, Long> {
    Optional <TurmaEntity> findByNumero(int numero);
    List<TurmaEntity> findByAno(String ano);
    List<TurmaEntity> findByCriadoEmBetween(LocalDateTime dataInicio, LocalDateTime dataFim);
}
