package br.com.ope.security.jwt.model.token;

import br.com.ope.model.Usuario;
import br.com.ope.security.jwt.config.JwtSettings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtTokenFactory {
	
	@Autowired
	private final JwtSettings settings;

	@Autowired
	public JwtTokenFactory(JwtSettings settings) {
		this.settings = settings;
	}

	public AccessJwtToken createAccessJwtToken(Usuario userContext) {
		if (StringUtils.isBlank(userContext.getUsername())) throw new IllegalArgumentException("Não é possivel criar o token JWT sem nome de usuário");

		if (userContext.getAuthorities().isEmpty()) throw new IllegalArgumentException("Usuario não tem permissões no perfil");

		Claims claims = Jwts.claims().setSubject(userContext.getUsername());
		claims.put("scopes", userContext.getAuthorities().stream().map(s -> s.toString()).collect(Collectors.toList()));

		LocalDateTime currentTime = LocalDateTime.now();
		
		String token = Jwts.builder()
		  .setClaims(claims)
		  .setIssuer(settings.getTokenIssuer())
		  .setIssuedAt(Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant()))
		  .setExpiration(Date.from(currentTime
			  .plusMinutes(Integer.valueOf(settings.getTokenExpirationTime()))
			  .atZone(ZoneId.systemDefault()).toInstant()))
		  .signWith(settings.getSignatureAlgorithm(), settings.getTokenSigningKey())
		.compact();

		return new AccessJwtToken(token, claims);
	}
}
