import java.io.*;

public class q14626 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] nums = br.readLine().trim().toCharArray();

        int starIdx = -1;
        int sum = 0;        // * 제외 1~12자리 가중합
        for (int i = 0; i < 12; i++) {
            
            if (nums[i] == '*') { 
                starIdx = i + 1; 
                continue; 
            }
            
            int weight = ((i + 1) % 2 == 0) ? 3 : 1;    // 가중치 1 or 3
            sum += (nums[i] - '0') * weight;
        }

        int last = nums[12] - '0';
        int need = (10 - ((sum + last) % 10)) % 10;         // weight * x %10 == need
        int starIdxWeight = (starIdx % 2 == 0) ? 3 : 1;

        int ans = -1;
        for (int x = 0; x <= 9; x++) {
            if ((starIdxWeight * x) % 10 == need) { 
                ans = x; 
                break; 
            }
        }
        System.out.println(ans);
    }
}
