package com.example.jacocotestproject;

import org.springframework.stereotype.Component;

public class Calculator {

    public long sum(long a, long b) {
        return a + b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }
}
