import java.util.*;

class Solution {

    private final Set<Character> VOWELS = new HashSet<>(
        Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    );

    public String reverseVowels(String s) {
        
        // v1: stack
        // Deque<Character> stack = new ArrayDeque<Character>();
        // for (char c : s.toCharArray()) {
        //     if (VOWELS.contains(c)) {
        //         stack.push(c);
        //     }
        // }

        // StringBuilder sb = new StringBuilder();
        // for (char c : s.toCharArray()) {
        //     if (VOWELS.contains(c)) {
        //         sb.append(stack.pop());
        //     } else {
        //         sb.append(c);
        //     }
        // }

        // return sb.toString();

        // --------------------------------------------------
        // v2: two pointer
        
        char[] s_char = s.toCharArray();
        int left = 0;
        int right = s_char.length - 1;

        while (left < right) {

            // left -> right
            while ((left < right) && VOWELS.contains(s_char[left]) == false) {
                left++;
            }

            // right -> left
            while ((left < right) && VOWELS.contains(s_char[right]) == false) {
                right--;
            }

            if (left < right) {
                char temp = s_char[left];
                s_char[left] = s_char[right];
                s_char[right] = temp;
                left++;
                right--;
            }
        }

        return new String(s_char);
    }
}

// https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75