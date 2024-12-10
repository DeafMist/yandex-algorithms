package courses.algorithms1.lesson1;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int curTemp = scanner.nextInt();
        int desTemp = scanner.nextInt();
        scanner.nextLine();
        String mode = scanner.nextLine();
        if (mode.equals("freeze")) {
            System.out.println(Math.min(desTemp, curTemp));
        }

        if (mode.equals("heat")) {
            System.out.println(Math.max(desTemp, curTemp));
        }

        if (mode.equals("auto")) {
            System.out.println(desTemp);
        }

        if (mode.equals("fan")) {
            System.out.println(curTemp);
        }

        scanner.close();
    }
}
