package dev.ellyon.SistemaEscolar.infra.gateway;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.gateway.MateriaGateway;
import dev.ellyon.SistemaEscolar.infra.exceptions.Coordenador.CoordenadorNaoEncontradoPeloIdException;
import dev.ellyon.SistemaEscolar.infra.exceptions.Materia.MateriaNaoEncontradaPeloIdException;
import dev.ellyon.SistemaEscolar.infra.mapper.MateriaEntityMapper;
import dev.ellyon.SistemaEscolar.infra.persistence.CoordenadorEntity;
import dev.ellyon.SistemaEscolar.infra.persistence.MateriaEntity;
import dev.ellyon.SistemaEscolar.infra.persistence.MateriaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class MateriaRepositoryGateway implements MateriaGateway {
    private final MateriaRepository materiaRepository;
    private final MateriaEntityMapper materiaEntityMapper;

    public MateriaRepositoryGateway(MateriaRepository materiaRepository, MateriaEntityMapper materiaEntityMapper) {
        this.materiaRepository = materiaRepository;
        this.materiaEntityMapper = materiaEntityMapper;
    }

    // Verifica se já existe uma materia com o id fornecido ao criar ou editar
    @Override
    public boolean isMateriaExistentePorId(Long idMateria) {
        return materiaRepository.findAll().stream().anyMatch(materia -> materia.getIdMateria().equals(idMateria));
    }

    @Override
    public Materia criarMateria(Materia materia) {
        MateriaEntity novaMateria = new MateriaEntity();
        novaMateria.setNome(materia.getNome().toUpperCase());
        novaMateria.setCriadoEm(LocalDateTime.now());
        novaMateria.setAtualizadoEm(LocalDateTime.now());
        MateriaEntity materiaSalva = materiaRepository.save(novaMateria);
        return materiaEntityMapper.toDomain(materiaSalva);
    }

    @Override
    public List<Materia> buscarTodasMaterias() {
        return materiaRepository.findAll().stream().map(materiaEntityMapper::toDomain).toList();
    }

    @Override
    public Materia editarMateria(Long idMateria, Materia materiaAtualizado) {
        // 1. Buscar a matéria existente
        MateriaEntity materiaExistente = materiaRepository.findById(idMateria)
                .orElseThrow(() -> new MateriaNaoEncontradaPeloIdException(idMateria));

        // 2. Atualizar os campos necessários
        materiaExistente.setNome(materiaAtualizado.getNome().toUpperCase());

        // 3. Atualizar a data de atualização
        materiaExistente.setAtualizadoEm(LocalDateTime.now());

        // 4. Salvar as alterações
        MateriaEntity materiaSalva = materiaRepository.save(materiaExistente);

        return materiaEntityMapper.toDomain(materiaSalva);
    }

    @Override
    public Materia buscarMateriaPeloId(Long idMateria) {
        MateriaEntity materiaEntity = materiaRepository.findById(idMateria)
                .orElseThrow(() -> new MateriaNaoEncontradaPeloIdException(idMateria));

        return materiaEntityMapper.toDomain(materiaEntity);
    }

    @Override
    public void deletarMateria(Long idMateria) {
        // 1. Buscar materia para garantir que existe
        MateriaEntity materia = materiaRepository.findById(idMateria)
                .orElseThrow(() -> new MateriaNaoEncontradaPeloIdException(idMateria));

        // 2. Deletar materia
        materiaRepository.deleteById(idMateria);
    }

    @Override
    public long contarTotalMaterias() {
        return materiaRepository.count();
    }

    @Override
    public List<Materia> buscarMateriasPeloNome(String nome) {
        return materiaRepository.findByNomeContainingIgnoreCase(nome).stream()
                .map(materiaEntityMapper::toDomain)
                .toList();
    }

    @Override
    public List<Materia> buscarMateriasEntreDatasCriacao(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return materiaRepository.findByCriadoEmBetween(dataInicio, dataFim).stream().map(materiaEntityMapper::toDomain).toList();
    }
}
