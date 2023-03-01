package algorithms3.divisionB.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task16 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = 100_000;
            int[] queue = new int[n];

            String[] commands;
            int front = 0;
            int back = 0;
            while (true) {
                commands = br.readLine().split(" ");

                if (commands[0].equals("push")) {
                    queue[back] = Integer.parseInt(commands[1]);
                    back = (back + 1) % n;
                    System.out.println("ok");
                }
                else if (commands[0].equals("pop")) {
                    if (front == back) {
                        System.out.println("error");
                        continue;
                    }
                    System.out.println(queue[front]);
                    front = (front + 1) % n;
                }
                else if (commands[0].equals("front")) {
                    if (front == back) {
                        System.out.println("error");
                        continue;
                    }
                    System.out.println(queue[front]);
                }
                else if (commands[0].equals("size")) {
                    if (front <= back) {
                        System.out.println(back - front);
                    }
                    else {
                        System.out.println(n - front + back);
                    }
                }
                else if (commands[0].equals("clear")) {
                    back = front;
                    System.out.println("ok");
                }
                else if (commands[0].equals("exit")) {
                    System.out.println("bye");
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
