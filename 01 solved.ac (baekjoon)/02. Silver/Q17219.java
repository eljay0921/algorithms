import java.io.*;
import java.util.*;

public class Q17219 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int siteCount = Integer.parseInt(st.nextToken());
        int findCount = Integer.parseInt(st.nextToken());

        Map<String, String> sitePassowrdMap = new HashMap<>();
        for (int i = 0; i < siteCount; i++) {

            st = new StringTokenizer(br.readLine());
            sitePassowrdMap.put(st.nextToken(), st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < findCount; i++) {

            String site = br.readLine();
            sb.append(sitePassowrdMap.get(site)).append("\n");
        }

        System.out.print(sb);
    }
    
}
