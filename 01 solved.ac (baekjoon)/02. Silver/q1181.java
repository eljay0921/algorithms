import java.io.*;
import java.util.*;

public class q1181 {
    public static void main(String[] args) throws IOException {

        // 입력 및 전처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        Set<String> wordSet = new HashSet<String>(count);
        for (int i = 0; i < count; i++) {
            wordSet.add(br.readLine());
        }

        // 정렬 (길이, 알파벳)
        List<String> wordList = new ArrayList<>(wordSet);
        wordList.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));

        // 출력
        StringBuilder sb = new StringBuilder();
        for (String word : wordList) {
            sb.append(word).append('\n');
        }

        System.out.print(sb);
    }
}
