package br.com.namao.integra.models.validators.Impl;

import br.com.namao.integra.models.validators.Nome;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NomeValidator implements ConstraintValidator<Nome, String> {

    private Pattern pattern = Pattern.compile("^[\\p{L}a-zA-Z0-9.\\s]{3,100}$");

    @Override
    public void initialize(Nome constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Matcher m = pattern.matcher(value);
        return m.matches();
    }
}
