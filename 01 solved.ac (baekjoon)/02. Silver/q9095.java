import java.io.*;

public class q9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        StringBuilder sb = new StringBuilder();
        while(br.ready()) {
            int num = Integer.parseInt(br.readLine());
            int total = backTrack(num, 0);
            sb.append(total).append("\n");
        }

        System.out.print(sb);
    }

    private static int backTrack(int target, int current) {

        // 종료 조건 + 현재 동작
        // 전처리 + 다음 동작(재귀)

        if (current == target) return 1;
        if (current > target) return 0;

        int count = 0;
        for (int i = 1; i <= 3; i++) {  // 1, 2, 3
            count += backTrack(target, current + i);
        }

        return count;
    }
}