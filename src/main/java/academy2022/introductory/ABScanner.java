package academy2022.introductory;

import java.util.Scanner;

public class ABScanner {
    public static long task() {
        Scanner scanner = new Scanner(System.in);

        long A = scanner.nextLong();
        long B = scanner.nextLong();

        scanner.close();

        return A + B;
    }
}
