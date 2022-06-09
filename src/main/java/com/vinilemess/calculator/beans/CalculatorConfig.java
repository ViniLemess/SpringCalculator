package com.vinilemess.calculator.beans;

import com.vinilemess.calculator.enums.SupportedOperations;
import com.vinilemess.calculator.service.*;
import com.vinilemess.calculator.service.implementations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com/vinilemess/calculator/beans")
public class CalculatorConfig {

    @Bean
    public Operation sumBean() {
        return new Sum();
    }
    @Bean
    public Operation subtractBean() {
        return new Subtract();
    }
    @Bean
    public Operation multiplyBean() {
        return new Multiply();
    }
    @Bean
    public Operation divideBean() {
        return new Divide();
    }
    @Bean
    public Operation powerBean() {
        return new Power();
    }
    @Bean
    public Calculator calculatorBean() {
        CalculatorImpl calculatorImpl = new CalculatorImpl();
        calculatorImpl.addOperation(SupportedOperations.SUM, sumBean());
        calculatorImpl.addOperation(SupportedOperations.SUBTRACT, subtractBean());
        calculatorImpl.addOperation(SupportedOperations.MULTIPLY, multiplyBean());
        calculatorImpl.addOperation(SupportedOperations.DIVIDE, divideBean());
        calculatorImpl.addOperation(SupportedOperations.POWER, powerBean());
        return calculatorImpl;
    }
}
