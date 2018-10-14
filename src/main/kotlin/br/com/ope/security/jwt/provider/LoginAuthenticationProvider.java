package br.com.ope.security.jwt.provider;

import br.com.ope.security.UserDetailsServiceImpl;
import br.com.ope.security.jwt.exceptions.UsuarioDesabilitadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {
	private BCryptPasswordEncoder encoder;

	private UserDetailsServiceImpl usuarioNameRepository;

	@Autowired
	public LoginAuthenticationProvider(UserDetailsServiceImpl usuarioNameRepository) {
		this.usuarioNameRepository = usuarioNameRepository;
		this.encoder = new BCryptPasswordEncoder();
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		Assert.notNull(authentication, "Dados de autenticação não inseridos");

		String login = (String) authentication.getPrincipal();
		String senha = (String) authentication.getCredentials();

		//TODO UsuarioAuth
		UserDetails usuario = usuarioNameRepository.loadUserByUsername(login);

		if (!encoder.matches(senha, usuario.getPassword())) {
			throw new BadCredentialsException("Usuário ou senha estão incorretos");
		}

		if (!usuario.isEnabled()) {
		    throw new UsuarioDesabilitadoException("Usuario nao esta habilitado");
        }

		return new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
}
