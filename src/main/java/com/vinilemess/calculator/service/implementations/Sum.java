package com.vinilemess.calculator.service.implementations;

import com.vinilemess.calculator.service.Operation;
import org.springframework.stereotype.Component;

@Component
public class Sum implements Operation {
    @Override
    public double calculate(double parcelX, double parcelY) {
        double sum = parcelX + parcelY;
        return sum;
    }
}
