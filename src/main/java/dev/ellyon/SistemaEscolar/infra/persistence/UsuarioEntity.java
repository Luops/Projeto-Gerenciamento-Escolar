package dev.ellyon.SistemaEscolar.infra.persistence;

import dev.ellyon.SistemaEscolar.core.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioEntity extends Entidade{
    private String email;
    private String senha;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entidadeId;
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public UsuarioEntity(Long id, String email, String senha, Long entidadeId, RoleEnum role, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        super(id, criadoEm, atualizadoEm);
        this.email = this.email;
        this.senha = this.senha;
        this.entidadeId = this.entidadeId;
        this.role = this.role;
    }

    public UsuarioEntity() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getEntidadeId() {
        return entidadeId;
    }

    public void setEntidadeId(Long entidadeId) {
        this.entidadeId = entidadeId;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
