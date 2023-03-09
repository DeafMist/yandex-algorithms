package algorithms3.divisionB.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task21 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[35];
            dp[0] = 2;
            dp[1] = 4;
            dp[2] = 7;
            for (int i = 3; i < n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i -3];
            }

            System.out.println(dp[n - 1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
