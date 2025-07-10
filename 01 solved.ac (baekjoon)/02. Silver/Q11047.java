import java.io.*;
import java.util.*;

public class Q11047 {

    private static int[] COINS;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int coinCount = Integer.parseInt(st.nextToken());
        int amount = Integer.parseInt(st.nextToken());

        COINS = new int[coinCount];
        for (int i = 0; i < coinCount; i++) { // 오름차순으로 주어지기 때문에 비싼 동전부터 검증하기 위함
            COINS[(coinCount - i) - 1] = Integer.parseInt(br.readLine());
        }

        // greedy로 변경
        int count = 0;
        for (int i = 0; i < COINS.length; i++) {
            
            if (amount == 0) break;

            count += amount / COINS[i];
            amount %= COINS[i];
        }
        System.out.print(count);
    }

    // private static int backTrack(int price, int index, int count) {

    //     // 종료 조건 + 현재 동작
    //     // 전처리 + 다음 동작(재귀)

    //     int change = price % COINS[index];
    //     count += price / COINS[index];
    //     if (change == 0) {
    //         return count;
    //     }

    //     return backTrack(change, index + 1, count);
    // }
}
