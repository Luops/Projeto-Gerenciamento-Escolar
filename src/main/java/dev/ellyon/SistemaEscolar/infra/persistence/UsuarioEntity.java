package dev.ellyon.SistemaEscolar.infra.persistence;

import dev.ellyon.SistemaEscolar.core.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
