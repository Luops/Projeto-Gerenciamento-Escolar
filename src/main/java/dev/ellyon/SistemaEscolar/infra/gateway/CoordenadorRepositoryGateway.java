package dev.ellyon.SistemaEscolar.infra.gateway;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.enums.RoleEnum;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;
import dev.ellyon.SistemaEscolar.infra.mapper.CoordenadorEntityMapper;
import dev.ellyon.SistemaEscolar.infra.persistence.CoordenadorEntity;
import dev.ellyon.SistemaEscolar.infra.persistence.CoordenadorRepository;
import dev.ellyon.SistemaEscolar.infra.persistence.UsuarioEntity;
import dev.ellyon.SistemaEscolar.infra.persistence.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CoordenadorRepositoryGateway implements CoordenadorGateway {
    // Injeção do repositório de coordenadores. Usar o JPA Repository para fazer operações no banco de dados.
    private final CoordenadorRepository coordenadorRepository; // Repositório de coordenadores. Pegar as queries do banco de dados.
    private final UsuarioRepository usuarioRepository;
    private final CoordenadorEntityMapper coordenadorEntityMapper;

    public CoordenadorRepositoryGateway(CoordenadorRepository coordenadorRepository, CoordenadorEntityMapper coordenadorEntityMapper, UsuarioRepository usuarioRepository) {
        this.coordenadorRepository = coordenadorRepository;
        this.coordenadorEntityMapper =  coordenadorEntityMapper;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    @Override
    public Coordenador criarCoordenador(Coordenador coordenador, String email, String senha, Long entidadeId) {
        // 1. Criar o usuário
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setEntidadeId(entidadeId);
        usuario.setRole(RoleEnum.COORDENADOR);
        usuario.setCriadoEm(LocalDateTime.now());
        usuario.setAtualizadoEm(LocalDateTime.now());

        UsuarioEntity usuarioSalvo = usuarioRepository.save(usuario);

        // 2. Criar o coordenador
        CoordenadorEntity coordenadorEntity = coordenadorEntityMapper.toEntity(coordenador);
        coordenadorEntity.setId(usuarioSalvo.getId());
        coordenadorEntity.setCriadoEm(LocalDateTime.now());
        coordenadorEntity.setAtualizadoEm(LocalDateTime.now());

        CoordenadorEntity novoCoordenador = coordenadorRepository.save(coordenadorEntity);

        return coordenadorEntityMapper.toDomain(novoCoordenador);
    }
}
