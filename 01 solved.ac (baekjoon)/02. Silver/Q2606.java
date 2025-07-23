import java.io.*;
import java.util.*;

public class Q2606 {
    
    public static void main(String[] args) throws IOException {

        // (1) 입력 값 -> 간선 정보
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        int pairCount = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] nodeTree = new ArrayList[nodeCount + 1];   // 1-based index
        for (int i = 1; i < nodeCount + 1; i++) {
            nodeTree[i] = new ArrayList();
        }
        for (int i = 0; i < pairCount; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            nodeTree[left].add(right);
            nodeTree[right].add(left);
        }
        
        // (2) 탐색: dfs
        boolean[] visited = new boolean[nodeCount + 1];
        int count = dfs(nodeTree, visited, 1);

        // (3) 결과
        System.out.print(count);
    }

    private static int dfs(ArrayList<Integer>[] nodeTree, boolean[] visited, int currentIdx) {

        visited[currentIdx] = true;

        int count = 0;
        for (int nextIdx : nodeTree[currentIdx]) {

            if (visited[nextIdx] == false) {
                visited[nextIdx] = true;
                count += 1 + dfs(nodeTree, visited, nextIdx);
            }
        }

        return count;
    }
}
