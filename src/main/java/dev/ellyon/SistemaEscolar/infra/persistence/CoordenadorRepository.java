package dev.ellyon.SistemaEscolar.infra.persistence;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// Repositório JPA para a entidade Coordenador. Fazer operações de CRUD no banco de dados pela interface.
public interface CoordenadorRepository extends JpaRepository<CoordenadorEntity, Long> {
    @Query("SELECT c FROM CoordenadorEntity c JOIN FETCH c.usuario WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<CoordenadorEntity> findByNomeContainingIgnoreCase(@Param("nome") String nome);

    @Query("SELECT c FROM CoordenadorEntity c JOIN FETCH c.usuario WHERE c.criadoEm BETWEEN :dataInicio AND :dataFim")
    List<CoordenadorEntity> findByCriadoEmBetween(@Param("dataInicio") LocalDateTime dataInicio, @Param("dataFim") LocalDateTime dataFim);

    @Query("SELECT c FROM CoordenadorEntity c JOIN FETCH c.usuario u WHERE u.entidadeId = :entidadeId")
    List<CoordenadorEntity> findByUsuario_EntidadeId(@Param("entidadeId") Long entidadeId);

    @Query("SELECT c FROM CoordenadorEntity c " +
            "JOIN FETCH c.usuario u " +
            "WHERE LOWER(u.email) LIKE LOWER(CONCAT('%', :email, '%'))")
    List<CoordenadorEntity> buscarPorEmail(@Param("email") String email);

    @Query("SELECT c FROM CoordenadorEntity c JOIN FETCH c.usuario WHERE c.idCoordenador = :id")
    Optional<CoordenadorEntity> findByIdWithUsuario(@Param("id") Long id);

}
