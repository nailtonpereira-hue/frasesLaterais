package br.ufpb.dcx.nailton.academia;

import br.ufpb.dcx.nailton.academia.treino.*;
import br.ufpb.dcx.nailton.academia.usuario.Sexo;

import java.io.IOException;
import java.util.List;

public interface SistemaMaromba {
    /**
     *
     * @param nome
     * @param descicao
     * @param musculo
     */
    public void adicionaExercicio(String nome, String descicao, List<ParteDoCorpo> musculo)throws ExercicioJaExisteExeption;

    /**
     *
     * @param nome
     */
    public void removerExercicio(String nome) throws ExercicioInexistenteExeption;

    /**
     * Busca um Exercicio no bancode dados
     * @param nome O nome do exercicio
     * @return Exercicio o exercicio equevalente ao nome passado
     */
    public Exercicio pesquisaExercicio(String nome) throws ExercicioInexistenteExeption;

    /**
     * Filtra os exercicios do banco de dados pela parte do corpo trabalhada
     * @param tipo O tipo é a parte do corpo em que este exercicio foca
     * @return Uma Lista de exercicios que trabalhão esta area corporal
     */
    public List<Exercicio> filtrarExercicioPorTipo(ParteDoCorpo tipo) throws TipoNuloException;

    public void cadastraUsuario(String nome, String email, String nomeDeUsuario);

    public double cauculaDieta(double peso, double altura, int idade, Sexo sexo);

    public double hidratacao(double peso);




    public void salvarDados() throws IOException;
    public void recuperarDados() throws IOException;
}
