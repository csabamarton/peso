package com.csmarton.validation;

import com.csmarton.service.CashRegisterFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegisterKeyValidator implements ConstraintValidator<RegisterKey, String> {

    @Override
    public void initialize(RegisterKey constraintAnnotation) {

    }

    @Override
    public boolean isValid(String key, ConstraintValidatorContext constraintContext) {
        if (key == null) {
            return true;
        }

        boolean isValid = false;
        if (key.equals(CashRegisterFactory.CUC) ||
                key.equals(CashRegisterFactory.HUF_BEFORE_2008) ||
                key.equals(CashRegisterFactory.HUF_AFTER_2008)) {
            isValid = true;
        }


        if (!isValid) {
            //constraintContext.disableDefaultConstraintViolation();
            //constraintContext.buildConstraintViolationWithTemplate(
            //        "{invalid.cash.register.key}"
            //).addConstraintViolation();
        }

        return isValid;
    }

}
