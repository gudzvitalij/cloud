package com.example.producer.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CardNumberValidator implements ConstraintValidator<CardNumber, String> {
    @Override
    public boolean isValid(String cardNumber, ConstraintValidatorContext constraintValidatorContext) {
        String purportedCC = cardNumber.replaceAll(" ", "");
        int sum = 0;
        for (int i = 0; i < purportedCC.length(); i++) {
            int cardNum = Integer.parseInt(Character.toString(purportedCC.charAt(i)));
            if ((purportedCC.length() - i) % 2 == 0) {
                cardNum = cardNum * 2;

                if (cardNum > 9) {
                    cardNum = cardNum - 9;
                }
            }
            sum += cardNum;
        }
        return sum % 10 == 0;
    }
}
