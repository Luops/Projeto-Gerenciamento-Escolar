package dev.ellyon.SistemaEscolar.core.gateway;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
/*
public interface CoordenadorGateway {
    // Método para criar um coordenador
    Coordenador criarCoordenador(Coordenador coordenador);

}*/

public interface CoordenadorGateway {
    // CRUD - coordenador
    Coordenador criarCoordenador(Coordenador coordenador, String email, String senha, Long entidadeId);
    Coordenador editarCoordenador(Long id, Coordenador coordenadorAtualizado, String email, String senha);
    void deletarCoordenador(Long id);
    Coordenador buscarCoordenadorPeloId(Long id);
    List<Coordenador> buscarTodosCoordenadores();

    // Queries - coordenador
    List<Coordenador> buscarCoordenadoresPeloNome(String nome);
    List<Coordenador> buscarCoordenadoresEntreDatas(LocalDateTime dataInicio, LocalDateTime dataFim);
    List<Coordenador> buscarCoordenadoresPelaEntidadeId(Long entidadeId);
    List<Coordenador> buscarCoordenadoresPeloEmail(String email);

    // Exception - infra
    boolean isCoordenadorExistentePorEmail(String email);
}
