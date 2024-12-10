package courses.algorithms1.lesson1;

import java.util.Scanner;

public class TaskI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();

        if (a <= d && b <= e || b <= d && a <= e || b <= d && c <= e ||
                c <= d && b <= e || a <= d && c <= e || c <= d && a <= e) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

        scanner.close();
    }
}
