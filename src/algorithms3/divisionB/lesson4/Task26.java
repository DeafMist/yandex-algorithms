package algorithms3.divisionB.lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task26 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            int[][] costs = new int[n][m];
            
            for (int i = 0; i < n; i++) {
                line = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    costs[i][j] = Integer.parseInt(line[j]);
                }
            }

            for (int i = 1; i < n; i++) {
                costs[i][0] += costs[i - 1][0];
            }

            for (int j = 1; j < m; j++) {
                costs[0][j] += costs[0][j - 1];
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    costs[i][j] += Math.min(costs[i - 1][j], costs[i][j - 1]);
                }
            }

            System.out.println(costs[n - 1][m - 1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
