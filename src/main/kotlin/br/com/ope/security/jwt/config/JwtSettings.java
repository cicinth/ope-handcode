package br.com.ope.security.jwt.config;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtSettings {
	
	private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
	
	@Value("${token.expiration.time}")
	private String tokenExpirationTime;
	
	@Value("${token.issuer}")
	private String tokenIssuer;
	
	@Value("${token.signing.key}")
	private String tokenSigningKey;
	
	public String getTokenExpirationTime() {
		return tokenExpirationTime;
	}
	
	public void setTokenExpirationTime(String tokenExpirationTime) {
		this.tokenExpirationTime = tokenExpirationTime;
	}
	
	public SignatureAlgorithm getSignatureAlgorithm() {
		return signatureAlgorithm;
	}
	
	public void setSignatureAlgorithm(SignatureAlgorithm signatureAlgorithm) {
		this.signatureAlgorithm = signatureAlgorithm;
	}
	
	public String getTokenIssuer() {
		return tokenIssuer;
	}
	
	public void setTokenIssuer(String tokenIssuer) {
		this.tokenIssuer = tokenIssuer;
	}
	
	public String getTokenSigningKey() {
		return tokenSigningKey;
	}
	
	public void setTokenSigningKey(String tokenSigningKey) {
		this.tokenSigningKey = tokenSigningKey;
	}
}
