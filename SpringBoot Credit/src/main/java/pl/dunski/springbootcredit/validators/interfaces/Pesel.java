package pl.dunski.springbootcredit.validators.interfaces;

import pl.dunski.springbootcredit.validators.PeselConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
// Walidator który sprawdza czy pesel juz istnieje w Basie danych
@Documented
@Constraint(validatedBy = PeselConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Pesel {

    public String message() default "Zajęty pesel";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
