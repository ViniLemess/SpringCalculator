package com.vinilemess.calculator.service;

import com.vinilemess.calculator.enums.SupportedOperations;

import java.util.List;

public interface Calculator {

    double calculate(double x, double y, SupportedOperations operation);

    List<String> listHistory();

    void clearHistory();
}
