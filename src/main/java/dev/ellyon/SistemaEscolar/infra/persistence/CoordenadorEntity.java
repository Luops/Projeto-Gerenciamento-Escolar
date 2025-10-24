package dev.ellyon.SistemaEscolar.infra.persistence;

import dev.ellyon.SistemaEscolar.core.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "coordenador")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CoordenadorEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coordenador")
    private Long idCoordenador;

    private String nome;
    private String sobrenome;

    @Column(name = "id_usuario")
    private Long idUsuario; // FK para usuario

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    // Opcional: relacionamento JPA
    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private UsuarioEntity usuario;

    public CoordenadorEntity(Long idCoordenador, String nome, String sobrenome, Long idUsuario, LocalDateTime criadoEm, LocalDateTime atualizadoEm, UsuarioEntity usuario) {
        this.idCoordenador = idCoordenador;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idUsuario = idUsuario;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.usuario = usuario;
    }

    public CoordenadorEntity(Long id, String nome, LocalDateTime criadoEm, LocalDateTime atualizadoEm, String sobrenome) {
    }

    public Long getId() {
        return idCoordenador;
    }

    public void setId(Long idCoordenador) {
        this.idCoordenador = idCoordenador;
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

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
}
