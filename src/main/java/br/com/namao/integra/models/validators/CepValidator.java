package br.com.namao.integra.models.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CepValidator implements ConstraintValidator<CEP, String> {

    private Pattern pattern = Pattern.compile("^[0-9]{8}$");

    @Override
    public void initialize(CEP constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Matcher m = pattern.matcher(value);
        return m.matches();
    }

}
