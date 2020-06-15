package com.mean.world.a150_evaluateReversePolishNotation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        return twoStacks(tokens);
    }

    private int twoStacks(String[] tokens){
        if(tokens == null || tokens.length == 0) {
            throw new RuntimeException("tokens can not empty");
        }
        Stack<String> numbers = new Stack();
        //Stack<String> exps = new Stack();
        for(String item: tokens){
            if(item.equals("+")){
                numbers.push(String.valueOf(Integer.valueOf(numbers.pop()) + Integer.valueOf(numbers.pop())));
            }else if(item.equals("-")){
                int n1 = Integer.valueOf(numbers.pop());
                int n2 = Integer.valueOf(numbers.pop());
                numbers.push(String.valueOf(n2 - n1));
            }else if(item.equals("*")){
                numbers.push(String.valueOf(Integer.valueOf(numbers.pop()) * Integer.valueOf(numbers.pop())));
            }else if(item.equals("/")){
                int n3 = Integer.valueOf(numbers.pop());
                int n4 = Integer.valueOf(numbers.pop());
                numbers.push(String.valueOf(n4 / n3));
            }else {
                numbers.push(item);
            }
        }
        return Integer.valueOf(numbers.pop());
    }
}
