package br.ufpb.dcx.nailton.academia.usuario;

import java.io.Serializable;

public class DadosDeUsuario implements Serializable {
    private String nome;
    private String email;

    public DadosDeUsuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
