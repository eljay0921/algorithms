import java.io.*;

public class q28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int printNumber = -1;
        for (int i = 0; i < 3; i++) {
            String text = br.readLine();
            if (text.matches("\\d+")) {
                int currentNumber = Integer.parseInt(text);
                printNumber = currentNumber + (3 - i);
                break;
            }
        }

        printText(printNumber);
    }

    private static void printText(int num) {
        if (num % 3 == 0 && num % 5 == 0) {
            System.out.print("FizzBuzz");
        } else if (num % 3 == 0) {
            System.out.print("Fizz");
        } else if (num % 5 == 0) {
            System.out.print("Buzz");
        } else {
            System.out.print(num);
        }
    }
}
