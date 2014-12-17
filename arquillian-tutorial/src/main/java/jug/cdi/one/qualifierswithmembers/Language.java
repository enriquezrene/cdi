package jug.cdi.one.qualifierswithmembers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE, ElementType.METHOD,
		ElementType.PARAMETER })
public @interface Language {

	Languages value();

	@Nonbinding
	String description() default "";

	public enum Languages {
		FRENCH, ENGLISH
	}
}
