package dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;

public class DeletarCoordenadorUseCaseImpl implements DeletarCoordenadorUseCase {
    private final CoordenadorGateway coordenadorGateway;

    public DeletarCoordenadorUseCaseImpl(CoordenadorGateway coordenadorGateway) {
        this.coordenadorGateway = coordenadorGateway;
    }

    @Override
    public Coordenador execute(Long id) {
        validar(id);
        coordenadorGateway.deletarCoordenador(id);
        return null;
    }

    private void validar(Long id){
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
    }
}
