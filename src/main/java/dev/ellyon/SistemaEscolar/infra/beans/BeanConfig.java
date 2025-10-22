package dev.ellyon.SistemaEscolar.infra.beans;

import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;
import dev.ellyon.SistemaEscolar.core.usecase.CriarCoordenadorUseCase;
import dev.ellyon.SistemaEscolar.core.usecase.CriarCoordenadorUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    // Define o bean para o caso de uso de criar coordenador
    @Bean
    public CriarCoordenadorUseCase criarCoordenador(CoordenadorGateway coordenadorGateway){
        return new CriarCoordenadorUseCaseImpl(coordenadorGateway);
    }
}
