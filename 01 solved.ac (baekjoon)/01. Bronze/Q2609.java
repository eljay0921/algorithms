import java.util.*;
import java.io.*;

public class Q2609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int gcd = getGCD(num1, num2);
        int lcm = getLCM(num1, num2);

        StringBuilder sb = new StringBuilder();
        sb.append(gcd).append(" ").append(lcm);
        System.out.print(sb);

        br.close();
    }

    // 최대공약수(Greatest Common Divisor) 찾기
    private static int getGCD(int num1, int num2) {
        // 유클리드 호제법
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    // 최소공배수(Least Common Multiple) 찾기
    private static int getLCM(int num1, int num2) {
        return (num1 * num2) / getGCD(num1, num2);
    }
}