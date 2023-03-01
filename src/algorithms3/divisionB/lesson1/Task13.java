package algorithms3.divisionB.lesson1;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class Task13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        String[] expression = scanner.nextLine().split(" ");
        for (String symbol : expression) {
            if (!Objects.equals(symbol, "+") && !Objects.equals(symbol, "-") && !Objects.equals(symbol, "*")) {
                 stack.push(Integer.parseInt(symbol));
            }

            if (symbol.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }

            if (symbol.equals("-")) {
                stack.push(- stack.pop() + stack.pop());
            }

            if (symbol.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
        }

        System.out.println(stack.pop());

        scanner.close();
    }
}
