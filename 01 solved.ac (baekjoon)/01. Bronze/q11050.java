import java.io.*;
import java.util.StringTokenizer;

public class q11050 {

    /*
     * v1: 단순 구현
     */
    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st = new StringTokenizer(br.readLine());

    //     int n = Integer.parseInt(st.nextToken());
    //     int k = Integer.parseInt(st.nextToken());

    //     if (n == k || k == 0) {

    //         System.out.print(1);
    //     } else {

    //         int result = getFactorial(n) / (getFactorial(k) * getFactorial(n - k));
    //         System.out.print(result);
    //     }
    // }

    // private static int getFactorial(int num) {
    //     if (num <= 2) return num;

    //     int fac = 1;
    //     for (int i = 2; i <= num; i++) {
    //         fac *= i;
    //     }

    //     return fac;
    // }

    /*
     * v2: dp
     */
    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st = new StringTokenizer(br.readLine());

    //     int n = Integer.parseInt(st.nextToken());
    //     int k = Integer.parseInt(st.nextToken());

    //     if (n == k || k == 0) {
    //         System.out.print(1);
    //         return;
    //     }

    //     int[] dp = new int[n + 1];
    //     dp[0] = 0;
    //     dp[1] = 1;
    //     dp[2] = 2;
    //     for (int i = 3; i <= n; i++) {
    //         dp[i] = dp[i - 1] * i;
    //     }

    //     int result = dp[n] / (dp[k] * dp[n - k]);
    //     System.out.print(result);
    // }

    /*
     * v3: dp 2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k || k == 0) {
            System.out.print(1);
            return;
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {

            int jMax = Math.min(i, k);  // 문제에서 k는 n보다 작거나 같다.
            for (int j = 0; j <= jMax; j++) {
                
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        System.out.print(dp[n][k]);
    }
}
