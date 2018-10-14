package br.com.ope.security.jwt.auth.extractor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;

@Component
public class JwtHeaderTokenExtractor implements TokenExtractor {
	public static String HEADER_PREFIX = "Bearer ";

	@Override
	public String extract(String payload) {
		return null;
	}

	@Override
	public String extract(String header, String token) {
		if (StringUtils.isBlank(header) && StringUtils.isBlank(token)) {
			throw new AuthenticationServiceException("Authorization header cannot be blank!");
		}

		if (header != null) {
			if (header.length() < HEADER_PREFIX.length()) {
				throw new AuthenticationServiceException("Invalid authorization header size.");
			}
			return header.substring(HEADER_PREFIX.length(), header.length());
		}

		return "";
	}
}
