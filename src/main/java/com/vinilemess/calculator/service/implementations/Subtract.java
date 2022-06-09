package com.vinilemess.calculator.service.implementations;

import com.vinilemess.calculator.service.Operation;
import org.springframework.stereotype.Component;

@Component
public class Subtract implements Operation {
    @Override
    public double calculate(double addtive, double subtractive) {
        double difference = addtive - subtractive;
        return difference;
    }
}
