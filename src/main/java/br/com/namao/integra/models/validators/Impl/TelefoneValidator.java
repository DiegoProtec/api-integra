package br.com.namao.integra.models.validators.Impl;

import br.com.namao.integra.models.enums.TipoTelefoneEnum;
import br.com.namao.integra.models.validators.Telefone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelefoneValidator implements ConstraintValidator<Telefone, br.com.namao.integra.models.entities.Telefone> {

    @Override
    public void initialize(Telefone constraintAnnotation) {
    }

    @Override
    public boolean isValid(br.com.namao.integra.models.entities.Telefone value, ConstraintValidatorContext context) {
        if (value.getTelefone().isEmpty()) {
            return false;
        }
        if (value.getTelefone().length() == 10 || value.getTelefone().length() == 11) {
            if (value.getTipoTelefone() == TipoTelefoneEnum.CELULAR) {
                setValidationErrorMessage(context, "Telefone deve conter 11 caracteres.");
            } else {
                setValidationErrorMessage(context, "Telefone deve conter 9 caracteres");
            }
            return true;
        } else {
            return false;
        }
    }

    private void setValidationErrorMessage(ConstraintValidatorContext context, String template) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(template).addConstraintViolation();
    }
}
