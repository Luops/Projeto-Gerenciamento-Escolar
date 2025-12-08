package dev.ellyon.SistemaEscolar.core.gateway;

import dev.ellyon.SistemaEscolar.core.entities.Professor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProfessorGateway {
    // CRUD - professor
    Professor criarProfessor(Professor professor, String email, String senha, Long entidadeId, List<Long> idTurma);
    /*Coordenador editarCoordenador(Long id, Coordenador coordenadorAtualizado, String email, String senha);
    void deletarCoordenador(Long id);
    Coordenador buscarCoordenadorPeloId(Long id);
    List<Coordenador> buscarTodosCoordenadores();

    // Queries - coordenador
    List<Coordenador> buscarCoordenadoresPeloNome(String nome);
    List<Coordenador> buscarCoordenadoresEntreDatas(LocalDateTime dataInicio, LocalDateTime dataFim);
    List<Coordenador> buscarCoordenadoresPelaEntidadeId(Long entidadeId);
    List<Coordenador> buscarCoordenadoresPeloEmail(String email);
    long contarTotalCoodenadores();

    // Exception - infra
    boolean isCoordenadorExistentePorEmail(String email);
    boolean isCoordenadorExistentePorId(Long id);*/
}
