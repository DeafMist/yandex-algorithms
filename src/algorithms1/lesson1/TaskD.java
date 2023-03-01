package algorithms1.lesson1;

import java.util.Scanner;

public class TaskD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        int b = scanner.nextInt();
        scanner.nextLine();
        int c = scanner.nextInt();
        scanner.nextLine();

        if (c < 0) {
            System.out.println("NO SOLUTION");
        }
        else {
            if (a == 0) {
                if (b == c * c) {
                    System.out.println("MANY SOLUTIONS");
                }
                else {
                    System.out.println("NO SOLUTION");
                }
            }
            else {
                int x = c * c - b;
                if (x % a == 0) {
                    System.out.println(x / a);
                }
                else {
                    System.out.println("NO SOLUTION");
                }
            }
        }
        scanner.close();
    }
}
