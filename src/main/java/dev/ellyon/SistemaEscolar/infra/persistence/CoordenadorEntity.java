package dev.ellyon.SistemaEscolar.infra.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_coordenadores")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CoordenadorEntity extends Entidade{
    private String nome;
    private String sobrenome;
}
