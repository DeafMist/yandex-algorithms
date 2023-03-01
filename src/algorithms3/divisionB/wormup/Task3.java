package algorithms3.divisionB.wormup;

import java.util.*;
import java.util.stream.Collectors;

//TODO: Time limit, need in optimization
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> stickers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stickers.add(scanner.nextInt());
        }

        stickers = new HashSet<>(stickers).stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        int k = scanner.nextInt();
        for (int i = 0; i < k; i++) {
            int pi = scanner.nextInt();
            int res = binarySearch(stickers, pi);
            System.out.println(res + 1);
        }

        scanner.close();
    }

    private static int binarySearch(List<Integer> stickers, int pi) {
        int left = 0;
        int right = stickers.size() - 1;
        while (left < right) {
            int m = (left + right + 1) / 2;
            if (stickers.get(m) < pi) {
                left = m;
            }
            else {
                right = m - 1;
            }
        }

        if (stickers.get(right) >= pi) {
            return -1;
        }

        return right;
    }
}
