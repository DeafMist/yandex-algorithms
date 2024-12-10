package courses.algorithms1.lesson1;

import java.util.Scanner;

public class TaskF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int b1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int b2 = scanner.nextInt();

        int[][] allSides = {
                {a1 + a2, Math.max(b1, b2)},
                {a1 + b2, Math.max(b1, a2)},
                {b1 + a2, Math.max(a1, b2)},
                {b1 + b2, Math.max(a1, a2)}
        };

        int min = Integer.MAX_VALUE;
        int[] minSides = new int[2];
        for (int[] sides : allSides) {
            int curMin = sides[0] * sides[1];
            if (curMin < min) {
                minSides = sides;
                min = sides[0] * sides[1];
            }
        }

        System.out.println(minSides[0] + " " + minSides[1]);
    }
}
