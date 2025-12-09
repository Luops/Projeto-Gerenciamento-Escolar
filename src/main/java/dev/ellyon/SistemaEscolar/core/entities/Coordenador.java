package dev.ellyon.SistemaEscolar.core.entities;


import dev.ellyon.SistemaEscolar.core.enums.RoleEnum;

import java.time.LocalDateTime;

public class Coordenador extends Entidade{
    private String nome;
    private String sobrenome;

    // Campos opcionais do Usuario (transientes)
    private String email;
    private Long entidadeId;

    public Coordenador(Long id, String nome, LocalDateTime criadoEm, LocalDateTime atualizadoEm, String sobrenome) {
        super(id, criadoEm, atualizadoEm);
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Coordenador(){
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getEntidadeId() {
        return entidadeId;
    }

    public void setEntidadeId(Long entidadeId) {
        this.entidadeId = entidadeId;
    }
}
