package br.com.ope.security.jwt.provider;

import br.com.ope.model.Usuario;
import br.com.ope.security.UserDetailsServiceImpl;
import br.com.ope.security.jwt.auth.JwtAuthenticationToken;
import br.com.ope.security.jwt.config.JwtSettings;
import br.com.ope.security.jwt.exceptions.UsuarioDesabilitadoException;
import br.com.ope.security.jwt.model.token.RawAccessJwtToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@SuppressWarnings("unchecked")
public class JwtAuthenticationProvider implements AuthenticationProvider {
	private final JwtSettings jwtSettings;
    private final UserDetailsServiceImpl userDetailsService;
	
	public JwtAuthenticationProvider(JwtSettings jwtSettings, UserDetailsServiceImpl userDetailsService) {
		this.jwtSettings = jwtSettings;
		this.userDetailsService = userDetailsService;
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		RawAccessJwtToken rawAccessToken = (RawAccessJwtToken) authentication.getCredentials();

		if (StringUtils.isBlank(rawAccessToken.getToken())) {
			return new JwtAuthenticationToken(null, new ArrayList<>());
		}

		Jws<Claims> jwsClaims = rawAccessToken.parseClaims(jwtSettings.getTokenSigningKey());
		String subject = jwsClaims.getBody().getSubject();
		List<String> scopes = jwsClaims.getBody().get("scopes", List.class);
		Set<GrantedAuthority> authorities = scopes.stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toSet());
		
		Usuario context = new Usuario(subject, authorities);

        UserDetails usuario = userDetailsService.loadUserByUsername(subject);

        if (!usuario.isEnabled()) {
            throw new UsuarioDesabilitadoException("Usuario nao esta habilitado");
        }
		
		return new JwtAuthenticationToken(context, context.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
	}
}
