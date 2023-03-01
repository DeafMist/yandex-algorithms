package algorithms3.divisionB.lesson1;

import java.util.Scanner;
import java.util.Stack;

public class Task12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Character> stack = new Stack<>();

        String seq = scanner.nextLine();
        for (int i = 0; i < seq.length(); i++) {
            char letter = seq.charAt(i);
            if (letter == '(' || letter == '{' || letter == '[') {
                stack.push(letter);
            }

            if (letter == ')' || letter == ']' || letter == '}') {
                if (!stack.isEmpty()) {
                    char topStack = stack.peek();

                    if (topStack == '(' && letter == ')' || topStack == '[' && letter == ']' || topStack == '{' && letter == '}') {
                        stack.pop();
                    }
                    else {
                        break;
                    }
                }
                else {
                    stack.push(letter);
                    break;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }

        scanner.close();
    }
}
