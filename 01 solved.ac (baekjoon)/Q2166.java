import java.io.*;
import java.util.*;

public class Q2166 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int angles = Integer.parseInt(br.readLine());   // 3 <= angles <= 10,000
        int[][] positions = new int[angles][2];
        for (int i = 0; i < angles; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
            int y = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

            positions[i][0] = x;
            positions[i][1] = y;
        }

        // 신발끈 공식
        // 삼각형일 때 넓이 = (1/2) * | (x1y2 + x2y3 + x3y1) - (x2y1 + x3y2 + x1y3) |
        // 사각형일 때 넓이 = (1/2) * | (x1y2 + x2y3 + x3y4 + x4y1) - (x2y1 + x3y2 + x4y3 + x1y4) |
        // ...
        long temp = 0;
        for (int i = 0; i < angles; i++) {
            int[] current = positions[i];
            int nextIdx = (i == angles - 1) ? 0 : i + 1;
            int[] next = positions[nextIdx];
            temp += ((long)current[0] * next[1]) - ((long)next[0] * current[1]);
        }

        double result = Math.abs(temp) / 2.0;
        System.out.printf("%.1f", result);
    }
}

// 문제의 설명이 부족한 것 같다.
// -> 주어진 좌표의 다각형은 볼록한 형태인가?
// -> 주어진 좌표는 시계 방향인가?
// 일단 다각형 구하는 공식을 모르기 때문에, 삼각형으로 나눠서 구해보는 쪽으로 트라이한다. (위 내용이 맞다고 가정함)
// 결국 세 좌표를 알고도 넓이 구하는 공식을 몰라서 찾아봤다. -> 신발끈 공식


// 4각형이면 6회 순회 -> 삼각형 2개
// 1,2,3 (1)
// 1,3,4 (2)

// 5각형이면 9회 순회 -> 삼각형 3개
// 1,2,3 (1)
// 1,3,4 (2)
// 1,4,5 (3)

// 6각형이면 12회 순회 -> 삼각형 4개
// 1,2,3 (1)
// 1,3,4 (2)
// 1,4,5 (3)
// 1,5,6 (4)