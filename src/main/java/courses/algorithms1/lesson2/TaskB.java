package courses.algorithms1.lesson2;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isConstant = true;
        boolean isAscending = true;
        boolean isWeaklyAscending = true;
        boolean isDescending = true;
        boolean isWeaklyDescending = true;
        int prev = scanner.nextInt();
        while (scanner.hasNextInt()) {
            int cur = scanner.nextInt();
            if (cur == -2e9) {
                break;
            }
            if (cur == prev) {
                isAscending = false;
                isDescending = false;
            }
            else if (prev < cur) {
                isConstant = false;
                isDescending = false;
                isWeaklyDescending = false;
            }
            else {
                isConstant = false;
                isAscending = false;
                isWeaklyAscending = false;
            }
            prev = cur;
        }

        if (isConstant) {
            System.out.println("CONSTANT");
        }
        else if (isAscending) {
            System.out.println("ASCENDING");
        }
        else if (isWeaklyAscending) {
            System.out.println("WEAKLY ASCENDING");
        }
        else if (isDescending) {
            System.out.println("DESCENDING");
        }
        else if (isWeaklyDescending) {
            System.out.println("WEAKLY DESCENDING");
        }
        else {
            System.out.println("RANDOM");
        }

        scanner.close();
    }
}
