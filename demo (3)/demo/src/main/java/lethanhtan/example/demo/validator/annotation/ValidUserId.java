package lethanhtan.example.demo.validator.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import lethanhtan.example.demo.validator.ValidCategoryIdValidator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE , FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidCategoryIdValidator.class)
public @interface ValidUserId {
    String message() default "Invail user ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
