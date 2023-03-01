package algorithms1.lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        int x = scanner.nextInt();
        int diff = Math.abs(numbers.get(0) - x);
        int res = numbers.get(0);
        for (int number : numbers) {
            int curDiff = Math.abs(number - x);
            if (curDiff < diff) {
                diff = curDiff;
                res = number;
            }
        }

        System.out.println(res);

        scanner.close();
    }
}
