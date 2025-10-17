package dev.ellyon.SistemaEscolar.infra.persistence;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public abstract class Entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

}
