package com.vinilemess.calculator.service.implementations;

import com.vinilemess.calculator.service.Operation;
import org.springframework.stereotype.Component;

@Component
public class Power implements Operation {
    @Override
    public double calculate(double base, double exponent) {
        double power = Math.pow(base, exponent);
        return power;
    }
}
