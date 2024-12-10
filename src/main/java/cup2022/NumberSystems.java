package cup2022;

import java.util.Scanner;

public class NumberSystems {
    public static void task3() {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int minBase = defineMinBase(line);

        String[] left = line.substring(0, line.indexOf(" =")).split(" ");
        String[] right = line.substring(line.indexOf("= ") + 2).split(" ");

        boolean flag = false;
        for (int i = minBase; i <= 36; i++) {
            flag = sum(left, i) == sum(right, i);

            if (flag) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    private static int defineMinBase(String str) {
        int base = 1;
        for (int i = 0; i < str.length(); i++) {
            char elem = str.charAt(i);
            if (elem == '+' || elem == '-' || elem == '=' || elem == ' ') {
                continue;
            }

            int curBase = elem;

            if (Character.isDigit(elem)) {
                curBase -= 47;
            }

            if (Character.isAlphabetic(elem)) {
                curBase -= 54;
            }

            if (curBase > base) {
                base = curBase;
            }
        }

        return base;
    }

    private static int sum(String[] str, int n) {
        int total = 0;
        String prev = "";
        for (String elem : str) {
            if (!elem.equals("+") && !elem.equals("-")) {
                if (prev.equals("+") || prev.equals("")) {
                    total += Long.parseLong(elem, n);
                }

                if (prev.equals("-")) {
                    total -= Long.parseLong(elem, n);
                }
                continue;
            }
            prev = elem;
        }

        return total;
    }
}
