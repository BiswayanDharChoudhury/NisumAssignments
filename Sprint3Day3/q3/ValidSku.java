package com.nisum.NisumAssignments;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SkuValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSku {
    String message() default "Invalid SKU format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
