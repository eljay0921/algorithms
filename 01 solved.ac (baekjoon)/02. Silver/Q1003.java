import java.io.*;

public class Q1003 {
    
    public static void main(String[] args) throws IOException {

        // dp 초기화 및 전처리
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        // 입력 값 기준 dp에서 꺼내기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num][0]).append(" ").append(dp[num][1]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}

// 3 ->
// (2) + (1)
// (1) + (0) / (1)