import java.io.*;
import java.util.*;

public class q10989 {

    // public static void main(String[] args) throws IOException {

    //     // 입력 및 전처리
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     int count = Integer.parseInt(br.readLine());

    //     int[] nums = new int[count];
    //     for (int i = 0; i < nums.length; i++) {
    //         nums[i] = Integer.parseInt(br.readLine());
    //     }

    //     // processing : 정렬
    //     Arrays.sort(nums);

    //     // 출력
    //     StringBuilder sb = new StringBuilder();
    //     for (int num : nums) {
    //         sb.append(num).append("\n");
    //     }

    //     System.out.print(sb);
    // }

    public static void main(String[] args) throws IOException {

        // 입력 및 전처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int offset = 10001;

        int[] nums = new int[offset];
        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[num] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < offset; i++) {
            if (nums[i] > 0) {
                for (int j = 0; j < nums[i]; j++) {
                    sb.append(i).append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}
