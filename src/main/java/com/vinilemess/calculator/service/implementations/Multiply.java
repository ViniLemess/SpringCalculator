package com.vinilemess.calculator.service.implementations;

import com.vinilemess.calculator.service.Operation;
import org.springframework.stereotype.Component;

@Component
public class Multiply implements Operation {
    @Override
    public double calculate(double factorX, double factorY) {
        double product = factorX * factorY;
        return product;
    }
}
