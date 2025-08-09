package dsa.problems.pointer;

// https://leetcode.com/problems/valid-palindrome
public class ValidPalindrome {
    public boolean isPalindromeOriginal(String s) {
        char[] data = s.toLowerCase()
            .replaceAll("[^a-z0-9]", "")
            .toCharArray();

        int pointer1 = 0;
        int pointer2 = data.length - 1;
        for (int i = 0; i < data.length / 2 ; i++) {
            if (data[pointer1++] != data[pointer2--]) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (true) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left >= right) {
                return true;
            }
            if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) {
                return false;
            }
        }
    }
}
