package pl.dunski.springbootcredit.validators.interfaces;

import pl.dunski.springbootcredit.validators.CustomNotNullConstraitValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
// Walidator który sprawdza nam czy wszystkie wartosci posiadaja jakies znaki
@Documented
@Constraint(validatedBy = CustomNotNullConstraitValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomNotNull {

    public String message() default "To pole nie może być puste";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
