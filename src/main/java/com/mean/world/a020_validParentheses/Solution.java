package com.mean.world.a020_validParentheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        return viaStack(s);
//        return replacePair(s);
    }

    /**
     * Runtime: 70 ms, faster than 5.70% of Java online submissions for Valid Parentheses.
     * Memory Usage: 51.8 MB, less than 5.04% of Java online submissions for Valid Parentheses.
     */
    private boolean replacePair(String target){
        if(target.equals("")) return true;
        String tmp = target;
        while(tmp.contains("()") || tmp.contains("[]") || tmp.contains("{}")){
            tmp = tmp.replace("()","");
            tmp = tmp.replace("[]","");
            tmp = tmp.replace("{}","");
        }
        if(tmp == "") return true;
        return false;
    }

    private boolean viaStack(String target){
        int size = target.length();
        if(size % 2 != 0) return false;//when string is "("
        int i=0;
        Stack<Character> stack = new Stack();
        boolean match = true;
        while (i < size){
            char c = target.charAt(i++);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                Character pop;
                try {
                    pop = stack.pop();
                } catch (Exception e) {//when string is "){"
                    match = false;
                    break;
                }
                if(pop == '('){
                    if(c != ')'){
                        match = false;
                        break;
                    }
                }else if(pop == '['){
                    if(c != ']'){
                        match = false;
                        break;
                    }
                }else if(pop == '{'){
                    if(c != '}'){
                        match = false;
                        break;
                    }
                }
            }
        }
        if(!stack.isEmpty()) match = false;//when string is "(("
        return match;
    }
}
