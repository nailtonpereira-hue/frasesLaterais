package br.ufpb.dcx.nailton.academia.treino;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Exercicio implements Serializable {
    private String nome;
    private String descricao; //Talvez criar um objeto para descrição
    private List<ParteDoCorpo> musculos;

    public Exercicio(String nome, String descricao, List<ParteDoCorpo> musculo){
        this.nome = nome;
        this.descricao = descricao;
        this.musculos = musculo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ParteDoCorpo> getMusculos() {
        return musculos;
    }

    public void setMusculos(List<ParteDoCorpo> musculos) {
        this.musculos = musculos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercicio exercicio = (Exercicio) o;
        return Objects.equals(nome, exercicio.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Exercicio{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", musculos=" + musculos +
                '}';
    }
}
