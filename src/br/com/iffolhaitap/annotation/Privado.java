package br.com.iffolhaitap.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import br.com.iffolhaitap.model.Perfil;

@Retention(RUNTIME)
@Target(METHOD)
public @interface Privado {
	
	Perfil[] value() default {};
}
