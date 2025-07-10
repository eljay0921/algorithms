import java.io.*;

public class Q2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int targetNumber = Integer.parseInt(br.readLine());
        int distance = 1;

        if (targetNumber != 1) {

            int offset = 6;
            int explorerNumber = 1;
            while (explorerNumber < targetNumber) {

                explorerNumber += offset;
                distance++;

                offset += 6;
            }
        }

        System.out.print(distance);
    }
}

// (depth: 1) 1 -> 1
// (depth: 2) 2,3,4,5,6,7 -> 6
// (depth: 3) 8,9,10, ... ,19 -> 12
// (depth: 4) 20,21,22,23, ... ,37 -> 18