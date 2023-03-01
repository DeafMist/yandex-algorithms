package algorithms3.divisionB.wormup;

import java.util.Arrays;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int[][] prefixSums = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                prefixSums[i][j] = prefixSums[i - 1][j] + prefixSums[i][j - 1] - prefixSums[i - 1][j - 1] + arr[i - 1][j - 1];
            }
        }

        int x1, y1, x2, y2;
        int res;
        for (int i = 0; i < k; i++) {
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();

            res = prefixSums[x2][y2] - prefixSums[x1 - 1][y2] - prefixSums[x2][y1 - 1] + prefixSums[x1 - 1][y1 - 1];
            System.out.println(res);
        }

        scanner.close();
    }
}
