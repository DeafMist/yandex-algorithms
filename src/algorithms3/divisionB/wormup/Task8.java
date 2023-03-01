package algorithms3.divisionB.wormup;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;

        int k = scanner.nextInt();
        for (int i = 0; i < k; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (x < x1) {
                x1 = x;
            }

            if (x > x2) {
                x2 = x;
            }

            if (y < y1) {
                y1 = y;
            }

            if (y > y2) {
                y2 = y;
            }
        }

        System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);

        scanner.close();
    }
}
