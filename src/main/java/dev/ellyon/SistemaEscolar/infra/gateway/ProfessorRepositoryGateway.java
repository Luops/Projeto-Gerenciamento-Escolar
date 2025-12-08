package dev.ellyon.SistemaEscolar.infra.gateway;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.enums.RoleEnum;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;
import dev.ellyon.SistemaEscolar.infra.exceptions.Coordenador.CoordenadorNaoEncontradoPeloIdException;
import dev.ellyon.SistemaEscolar.infra.mapper.CoordenadorEntityMapper;
import dev.ellyon.SistemaEscolar.infra.persistence.CoordenadorEntity;
import dev.ellyon.SistemaEscolar.infra.persistence.CoordenadorRepository;
import dev.ellyon.SistemaEscolar.infra.persistence.UsuarioEntity;
import dev.ellyon.SistemaEscolar.infra.persistence.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ProfessorRepositoryGateway implements CoordenadorGateway {
    private final CoordenadorRepository coordenadorRepository;
    private final UsuarioRepository usuarioRepository;
    private final CoordenadorEntityMapper coordenadorEntityMapper;

    public ProfessorRepositoryGateway(
            CoordenadorRepository coordenadorRepository,
            UsuarioRepository usuarioRepository,
            CoordenadorEntityMapper coordenadorEntityMapper) {
        this.coordenadorRepository = coordenadorRepository;
        this.usuarioRepository = usuarioRepository;
        this.coordenadorEntityMapper = coordenadorEntityMapper;
    }


    @Override
    @Transactional
    public Coordenador criarCoordenador(Coordenador coordenador, String email, String senha, Long entidadeId) {
        // 1. Criar o Usuario primeiro
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setEntidadeId(entidadeId);
        usuario.setRole(RoleEnum.COORDENADOR);
        usuario.setCriadoEm(LocalDateTime.now());
        usuario.setAtualizadoEm(LocalDateTime.now());

        UsuarioEntity usuarioSalvo = usuarioRepository.save(usuario);

        // 2. Criar o Coordenador vinculado ao Usuario
        CoordenadorEntity coordenadorEntity = new CoordenadorEntity();
        coordenadorEntity.setNome(coordenador.getNome());
        coordenadorEntity.setSobrenome(coordenador.getSobrenome());
        coordenadorEntity.setIdUsuario(usuarioSalvo.getIdUsuario());
        coordenadorEntity.setCriadoEm(LocalDateTime.now());
        coordenadorEntity.setAtualizadoEm(LocalDateTime.now());

        CoordenadorEntity novoCoordenador = coordenadorRepository.save(coordenadorEntity);

        return coordenadorEntityMapper.toDomain(novoCoordenador);
    }


}