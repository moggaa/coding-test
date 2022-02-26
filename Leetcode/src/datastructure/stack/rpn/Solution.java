package datastructure.stack.rpn;

import java.util.Stack;

class Solution {
    /*
        간단한 스택 문제. (150번)
        else문을 이용하지 않고 최대한 메서드를 활용해서 코딩해봤다.
     */

    Stack<Integer> tokenStack = new Stack<>();
    public int evalRPN(String[] tokens) {
        for (String token : tokens){
            scanToken(token);
        }
        return tokenStack.peek();
    }
    public void scanToken(String token){
        if(token.length()==1 && isOperator(token.charAt(0))){
            int num2 = tokenStack.pop();
            int num1 = tokenStack.pop();
            tokenStack.push(calTwoNum(num1,num2,token.charAt(0)));
            return;
        }
        tokenStack.push(Integer.parseInt(token));
    }
    public boolean isOperator(char tokenChar){
        return tokenChar == '+' || tokenChar == '-' || tokenChar == '*' || tokenChar == '/';
    }
    public int calTwoNum(int num1 , int num2 , char operator){
        if(operator == '+'){
            return num1 + num2;
        }
        if(operator == '-'){
            return num1 - num2;
        }
        if(operator == '*'){
            return num1 * num2;
        }
        if(operator == '/'){
            return num1 / num2;
        }
        return 0;
    }
}