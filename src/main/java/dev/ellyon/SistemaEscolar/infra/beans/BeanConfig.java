package dev.ellyon.SistemaEscolar.infra.beans;

import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;
import dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases.*;
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

    @Bean
    public BuscarCoordenadoresEntreDatasUseCase buscarCoordenadoresPelaDataDeCadastroUseCase(CoordenadorGateway coordenadorGateway) {
        return new BuscarCoordenadoresEntreDatasUseCaseImpl(coordenadorGateway);
    }

    @Bean
    public BuscarCoordenadorPelaEntidadeIdUseCase buscarCoordenadorPelaEntidadeIdUseCase(CoordenadorGateway coordenadorGateway) {
        return new BuscarCoordenadorPelaEntidadeIdUseCaseImpl(coordenadorGateway);
    }

    @Bean
    public BuscarCoordenadoresPeloEmailUseCase buscarCoordenadoresPeloEmailUseCase(CoordenadorGateway coordenadorGateway) {
        return new BuscarCoordenadoresPeloEmaiUseCaseImpl(coordenadorGateway);
    }

    @Bean
    public EditarCoordenadorUseCase editarCoordenadorUseCase(CoordenadorGateway coordenadorGateway) {
        return new EditarCoordenadorUseCaseImpl(coordenadorGateway);
    }

    @Bean
    public BuscarCoordenadorPeloIdUseCase buscarCoordenadorPeloIdUseCase(CoordenadorGateway coordenadorGateway){
        return new BuscarCoordenadorPeloIdUseCaseImpl(coordenadorGateway);
    }

    @Bean public DeletarCoordenadorUseCase deletarCoordenadorUseCase(CoordenadorGateway coordenadorGateway){
        return new DeletarCoordenadorUseCaseImpl(coordenadorGateway);
    }

    @Bean
    public ContarTotalCoordenadoresUseCase contarTotalCoordenadoresUseCase(CoordenadorGateway coordenadorGateway) {
        return new ContarTotalCoordenadoresUseCaseImpl(coordenadorGateway);
    }
}
