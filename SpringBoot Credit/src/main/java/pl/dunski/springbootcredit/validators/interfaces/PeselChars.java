package pl.dunski.springbootcredit.validators.interfaces;

import pl.dunski.springbootcredit.validators.PeselConstraintValidatorChars;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

// Walidacja ktora sprawdza nam czy pesel zawiera litery ktoryc nie moze zawierac.
@Documented
@Constraint(validatedBy = PeselConstraintValidatorChars.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PeselChars {
    public String message() default "Pesel zawiera litery!";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
