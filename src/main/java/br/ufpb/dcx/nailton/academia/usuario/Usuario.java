package br.ufpb.dcx.nailton.academia.usuario;

import br.ufpb.dcx.nailton.academia.usuario.melhorarUsuario.Dadosfisicos;
import br.ufpb.dcx.nailton.academia.usuario.melhorarUsuario.Dieta;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {
    private String nomeDeUsuario;
    private DadosDeUsuario dados;
//    private Dadosfisicos fisico;
//    private Dieta dieta;
    private TabelaDeTreino treinos;

    public Usuario(String nomeDeUsuario, DadosDeUsuario dados, TabelaDeTreino treinos){
        this.dados = dados;
        this.treinos = treinos;
        this.nomeDeUsuario = nomeDeUsuario;
//        this.fisico = fisico;
//        this.dieta = dieta;
    }

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }

    public DadosDeUsuario getDados() {
        return dados;
    }

    public void setDados(DadosDeUsuario dados) {
        this.dados = dados;
    }

    public TabelaDeTreino getTreinos() {
        return treinos;
    }

    public void setTreinos(TabelaDeTreino treinos) {
        this.treinos = treinos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nomeDeUsuario, usuario.nomeDeUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeDeUsuario);
    }

    //    public Dadosfisicos getFisico() {
//        return fisico;
//    }
//
//    public void setFisico(Dadosfisicos fisico) {
//        this.fisico = fisico;
//    }
//
//    public Dieta getDieta() {
//        return dieta;
//    }
//
//    public void setDieta(Dieta dieta) {
//        this.dieta = dieta;
//    }
    public void cauculaMacro(){

    }

    public double TMB(Sexo sexo, double peso, int idade, double altura) {
        return 0;
    }

    public double TMT(String nivelDeItensidade, double TMB) {
        return 0;
    }

}
