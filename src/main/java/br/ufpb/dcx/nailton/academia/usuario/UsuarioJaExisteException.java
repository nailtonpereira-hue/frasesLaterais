package br.ufpb.dcx.nailton.academia.usuario;

public class UsuarioJaExisteException extends Exception {
    public UsuarioJaExisteException(String msg){
        super(msg);
    }
}
