package algorithms3.divisionB.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task22 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);

            int[] dp = new int[30];
            Arrays.fill(dp, 0);
            dp[0] = 1;
            for (int i = 1; i < k; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] += dp[j];
                }
            }
            for (int i = k; i < n; i++) {
                for (int j = i - k; j < i; j++) {
                    dp[i] += dp[j];
                }
            }
            System.out.println(dp[n - 1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
