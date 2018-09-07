package br.com.ope.util.environment.util;

import br.com.ope.util.environment.enumx.EnvProfile;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvUtil implements ApplicationContextAware {

	private static Environment environment;

	private static String profile = EnvProfile.DEFAULT;

	public static void setEnvironment(Environment env) {

		if (environment != null) {
			return;
		}

		environment = env;

		if (env.getActiveProfiles().length > 0) {
			profile = env.getActiveProfiles()[0];
		} else {
			profile = env.getDefaultProfiles()[0];
		}

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		setEnvironment(applicationContext.getEnvironment());
	}

	public static Environment getEnvironment() {
		return environment;
	}

	public static String getProfile() {
		return profile;
	}

	public static boolean isProd() {
		return EnvProfile.PROD.equals(profile);
	}

	public static boolean isStage() {
		return EnvProfile.STAGE.equals(profile);
	}

	public static boolean isHomolog() {
		return EnvProfile.HOMOLOG.equals(profile);
	}

	public static boolean isOnlyDev() {
		return EnvProfile.DEV.equals(profile);
	}

	public static boolean isOnlyDefault() {
		return EnvProfile.DEFAULT.equals(profile);
	}

	public static boolean isOnlyTest() {
		return EnvProfile.TEST.equals(profile);
	}

	public static boolean isDev() {
		return isOnlyDev() || isOnlyDefault() || isOnlyTest();
	}
}