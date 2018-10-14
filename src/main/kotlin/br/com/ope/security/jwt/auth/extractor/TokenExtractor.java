package br.com.ope.security.jwt.auth.extractor;

public interface TokenExtractor {
	public String extract(String payload);

	public String extract(String payload, String token); // TODO quando os projetos implementarem o JWT, esse metodo será excluido
}
