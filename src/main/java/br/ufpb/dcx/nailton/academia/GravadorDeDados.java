package br.ufpb.dcx.nailton.academia;

import br.ufpb.dcx.nailton.academia.treino.Exercicio;
import br.ufpb.dcx.nailton.academia.usuario.Usuario;

import java.io.*;
import java.util.HashMap;

public class GravadorDeDados {
    public static final String ARQUIVO_TREINOS = "treinos.dat";
    public static final String DADOS_USUARIO = "usuario.dat";


    public HashMap<String, Exercicio> recuperarExercicios() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_TREINOS))) {
            return (HashMap<String, Exercicio>) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }

    public Usuario recuperarUsuario() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DADOS_USUARIO))) {
            return (Usuario) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }

    public void salvarDadosExercicios(HashMap<String, Exercicio> exercicio) throws IOException {
        //TODO: pASSAR TAMBÉM O MAPA DOS USUÁRIOS
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_TREINOS))) {
            out.writeObject(exercicio);
        }
    }
    public void salvarDadosUsuario(Usuario usuario) throws IOException{
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DADOS_USUARIO))){
            out.writeObject(usuario);
        }
    }
}