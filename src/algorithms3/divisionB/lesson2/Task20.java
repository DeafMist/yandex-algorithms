package algorithms3.divisionB.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task20 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> heap = new ArrayList<>();

            String[] numbers = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                heap.add(Integer.parseInt(numbers[i]));
            }

            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(heap, i, n);
            }

            for (int i = n - 1; i >= 0; i--) {
                int tmp = heap.get(0);
                heap.set(0, heap.get(i));
                heap.set(i, tmp);
                heapify(heap, 0, i);
            }

            for (int number : heap) {
                System.out.print(number + " ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void heapify(List<Integer> heap, int i, int n) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && heap.get(l) > heap.get(largest))
            largest = l;

        if (r < n && heap.get(r) > heap.get(largest))
            largest = r;

        if (largest != i) {
            int swap = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest, swap);

            heapify(heap, largest, n);
        }
    }
}
