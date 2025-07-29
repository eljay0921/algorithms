import java.io.*;
import java.util.*;

public class q15681 {
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

        // (3) 입력값 -> 쿼리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queryCount; i++) {
            
            int query = Integer.parseInt(br.readLine());
            if (query == nodeRoot) {
                sb.append(nodeCount).append("\n");
                continue;
            }

            // (4) dfs
            boolean[] visited = new boolean[nodeCount + 1];
            int count = dfsFind(tree, nodeRoot, query, visited);
            sb.append(count).append("\n");
        }

        // (4) 출력
        System.out.print(sb);
    }

    private static int dfsFind(ArrayList<Integer>[] tree, int startNode, int queryNode, boolean[] visited) {

        visited[startNode] = true;
        if (startNode == queryNode) {
            return dfsCount(tree, startNode, visited);
        }
        
        for (int currentNode : tree[startNode]) {
            if (visited[currentNode] == false) {    

                visited[currentNode] = true;
                int result = dfsFind(tree, currentNode, queryNode, visited);
                if (result != -1) {

                    return result;
                }
            }
        }

        return -1;
    }

    private static int dfsCount(ArrayList<Integer>[] tree, int startNode, boolean[] visited) {
        // visited[startNode] = true;   // 중복

        int count = 1;
        for (int currentNode : tree[startNode]) {
            if (visited[currentNode] == false) {

                visited[currentNode] = true;
                count += dfsCount(tree, currentNode, visited);
            }
        }

        return count;
    }
}
