package br.com.ope.security.jwt.model.token;


public enum Scopes {
	REFRESH_TOKEN;
	
	public String authority() {
		return "ROLE_" + this.name();
	}
}
