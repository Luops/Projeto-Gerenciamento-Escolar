package dev.ellyon.SistemaEscolar.infra.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coordenador")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CoordenadorEntity extends UsuarioEntity{
    private String nome;
    private String sobrenome;
}
