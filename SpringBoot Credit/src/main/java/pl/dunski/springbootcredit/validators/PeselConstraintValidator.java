package pl.dunski.springbootcredit.validators;

import pl.dunski.springbootcredit.services.CreditService;
import pl.dunski.springbootcredit.validators.interfaces.Pesel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PeselConstraintValidator implements ConstraintValidator<Pesel, String> {

    private CreditService creditService;

    public PeselConstraintValidator(CreditService creditService) {
        this.creditService = creditService;
    }
    //Warunek przy ktorym za odrzucane powstanie kredytu z istniejacym juz klientem o tym samuym peselu.
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if (s.length() == 0) {
            return false;
        }

        return creditService.ifCustomerExist(s);
    }
}
