package dev.ellyon.SistemaEscolar.infra.persistence;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import dev.ellyon.SistemaEscolar.core.entities.Responsavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
public class AlunoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_aluno")
  private Long idAluno;

  @Column(name = "nome")
  private String nome;

  @Column(name = "sobrenome")
  private String sobrenome;

  @Column(name = "anoNascimento")
  private String anoNascimento;

  @Column(name = "idade")
  private int idade;

  @Column(name = "id_turma")
  private Long idTurma;

  @Column(name = "telefone")
  private String telefone;

  @Column(name = "email")
  private String email;

  @Column(name = "id_boletim")
  private Long idBoletim;

  @Column(name = "id_endereco")
  private Long idEndereco;

  //TODO - ResponsavelEntity
  // @OneToMany(mappedBy = "aluno")
  // private Set<ResponsavelEntity> responsaveis;

  //TODO - TurmaEntity
  // @ManyToAny(fetch = FetchType.LAZY)
  // @JoinColumn(name = "id_turma")
  // private TurmaEntity turma;
}
