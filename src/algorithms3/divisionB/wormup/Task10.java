package algorithms3.divisionB.wormup;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> map = new TreeMap<>();

        char[] word = scanner.nextLine().toCharArray();
        int n = word.length;
        for (int i = 0; i < n / 2; i++) {
            if (!map.containsKey(word[i])) {
                map.put(word[i], 0);
            }
            map.put(word[i], map.get(word[i]) + (i + 1) * (n - i));

            if (!map.containsKey(word[n - i - 1])) {
                map.put(word[n - i - 1], 0);
            }
            map.put(word[n - i - 1], map.get(word[n - i - 1]) + (i + 1) * (n - i));
        }

        if (n % 2 != 0) {
            if (!map.containsKey(word[(n + 1) / 2 - 1])) {
                map.put(word[(n + 1) / 2 - 1], 0);
            }
            map.put(word[(n + 1) / 2 - 1], map.get(word[(n + 1) / 2 - 1]) + (n + 1) / 2 * (1 + n - (n + 1) / 2));
        }

        for (char key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

        scanner.close();
    }
}
