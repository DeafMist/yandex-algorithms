package courses.algorithms1.lesson1;

import java.util.Scanner;

public class TaskH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int minTime = Math.max(n + (n - 1) * a, m + (m - 1) * b);
        int maxTime = Math.min(n + (n + 1) * a, m + (m + 1) * b);

        if (minTime > maxTime) {
            System.out.println(-1);
        }
        else {
            System.out.println(minTime + " " + maxTime);
        }

        scanner.close();
    }
}
