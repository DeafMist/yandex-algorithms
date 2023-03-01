package algorithms3.divisionB.lesson1;

import java.util.Scanner;
import java.util.Stack;

public class Task15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] cities = new int[n];
        for (int i = 0; i < n; i++) {
            cities[i] = scanner.nextInt();
        }

        Stack<Integer> prices = new Stack<>();
        Stack<Integer> indexes = new Stack<>();

        for (int i = 0; i < n; i++) {
            int cur = cities[i];
            while (!prices.isEmpty() && prices.peek() > cur) {
                prices.pop();
                cities[indexes.pop()] = i;
            }
            prices.push(cur);
            indexes.push(i);
        }

        while (!indexes.isEmpty()) {
            cities[indexes.pop()] = -1;
        }

        for (int city : cities) {
            System.out.print(city + " ");
        }

        scanner.close();
    }
}
