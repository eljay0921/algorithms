import java.io.*;

public class Q1463 {

    private static int MIN_COUNT;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        // Back Tracking
        // MIN_COUNT = Integer.MAX_VALUE;
        // backTrack(number, 0);
        // System.out.println(MIN_COUNT);

        // DP
        int[] dp = new int[number + 1];
        dp[1] = 0;

        for (int i = 2; i <= number; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[number]);
    }

    // 종료 조건 + 현재 동작
    // 전처리 + 재귀 호출
    private static void backTrack(int startNumber, int count) {

        // 이미 최소 카운트를 넘겼다면 skip (가지치기)
        if (count >= MIN_COUNT) {
            return; 
        }

        // 종료 조건
        if (startNumber == 1) {

            MIN_COUNT = Math.min(MIN_COUNT, count);
            return;
        }

        if (startNumber % 3 == 0) {
            backTrack(startNumber / 3, count + 1);
        }

        if (startNumber % 2 == 0) {
            backTrack(startNumber / 2, count + 1);
        }

        backTrack(startNumber - 1, count + 1);
    }
}