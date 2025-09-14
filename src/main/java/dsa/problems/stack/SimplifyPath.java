package dsa.problems.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

// https://leetcode.com/problems/simplify-path
public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String split : path.split("/")) {
            if (split.isBlank() || split.equals(".")) {
                continue;
            } else if (split.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(split);
            }
        }
        StringBuilder builder = new StringBuilder();
        Iterator<String> iterator = stack.descendingIterator();
        while (iterator.hasNext()) {
            builder.append('/').append(iterator.next());
        }
        return builder.length() == 0 ? "/" : builder.toString();
    }
}
