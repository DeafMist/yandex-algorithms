package courses.algorithms3.divisionB.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task19 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            List<Integer> heap = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                int function = Integer.parseInt(line[0]);

                if (function == 0) {
                    int value = Integer.parseInt(line[1]);
                    insert(value, heap);
                }
                else {
                    System.out.println(extract(heap));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void insert(int value, List<Integer> heap) {
        int index = heap.size();
        heap.add(value);

        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            int tmp1 = heap.get(index);
            int tmp2 = heap.get(parentIndex);
            if (tmp1 > tmp2) {
                heap.set(index, tmp2);
                heap.set(parentIndex, tmp1);
                index = parentIndex;
            }
            else {
                break;
            }
        }
    }

    private static int extract(List<Integer> heap) {
        int res = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        int index = 0;

        while (2 * index + 2 < heap.size()) {
            int maxValue = heap.get(2 * index + 1);
            int maxIndex = 2 * index + 1;
            if (maxValue < heap.get(2 * index + 2)) {
                maxValue = heap.get(2 * index + 2);
                maxIndex = 2 * index + 2;
            }

            if (heap.get(index) < maxValue) {
                int tmp = heap.get(index);
                heap.set(index, maxValue);
                heap.set(maxIndex, tmp);
                index = maxIndex;
            }
            else {
                break;
            }
        }

        heap.remove(heap.size() - 1);

        return res;
    }
}
