package com.vinilemess.calculator.controller;

import com.vinilemess.calculator.enums.SupportedOperations;
import com.vinilemess.calculator.exceptions.IllegalZeroDividerException;
import com.vinilemess.calculator.service.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    @Qualifier("calculatorBean")
    private Calculator calculator;

    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @GetMapping("/calculate")
    public double calculate(@RequestParam("x") double x, @RequestParam("y") double y, @RequestParam("operation") String operation) {
        try {
            return calculator.calculate(x, y, SupportedOperations.valueOf(operation.toUpperCase()));
        } catch (IllegalArgumentException | IllegalZeroDividerException exception) {
            logger.error(exception.getMessage(), exception);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage(), exception);
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @GetMapping("/history")
    public List<String> getHistory() {
        return calculator.listHistory();
    }
}
