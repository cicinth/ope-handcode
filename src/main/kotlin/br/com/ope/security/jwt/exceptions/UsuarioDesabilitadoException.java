package br.com.ope.security.jwt.exceptions;

import org.springframework.security.core.AuthenticationException;

public class UsuarioDesabilitadoException extends AuthenticationException {

    private static final long serialVersionUID = -5833779298861613046L;

    public UsuarioDesabilitadoException(String msg, Throwable t) {
        super(msg, t);
    }

    public UsuarioDesabilitadoException(String msg) {
        super(msg);
    }
}