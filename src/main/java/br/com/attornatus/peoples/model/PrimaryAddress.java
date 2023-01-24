package br.com.attornatus.peoples.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidaEnderecoPrimario.class)
public @interface PrimaryAddress {
	
	String message() default "Somente um endereço principal é permito";
	Class<?> [] groups() default {};
	Class<? extends Payload>[] payload() default{};
}