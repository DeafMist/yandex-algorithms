package algorithms3.divisionB.wormup;

import java.util.Scanner;

//TODO: Not working on some examples, like: 3 salkdfjsldd
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        scanner.nextLine();
        char[] word = scanner.nextLine().toCharArray();

        int currentCount = 1;
        int maxCount = 1;
        int currentK = k;
        for (int i = 0; i < word.length; i++) {
            for (int j = i + 1; j < word.length; j++) {
                if (word[j] == word[i]) {
                    currentCount++;
                }
                else {
                    if (currentK > 0) {
                        currentCount++;
                        currentK--;
                    }
                    else {
                        if (currentCount > maxCount) {
                            maxCount = currentCount;
                        }
                        currentCount = 1;
                        currentK = k;
                        break;
                    }
                }
            }
        }


        if (currentCount > maxCount) {
            maxCount = currentCount;
        }

        System.out.println(maxCount);

        scanner.close();
    }
}
