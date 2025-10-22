package dev.ellyon.SistemaEscolar.infra.gateway;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;
import dev.ellyon.SistemaEscolar.infra.mapper.CoordenadorEntityMapper;
import dev.ellyon.SistemaEscolar.infra.persistence.CoordenadorEntity;
import dev.ellyon.SistemaEscolar.infra.persistence.CoordenadorRepository;
import org.springframework.stereotype.Component;

@Component
public class CoordenadorRepositoryGateway implements CoordenadorGateway {
    // Injeção do repositório de coordenadores. Usar o JPA Repository para fazer operações no banco de dados.
    private final CoordenadorRepository coordenadorRepository; // Repositório de coordenadores. Pegar as queries do banco de dados.
    private final CoordenadorEntityMapper coordenadorEntityMapper;

    public CoordenadorRepositoryGateway(CoordenadorRepository coordenadorRepository, CoordenadorEntityMapper coordenadorEntityMapper) {
        this.coordenadorRepository = coordenadorRepository;
        this.coordenadorEntityMapper = new CoordenadorEntityMapper();
    }

    @Override
    public Coordenador criarCoordenador(Coordenador coordenador) {
        CoordenadorEntity coordenadorEntity = coordenadorEntityMapper.toEntity(coordenador); // Converter a entidade de domínio para a entidade de persistência.
        CoordenadorEntity novoCoordenador = coordenadorRepository.save(coordenadorEntity); // Salvar a entidade no banco de dados.
        return coordenadorEntityMapper.toDomain(novoCoordenador); // Converter a entidade de persistência de volta para a entidade de domínio.
    }
}
