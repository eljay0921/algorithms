import java.io.*;
import java.util.*;

public class Q2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
        int target = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

        st = new StringTokenizer(br.readLine());
        int[] storage = new int[count];
        for (int i = 0; i < count; i++) {
            int value = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
            storage[i] = value;
        }

        Arrays.sort(storage);
        int result = 0;
        for (int i = 0; i < count - 2; i++) {

            int val1 = storage[i];
            for (int j = i + 1; j < count - 1; j++) {

                int val2 = storage[j];
                if (val1 + val2 >= target) continue;

                for (int k = j + 1; k < count; k++) {

                    int sum = val1 + val2 + storage[k];
                    if (sum > target) break;
                    if (sum == target) {
                        System.out.print(target);
                        return;
                    }

                    result = Math.max(result, sum);
                }
            }
        } 
        
        System.out.print(result);
    }
}
