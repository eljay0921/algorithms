import java.io.*;
import java.util.*;

public class q9375 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (cases-- > 0) {

            int caseCount = Integer.parseInt(br.readLine());
            Map<String, Integer> clothCountMap = new HashMap<String, Integer>();    // 중복은 없다고 했다
            for (int i = 0; i < caseCount; i++) {
                String[] clothInfo = br.readLine().split(" ");
                String clothType = clothInfo[1];
                clothCountMap.put(clothType, clothCountMap.getOrDefault(clothType, 0) + 1);
            }

            int resultCount = 1;
            for (int count : clothCountMap.values()) {
                resultCount *= (count + 1);
            }
            resultCount--;

            sb.append(resultCount).append("\n");
        }

        System.out.print(sb);
    }
}
