package algorithms3.divisionB.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task23 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n + 1];
            int[] prev = new int[n + 1];

            Arrays.fill(dp, 0);
            Arrays.fill(prev, 0);

            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1];
                int minIndex = i - 1;

                if (i % 2 == 0) {
                    if (dp[i / 2] < dp[i]) {
                        dp[i] = dp[i / 2];
                        minIndex = i / 2;
                    }
                }

                if (i % 3 == 0) {
                    if (dp[i / 3] < dp[i]) {
                        dp[i] = dp[i / 3];
                        minIndex = i / 3;
                    }
                }

                dp[i] += 1;
                prev[i] = minIndex;
            }

            int m = dp[n] + 1;
            int[] res = new int[m];
            res[0] = 1;
            res[m - 1] = n;
            int link = m - 2;
            int index = n;
            while (link > 0) {
                res[link--] = prev[index];
                index = prev[index];
            }

            System.out.println(dp[n]);

            for (int number : res) {
                System.out.print(number + " ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
