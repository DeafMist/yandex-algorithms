package algorithms3.divisionB.wormup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {
    private final static String ALPHABET = "qwertyuiopasdfghjklzxcvbnm";

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int k = Integer.parseInt(br.readLine());
            String str = br.readLine();

            int strLen = str.length();
            int maxCount = 0;
            for (int i = 0; i < ALPHABET.length(); i++) {
                char letter = ALPHABET.charAt(i);

                int right = 0;
                int left = 0;
                int currentK = k;
                while (right < strLen) {
                    while (right < strLen) {
                        if (currentK == 0 && str.charAt(right) != letter) {
                            break;
                        }

                        if (currentK > 0 && str.charAt(right) != letter) {
                            currentK--;
                        }

                        right++;
                    }

                    if (right - left > maxCount) {
                        maxCount = right - left;
                    }

                    while (left < strLen && str.charAt(left) == letter) {
                        left++;
                    }

                    left++;
                    currentK++;
                }
            }

            System.out.println(maxCount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
