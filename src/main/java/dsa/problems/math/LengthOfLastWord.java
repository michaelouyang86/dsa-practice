package dsa.problems.math;

// https://leetcode.com/problems/length-of-last-word
public class LengthOfLastWord {
    public int lengthOfLastWordOriginal(String s) {
        String[] words = s.trim().split("\\s+");
        return words[words.length - 1].length();
    }

    public int lengthOfLastWord(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (result != 0) {
                    return result;
                }
            } else {
                result++;
            }
        }
        return result;
    }
}
