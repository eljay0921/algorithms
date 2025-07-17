import java.io.*;
import java.util.*;

public class Q1546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        // v1
        /*
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scores = new int[count];
        int maxScore = 0;
        for (int i = 0; i < count; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            maxScore = Math.max(maxScore, scores[i]);
        }

        double totalScore = 0 ;
        for (int i = 0; i < count; i++) {
            totalScore = totalScore + ((double) scores[i] / maxScore * 100);
        }

        System.out.print(totalScore / count);
        */

        // v2(stream)
        double[] scores = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double maxScore = Arrays.stream(scores).max().getAsDouble();
        double average = Arrays.stream(scores).map(score -> score / maxScore * 100).average().getAsDouble();

        System.out.print(average);
    }
    
}
