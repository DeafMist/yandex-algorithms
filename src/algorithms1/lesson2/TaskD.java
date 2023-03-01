package algorithms1.lesson2;

import java.util.Scanner;

public class TaskD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int prev = 0;
        int cur = 0;
        int next = 0;

        if (scanner.hasNextInt()) {
            cur = scanner.nextInt();
        }

        if (scanner.hasNextInt()) {
            next = scanner.nextInt();
        }

        int counter = 0;
        while (scanner.hasNextInt()) {
            prev = cur;
            cur = next;
            next = scanner.nextInt();
            if (cur > prev && cur > next) {
                counter++;
            }
        }
        System.out.println(counter);
        scanner.close();
    }
}
