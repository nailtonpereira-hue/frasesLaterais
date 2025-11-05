package br.ufpb.dcx.nailton.academia.usuario;

public class UsuarioInexistenteExeption extends Exception {
    public UsuarioInexistenteExeption(String msg){
        super(msg);
    }
}
