import java.io.*;
import java.util.*;

public class Q1764 {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        try {
                
            StringTokenizer st = new StringTokenizer(br.readLine());
            int unknownHeared = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
            int unknownSaw = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

            Set<String> unknownHearedSet = new TreeSet<>();
            for (int i = 0; i < unknownHeared; i++) {
                String unHeared = br.readLine();
                unknownHearedSet.add(unHeared);
            }
            
            Set<String> unknownHearedAndSawSet = new TreeSet<>();
            int count = 0;
            for (int i = 0; i < unknownSaw; i++) {
                String unSaw = br.readLine();
                if (unknownHearedSet.contains(unSaw)) {
                    count++;
                    unknownHearedAndSawSet.add(unSaw);
                }

                if (count >= unknownHeared) break;
            }

            sb.append(count).append("\n");
            for (String name : unknownHearedAndSawSet) {
                sb.append(name).append("\n");
            }

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            System.out.print(sb.toString());
        }
        
    }
}