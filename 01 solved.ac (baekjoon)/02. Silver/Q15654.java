import java.io.*;
import java.util.*;

public class Q15654 {

    private static int MAX, SIZE = 0;
    private static StringBuilder SB;
    private static int[] NUMS;

    public static void main(String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

            // 1. 첫 번째 라인 값
            StringTokenizer st = new StringTokenizer(br.readLine());
            MAX = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
            SIZE = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
            SB = new StringBuilder();

            // 2. 두 번째 라인 값 + 정렬
            st = new StringTokenizer(br.readLine());
            Set<Integer> sortedNums = new TreeSet<>();
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                sortedNums.add(num);
            }
            NUMS = sortedNums.stream().mapToInt(Integer::intValue).toArray();

            // 3. processing: 백트래킹
            boolean[] visited = new boolean[NUMS.length];
            int[] printNums = new int[SIZE];
            backTrack(0, visited, printNums);

        } catch (Exception e) {
            // TODO
        } finally {
            System.out.println(SB.toString());
        }

    }

    private static void backTrack(int depth, boolean[] visited, int[] printNums) {

        // 종료 조건 + 현재 동작
        // 전처리 + 다음 동작(재귀)

        if (depth >= SIZE) {
            for (int i = 0; i < SIZE; i++) {
                SB.append(printNums[i]).append(" ");
            }
            SB.append("\n");
            return;
        }

        for (int i = 0; i < NUMS.length; i++) {

            if (visited[i] == false) {
                printNums[depth] = NUMS[i];
                visited[i] = true;

                backTrack(depth + 1, visited, printNums);
                visited[i] = false;
            }

        }
    }
    
}

/*
2, 4, 5
1, 7, 8, 9
1231 1232 1233 1234
*/
