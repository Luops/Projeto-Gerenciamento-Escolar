package dev.ellyon.SistemaEscolar.infra.controller;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.usecase.CriarCoordenadorUseCase;
import dev.ellyon.SistemaEscolar.infra.dtos.CoordenadorDto;
import dev.ellyon.SistemaEscolar.infra.mapper.CoordenadorDtoMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/coordenador/")
public class CoordenadorController {
    private final CriarCoordenadorUseCase criarCoordenadorUseCase; // Executar caso de uso de criar coordenador
    private final CoordenadorDtoMapper coordenadorDtoMapper; // Mapper para converter entre Coordenador e CoordenadorDto

    // Constructor Injection
    public CoordenadorController(CriarCoordenadorUseCase criarCoordenadorUseCase, CoordenadorDtoMapper coordenadorDtoMapper) {
        this.criarCoordenadorUseCase = criarCoordenadorUseCase;
        this.coordenadorDtoMapper = coordenadorDtoMapper;
    }

    // Endpoint para criar um novo coordenador
    @PostMapping("criar")
    public CoordenadorDto criarCoordenador(@RequestBody CoordenadorDto coordenadorDto) {
        // Executa o caso de uso para criar um novo coordenador. Pega o DTO, converte para domínio e passa para o caso de uso pois ele recebe somente a entidade de domínio
        Coordenador coordenadorDominio  = criarCoordenadorUseCase.execute(coordenadorDtoMapper.toDomain(coordenadorDto), coordenadorDto.getEmail(), coordenadorDto.getSenha(), coordenadorDto.getEntidadeId());
        // Passa email e senha separadamente
        Coordenador novoCoordenador = criarCoordenadorUseCase.execute(
                coordenadorDominio,
                coordenadorDto.getEmail(),
                coordenadorDto.getSenha(),
                coordenadorDto.getEntidadeId()
        );

        return coordenadorDtoMapper.toDto(novoCoordenador);// Converte o coordenador criado de volta para DTO
    }

    // Endpoint para listar coordenadores
    @GetMapping("listar")
    public String listarCoordenadores() {
        return "Listando coordenadores...";
    }
}
