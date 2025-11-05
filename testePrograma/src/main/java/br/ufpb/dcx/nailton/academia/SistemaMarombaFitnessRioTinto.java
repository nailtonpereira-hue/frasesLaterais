package br.ufpb.dcx.nailton.academia;

import br.ufpb.dcx.nailton.academia.treino.*;
import br.ufpb.dcx.nailton.academia.usuario.DadosDeUsuario;
import br.ufpb.dcx.nailton.academia.usuario.Sexo;
import br.ufpb.dcx.nailton.academia.usuario.Usuario;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaMarombaFitnessRioTinto implements SistemaMaromba {
    private HashMap<String, Exercicio> exercicios;
    private Usuario usuario;
    private GravadorDeDados gravador;

    public SistemaMarombaFitnessRioTinto(){
        this.exercicios = new HashMap<>();
        this.gravador = new GravadorDeDados();
        this.usuario = null;

    }


    @Override
    public void adicionaExercicio(String nome, String descicao, List<ParteDoCorpo> musculo) throws ExercicioJaExisteExeption {
        if (this.exercicios.containsKey(nome)){
            throw new ExercicioJaExisteExeption("Exercio "+nome+" ja se encontra no banco de dados");
        }else{
            Exercicio e = new Exercicio(nome, descicao,musculo);
            this.exercicios.put(nome,e);
        }
    }

    @Override
    public void removerExercicio(String nome) throws ExercicioInexistenteExeption {
        if (this.exercicios.containsKey(nome)) {
            this.exercicios.remove(nome);
        }else{
            throw new ExercicioInexistenteExeption("Exercicio "+nome+" não encontrado");
        }
    }

    @Override
    public Exercicio pesquisaExercicio(String nome) throws ExercicioInexistenteExeption {
        if(this.exercicios.containsKey(nome)){
            return this.exercicios.get(nome);
        }else {
            throw new ExercicioInexistenteExeption("Exercicio " + nome + " não foi encontrado");
        }
    }

    @Override
    public List<Exercicio> filtrarExercicioPorTipo(ParteDoCorpo tipo) throws TipoNuloException {
        if (tipo == null) {
            throw new TipoNuloException("Tipo não pode ser nulo");
        }

        return this.exercicios.values().stream()
                .filter(exercicio -> exercicio.getMusculos().contains(tipo))
                .collect(Collectors.toList());
    }

    @Override
    public void cadastraUsuario(String nome, String email, String nomeDeUsuario) {
        DadosDeUsuario dados = new DadosDeUsuario(email,nomeDeUsuario);
        usuario = new Usuario(nome,dados,null);
    }

    @Override
    public double cauculaDieta(double peso, double altura, int idade, Sexo sexo) {
        Double taxa = 0.0;
        if(sexo == Sexo.M){
            taxa = 66 + (13.7*peso) + (5.0 * altura) - (6.8 * idade);
        }
        else{
            taxa = 665 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade);
        }
        return taxa;
    }
    public double hidratacao(double peso){
        return (40*peso)/1000;
    }


    @Override
    public void salvarDados() throws IOException {
        this.gravador.salvarDadosExercicios(this.exercicios);
        this.gravador.salvarDadosUsuario(this.usuario);
    }

    @Override
    public void recuperarDados() throws IOException {
        this.exercicios = this.gravador.recuperarExercicios();
        this.usuario = this.gravador.recuperarUsuario();
    }
    public HashMap<String, Exercicio> getExercicios() {
        return exercicios;
    }

    public Usuario getUsuario() {
        return this.usuario; // Retorna o usuário ou null se não houver um cadastrado
    }
}
