package dsa.problems.combination;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number
public class LetterCombinationsOfAPhoneNumberOriginal {

    private static final char[] TWO   = new char[] {'a', 'b', 'c'};
    private static final char[] THREE = new char[] {'d', 'e', 'f'};
    private static final char[] FOUR  = new char[] {'g', 'h', 'i'};
    private static final char[] FIVE  = new char[] {'j', 'k', 'l'};
    private static final char[] SIX   = new char[] {'m', 'n', 'o'};
    private static final char[] SEVEN = new char[] {'p', 'q', 'r', 's'};
    private static final char[] EIGHT = new char[] {'t', 'u', 'v'};
    private static final char[] NINE  = new char[] {'w', 'x', 'y', 'z'};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer("");
        for (char character : digits.toCharArray()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                String data = queue.poll();
                for (char mapping : getMapping(character)) {
                    queue.offer(data + mapping);
                }
            }
        }
        return new ArrayList<>(queue);
    }

    private char[] getMapping(char character) {
        switch (character) {
            case '2':
                return TWO;
            case '3':
                return THREE;
            case '4':
                return FOUR;
            case '5':
                return FIVE;
            case '6':
                return SIX;
            case '7':
                return SEVEN;
            case '8':
                return EIGHT;
            case '9':
                return NINE;
            default:
                throw new IllegalArgumentException("Invalid character: " + character);
        }
    }
}
