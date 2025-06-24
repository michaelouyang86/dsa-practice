package dsa.problems.stack;

import java.util.ArrayDeque;

// https://leetcode.com/problems/valid-parentheses
public class ValidParenthesesOriginal {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char character : s.toCharArray()) {
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.poll();
                if (character == ')' && top != '(') {
                    return false;
                } else if (character == ']' && top != '[') {
                    return false;
                } else if (character == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
