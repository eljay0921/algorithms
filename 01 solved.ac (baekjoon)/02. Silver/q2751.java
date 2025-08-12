import java.io.*;

public class q2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int offset = 1000000;
        int realSize = offset * 2 + 1; // 2000001
        boolean[] exists = new boolean[realSize]; 
        
        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            exists[num + offset] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < realSize; i++) {
            if (exists[i]) {
                sb.append(i - offset).append("\n");
            }
        }

        System.out.print(sb);
    }
}
