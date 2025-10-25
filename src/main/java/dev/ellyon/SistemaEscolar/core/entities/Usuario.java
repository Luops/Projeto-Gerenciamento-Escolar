package dev.ellyon.SistemaEscolar.core.entities;

import dev.ellyon.SistemaEscolar.core.enums.RoleEnum;

import java.time.LocalDateTime;

public class Usuario extends Entidade {
    private String email;
    private String senha;
    private Long entidadeId;
    private RoleEnum role;

    public Usuario(Long id, LocalDateTime criadoEm, LocalDateTime atualizadoEm, String email, String senha, Long entidadeId, RoleEnum role) {
        super(id, criadoEm, atualizadoEm);
        this.email = email;
        this.senha = senha;
        this.entidadeId = entidadeId;
        this.role = role;
    }

    public Usuario(){
        super();
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getEntidadeId() {
        return this.entidadeId;
    }

    public void setEntidadeId(Long entidadeId) {
        this.entidadeId = entidadeId;
    }

    public RoleEnum getRole() {
        return this.role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    /*
     * Ajustes: atributo role, getRole e setRole estavam como String e não como RoleEnum - 15/10/2025 Fabrício */

}