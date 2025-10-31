package dev.ellyon.SistemaEscolar.core.gateway;

import java.util.List;

import dev.ellyon.SistemaEscolar.core.entities.Aluno;

public interface AlunoGateway {
  Aluno criarAluno(Aluno aluno);
  List<Aluno> buscarTodosAlunos();
}
