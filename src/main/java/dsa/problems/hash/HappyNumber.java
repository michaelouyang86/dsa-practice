package dsa.problems.hash;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/happy-number
public class HappyNumber {
    public boolean isHappyOriginal(int n) {
        Set<Integer> seen = new HashSet<>();

        int current = n;
        while (true) {
            if (current == 1) {
                return true;
            }
            if (seen.contains(current)) {
                return false;
            } else {
                seen.add(current);
            }
            int sum = 0;
            char[] digits = String.valueOf(current).toCharArray();
            for (char digit : digits) {
                sum += (digit - '0') * (digit - '0');
            }
            current = sum;
        }
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (true) {
            if (n == 1) {
                return true;
            }
            if (seen.contains(n)) {
                return false;
            } else {
                seen.add(n);
            }
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
    }
}
