package br.com.ope.util.environment.condition;

import br.com.ope.util.environment.util.EnvUtil;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class NotDevAndDefaultCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		EnvUtil.setEnvironment(context.getEnvironment());
		return !EnvUtil.isDev();
	}

}