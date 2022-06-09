package com.vinilemess.calculator.service.implementations;


import com.vinilemess.calculator.enums.SupportedOperations;
import com.vinilemess.calculator.exceptions.NullOperationException;
import com.vinilemess.calculator.service.Calculator;
import com.vinilemess.calculator.service.Operation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class CalculatorImpl implements Calculator {

    private static HashMap<SupportedOperations, Operation> supportedOperationsMap = new HashMap<>();

    private List<String> history = new ArrayList<>();

    public void addOperation(SupportedOperations operations, Operation operation) {
        validateOperation(operations);
        validateOperation(operation);
        supportedOperationsMap.put(operations, operation);
    }
    public double calculate(double x, double y, SupportedOperations operations) {
        validateOperation(operations);
        double result = supportedOperationsMap.get(operations).calculate(x, y);
        history.add(operations +" : "+ x +", "+ y +" = "+ result);
        return result;
    }
    public List<String> listHistory() {
        return history;
    }

    public void clearHistory() {
        history.clear();
    }

    private void validateOperation(SupportedOperations operations) {
        if (operations == null) {
            throw new NullOperationException("Operation not supported!");
        }
    }
    private void validateOperation(Operation operation) {
        if (operation == null) {
            throw new NullOperationException("Operation not supported!");
        }
    }
}
