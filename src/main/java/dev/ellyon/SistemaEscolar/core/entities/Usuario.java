package dev.ellyon.SistemaEscolar.core.entities;

public final class Usuario extends Entity {
    private String email;
    private String senha;
    private Long entidadeId;
    private String role;

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

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
