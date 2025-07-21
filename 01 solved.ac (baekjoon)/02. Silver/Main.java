import java.io.*;
import java.util.*;

public class Main {

    private static int SIZE;
    private static int[] NUMS;
    private static StringBuilder SB;
    
    public static void main(String[] args) throws IOException {

        // 1. 입력 및 전처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        SIZE = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        NUMS = new int[count];
        for (int i = 0; i < count; i++) {
            NUMS[i] = Integer.parseInt(st.nextToken());
        }
        
        // 2. 정렬
        Arrays.sort(NUMS);       

        // 3. processing
        boolean[] visited = new boolean[NUMS.length];   // "숫자" 별 체크가 아니라, "인덱스(depth)" 별 체크로 변경
        int[] prints = new int[SIZE];
        SB = new StringBuilder();
        backTrack(0, prints, visited);

        System.out.print(SB);
    }

    private static void backTrack(int depth, int[] prints, boolean[] visited) {

        // 종료 조건 + 현재 동작
        // 전처리 + 다음 동작(재귀)

        if (depth == SIZE) {

            for (int i = 0; i < prints.length; i++) {
                SB.append(prints[i]).append(" ");
            }
            SB.append("\n");

            return;
        }

        int prev = -1;
        for (int i = 0; i < NUMS.length; i++) {

            if (visited[i] == false && NUMS[i] != prev) {

                visited[i] = true;
                prints[depth] = NUMS[i];
                
                backTrack(depth + 1, prints, visited);
                
                visited[i] = false;
                prev = NUMS[i];
            }
        }
    }
}


// 2 4 4 
// 1 7 9 9 
// 1 1 1 1