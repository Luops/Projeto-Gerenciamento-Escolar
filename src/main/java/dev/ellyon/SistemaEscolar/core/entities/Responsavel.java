package dev.ellyon.SistemaEscolar.core.entities;

import java.util.List;

public final class Responsavel extends Entidade {
    private String nome;
    private String sobrenome;
    private List<Telefone> telefones;
    private String email;

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

    public List<Telefone> getTelefones() {
        return this.telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
