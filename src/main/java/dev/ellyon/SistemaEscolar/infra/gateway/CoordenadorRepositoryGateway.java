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
import java.util.List;
import java.util.Optional;

@Component
public class CoordenadorRepositoryGateway implements CoordenadorGateway {
    private final CoordenadorRepository coordenadorRepository;
    private final UsuarioRepository usuarioRepository;
    private final CoordenadorEntityMapper coordenadorEntityMapper;

    public CoordenadorRepositoryGateway(
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
        //usuario.setCriadoEm(LocalDateTime.now());
        usuario.setAtualizadoEm(LocalDateTime.now());

        UsuarioEntity usuarioSalvo = usuarioRepository.save(usuario);

        // 2. Criar o Coordenador vinculado ao Usuario
        CoordenadorEntity coordenadorEntity = new CoordenadorEntity();
        coordenadorEntity.setNome(coordenador.getNome());
        coordenadorEntity.setSobrenome(coordenador.getSobrenome());
        coordenadorEntity.setIdUsuario(usuarioSalvo.getIdUsuario());
        // coordenadorEntity.setCriadoEm(LocalDateTime.now());
        //coordenadorEntity.setAtualizadoEm(LocalDateTime.now());

        CoordenadorEntity novoCoordenador = coordenadorRepository.save(coordenadorEntity);

        return coordenadorEntityMapper.toDomain(novoCoordenador);
    }

    @Override
    public List<Coordenador> buscarTodosCoordenadores() {
        return coordenadorRepository.findAll().stream().map(coordenadorEntityMapper::toDomainWithUsuario).toList();
    }

    @Override
    public boolean isCoordenadorExistentePorEmail(String email) {
        return coordenadorRepository.findAll().stream().anyMatch(coordenador -> coordenador.getUsuario().getEmail().equalsIgnoreCase(email));
    }

    @Override
    public List<Coordenador> buscarCoordenadoresPeloNome(String nome) {
        return coordenadorRepository.findByNomeContainingIgnoreCase(nome).stream().map(coordenadorEntityMapper::toDomainWithUsuario).toList();
    }

    @Override
    public List<Coordenador> buscarCoordenadoresEntreDatas(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return coordenadorRepository.findByCriadoEmBetween(dataInicio, dataFim).stream().map(coordenadorEntityMapper::toDomainWithUsuario).toList();
    }

    @Override
    public List<Coordenador> buscarCoordenadoresPelaEntidadeId(Long entidadeId) {
        return coordenadorRepository.findByUsuario_EntidadeId(entidadeId).stream().map(coordenadorEntityMapper::toDomainWithUsuario).toList();
    }

    @Override
    public List<Coordenador> buscarCoordenadoresPeloEmail(String email) {
        return coordenadorRepository.buscarPorEmail(email).stream().map(coordenadorEntityMapper::toDomainWithUsuario).toList();
    }

    @Override
    @Transactional
    public Coordenador editarCoordenador(Long id, Coordenador coordenadorAtualizado, String email, String senha) {
        // 1. Buscar coordenador existente
        CoordenadorEntity coordenadorExistente = coordenadorRepository.findByIdWithUsuario(id)
                .orElseThrow(() -> new RuntimeException("Coordenador não encontrado com ID: " + id));

        // LOG ANTES
        System.out.println("=== ANTES DA EDIÇÃO ===");
        System.out.println("Coordenador criadoEm: " + coordenadorExistente.getCriadoEm());
        System.out.println("Coordenador atualizadoEm: " + coordenadorExistente.getAtualizadoEm());
        System.out.println("Usuario criadoEm: " + coordenadorExistente.getUsuario().getCriadoEm());
        System.out.println("Usuario atualizadoEm: " + coordenadorExistente.getUsuario().getAtualizadoEm());

        // 2. Atualizar dados do Coordenador
        coordenadorExistente.setNome(coordenadorAtualizado.getNome());
        coordenadorExistente.setSobrenome(coordenadorAtualizado.getSobrenome());
        coordenadorExistente.setAtualizadoEm(LocalDateTime.now());

        // 3. Atualizar dados do Usuario relacionado
        UsuarioEntity usuario = coordenadorExistente.getUsuario();
        if (usuario == null) {
            throw new RuntimeException("Usuario não encontrado para o coordenador ID: " + id);
        }

        // ATUALIZAR EMAIL se fornecido
        if (email != null && !email.isBlank()) {
            usuario.setEmail(email);
        }

        // ATUALIZAR SENHA se fornecida
        if (senha != null && !senha.isBlank()) {
            usuario.setSenha(senha);
        }

        usuario.setAtualizadoEm(LocalDateTime.now());

        // LOG ANTES DE SALVAR
        System.out.println("=== ANTES DE SALVAR ===");
        System.out.println("Coordenador criadoEm: " + coordenadorExistente.getCriadoEm());
        System.out.println("Coordenador atualizadoEm: " + coordenadorExistente.getAtualizadoEm());
        System.out.println("Usuario criadoEm: " + usuario.getCriadoEm());
        System.out.println("Usuario atualizadoEm: " + usuario.getAtualizadoEm());

        // 4. Salvar alterações
        usuarioRepository.save(usuario);
        CoordenadorEntity coordenadorSalvo = coordenadorRepository.save(coordenadorExistente);

        // LOG DEPOIS DE SALVAR
        System.out.println("=== DEPOIS DE SALVAR ===");
        System.out.println("Coordenador criadoEm: " + coordenadorSalvo.getCriadoEm());
        System.out.println("Coordenador atualizadoEm: " + coordenadorSalvo.getAtualizadoEm());
        System.out.println("Usuario criadoEm: " + coordenadorSalvo.getUsuario().getCriadoEm());
        System.out.println("Usuario atualizadoEm: " + coordenadorSalvo.getUsuario().getAtualizadoEm());

        // 5. Retornar com dados completos
        return coordenadorEntityMapper.toDomainWithUsuario(coordenadorSalvo);
    }

    @Override
    public Coordenador buscarCoordenadorPeloId(Long id) {
        CoordenadorEntity coordenadorEntity = coordenadorRepository.findByIdWithUsuario(id)
                .orElseThrow(() -> new RuntimeException("Coordenador não encontrado com ID: " + id));

        return coordenadorEntityMapper.toDomainWithUsuario(coordenadorEntity);
    }

    @Override
    @Transactional
    public void deletarCoordenador(Long id) {
        // 1. Buscar coordenador para garantir que existe
        CoordenadorEntity coordenador = coordenadorRepository.findByIdWithUsuario(id)
                .orElseThrow(() -> new RuntimeException("Coordenador não encontrado com ID: " + id));

        // 2. Guardar o ID do usuario
        Long idUsuario = coordenador.getIdUsuario();

        // 3. Deletar coordenador primeiro (por causa da FK)
        coordenadorRepository.deleteById(id);

        // 4. Deletar usuario depois
        usuarioRepository.deleteById(idUsuario);
    }
}