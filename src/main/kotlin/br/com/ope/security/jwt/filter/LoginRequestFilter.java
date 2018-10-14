package br.com.ope.security.jwt.filter;

import br.com.ope.security.jwt.model.LoginRequestTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class LoginRequestFilter extends AbstractAuthenticationProcessingFilter {
	
	private final AuthenticationSuccessHandler successHandler;
	private final AuthenticationFailureHandler failureHandler;
	
	private final ObjectMapper objectMapper;
	
	public LoginRequestFilter(String defaultProcessUrl, AuthenticationSuccessHandler successHandler, AuthenticationFailureHandler failureHandler, ObjectMapper mapper) {
		super(defaultProcessUrl);
		this.successHandler = successHandler;
		this.failureHandler = failureHandler;
		this.objectMapper = mapper;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		
		LoginRequestTO loginRequestTO;
		
		try {
			loginRequestTO = objectMapper.readValue(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())), LoginRequestTO.class);
		} catch (Exception e) {
			throw new AuthenticationServiceException("Impossivel serializar a resposta.", e);
		}
		
		if (loginRequestTO == null) {
			throw new AuthenticationServiceException("Impossivel serializar a resposta.");
		}
		
		if (StringUtils.isBlank(loginRequestTO.getEmail()) || StringUtils.isBlank(loginRequestTO.getSenha())) {
			throw new AuthenticationServiceException("Usuário ou senha não inseridos.");
		}

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequestTO.getEmail(), loginRequestTO.getSenha());

		return this.getAuthenticationManager().authenticate(token);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
		successHandler.onAuthenticationSuccess(request, response, authResult);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
		SecurityContextHolder.clearContext();
		failureHandler.onAuthenticationFailure(request, response, failed);
	}
}
