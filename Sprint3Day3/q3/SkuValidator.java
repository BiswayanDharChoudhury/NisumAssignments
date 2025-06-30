package com.nisum.NisumAssignments;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SkuValidator implements ConstraintValidator<ValidSku, String> {
    private static final String SKU_PATTERN = "^[A-Z]{3}-\\d{4}$";

    @Override
    public boolean isValid(String sku, ConstraintValidatorContext context) {
        if (sku == null) return true; 
        return sku.matches(SKU_PATTERN);
    }
}
