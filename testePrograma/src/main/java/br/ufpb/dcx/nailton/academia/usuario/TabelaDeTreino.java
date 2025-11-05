package br.ufpb.dcx.nailton.academia.usuario;

import br.ufpb.dcx.nailton.academia.treino.Exercicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabelaDeTreino implements Serializable {
    private List<Exercicio> exercicios;
    private SemanaDia dia;

    public TabelaDeTreino(List<Exercicio> exercicios, SemanaDia dia){
        this.exercicios = exercicios;
        this.dia = dia;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public SemanaDia getDia() {
        return dia;
    }

    public void setDia(SemanaDia dia) {
        this.dia = dia;
    }

    public List<Exercicio> filtrarExercicioPorDia(SemanaDia dia) {
        if (this.dia.equals(dia)) {
            return new ArrayList<>(this.exercicios); // Retorna os exercícios se o dia corresponder
        }
        return Collections.emptyList(); // Retorna uma lista vazia se o dia não corresponder
    }

}
