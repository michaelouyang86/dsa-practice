package dsa.problems.hash;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/word-pattern
public class WordPattern {
    public boolean wordPatternOriginal(String pattern, String s) {
        Map<Character, String> mapping = new HashMap<>();
        char[] letters = pattern.toCharArray();
        String[] words = s.split(" ");
        if (letters.length != words.length) {
            return false;
        }
        for (int i = 0; i < letters.length; i++) {
            if (mapping.containsKey(letters[i])) {
                String word = mapping.get(letters[i]);
                if (!word.equals(words[i])) {
                    return false;
                }
            } else {
                if (mapping.containsValue(words[i])) {
                    return false;
                }
                mapping.put(letters[i], words[i]);
            }
        }
        return true;
    }

    public boolean wordPattern(String pattern, String s) {
        char[] letters = pattern.toCharArray();
        String[] words = s.split(" ");
        if (letters.length != words.length) {
            return false;
        }
        Map<Character, String> letterToWord = new HashMap<>();
        Map<String, Character> wordToLetter = new HashMap<>();
        for (int i = 0; i < letters.length; i++) {
            // check letter to word
            String word = letterToWord.get(letters[i]);
            if (word != null && !word.equals(words[i])) {
                return false;
            }
            // check word to letter
            Character letter = wordToLetter.get(words[i]);
            if (letter != null && !letter.equals(letters[i])) {
                return false;
            }
            letterToWord.put(letters[i], words[i]);
            wordToLetter.put(words[i], letters[i]);
        }
        return true;
    }
}
