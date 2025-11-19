package dev.ellyon.SistemaEscolar.infra.controller;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases.CriarMateriaUseCase;
import dev.ellyon.SistemaEscolar.infra.dtos.MateriaDto;
import dev.ellyon.SistemaEscolar.infra.mapper.MateriaDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/materia/")
public class MateriaController {
    private final MateriaDtoMapper materiaDtoMapper;
    private final CriarMateriaUseCase criarMateriaUseCase;

    // Constructor Injection
    public MateriaController(MateriaDtoMapper materiaDtoMapper, CriarMateriaUseCase criarMateriaUseCase) {
        this.materiaDtoMapper = materiaDtoMapper;
        this.criarMateriaUseCase = criarMateriaUseCase;
    }

    @PostMapping("criar")
    public ResponseEntity<Map<String, Object>> criarMateria(@RequestBody MateriaDto materiaDto) {
        Materia materiaDominio = materiaDtoMapper.toDomain(materiaDto);

        // Executa o caso de uso para criar um nova materia. Pega o DTO, converte para domínio e passa para o caso de uso pois ele recebe somente a entidade de domínio
        Materia novaMateria = criarMateriaUseCase.execute(materiaDominio);

        // Prepara a resposta
        MateriaDto resposta = new MateriaDto();
        resposta.setIdMateria(novaMateria.getIdMateria());
        resposta.setNome(novaMateria.getNome());
        resposta.setCriadoEm(novaMateria.getCriadoEm());
        resposta.setAtualizadoEm(novaMateria.getAtualizadoEm());
        Map<String, Object> response = new HashMap<>();
        response.put("message: ", "Materia criada com sucesso!");
        response.put("dados da Materia: ", resposta);
        return ResponseEntity.ok(response);
    }
}
