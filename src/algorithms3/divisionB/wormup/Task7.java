package algorithms3.divisionB.wormup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;

public class Task7 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] time1 = br.readLine().split(":");
            String[] time2 = br.readLine().split(":");
            String[] time3 = br.readLine().split(":");

            int plus = 0;
            if (Integer.parseInt(time3[0]) < Integer.parseInt(time1[0])) {
                plus = 24 * 3600;
            }

            long sec1 = Integer.parseInt(time1[0]) * 3600L + Integer.parseInt(time1[1]) * 60L + Integer.parseInt(time1[2]);
            long sec2 = Integer.parseInt(time2[0]) * 3600L + Integer.parseInt(time2[1]) * 60L + Integer.parseInt(time2[2]);
            long sec3 = Integer.parseInt(time3[0]) * 3600L + Integer.parseInt(time3[1]) * 60L + Integer.parseInt(time3[2]) + plus;

            long res = Math.round((sec3 - sec1) / 2.) + sec2;

            long hours = res / 3600;
            res -= hours * 3600;
            hours %= 24;

            long minutes = res / 60;
            res -= minutes * 60;

            long sec = res;

            StringBuilder sb = new StringBuilder();
            if (hours < 10) {
                sb.append(0);
            }
            sb.append(hours).append(":");

            if (minutes < 10) {
                sb.append(0);
            }
            sb.append(minutes).append(":");

            if (sec < 10) {
                sb.append(0);
            }
            sb.append(sec);

            System.out.println(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
