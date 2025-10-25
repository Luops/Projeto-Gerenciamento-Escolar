package dev.ellyon.SistemaEscolar.core.gateway;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import jakarta.transaction.Transactional;
/*
public interface CoordenadorGateway {
    // Método para criar um coordenador
    Coordenador criarCoordenador(Coordenador coordenador);

}*/

public interface CoordenadorGateway {
    Coordenador criarCoordenador(Coordenador coordenador, String email, String senha, Long entidadeId);
}
