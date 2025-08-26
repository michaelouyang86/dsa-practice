package dsa.problems.hash;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstringOriginal(String s) {
        int maxlength = 0;

        LinkedHashSet<Character> window = new LinkedHashSet<>();
        for (char c : s.toCharArray()) {
            if (window.contains(c)) {
                while (!window.getFirst().equals(c)) {
                    window.removeFirst();
                }
                window.removeFirst();
            }
            window.add(c);
            if (window.size() > maxlength) {
                maxlength = window.size();
            }
        }

        return maxlength;
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        int left = 0;
        char[] characters = s.toCharArray();
        Set<Character> window = new HashSet<>();
        for (int i = 0; i < characters.length; i++) {
            while (window.contains(characters[i])) {
                window.remove(characters[left++]);
            }
            window.add(characters[i]);
            if (window.size() > maxLength) {
                maxLength = window.size();
            }
        }

        return maxLength;
    }
}
