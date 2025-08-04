import java.io.*;
import java.util.*;

public class q1197_prim {
    public static void main(String[] args) throws IOException {

        // 입력 -> 간선 정보
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());

        ArrayList<PathInfo>[] pathListArray = new ArrayList[nodeCount + 1];
        for (int i = 1; i < nodeCount + 1; i++) {
            pathListArray[i] = new ArrayList<PathInfo>();
        }

        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pathListArray[node1].add(new PathInfo(node2, weight));
            pathListArray[node2].add(new PathInfo(node1, weight));
        }

        // processing: prim
        boolean[] visited = new boolean[nodeCount + 1];
        int result = prim(pathListArray, visited, 1);

        // 출력
        System.out.print(result);
    }

    private static int prim(ArrayList<PathInfo>[] paths, boolean[] visited, int start) {

        PriorityQueue<PathInfo> pq = new PriorityQueue<>();
        pq.add(new PathInfo(start, 0));

        int totalWeight = 0;
        while (pq.isEmpty() == false) {

            PathInfo current = pq.poll();
            if (visited[current.to] == false) {
                visited[current.to] = true;
                totalWeight += current.weight;

                for (PathInfo next : paths[current.to]) {
                    if (visited[next.to] == false) {
                        pq.offer(next);
                    }
                }
            }
        }

        return totalWeight;
    }

    private static class PathInfo implements Comparable {
        int to;
        int weight;

        public PathInfo(int pTo, int pWeight) {
            to = pTo;
            weight = pWeight;
        }

        @Override
        public int compareTo(Object o) {
            return this.weight - ((PathInfo) o).weight;
        }
    }
}
