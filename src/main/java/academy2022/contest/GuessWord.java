package academy2022.contest;

import java.util.*;

public class GuessWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        String Q = sc.nextLine();

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> coincidences = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == Q.charAt(i)) {
                if (coincidences.get(S.charAt(i)) == null) {
                    coincidences.put(S.charAt(i), 1);
                }
                else {
                    coincidences.put(S.charAt(i), coincidences.get(S.charAt(i)) + 1);
                }
            }
            else if (sMap.get(S.charAt(i)) == null) {
                sMap.put(S.charAt(i), 1);
            }
            else {
                sMap.put(S.charAt(i), sMap.get(S.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == Q.charAt(i)) {
                System.out.println("correct");
                coincidences.put(S.charAt(i), coincidences.get(S.charAt(i)) - 1);

                if (coincidences.get(Q.charAt(i)) == 0) {
                    coincidences.remove(Q.charAt(i));
                }
            }
            else {
                if (sMap.get(Q.charAt(i)) != null && (coincidences.get(Q.charAt(i)) == null || Objects.equals(sMap.get(Q.charAt(i)), coincidences.get(Q.charAt(i))))) {
                    System.out.println("present");
                    sMap.put(Q.charAt(i), sMap.get(Q.charAt(i)) - 1);

                    if (sMap.get(Q.charAt(i)) == 0) {
                        sMap.remove(Q.charAt(i));
                    }
                }
                else {
                    System.out.println("absent");
                }
            }
        }
    }
}
