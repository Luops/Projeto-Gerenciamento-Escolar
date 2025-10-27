package dev.ellyon.SistemaEscolar.infra.controller;


import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.usecase.BuscarCoordenadorUseCase;
import dev.ellyon.SistemaEscolar.core.usecase.CriarCoordenadorUseCase;
import dev.ellyon.SistemaEscolar.infra.dtos.CoordenadorDto;
import dev.ellyon.SistemaEscolar.infra.mapper.CoordenadorDtoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/coordenador/")
public class CoordenadorController {
    private final CriarCoordenadorUseCase criarCoordenadorUseCase; // Executar caso de uso de criar coordenador
    private final CoordenadorDtoMapper coordenadorDtoMapper; // Mapper para converter entre Coordenador e CoordenadorDto
    private final BuscarCoordenadorUseCase buscarCoordenadorUseCase;

    // Constructor Injection
    public CoordenadorController(CriarCoordenadorUseCase criarCoordenadorUseCase, CoordenadorDtoMapper coordenadorDtoMapper, BuscarCoordenadorUseCase buscarCoordenadorUseCase) {
        this.criarCoordenadorUseCase = criarCoordenadorUseCase;
        this.coordenadorDtoMapper = coordenadorDtoMapper;
        this.buscarCoordenadorUseCase = buscarCoordenadorUseCase;
    }

    // Endpoint para criar um novo coordenador
    /*@PostMapping("criar")
    public CoordenadorDto criarCoordenador(@RequestBody CoordenadorDto coordenadorDto) {
        // Executa o caso de uso para criar um novo coordenador. Pega o DTO, converte para domínio e passa para o caso de uso pois ele recebe somente a entidade de domínio
        Coordenador novoCoordenador = criarCoordenadorUseCase.execute(coordenadorDtoMapper.toDomain(coordenadorDto));
        return coordenadorDtoMapper.toDto(novoCoordenador); // Converte o coordenador criado de volta para DTO
    }*/
    @PostMapping("criar")
    public CoordenadorDto criarCoordenador(@RequestBody CoordenadorDto coordenadorDto) {
        Coordenador coordenadorDominio = coordenadorDtoMapper.toDomain(coordenadorDto);

        // Executa o caso de uso para criar um novo coordenador. Pega o DTO, converte para domínio e passa para o caso de uso pois ele recebe somente a entidade de domínio
        Coordenador novoCoordenador = criarCoordenadorUseCase.execute(
                coordenadorDominio,
                coordenadorDto.getEmail(),
                coordenadorDto.getSenha(),
                coordenadorDto.getEntidadeId()
        );

        // Criar resposta MANUALMENTE para incluir email e entidadeId (SEM senha)
        CoordenadorDto resposta = new CoordenadorDto();
        resposta.setId(novoCoordenador.getId());
        resposta.setNome(novoCoordenador.getNome());
        resposta.setSobrenome(novoCoordenador.getSobrenome());
        resposta.setEmail(coordenadorDto.getEmail());
        resposta.setEntidadeId(coordenadorDto.getEntidadeId());
        resposta.setCriadoEm(novoCoordenador.getCriadoEm());
        resposta.setAtualizadoEm(novoCoordenador.getAtualizadoEm());

        return resposta;
    }

    // Endpoint para listar coordenadores
    @GetMapping("listar")
    public List<CoordenadorDto> buscarCoordenadores() {
        List<Coordenador> coordenadores = buscarCoordenadorUseCase.execute();
        return coordenadores.stream()
                .map(coordenador -> coordenadorDtoMapper.toDto(coordenador, null)) // Converte cada coordenador para DTO sem incluir senha
                .toList();
    }
}
