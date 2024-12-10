package courses.algorithms1.lesson2;

import java.util.*;

public class TaskF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        if (areNumbersPalindrome(numbers)) {
            System.out.println(0);
            return;
        }

        //Stack<Integer> stack =
    }

    private static boolean areNumbersPalindrome(List<Integer> numbers) {
        int n = numbers.size();
        for (int i = 0; i < n / 2; i++) {
            if (!Objects.equals(numbers.get(i), numbers.get(n - i - 1))) {
                return false;
            }
        }

        return true;
    }
}
