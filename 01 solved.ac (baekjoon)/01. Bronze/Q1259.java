import java.io.*;

public class Q1259 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        

        while (br.ready()) {

            int number = Integer.parseInt(br.readLine());
            if (number == 0) break;

            boolean isPal = isPalindrome(number);
            sb.append(isPal ? "yes\n" : "no\n");
        }

        System.out.print(sb.toString());
    }

    private static boolean isPalindrome(int num) {
        
        int offset = 10;

        if (num % offset == 0) return false;
        if (num < offset) return true;

        int left = num / offset;
        int right = num % offset;
        int reverse = 0;
        while (left > 0) {

            reverse = (reverse * offset) + right;
            if (left == reverse || left / offset == reverse) {
                return true;
            }

            right = left % offset;
            left = left / offset;
        }

        return false;
    }
}

// 121
// 12 -> 1
// 1 -> 12 (21) : true

// 1231
// 123 -> 1
// 12 -> 13 (31) : false

// 12421
// 1242 -> 1
// 124 -> 12 (21)
// 12 -> 124 (421) : true 