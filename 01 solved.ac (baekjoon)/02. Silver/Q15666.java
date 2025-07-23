import java.io.*;
import java.util.*;

public class Q15666 {
    
    public static void main(String[] args) throws IOException {
        
        // (1) 입력, 전처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        int[] nums = new int[count];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i< nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // (1)-1 정렬
        Arrays.sort(nums);

        // (2) backtracking
        StringBuilder sb = new StringBuilder();
        int[] printNums = new int[max];
        backTrack(nums, 0, 0, max, printNums, sb);

        System.out.print(sb);
    }

    private static void backTrack(int[] nums, int start, int current, int max, int[] prints, StringBuilder sb) {

        // 종료 조건 + 현재 동작
        // 전처리 + 재귀 호출

        if (current == max) {
            for (int i = 0; i < prints.length; i++) {
                sb.append(prints[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        int prevNum = 0;
        for (int i = start; i < nums.length; i++) {

            if (nums[i] == prevNum) continue; 

            prints[current] = nums[i];
            backTrack(nums, i, current + 1, max, prints, sb);
            prevNum = nums[i];
        }
    }
}

// (v1)
// 4 4 2    ->  2 4
// 9 7 9 1  ->  1 7 9
// 1 1 2 2  ->  1 2

// (v2)
// 4 4 2    ->  2 4 4
// 9 7 9 1  ->  1 7 9 9
// 1 1 2 2  ->  1 1 2 2