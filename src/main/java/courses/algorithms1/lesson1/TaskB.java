package courses.algorithms1.lesson1;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        int b = scanner.nextInt();
        scanner.nextLine();
        int c = scanner.nextInt();
        scanner.nextLine();

        if (a + b > c && b + c > a && a + c > b) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

        scanner.close();
    }
}
