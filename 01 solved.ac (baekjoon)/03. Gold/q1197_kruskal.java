import java.io.*;
import java.util.*;

public class q1197_kruskal {
    public static void main(String[] args) throws IOException {
        // 입력 -> 간선 정보
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());

        ArrayList<PathInfo> pathList = new ArrayList<PathInfo>();
        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pathList.add(new PathInfo(node1, node2, weight));
        }

        // 가중치 기준 정렬
        Collections.sort(pathList);

        // processing: union-find
        int[] parents = new int[nodeCount + 1];
        for (int i = 1; i < nodeCount + 1; i++) {
            parents[i] = i;
        }

        int resultWeight = 0;
        for (PathInfo info : pathList) {
            if (union(info.from, info.to, parents)) {
                resultWeight += info.weight;
            }
        }

        // 출력
        System.out.print(resultWeight);
    }

    private static boolean union(int from, int to, int[] parents) {
        int rootA = find(from, parents);
        int rootB = find(to, parents);

        if (rootA == rootB) return false;

        parents[rootB] = rootA;
        return true;
    }

    private static int find(int node, int[] parents) {
        if (node != parents[node]) {
            parents[node] = find(parents[node], parents);
        }
        return parents[node];
    }

    private static class PathInfo implements Comparable {
        int from;
        int to;
        int weight;

        public PathInfo(int pFrom, int pTo, int pWeight) {
            from = pFrom;
            to = pTo;
            weight = pWeight;
        }

        @Override
        public int compareTo(Object o) {
            return this.weight - ((PathInfo) o).weight;
        }
    }
}
