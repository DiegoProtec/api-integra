package br.com.namao.integra.models.validators;

import br.com.namao.integra.models.validators.Impl.MinimumOneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = MinimumOneValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MinimumOne {

    String message() default "Pelo menos um deve ser registrado.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
