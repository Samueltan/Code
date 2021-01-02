package com.sample.interview.hackerrank;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class BalancedString {

    public static void main(String[] args) {
        List<String> list = Arrays.asList(
            "({}[])",
            "((}))",
            "(({()})))",
            "({(){}()})()({(){}()})(){()}",
            "{}()))(()()({}}{}",
            "}}}}",
            "))))",
            "{{{",
            "(((",
            "[]{}(){()}((())){{{}}}{()()}{{}{}}",
            "[[]][][]",
            "}{"
        );

        for(String s: list) {
            System.out.println(isBalanced(s));
        }
    }

    private static boolean isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if(ch == ')') {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else if (ch == '}') {
                if(!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                if(!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }

//            if (!stack.isEmpty()) {
//                switch(ch) {
//                    case '}' :
//                        if (stack.peek() == '{') {
//                            stack.pop();
//                        } else {
//                            stack.push(ch);
//                        }
//                        break;
//                    case ']' :
//                        if (stack.peek() == '[') {
//                            stack.pop();
//                        } else {
//                            stack.push(ch);
//                        }
//                        break;
//                    case ')' :
//                        if (stack.peek() == '(') {
//                            stack.pop();
//                        }  else {
//                            stack.push(ch);
//                        }
//                        break;
//                    default: stack.push(ch);
//                }
//            } else {
//                stack.push(ch);
//            }
        }

        return stack.isEmpty();
    }
}
