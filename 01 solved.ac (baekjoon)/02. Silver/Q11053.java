import java.io.*;
import java.util.*;

public class Q11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 탐색하면서 현재 위치 기준의 최대 길이를 담는다
        int[] dp = new int[count];
        int maxLength = 0;
        for (int i = 0; i < count; i++) {
            
            dp[i] = 1;
            for (int j = 0; j < i; j++) {               // 이전까지의 숫자를 확인
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 앞서 체크하면서 올린 count(i)와 이전(j) 베이스+1 중에 큰 값
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }
        
        System.out.print(maxLength);
    }
    
}

// A = {10, 20, 10, 30, 20, 50} 
// i=0 : 10 -> 1                        [1, ...                     maxLength = 1
// i=1 : 20 -> 2 (10)                   [1, 2, ...                  maxLength = 2
// i=2 : 10 -> 2 (10, 20)               [1, 2, 1, ...               maxLength = 2
// i=3 : 30 -> 3 (10, 20, 10)           [1, 2, 1, 3, ...            maxLength = 3
// i=4 : 20 -> 3 (10, 20, 10, 30)
// i=5 : 50 -> 4 (10, 20, 10, 30, 20)