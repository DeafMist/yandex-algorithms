package courses.algorithms3.divisionB.wormup;

import java.util.*;

public class Task6 {
    static class  Pair {
        public final int start;

        public final int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();

        int n = scanner.nextInt();

        List<Pair> os = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            Pair pair = new Pair(a, b);
            Iterator<Pair> iterator = os.iterator();
            while (iterator.hasNext()) {
                Pair elem = iterator.next();
                if (pair.start <= elem.start && pair.end >= elem.start ||
                        elem.start <= pair.start && elem.end >= pair.start) {
                    iterator.remove();
                }
            }
            os.add(pair);
        }

        System.out.println(os.size());

        scanner.close();
    }
}
