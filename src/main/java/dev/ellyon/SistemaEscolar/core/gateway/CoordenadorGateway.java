package dev.ellyon.SistemaEscolar.core.gateway;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
/*
public interface CoordenadorGateway {
    // Método para criar um coordenador
    Coordenador criarCoordenador(Coordenador coordenador);

}*/

public interface CoordenadorGateway {
    Coordenador criarCoordenador(Coordenador coordenador, String email, String senha, Long entidadeId);
    List<Coordenador> buscarTodosCoordenadores();
    List<Coordenador> buscarCoordenadoresPeloNome(String nome);
    List<Coordenador> buscarCoordenadoresEntreDatas(LocalDateTime dataInicio, LocalDateTime dataFim);
    List<Coordenador> buscarCoordenadoresPelaEntidadeId(Long entidadeId);
    boolean isCoordenadorExistentePorEmail(String email);
}
