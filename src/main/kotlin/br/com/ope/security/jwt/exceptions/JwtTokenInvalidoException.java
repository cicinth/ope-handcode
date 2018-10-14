package br.com.ope.security.jwt.exceptions;

import br.com.ope.security.jwt.model.token.JwtToken;
import org.springframework.security.core.AuthenticationException;

public class JwtTokenInvalidoException extends AuthenticationException {
	private static final long serialVersionUID = -294671188037098603L;

	private JwtToken token;

	public JwtTokenInvalidoException(String msg) {
		super(msg);
	}

	public JwtTokenInvalidoException(JwtToken token, String msg, Throwable t) {
		super(msg, t);
		this.token = token;
	}

	public String token() {
		return this.token.getToken();
	}
}