package algorithms3.divisionB.lesson1;

import java.util.Scanner;
import java.util.Stack;

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        int size = 0;

        String[] commands;
        while (true) {
            commands = scanner.nextLine().split(" ");

            if (commands[0].equals("push")) {
                stack.push(Integer.parseInt(commands[1]));
                size++;
                System.out.println("ok");
            }

            if (commands[0].equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println("error");
                    continue;
                }
                size--;
                System.out.println(stack.pop());
            }

            if (commands[0].equals("back")) {
                if (stack.isEmpty()) {
                    System.out.println("error");
                    continue;
                }
                System.out.println(stack.peek());
            }

            if (commands[0].equals("size")) {
                System.out.println(size);
            }

            if (commands[0].equals("clear")) {
                stack.clear();
                size = 0;
                System.out.println("ok");
            }

            if (commands[0].equals("exit")) {
                System.out.println("bye");
                break;
            }
        }

        scanner.close();
    }
}
