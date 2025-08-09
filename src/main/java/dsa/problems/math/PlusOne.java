package dsa.problems.math;

// https://leetcode.com/problems/plus-one
public class PlusOne {
    public int[] plusOneOriginal(int[] digits) {
        if (digits[digits.length - 1] == 9) {
            int index = digits.length - 1;
            do {
                digits[index--] = 0;
                if (index == -1) {
                    int[] newDigits = new int[digits.length + 1];
                    newDigits[0] = 1;
                    return newDigits;
                }
            } while (digits[index] == 9);
            digits[index]++;
        } else {
            digits[digits.length - 1]++;
        }
        return digits;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
