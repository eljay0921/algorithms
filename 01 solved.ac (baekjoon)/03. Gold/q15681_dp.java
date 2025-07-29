import java.io.*;
import java.util.*;

public class q15681_dp {
    public static void main(String[] args) throws IOException {

        // (1) 입력값 -> 확인
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int nodeRoot = Integer.parseInt(st.nextToken());
        int queryCount = Integer.parseInt(st.nextToken());

        // (2) 입력값 -> 트리(간선 정보)
        ArrayList<Integer>[] tree = new ArrayList[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i < nodeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        // v2 -> dp 적용
        int[] dp = new int[nodeCount + 1];
        boolean[] visited = new boolean[nodeCount + 1];
        dp[nodeRoot] = dfsForDP(tree, dp, nodeRoot, visited);

        // (3) 입력값 -> 쿼리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queryCount; i++) {
            
            int query = Integer.parseInt(br.readLine());
            sb.append(dp[query]).append("\n");
        }

        // (4) 출력
        System.out.print(sb);
    }

    private static int dfsForDP(ArrayList<Integer>[] tree, int[] dp, int currentNode, boolean[] visited) {
        visited[currentNode] = true;

        int count = 1;
        for (int nextNode : tree[currentNode]) {

            if (visited[nextNode] == false) {
                visited[nextNode] = true;

                count += dfsForDP(tree, dp, nextNode, visited);
            }
        }

        dp[currentNode] = count;
        return count;
    }
}
