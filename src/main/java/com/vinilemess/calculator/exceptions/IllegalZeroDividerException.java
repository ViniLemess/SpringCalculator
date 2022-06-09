package com.vinilemess.calculator.exceptions;

public class IllegalZeroDividerException extends RuntimeException {
    public IllegalZeroDividerException() {
        super("Divider cannot be 0!");
    }
}
