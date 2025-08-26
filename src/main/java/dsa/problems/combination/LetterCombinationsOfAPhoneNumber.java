package dsa.problems.combination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number
public class LetterCombinationsOfAPhoneNumber {

    private static final Map<Character, String> MAPPING = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz");

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> combinations = new ArrayList<>();
        backTracking(digits, 0, new StringBuilder(), combinations);
        return combinations;
    }

    private void backTracking(String digits, int index, StringBuilder builder, List<String> combinations) {
        if (index == digits.length()) {
            combinations.add(builder.toString());
            return;
        }
        for (char letter : MAPPING.get(digits.charAt(index)).toCharArray()) {
            builder.append(letter);
            backTracking(digits, index + 1, builder, combinations);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
