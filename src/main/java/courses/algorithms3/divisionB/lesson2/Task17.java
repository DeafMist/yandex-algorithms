package courses.algorithms3.divisionB.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Collectors;

public class Task17 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Queue<Integer> firstPlayer = new ArrayDeque<>(
                    Arrays.stream(br.readLine().split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toCollection(ArrayDeque::new))
            );
            Queue<Integer> secondPlayer = new ArrayDeque<>(
                    Arrays.stream(br.readLine().split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toCollection(ArrayDeque::new))
            );

            int counter = 1;
            while (counter <= 1e6 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
                int firstCard = firstPlayer.poll();
                int secondCard = secondPlayer.poll();

                if ((firstCard > secondCard || firstCard == 0 && secondCard == 9) && !(firstCard == 9 && secondCard == 0)) {
                    firstPlayer.offer(firstCard);
                    firstPlayer.offer(secondCard);
                }
                else {
                    secondPlayer.offer(firstCard);
                    secondPlayer.offer(secondCard);
                }
                counter++;
            }

            if (firstPlayer.isEmpty()) {
                System.out.println("second " + (counter - 1));
            }
            else if (secondPlayer.isEmpty()) {
                System.out.println("first " + (counter - 1));
            }
            else {
                System.out.println("botva");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
