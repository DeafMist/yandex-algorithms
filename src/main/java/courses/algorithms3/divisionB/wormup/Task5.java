package courses.algorithms3.divisionB.wormup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task5 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int prev = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                int cur = Integer.parseInt(br.readLine());
                sum += Math.min(prev, cur);
                prev = cur;
            }

            System.out.println(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
