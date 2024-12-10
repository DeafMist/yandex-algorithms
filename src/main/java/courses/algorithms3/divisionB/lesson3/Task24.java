package courses.algorithms3.divisionB.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task24 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] a = new int[n + 3];
            int[] b = new int[n + 3];
            int[] c = new int[n + 3];

            a[0] = Integer.MAX_VALUE;
            a[1] = Integer.MAX_VALUE;
            a[2] = Integer.MAX_VALUE;

            b[0] = Integer.MAX_VALUE;
            b[1] = Integer.MAX_VALUE;
            b[2] = Integer.MAX_VALUE;

            c[0] = Integer.MAX_VALUE;
            c[1] = Integer.MAX_VALUE;
            c[2] = Integer.MAX_VALUE;

            for (int i = 3; i < n + 3; i++) {
                String[] line = br.readLine().split(" ");
                a[i] = Integer.parseInt(line[0]);
                b[i] = Integer.parseInt(line[1]);
                c[i] = Integer.parseInt(line[2]);
            }

            int[] dp = new int[n + 3];
            dp[0] = 0;
            dp[1] = 0;
            dp[2] = 0;

            for (int i = 3; i < n + 3; i++) {
                int min = Math.min(
                        Math.min(a[i] + dp[i - 1], b[i - 1] + dp[i - 2]),
                        c[i - 2] + dp[i - 3]
                );
                dp[i] = min;
            }

            System.out.println(dp[n + 2]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
