package br.com.namao.integra.models.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = NomeValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NOME {

    String message() default "O campo deve conter 3 e no máximo 100 caracteres dos tipos: letras, números e espaços.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
