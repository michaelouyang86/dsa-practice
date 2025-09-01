package dsa.problems.matrix;

import java.util.Arrays;

// https://leetcode.com/problems/valid-sudoku
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] validator = new boolean[10];

        // row
        for (int i = 0; i < 9; i++) {
            Arrays.fill(validator, false);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int value = board[i][j] - '0';
                if (validator[value]) {
                    return false;
                }
                validator[value] = true;
            }
        }

        // column
        for (int i = 0; i < 9; i++) {
            Arrays.fill(validator, false);
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                int value = board[j][i] - '0';
                if (validator[value]) {
                    return false;
                }
                validator[value] = true;
            }
        }

        // sub-boxes
        for (int i = 0; i <= 6; i+=3) {
            for (int j = 0; j <= 6; j+=3) {
                Arrays.fill(validator, false);
                for (int m = i; m < i + 3; m++) {
                    for (int n = j; n < j + 3; n++) {
                        if (board[m][n] == '.') {
                            continue;
                        }
                        int value = board[m][n] - '0';
                        if (validator[value]) {
                            return false;
                        }
                        validator[value] = true;
                    }
                }
            }
        }

        return true;
    }
}
