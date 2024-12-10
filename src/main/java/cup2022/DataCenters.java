package cup2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataCenters {
    private static class Pair {
        public int r;
        public int a;

        public Pair(int r, int a) {
            this.r = r;
            this.a = a;
        }
    }

    private static int n;

    private static int m;

    private static int[][] dataCentres;

    private static Map<Integer, Pair> map = new HashMap<>();

    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();

        dataCentres = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dataCentres[i], 1);
            map.put(i + 1, new Pair(0, m));
        }

        String[] line;
        for (int i = 0; i < q; i++) {
            line = scanner.nextLine().split(" ");

            if (line.length == 1) {
                if (line[0].equals("GETMAX")) {
                    System.out.println(getMax());
                }
                else {
                    System.out.println(getMin());
                }
                continue;
            }

            if (line.length == 2) {
                resetDataCenter(Integer.parseInt(line[1]));
                continue;
            }

            disableDataCenter(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
        }

        scanner.close();
    }

    private static void disableDataCenter(int i, int j) {
        dataCentres[i - 1][j - 1] = 0;

        Pair elem = map.get(i);
        if (elem.a > 0) {
            elem.a -= 1;
        }

        map.put(i, elem);
    }

    private static void resetDataCenter(int i) {
        Arrays.fill(dataCentres[i - 1], 1);

        Pair elem = map.get(i);
        elem.r += 1;
        elem.a = m;
        map.put(i, elem);
    }

    private static int getMin() {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        Pair pair;

        for (int i = 1; i <= n; i++) {
            pair = map.get(i);
            int cur = pair.r * pair.a;

            if (cur < min) {
                min = cur;
                minIndex = i;
            }
        }

        return minIndex;
    }

    private static int getMax() {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        Pair pair;

        for (int i = 1; i <= n; i++) {
            pair = map.get(i);
            int cur = pair.r * pair.a;

            if (cur > max) {
                max = cur;
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
