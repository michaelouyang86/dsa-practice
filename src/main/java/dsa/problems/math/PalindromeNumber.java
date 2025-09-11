package dsa.problems.math;

// https://leetcode.com/problems/palindrome-number
public class PalindromeNumber {
    public boolean isPalindromeOriginal(int x) {
        char[] data = String.valueOf(x).toCharArray();
        for (int i = 0, j = data.length - 1; i < data.length; i++, j--) {
            if (data[i] != data[j]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeImprove(int x) {
        char[] data = String.valueOf(x).toCharArray();
        int left = 0;
        int right = data.length - 1;
        while (left < right) {
            if (data[left] != data[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int reversed = 0;
        while (reversed < x) {
            reversed *= 10;
            reversed += (x % 10);
            x /= 10;
        }
        return x == reversed || x == (reversed / 10);
    }
}
