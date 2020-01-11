package pl.dunski.springbootcredit.validators;

import pl.dunski.springbootcredit.validators.interfaces.CustomNotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomNotNullConstraitValidator implements ConstraintValidator<CustomNotNull, String> {
    //Warunek przy ktorym za odrzucane wpisywane zmienne przez uzytkonika.
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.length() == 0) {
            return false;
        }
        return true;
    }
}
