package courses.algorithms1.lesson2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TaskE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> dists = new ArrayList<>();
        int n = scanner.nextInt();
        int max = -1;
        for (int i = 0; i < n; i++) {
            int cur = scanner.nextInt();

            if (cur > max) {
                max = cur;
            }

            dists.add(cur);
        }

        scanner.close();

        List<Integer> candidates = new ArrayList<>();
        boolean flag;
        if (dists.get(0) == max) {
            flag = true;
        }
        else {
            flag = false;
        }
        for (int i = 1; i < n - 1; i++) {
            int candidate = dists.get(i);

            if (!flag && candidate == max) {
                flag = true;
                continue;
            }

            if (flag && candidate % 10 == 5 && candidate > dists.get(i + 1)) {
                candidates.add(candidate);
            }
        }

        int res = candidates.stream()
                .max(Comparator.naturalOrder())
                .orElse(-1);

        if (res == -1) {
            System.out.println(0);
        }
        else {
            dists.sort(Comparator.reverseOrder());
            System.out.println(dists.indexOf(res) + 1);
        }
    }
}
