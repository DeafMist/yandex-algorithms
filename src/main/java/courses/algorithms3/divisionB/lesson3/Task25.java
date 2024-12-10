package courses.algorithms3.divisionB.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task25 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] coords = new int[n];
            String[] line = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                coords[i] = Integer.parseInt(line[i]);
            }

            Arrays.sort(coords);

            int[] dp = new int[n];
            dp[0] = coords[1] - coords[0];;
            dp[1] = dp[0];

            for (int i = 2; i < n; i++) {
                int diff = coords[i] - coords[i - 1];

                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + diff;
            }

            System.out.println(dp[n - 1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
