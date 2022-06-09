package com.vinilemess.calculator.service;

import org.springframework.stereotype.Component;

@Component
public interface Operation {
    public double calculate(double x, double y);
}
