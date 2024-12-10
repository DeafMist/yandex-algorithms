package academy2022.contest;

import java.util.*;

public class PastCandidates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> vacancies = new HashMap<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(",");
            vacancies.put(line[0], Integer.valueOf(line[1]));
        }

        Map<String, List<String>> candidates = new HashMap<>();
        Map<String, Integer> tasks = new HashMap<>();
        Map<String, Integer> fines = new HashMap<>();

        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            String[] line = sc.nextLine().split(",");

            String key = line[1];
            if (candidates.get(key) == null) {
                List<String> temp = new ArrayList<>();
                temp.add(line[0]);
                candidates.put(key, temp);
            }
            else {
                List<String> temp = candidates.get(key);
                //candidates.put(key, temp.add(list[0]));
            }
        }
    }
}
