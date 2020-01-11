package pl.dunski.springbootcredit.validators;

import pl.dunski.springbootcredit.validators.interfaces.PeselChars;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PeselConstraintValidatorChars implements ConstraintValidator<PeselChars, String> {

    // Warunek sprawdzajacy czy w peselu jest jakas litera.
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        for (char chars : s.toCharArray()) {
            if (Character.isAlphabetic(chars)) {
                return false;
            }
        }
        return true;
    }
}
