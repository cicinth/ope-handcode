package br.com.ope.security.jwt.model.token;

import br.com.ope.security.jwt.exceptions.JwtTokenExpiradoException;
import br.com.ope.security.jwt.exceptions.JwtTokenInvalidoException;
import io.jsonwebtoken.*;

public class RawAccessJwtToken implements JwtToken {
			
	private String token;
	
	public RawAccessJwtToken(String token) {
		this.token = token;
	}

	public Jws<Claims> parseClaims(String signingKey) {
		try {
			return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(this.token);
		} catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException ex) {
			throw new JwtTokenInvalidoException(this, "Token inválido", ex);
		} catch (ExpiredJwtException expiredEx) {
			throw new JwtTokenExpiradoException(this, "JWT Token expirado", expiredEx);
		}
	}

	@Override
	public String getToken() {
		return token;
	}

}