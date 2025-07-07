import java.util.*;

class Solution {
    public String reverseWords(String s) {

        StringTokenizer st = new StringTokenizer(s);
        Deque<String> words = new ArrayDeque<String>();
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            words.push(st.nextToken());
        }

        while (words.isEmpty() == false) {
            sb.append(words.pop()).append(" ");
        }

        return sb.toString().trim();
    }
}