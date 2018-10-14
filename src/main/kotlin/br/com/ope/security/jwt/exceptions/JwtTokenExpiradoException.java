package br.com.ope.security.jwt.exceptions;

import br.com.ope.security.jwt.model.token.JwtToken;
import org.springframework.security.core.AuthenticationException;

public class JwtTokenExpiradoException extends AuthenticationException {
	private static final long serialVersionUID = -5959543783324224864L;
	
	private JwtToken token;

	public JwtTokenExpiradoException(String msg) {
		super(msg);
	}

	public JwtTokenExpiradoException(JwtToken token, String msg, Throwable t) {
		super(msg, t);
		this.token = token;
	}

	public String token() {
		return this.token.getToken();
	}
}
