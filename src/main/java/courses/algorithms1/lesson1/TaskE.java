package courses.algorithms1.lesson1;

import java.util.Random;
import java.util.Scanner;

//ToDo: Task is not working
public class TaskE {
    public static void main(String[] args) {
        test();
    }

    private static int[] doTask(int k1, int m, int k2, int p2, int n2) {
        Scanner scanner = new Scanner(System.in);
//        int k1 = scanner.nextInt();
//        int m = scanner.nextInt();
//        int k2 = scanner.nextInt();
//        int p2 = scanner.nextInt();
//        int n2 = scanner.nextInt();

        if (n2 > m) {
            //System.out.println(-1 + " " + -1);
            return new int[]{-1, -1};
            //return;
        }

        int p1 = 0;
        int n1 = 0;
        int i = m * (p2 - 1) + n2 - 1;
        int x = 1;
        while (!(i * x + 1 <= k2) || !(k2 <= (i + 1) * x)) {
            if (k2 > (i + 1) * x && k2 < i * (x + 1) + 1 || k2 < i * x + 1) {
                p1 = -1;
                n1 = -1;
                break;
            }
            x++;
        }

        if (i * (x + 1) + 1 <= k2 && k2 <= (i + 1) * (x + 1)) {
            p1 = 0;
            n1 = 0;
            if (m == 1) {
                n1 = 1;
            }
            if (k1 <= k2 * m) {
                p1 = 1;
            }
            if (n2 == 1 && p2 == 1 && k1 <= k2) {
                n1 = 1;
                p1 = 1;
            }
        }
        else {
            if (n1 != -1) {
                p1 = (k1 - 1) / (m * x) + 1;
                n1 = (k1 - m * x * (p1 - 1) - 1) / x + 1;
            }
        }

        //System.out.println(p1 + " " + n1);

        scanner.close();
        return new int[]{p1, n1};
    }

    private static void test() {
        Random random = new Random();
        int i = 1;
        while (i < 30) {
            int k1 = random.nextInt(10) + 1;
            int m = random.nextInt(10) + 1;
            int k2 = random.nextInt(10) + 1;
            int p2 = random.nextInt(10) + 1;
            int n2 = random.nextInt(10) + 1;

            int[] res = doTask(k1, m, k2, p2, n2);
            if (res[0] != -1 && res[1] != -1) {
                System.out.println("----------Test #" + (i) + "----------");
                System.out.println(k1 + " " + m + " " + k2 + " " + p2 + " " + n2);
                System.out.println(res[0] + " " + res[1]);
                i++;
            }
        }
    }
}
