package br.com.namao.integra.models.validators;

import br.com.namao.integra.models.entities.Telefone;
import br.com.namao.integra.models.enums.TipoTelefoneEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelefoneValidator implements ConstraintValidator<TELEFONE, Telefone> {

    @Override
    public void initialize(TELEFONE constraintAnnotation) {
    }

    @Override
    public boolean isValid(Telefone value, ConstraintValidatorContext context) {
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
