import java.io.*;
import java.util.*;

public class Q11725 {

    private static ArrayList<Integer>[] TREE;
    private static int[] PARENTS;
    private static boolean[] VISITED;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        TREE = new ArrayList[count + 1];
        PARENTS = new int[count + 1];
        VISITED = new boolean[count + 1];

        // (1) 입력값 -> TREE로
        for (int i = 1; i <= count; i++) {
            TREE[i] = new ArrayList<>();
        }
        for (int i = 0; i < count - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            // 간선 정보 구축
            TREE[num1].add(num2);
            TREE[num2].add(num1);
        }

        // (2) bfs/dfs: PARENTS 찾기        
        // bfs(1);
        dfs(1, 0);

        // (3) 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= count; i++) {
            sb.append(PARENTS[i]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    // private static void bfs(int num) {
    //     ArrayDeque<Integer> queue = new ArrayDeque<>();
    //     queue.add(num);
    //     VISITED[num] = true;

    //     while (queue.isEmpty() == false) {
    //         int current = queue.poll();
    //         for (int node : TREE[current]) {
    //             if (VISITED[node] == false) {
    //                 VISITED[node] = true;
    //                 PARENTS[node] = current;
    //                 queue.add(node);
    //             }
    //         }
    //     }
    // }

    private static void dfs(int num, int parent) {

        VISITED[num] = true;
        PARENTS[num] = parent;

        for (int node : TREE[num]) {
            if (VISITED[node] == false) {
                dfs(node, num);
            }
        }
    }
}

/*
	1
   /  \
  6    4
 /    /  \
3    2    7
|
5

*/