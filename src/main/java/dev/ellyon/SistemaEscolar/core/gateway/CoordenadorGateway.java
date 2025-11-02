package dev.ellyon.SistemaEscolar.core.gateway;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import jakarta.transaction.Transactional;

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
    boolean isCoordenadorExistentePorEmail(String email);
}
