package courses.algorithms3.divisionB.final_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class TaskA {
    static class Carriage {
        String product;
        long count;

        public Carriage(String product, long count) {
            this.product = product;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            long n = Integer.parseInt(br.readLine());

            Stack<Carriage> train = new Stack<>();
            for (long i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");

                if (line[0].equals("add")) {
                    train.push(new Carriage(line[2], Integer.parseInt(line[1])));
                }
                else if (line[0].equals("delete")) {
                    int carriagesToDelete = Integer.parseInt(line[1]);
                    while (carriagesToDelete > 0) {
                        long cur = train.peek().count;
                        if (cur == carriagesToDelete) {
                            train.pop();
                            carriagesToDelete = 0;
                        }
                        else if (cur < carriagesToDelete) {
                            train.pop();
                            carriagesToDelete -= cur;
                        }
                        else {
                            train.peek().count -= carriagesToDelete;
                            carriagesToDelete = 0;
                        }
                    }
                }
                else {
                    long resToGet = 0;
                    for (Carriage carriage : train) {
                        if (carriage.product.equals(line[1])) {
                            resToGet += carriage.count;
                        }
                    }
                    System.out.println(resToGet);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
