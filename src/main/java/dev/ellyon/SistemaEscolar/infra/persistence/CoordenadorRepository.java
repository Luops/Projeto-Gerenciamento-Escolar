package dev.ellyon.SistemaEscolar.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

// Repositório JPA para a entidade Coordenador. Fazer operações de CRUD no banco de dados pela interface.
public interface CoordenadorRepository extends JpaRepository<CoordenadorEntity, Long> {
    List<CoordenadorEntity> findByNomeContainingIgnoreCase(String nome);
    List<CoordenadorEntity> findByCriadoEmBetween(LocalDateTime dataInicio, LocalDateTime dataFim);
    List<CoordenadorEntity> findByUsuario_EntidadeId(Long entidadeId);
}
