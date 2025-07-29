import java.io.*;
import java.util.StringTokenizer;

public class q2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());   // 올라갈 수 있는 거리
        int b = Integer.parseInt(st.nextToken());   // 미끄러지는 거리
        int v = Integer.parseInt(st.nextToken());   // 총 높이

        int days = (int) Math.ceil((double)(v - a) / (a - b)) + 1;
        
        System.out.print(days);
    }
}

// 2, 1, 5
// 2 1 -> 3 2 -> 4 3 -> 5 = 4일

// 5, 1, 6
// 5 4 -> 9 = 2일

// 100 99 1000000000
// 100 1 -> 101 2 -> 102 -> 3 -> 103 4 -> ... = 999999901