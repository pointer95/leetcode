package nQueens2;

import java.util.ArrayList;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/n-queens-ii/
 * date: 2019/11/21
 */
class Solution {

    private int res = 0;
    private int[] queens;

    public int totalNQueens(int n) {
        queens = new int[n];
        solveNQueensRecursive(n, 0);
        return res;
    }

    private void solveNQueensRecursive(int n, int row) {
        if (row == n) {
            res++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                queens[row] = col;
                solveNQueensRecursive(n, row+1);
            }
        }
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (col == queens[i]
                    || Math.abs(col - queens[i]) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }
}
