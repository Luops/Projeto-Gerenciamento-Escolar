package dev.ellyon.SistemaEscolar.core.entities;


import dev.ellyon.SistemaEscolar.core.enums.RoleEnum;

import java.time.LocalDateTime;

public class Coordenador extends Entidade{
    private String nome;
    private String sobrenome;

    public Coordenador(Long id, String nome, LocalDateTime criadoEm, LocalDateTime atualizadoEm, String sobrenome) {
        super(id, criadoEm, atualizadoEm);
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Coordenador(){
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
