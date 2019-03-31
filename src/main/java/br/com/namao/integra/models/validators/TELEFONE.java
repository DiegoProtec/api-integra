package br.com.namao.integra.models.validators;

import br.com.namao.integra.models.validators.Impl.TelefoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TelefoneValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TELEFONE {

    String message() default "Telefone inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}