package courses.algorithms1.lesson1;

import java.util.Scanner;

public class TaskG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();

        int res = 0;
        while (n >= k && k >= m) {
            int blanksNumber = n / k;

            int detailsNumber = k / m;
            detailsNumber *= blanksNumber;
            n -= detailsNumber * m;

            res += detailsNumber;
        }

        System.out.println(res);

        scanner.close();
    }
}
