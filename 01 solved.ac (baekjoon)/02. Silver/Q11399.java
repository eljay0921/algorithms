import java.io.*;
import java.util.*;

public class Q11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int accumulatedTime = 0;
        int totalTimes = 0;
        for (int i = 0; i < count; i++) {
            accumulatedTime += nums[i];
            totalTimes += accumulatedTime;
        }

        System.out.println(totalTimes);
    }
}