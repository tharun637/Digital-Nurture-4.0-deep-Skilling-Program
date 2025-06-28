package org.example;

public class Calculation {
    public int addition(int a,int b){
        return a+b;
    }
    public int subtraction(int a,int b){
        return a-b;
    }
    public int multiply(int a,int b){
        return a*b;
    }
    public int divide(int a,int b){
        if(b==0) throw new IllegalArgumentException("divide by zero is not possible...");
        return a/b;
    }
}