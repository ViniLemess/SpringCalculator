package com.vinilemess.calculator.service;

import com.vinilemess.calculator.beans.CalculatorConfig;
import com.vinilemess.calculator.enums.SupportedOperations;
import com.vinilemess.calculator.exceptions.IllegalZeroDividerException;
import com.vinilemess.calculator.exceptions.NullOperationException;
import com.vinilemess.calculator.service.implementations.CalculatorImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith( SpringExtension.class )
@ContextConfiguration(classes = { CalculatorConfig.class })
class CalculatorImplTest {

    @Autowired
    private CalculatorImpl calculator;

    @Test
    void mustSumSuccessfully() {
        assertEquals(22, calculator.calculate(20, 2, SupportedOperations.SUM), 0);
    }
    @Test
    void mustSubtractSuccessfully() {
        assertEquals(18, calculator.calculate(20, 2, SupportedOperations.SUBTRACT), 0);
    }
    @Test
    void mustMultiplySuccessfully() {
        assertEquals(40, calculator.calculate(20, 2, SupportedOperations.MULTIPLY), 0);
    }
    @Test
    void mustDivideSuccessfully() {
        assertEquals(10, calculator.calculate(20, 2, SupportedOperations.DIVIDE), 0);
    }
    @Test
    void mustPowerSuccessfully() {
        assertEquals(400, calculator.calculate(20, 2, SupportedOperations.POWER), 0);
    }
    @Test
    void musValidateCalculateWithNullOperations() {
        Exception exception = assertThrows(NullOperationException.class, () -> {
           calculator.calculate(20, 30, null);
        });
        assertEquals("Operation not supported!", exception.getMessage());
    }
    @Test
    void mustValidateDivideWithZeroDivider() {
        Exception exception = assertThrows(IllegalZeroDividerException.class, () -> {
            calculator.calculate(20, 0, SupportedOperations.DIVIDE);
        });
        assertEquals("Divider cannot be 0!", exception.getMessage());
    }
    @Test
    void mustListHistorySuccessfully() {
        calculator.calculate(20, 2, SupportedOperations.SUM);
        calculator.calculate(20, 2, SupportedOperations.SUBTRACT);
        calculator.calculate(20, 2, SupportedOperations.MULTIPLY);
        calculator.calculate(20, 2, SupportedOperations.DIVIDE);
        calculator.calculate(20, 2, SupportedOperations.POWER);
        assertEquals(5, calculator.listHistory().size());
    }
    @AfterEach
    void clearHistory() {
        calculator.clearHistory();
    }
}