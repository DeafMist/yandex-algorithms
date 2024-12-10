package courses.algorithms3.divisionB.lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task28 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);

            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (j == 0 && i == 0) {
                        dp[0][0] = 1;
                        continue;
                    }

                    int count = 0;

                    if (i - 2 >= 0) {
                        if (j - 1 >= 0) {
                            count += dp[i - 2][j - 1];
                        }
                    }

                    if (i - 1 >= 0) {
                        if (j - 2 >= 0) {
                            count += dp[i - 1][j - 2];
                        }
                    }

                    dp[i][j] = count;
                }
            }

            System.out.println(dp[n - 1][m - 1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
