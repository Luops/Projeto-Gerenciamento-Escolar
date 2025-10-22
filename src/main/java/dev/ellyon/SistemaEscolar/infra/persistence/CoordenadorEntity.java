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
public class CoordenadorEntity extends Entidade{
    private String nome;
    private String sobrenome;

    public CoordenadorEntity(Long id, String nome, LocalDateTime criadoEm, LocalDateTime atualizadoEm, String sobrenome) {
        super(id, criadoEm, atualizadoEm);
        this.nome = nome;
        this.sobrenome = sobrenome;
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
}
