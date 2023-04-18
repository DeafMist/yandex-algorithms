package algorithms3.divisionB.final_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskE {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] sizes = br.readLine().split(" ");
            int n = Integer.parseInt(sizes[0]);
            int m = Integer.parseInt(sizes[1]);

            int[][] field = new int[n][m];
            for (int i = n - 1; i >= 0; i--) {
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    if (line.charAt(j) == 'x') {
                        field[i][j] = 1;
                    }
                    else {
                        field[i][j] = 0;
                    }
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
