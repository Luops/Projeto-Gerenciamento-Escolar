package dev.ellyon.SistemaEscolar.core.entities;

import java.util.List;

public final class Aluno extends Entity {
        private String nome;
        private String sobrenome;
        private String anoNascimento;
        private int idade;
        private Turma turma;
        private String telefone;
        private String email;
        private Boletim boletim;
        private Endereco endereco;
        private List<Responsavel> responsaveis;
        /* Faltou matrícula */

        public String getNome() {
                return this.nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getSobrenome() {
                return this.sobrenome;
        }

        public void setSobrenome(String sobrenome) {
                this.sobrenome = sobrenome;
        }

        public String getAnoNascimento() {
                return this.anoNascimento;
        }

        public void setAnoNascimento(String anoNascimento) {
                this.anoNascimento = anoNascimento;
        }

        public int getIdade() {
                return this.idade;
        }

        public void setIdade(int idade) {
                this.idade = idade;
        }

        public Turma getTurma() {
                return this.turma;
        }

        public void setTurma(Turma turma) {
                this.turma = turma;
        }

        public String getTelefone() {
                return this.telefone;
        }

        public void setTelefone(String telefone) {
                this.telefone = telefone;
        }

        public String getEmail() {
                return this.email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Boletim getBoletim() {
                return this.boletim;
        }

        public void setBoletim(Boletim boletim) {
                this.boletim = boletim;
        }

        public Endereco getEndereco() {
                return this.endereco;
        }

        public void setEndereco(Endereco endereco) {
                this.endereco = endereco;
        }

        public List<Responsavel> getResponsaveis() {
                return this.responsaveis;
        }

        public void setResponsaveis(List<Responsavel> responsaveis) {
                this.responsaveis = responsaveis;
        }
}
