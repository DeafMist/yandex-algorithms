package courses.algorithms3.divisionB.wormup;

import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        Map<Character, Integer> map = doInput();

        int maxCount = map.values().stream()
                .max(Comparator.naturalOrder())
                .orElse(0);

        List<Character> keys = map.keySet().stream()
                .sorted()
                .collect(Collectors.toList());

        doOutput(map, maxCount, keys);

        scanner.close();
    }

    private static void doOutput(Map<Character, Integer> map, int maxCount, List<Character> keys) {
        for (int i = maxCount; i > 0; i--) {
            for (char key : keys) {
                if (i <= map.get(key)) {
                    System.out.print("#");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (char key : keys) {
            System.out.print(key);
        }
    }

    private static Map<Character, Integer> doInput() {
        Map<Character, Integer> map = new HashMap<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char letter = line.charAt(i);
                if (letter == ' ' || letter == '\n') {
                    continue;
                }

                if (!map.containsKey(letter)) {
                    map.put(letter, 0);
                }

                map.put(letter, map.get(letter) + 1);
            }
        }

        return map;
    }
}
