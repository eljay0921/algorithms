import java.io.*;

public class Q2579 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int count = Integer.parseInt(br.readLine());
        int[] stairs = new int[count + 1];
        for (int i = 1; i < count + 1; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // 조기 종료
        if (count == 1) {
            System.out.print(stairs[1]);
            return;
        } else if (count == 2) {
            System.out.print(stairs[1] + stairs[2]);
            return;
        }

        // dp
        int[] dp = new int[count + 1];
        dp[0] = 0;
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        for (int i = 3; i < count + 1; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.print(dp[count]);
    }

}

// stairs
// 0  1  2  3  4  5  6
// 0  10 20 15 25 10 20

// dp
// 0  10 30 35 55 65 

// dp[i]는 i까지의 누적 최대 합
// dp[i]는 
    // dp[i-2]에서 한번에 오르거나, 
    // dp[i-3]에서 이전 계단 stairs[i-1]까지 오른 후 오를 수 있다