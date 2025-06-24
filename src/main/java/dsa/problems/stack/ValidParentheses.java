package dsa.problems.stack;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/valid-parentheses
public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char character : s.toCharArray()) {
            if (brackets.containsValue(character)) {
                stack.push(character);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.poll();
                if (top != brackets.get(character)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
