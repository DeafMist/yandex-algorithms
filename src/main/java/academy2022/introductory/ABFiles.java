package academy2022.introductory;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ABFiles {
    public static void task() throws FileNotFoundException {
        File inputFile = new File("input.txt");
        Scanner sc = new Scanner(inputFile);

        File outputFile = new File("output.txt");
        PrintWriter pw = new PrintWriter(outputFile);

        long AB = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::valueOf).sum();

        pw.print(AB);

        pw.close();
        sc.close();
    }
}
