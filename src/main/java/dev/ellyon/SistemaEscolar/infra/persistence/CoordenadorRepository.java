package dev.ellyon.SistemaEscolar.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

// Repositório JPA para a entidade Coordenador. Fazer operações de CRUD no banco de dados pela interface.
public interface CoordenadorRepository extends JpaRepository<CoordenadorEntity, Long> {
}
