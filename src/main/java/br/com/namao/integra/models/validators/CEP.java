package br.com.namao.integra.models.validators;

import br.com.namao.integra.models.validators.Impl.CepValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = CepValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CEP {

    String message() default "Cep inválido: somente números; 8 caracteres";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
