package dev.ellyon.SistemaEscolar.infra.beans;

import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;
import dev.ellyon.SistemaEscolar.core.gateway.MateriaGateway;
import dev.ellyon.SistemaEscolar.core.gateway.TurmaGateway;
import dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases.*;
import dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases.*;
import dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    // Define o bean para o caso de uso de criar coordenador
    @Bean
    public CriarCoordenadorUseCase criarCoordenador(CoordenadorGateway coordenadorGateway){
        return new CriarCoordenadorUseCaseImpl(coordenadorGateway);
    }

    // Define o bean para o caso de uso de criar materia
    @Bean
    public CriarMateriaUseCase criarMateria(MateriaGateway materiaGateway){
        return new CriarMateriaUseCaseImpl(materiaGateway);
    }

    // Define o bean para o caso de uso de criar turma
    @Bean
    public CriarTurmaUseCase criarTurma(TurmaGateway turmaGateway){
        return new CriarTurmaUseCaseImpl(turmaGateway);
    }

    /*
     * Config para Coordenador
     */
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

    /*
    * Config para Materia
    */
    @Bean
    public BuscarTodasMateriasUseCase buscarTodasMateriasUseCase(MateriaGateway materiaGateway) {
        return new BuscarTodasMateriasUseCaseImpl(materiaGateway);
    }

    @Bean
    public EditarMateriaUseCase editarMateriaUseCase(MateriaGateway materiaGateway) {
        return new EditarMateriaUseCaseImpl(materiaGateway);
    }

    @Bean
    public DeletarMateriaUseCase deletarMateriaUseCase(MateriaGateway materiaGateway){
        return new DeletarMateriaUseCaseImpl(materiaGateway);
    }

    @Bean
    public BuscarMateriaPeloIdUseCase buscarMateriaPeloIdUseCase(MateriaGateway materiaGateway){
        return new BuscarMateriaPeloIdUseCaseImpl(materiaGateway);
    }

    @Bean
    public ContarTotalMateriasUseCase contarTotalMateriasUseCase(MateriaGateway materiaGateway) {
        return new ContarTotalMateriasUseCaseImpl(materiaGateway);
    }

    @Bean
    public BuscarMateriasPeloNomeUseCase buscarMateriasPeloNomeUseCase(MateriaGateway materiaGateway) {
        return new BuscarMateriasPeloNomeUseCaseImpl(materiaGateway);
    }

    @Bean
    public BuscarMateriasEntreDatasUseCase buscarMateriasEntreDatasUseCase(MateriaGateway materiaGateway) {
        return new BuscarMateriasEntreDatasUseCaseImpl(materiaGateway);
    }

    /*
     * Config para Turma
     */
    @Bean
    public BuscarTurmaPeloIdUseCase buscarTurmaPeloIdUseCase(TurmaGateway turmaGateway){
        return new BuscarTurmaPeloIdUseCaseImpl(turmaGateway);
    }

    @Bean
    public EditarTurmaUseCase editarTurmaUseCase(TurmaGateway turmaGateway) {
        return new EditarTurmaUseCaseImpl(turmaGateway);
    }

    @Bean
    public DeletarTurmaUseCase deletarTurmaUseCase(TurmaGateway turmaGateway){
        return new DeletarTurmaUseCaseImpl(turmaGateway);
    }

    @Bean
    public ContarTotalTurmasUseCase contarTotalTurmasUseCase(TurmaGateway turmaGateway) {
        return new ContarTotalTurmasUseCaseImpl(turmaGateway);
    }

    @Bean
    public BuscarTodasTurmasUseCase buscarTodasTurmasUseCase(TurmaGateway turmaGateway) {
        return new BuscarTodasTurmasUseCaseImpl(turmaGateway);
    }

    @Bean
    public BuscarTurmaPeloNumeroUseCase buscarTurmaPeloNumeroUseCase(TurmaGateway turmaGateway) {
        return new BuscarTurmaPeloNumeroUseCaseImpl(turmaGateway);
    }

}
