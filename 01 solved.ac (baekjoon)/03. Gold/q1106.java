import java.io.*;
import java.util.*;

public class q1106 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int targets = Integer.parseInt(st.nextToken());
        int cities = Integer.parseInt(st.nextToken());

        int[] cost = new int[cities];
        int[] gain = new int[cities];
        for (int i = 0; i < cities; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());  // 홍보 비용
            gain[i] = Integer.parseInt(st.nextToken());  // 고객 유치
        }

        int[] dp = new int[targets + 1];
        Arrays.fill(dp, 1000000);   // 임의의 큰 값을 넣음
        dp[0] = 0;
        for (int i = 1; i <= targets; i++) {
            for (int j = 0; j < cities; j++) {

                dp[i] = Math.min(dp[i], dp[Math.max(0, i - gain[j])] + cost[j]);
            }
        }

        System.out.print(dp[targets]);
    }
}

/*
예제 입력 1 기준,
12 2
3 5
1 1

0 - cost:3 gain:5
1 - cost:1 gain:1

dp[0] = 0
dp[1] = 1
dp[2] = 2
dp[3] = 3
dp[4] = 3
dp[5] = 3
dp[6] = 4
...
*/


/*
예제 입력 2 기준,
10 3
3 1
2 2
1 3

0 - cost:3 gain:1
1 - cost:2 gain:2
2 - cost:1 gain:3

dp[0] = 0
dp[1] = 1
dp[2] = 1
dp[3] = 1
dp[4] = 2
dp[5] = 2
dp[6] = 2
...
*/
