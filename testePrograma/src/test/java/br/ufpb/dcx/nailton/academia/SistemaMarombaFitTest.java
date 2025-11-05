package br.ufpb.dcx.nailton.academia;

import br.ufpb.dcx.nailton.academia.treino.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

public class SistemaMarombaFitTest {
    @Test
    public void ExercicoTest_Adiciona_remover_pesquisa_filtra() throws ExercicioInexistenteExeption, ExercicioJaExisteExeption, TipoNuloException {
        SistemaMarombaFitnessRioTinto testMaromba = new SistemaMarombaFitnessRioTinto();
        HashMap<String, Exercicio> exercicioMap = new HashMap<>();
        AdcionaExercioParaTest(exercicioMap, testMaromba);
        RemoveExercicioParaTest(testMaromba);

        //Test: pesquisa Afuundo e Cross Over
        try {
            testMaromba.pesquisaExercicio("Afundo");
        }catch (ExercicioInexistenteExeption e){
            fail("Lançou exeção quando não deveria");
        }

        try {
            testMaromba.removerExercicio("Cross over");
        }catch (ExercicioInexistenteExeption e){
            fail("Lançou a exeção quando não deveria");
        }

        //Test: Filtro em POSTERIOR E PEITO
        assertEquals(0,testMaromba.filtrarExercicioPorTipo(ParteDoCorpo.PEITO).size());

        try{
            testMaromba.filtrarExercicioPorTipo(ParteDoCorpo.POSTERIOR);
        }catch (TipoNuloException e){
            fail("Lançou exceção quando não deveria");
        }

        assertFalse(exercicioMap.containsKey("Supino Reto"));


    }

    private static void RemoveExercicioParaTest(SistemaMarombaFitnessRioTinto testMaromba) throws ExercicioInexistenteExeption {
        testMaromba.removerExercicio("Supino Reto");
        testMaromba.removerExercicio("Elevação Pelvica");
    }

    private static void AdcionaExercioParaTest(HashMap<String, Exercicio> exercicioMap, SistemaMarombaFitnessRioTinto testMaromba) throws ExercicioJaExisteExeption {
        testMaromba.adicionaExercicio("agachamento", "exercicio para partes inferiores", Arrays.asList(ParteDoCorpo.BICEPS,ParteDoCorpo.COSTAS));
        testMaromba.adicionaExercicio("Elevação Pelvica","Levante sua perna e escline levemnete",Arrays.asList(ParteDoCorpo.GLUTEO,ParteDoCorpo.POSTERIOR));
        testMaromba.adicionaExercicio("Supino Reto","Perfeito para areas superiores", Arrays.asList(ParteDoCorpo.BICEPS,ParteDoCorpo.PEITO));
        testMaromba.adicionaExercicio("Cross over","Ótiomo para recupera rodas as fibras do peitoral",Arrays.asList(ParteDoCorpo.PEITO));
        testMaromba.adicionaExercicio("Afundo","Ótimo para gluteos e quadriceps",Arrays.asList(ParteDoCorpo.GLUTEO, ParteDoCorpo.QUADRICEPS));
    }
}
