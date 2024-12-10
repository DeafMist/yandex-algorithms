package courses.algorithms3.divisionB.lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Task27 {
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

            String[][] prev = new String[n][m];
            prev[0][0] = "STOP";

            for (int i = 1; i < n; i++) {
                costs[i][0] += costs[i - 1][0];
                prev[i][0] = "D";
            }

            for (int j = 1; j < m; j++) {
                costs[0][j] += costs[0][j - 1];
                prev[0][j] = "R";
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    int cur = costs[i - 1][j];
                    String index = "D";
                    if (cur < costs[i][j - 1]) {
                        cur = costs[i][j - 1];
                        index = "R";
                    }
                    costs[i][j] += cur;
                    prev[i][j] = index;
                }
            }

            System.out.println(costs[n - 1][m - 1]);

            int i = n - 1;
            int j = m - 1;

            LinkedList<String> res = new LinkedList<>();
            while (!prev[i][j].equals("STOP")) {
                if (prev[i][j].equals("R")) {
                    j -= 1;
                    res.addFirst("R");
                }
                else {
                    i -= 1;
                    res.addFirst("D");
                }
            }

            for (String str : res) {
                System.out.print(str + " ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
