package dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.entities.Turma;
import dev.ellyon.SistemaEscolar.core.exceptions.ValidacaoException;
import dev.ellyon.SistemaEscolar.core.gateway.MateriaGateway;
import dev.ellyon.SistemaEscolar.core.gateway.TurmaGateway;

import java.util.List;

public class BuscarTurmaPeloNumeroUseCaseImpl implements BuscarTurmaPeloNumeroUseCase {
    private final TurmaGateway turmaGateway;

    public BuscarTurmaPeloNumeroUseCaseImpl(TurmaGateway turmaGateway) {
        this.turmaGateway = turmaGateway;
    }

    @Override
    public Turma execute(int numero) {
        validar(numero);
        return turmaGateway.buscarTurmaPeloNumero(numero);
    }

    private void validar(int numero) {
        if (numero <= 0) {
            throw new ValidacaoException("O Número deve ser um número positivo.");
        }
    }
}
