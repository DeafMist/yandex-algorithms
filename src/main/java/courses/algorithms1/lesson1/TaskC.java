package courses.algorithms1.lesson1;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String addNumber = validNumber(scanner.nextLine());

        for (int i = 0; i < 3; i++) {
            if (validNumber(scanner.nextLine()).equals(addNumber)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }

    private static String validNumber(String number) {
        number = number.replaceAll("[-()+]", "");

        if (number.length() == 10) {
            return number;
        }

        if (number.length() == 7) {
            return "495" + number;
        }

        return number.substring(1);
    }
}
