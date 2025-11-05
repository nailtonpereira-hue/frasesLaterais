package br.ufpb.dcx.nailton.academia;

import br.ufpb.dcx.nailton.academia.treino.Exercicio;
import br.ufpb.dcx.nailton.academia.treino.ParteDoCorpo;
import br.ufpb.dcx.nailton.academia.usuario.DadosDeUsuario;
import br.ufpb.dcx.nailton.academia.usuario.SemanaDia;
import br.ufpb.dcx.nailton.academia.usuario.TabelaDeTreino;
import br.ufpb.dcx.nailton.academia.usuario.Usuario;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

public class GravadorDeDadosTest {
    @Test
    public void testaGravacaoExercicio()throws IOException {
        File arquivoAcademia = new File(GravadorDeDados.ARQUIVO_TREINOS);
        if(arquivoAcademia.exists()){
            arquivoAcademia.delete();
        }
        GravadorDeDados gravadorDeDados = new GravadorDeDados();
        File arquivo = new File(GravadorDeDados.ARQUIVO_TREINOS);
        assertFalse(arquivo.exists());
        HashMap<String, Exercicio> exercicioMap = new HashMap<>();
        exercicioMap.put("agachamento búlgaro", new Exercicio("agachamento búlgaro", "exercicio para partes inferiores", Collections.singletonList(ParteDoCorpo.QUADRICEPS)));
        gravadorDeDados.salvarDadosExercicios(exercicioMap);
        assertTrue(arquivo.exists());
        arquivo.delete();
    }
    @Test
    public void testaRecupercaoExercicio()throws IOException{
        File arquivoAcademia = new File(GravadorDeDados.ARQUIVO_TREINOS);
        if(arquivoAcademia.exists()){
            arquivoAcademia.delete();
        }
        GravadorDeDados gravadorDeDados = new GravadorDeDados();
        File arquivo = new File(GravadorDeDados.ARQUIVO_TREINOS);
        assertFalse(arquivo.exists());
        HashMap<String, Exercicio> exercicioMap = new HashMap<>();
        exercicioMap.put("agachamento búlgaro", new Exercicio("agachamento búlgaro", "exercicio para partes inferiores", Arrays.asList(ParteDoCorpo.QUADRICEPS)));
        gravadorDeDados.salvarDadosExercicios(exercicioMap);
        assertTrue(arquivo.exists());
        HashMap<String, Exercicio> exercicioRecuperados = gravadorDeDados.recuperarExercicios();
        Exercicio e1 = exercicioRecuperados.get("agachamento búlgaro");
        assertEquals(Arrays.asList(ParteDoCorpo.QUADRICEPS), e1.getMusculos());
        assertEquals("exercicio para partes inferiores", e1.getDescricao());
        assertEquals("agachamento búlgaro", e1.getNome());
        arquivo.delete();
    }
    @Test
    public void TestaGravação_Recuperação() throws IOException {
        File arquivoUsuario = new File(GravadorDeDados.DADOS_USUARIO);
        if(arquivoUsuario.exists()){
            arquivoUsuario.delete();
        }
        GravadorDeDados gravadorDeDados = new GravadorDeDados();
        File arquivo = new File(GravadorDeDados.DADOS_USUARIO);
        assertFalse(arquivo.exists());
        Exercicio Scott = new Exercicio("Scott","Exelente para biceps",Arrays.asList(ParteDoCorpo.BICEPS));
        List<Exercicio> treinos = new ArrayList<>();
        DadosDeUsuario dados = new DadosDeUsuario("Carlos emanuel","carlos7441@gmail.com");
        TabelaDeTreino tabela = new TabelaDeTreino(treinos, SemanaDia.SABADO);
        Usuario usuario = new Usuario("Calos",dados, tabela);

        gravadorDeDados.salvarDadosUsuario(usuario);
        assertTrue(arquivo.exists());
        Usuario usuarioRecuperado = gravadorDeDados.recuperarUsuario();
        Usuario u1 = usuarioRecuperado;
        assertEquals("Calos", u1.getNomeDeUsuario());
        assertEquals("Carlos emanuel", u1.getDados().getNome());
        assertEquals("carlos7441@gmail.com",u1.getDados().getEmail());
        arquivo.delete();
    }

}
