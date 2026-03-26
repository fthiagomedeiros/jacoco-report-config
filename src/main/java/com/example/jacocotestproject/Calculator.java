package com.example.jacocotestproject;


public class Calculator {

    public long sum(long a, long b) {
        return a + b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public long subtract(long a, long b) {
        return a - b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            return -1;
        }
        return a / b;
    }
}
