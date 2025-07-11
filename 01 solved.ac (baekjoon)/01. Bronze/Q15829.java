import java.io.*;

public class Q15829 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();  // 첫 행 버림
        
        String text = br.readLine();
        long result = 0;
        long power = 1; // 31^0 = 1로 시작
        long mod = 1234567891;

        for (int i = 0; i < text.length(); i++) {

            long ascii = (long)(text.charAt(i) - 'a' + 1);    // 'a' = 97 (문제에서 a는 1이다)
            long value = (ascii * power) % mod; // mod
            result = (result + value) % mod;    // mod
            power = (power * 31) % mod;         // mod : 다음 계산을 위한 power를 사전 처리
        }

        System.out.println(result);
    }
    
}
