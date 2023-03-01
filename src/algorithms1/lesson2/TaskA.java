package algorithms1.lesson2;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int prev = scanner.nextInt();
        boolean flag = true;
        while (scanner.hasNextInt()) {
            int cur = scanner.nextInt();
            if (cur <= prev) {
                flag = false;
                break;
            }
            prev = cur;
        }

        if (flag) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

        scanner.close();
    }
}
