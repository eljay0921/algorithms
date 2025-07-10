import java.io.*;

public class Q2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 1; i < number; i++) {
            int sum = i;
            int temp = i;

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum == number) {
                result = i;
                break;
            }
        }

        System.out.println(result);
        br.close();
    }

}