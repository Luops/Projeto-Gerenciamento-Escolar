package dev.ellyon.SistemaEscolar.infra.beans;

import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;
import dev.ellyon.SistemaEscolar.core.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    // Define o bean para o caso de uso de criar coordenador
    @Bean
    public CriarCoordenadorUseCase criarCoordenador(CoordenadorGateway coordenadorGateway){
        return new CriarCoordenadorUseCaseImpl(coordenadorGateway);
    }

    @Bean
    public BuscarTodosCoordenadoresUseCase buscarTodosCoordenadores(CoordenadorGateway coordenadorGateway) {
        return new BuscarTodosCoordenadoresUseCaseImpl(coordenadorGateway);
    }

    @Bean
    public BuscarCoordenadoresPeloNomeUseCase buscarCoordenadoresPeloNomeUseCase(CoordenadorGateway coordenadorGateway) {
        return new BuscarCoordenadoresPeloNomeUseCaseImpl(coordenadorGateway);
    }
}
