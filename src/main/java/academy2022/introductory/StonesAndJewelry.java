package academy2022.introductory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StonesAndJewelry {
    public static int task() {
        Scanner scanner = new Scanner(System.in);

        String J = scanner.nextLine();
        String S = scanner.nextLine();

        Map<Character, Integer> jMap = new HashMap<>();

        for (int i = 0; i < J.length(); i++) {
            if (jMap.get(J.charAt(i)) == null) {
                jMap.put(J.charAt(i), 1);
            }
            else {
                jMap.put(J.charAt(i), jMap.get(J.charAt(i)) + 1);
            }
        }

        int counter = 0;

        for (int i = 0; i < S.length(); i++) {
            if (jMap.get(S.charAt(i)) != null) {
                counter++;
            }
        }

        scanner.close();

        return counter;
    }
}
