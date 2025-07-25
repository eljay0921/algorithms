import java.io.*;
import java.util.*;

public class Q16953 {
    
    // v1 (greedy)
    public static void main_greedy(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int origin = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int count = 0;
        while (target > origin) {

            if (target % 2 == 0) {
                target /= 2;
                count++;
            } else if (target % 10 == 1) {
                target /= 10;
                count++;
            } else {
                count = -1;
                break;
            }

            if (target == origin) {
                break;
            }
        }

        count = (target == origin) ? count + 1 : -1;
        System.out.print(count);
    }

    // v2 (bfs)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long origin = Long.parseLong(st.nextToken());
        long target = Long.parseLong(st.nextToken());

        if (target % 2 != 0 && target % 10 != 1) {  // 조기 종료
            System.out.print(-1);
            return;
        }

        ArrayDeque<long[]> queue = new ArrayDeque<long[]>();
        queue.add(new long[]{ origin, 1 });

        while (queue.isEmpty() == false) {

            long[] current = queue.poll();
            long currentNum = current[0];
            long currentCount = current[1];

            if (currentNum == target) { 
                System.out.println(currentCount);
                return;
            }

            if (currentNum * 2 <= target) { queue.add(new long[]{ currentNum * 2, currentCount + 1}); }
            if (currentNum * 10 + 1 <= target) { queue.add(new long[]{ currentNum * 10 + 1, currentCount + 1}); }
        }

        System.out.print(-1);
    }

}
