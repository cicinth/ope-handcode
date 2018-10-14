package br.com.ope.security.jwt.exceptions;

import org.springframework.security.authentication.AuthenticationServiceException;


public class MetodoAutenticacaoNaoSuportadoException extends AuthenticationServiceException {
	private static final long serialVersionUID = 3705043083010304496L;

	public MetodoAutenticacaoNaoSuportadoException(String msg) {
		super(msg);
	}
}
