package Assignment_Day8;
import java.util.*;

public class EvaluatePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[][] tests = {
            {"2", "1", "+", "3", "*"},        //  9
            {"4", "13", "5", "/", "+"},       // 6
            {"10", "6", "9", "3", "/", "-", "*"}, //30
            {"3", "11", "+", "5", "-"}        //  9
        };
        for (String[] test : tests) {
            System.out.println(evalRPN(test));
        }
    }
}
