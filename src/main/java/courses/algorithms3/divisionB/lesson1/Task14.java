package courses.algorithms3.divisionB.lesson1;

import java.util.*;

public class Task14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.offer(scanner.nextInt());
        }

        int number = 1;
        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && stack.peek() == number) {
                stack.pop();
            }
            else {
                while (!queue.isEmpty() && queue.element() != number) {
                    stack.push(queue.poll());
                }

                if (!queue.isEmpty() && queue.element() == number) {
                    queue.poll();
                }
                else {
                    break;
                }
            }
            number++;
        }

        if (number == n + 1) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

        scanner.close();
    }
}
