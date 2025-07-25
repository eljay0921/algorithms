import java.io.*;
import java.util.*;

public class q2467 {
    
    public static void main(String[] args) throws IOException {

        // (1) 입력 및 전처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // (2) processing
        int left = 0;
        int right = count - 1;
        int minSum = Integer.MAX_VALUE;
        int[] result = new int[2];
        while (left < right) {

            int sum = nums[left] + nums[right];
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                result[0] = nums[left];
                result[1] = nums[right];

                if (minSum == 0) {
                    break;
                }
            }
            
            if (sum < 0) {
                left++;
            } else {
                right--;
            }

        }

        System.out.println(result[0] + " " + result[1]);
    }
}
