package br.com.ope.security.jwt.handler;

import br.com.ope.security.jwt.exceptions.JwtTokenExpiradoException;
import br.com.ope.security.jwt.exceptions.JwtTokenInvalidoException;
import br.com.ope.security.jwt.exceptions.UsuarioDesabilitadoException;
import br.com.ope.security.jwt.model.ErrorCode;
import br.com.ope.security.jwt.model.ErrorResponseTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAwareAuthenticationFailureHandler implements AuthenticationFailureHandler {
	private final ObjectMapper mapper;
	
	@Autowired
	public AjaxAwareAuthenticationFailureHandler(ObjectMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
		
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);

		if (e instanceof JwtTokenExpiradoException) {
			mapper.writeValue(response.getWriter(), ErrorResponseTO.of("Token expirado", ErrorCode.JWT_TOKEN_EXPIRED, HttpStatus.UNAUTHORIZED));
		} else if (e instanceof UsuarioDesabilitadoException) {
			mapper.writeValue(response.getWriter(), ErrorResponseTO.of("Usuário está desabilitado", ErrorCode.AUTHENTICATION, HttpStatus.UNAUTHORIZED));
		} else if (e instanceof JwtTokenInvalidoException) {
			mapper.writeValue(response.getWriter(), ErrorResponseTO.of("Token inválido", ErrorCode.AUTHENTICATION, HttpStatus.UNAUTHORIZED));
		} else if (e instanceof BadCredentialsException) {
			mapper.writeValue(response.getWriter(), ErrorResponseTO.of("Usuario ou senha incorretos", ErrorCode.AUTHENTICATION, HttpStatus.UNAUTHORIZED));
		} else {
			mapper.writeValue(response.getWriter(), ErrorResponseTO.of("Falha de autenticação", ErrorCode.AUTHENTICATION, HttpStatus.UNAUTHORIZED));
		}
	}

}