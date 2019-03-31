package br.com.namao.integra.models.validators.Impl;

import br.com.namao.integra.models.validators.Cep;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CepValidator implements ConstraintValidator<Cep, String> {

    private Pattern pattern = Pattern.compile("^[0-9]{8}$");

    @Override
    public void initialize(Cep constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Matcher m = pattern.matcher(value);
        return m.matches();
    }

}
