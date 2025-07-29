import java.io.*;

public class q9095_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int[] dp = new int[11]; // 1 <= n <= 10
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        // dp[4] = 7;

        StringBuilder sb = new StringBuilder();
        while (br.ready()) {
            int num = Integer.parseInt(br.readLine());
            for (int i = 4; i <= num; i++) {
                if (dp[i] == 0) {
                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
                }
            }

            sb.append(dp[num]).append("\n");
        }

        System.out.print(sb);
    }
}

// 4 -> (7)
// 1 1 1 1
// 1 1 2
// 1 2 1
// 2 1 1
// 2 2
// 1 3
// 3 1

// 3 -> (4)
/*
 * 1 1 1
 * 1 2
 * 2 1
 * 3
 */

 // 2 -> (2)
 /*
  * 1 1
  * 2
  */

// 1 -> (1)
/*
 * 1
 */