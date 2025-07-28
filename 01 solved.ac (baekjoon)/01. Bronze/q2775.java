import java.io.*;

public class q2775 {
    public static void main(String[] args) throws IOException {

        // dp -> 0~14층, 1~14호
        int[][] dp = new int[15][15];
        for (int i = 1; i <= 14; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= 14; i++) {     // i = 층
            for (int j = 1; j <= 14; j++) { // j = 호
                if (j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        // 입력 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int floor = Integer.parseInt(br.readLine());
            int room = Integer.parseInt(br.readLine());
            sb.append(dp[floor][room]).append("\n");
        }

        System.out.print(sb);
    }
}

/*
 * {0, 1} = 1
 * {0, 2} = 2
 * {0, 3} = 3
 * {0, 4} = 4
 * ...
 * 
 * (1, 1) = 1
 * {1, 2} = 3
 * (1, 3) = 6
 * {1, 4} = 10
 * ...
 * 
 * {2, 1} = 1
 * {2, 2} = 4
 * {2, 3} = 10
 * {2, 4} = 20
 * 
 */