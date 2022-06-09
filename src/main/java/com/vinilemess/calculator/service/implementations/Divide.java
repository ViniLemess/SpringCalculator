package com.vinilemess.calculator.service.implementations;

import com.vinilemess.calculator.exceptions.IllegalZeroDividerException;
import com.vinilemess.calculator.service.Operation;
import org.springframework.stereotype.Component;

@Component
public class Divide implements Operation {
    @Override
    public double calculate(double dividend, double divider) {
        if (divider == 0) {
            throw new IllegalZeroDividerException();
        }
        double quotient = dividend / divider;
        return quotient;
    }
}
