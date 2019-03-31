package br.com.namao.integra.models.validators.Impl;

import br.com.namao.integra.models.validators.MinimumOne;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;

public class MinimumOneValidator implements ConstraintValidator<MinimumOne, Set<?>> {

    @Override
    public void initialize(MinimumOne constraintAnnotation) {

    }

    @Override
    public boolean isValid(Set<?> value, ConstraintValidatorContext context) {
        String msg = "";
        if (value.isEmpty()) {
            return false;
        }
        context.disableDefaultConstraintViolation();
        if (value.getClass().toString().equals("Telefone")) {
            msg = "Pelo menos um telefone deve ser registrado.";
        }

        if (value.getClass().toString().equals("EmailEntity")) {
            msg = "Pelo menos um email deve ser registrado.";
        }
        context.buildConstraintViolationWithTemplate(msg).addConstraintViolation();
        return value.size() > 0;
    }

}