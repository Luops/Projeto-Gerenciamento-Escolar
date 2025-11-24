package dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.exceptions.ValidacaoException;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;
import dev.ellyon.SistemaEscolar.core.gateway.MateriaGateway;

import java.util.List;

public class BuscarMateriasPeloNomeUseCaseImpl implements BuscarMateriasPeloNomeUseCase {
    private final MateriaGateway materiaGateway;

    public BuscarMateriasPeloNomeUseCaseImpl(MateriaGateway materiaGateway) {
        this.materiaGateway = materiaGateway;
    }

    @Override
    public List<Materia> execute(String nome) {
        validarNome(nome);
        return materiaGateway.buscarMateriasPeloNome(nome);
    }

    private void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ValidacaoException("O nome da matéria não pode ser vazio.");
        }

        if (nome.trim().length() < 5) {
            throw new ValidacaoException("O nome da matéria deve ter pelo menos 5 caracteres.");
        }
    }
}
