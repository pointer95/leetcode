package nQueens;

import java.util.ArrayList;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/n-queens/
 * date: 2019/11/20
 */
class Solution {

    private List<List<String>> res = new ArrayList<>();
    private int[] queens;

    public List<List<String>> solveNQueens(int n) {
        queens = new int[n];
        solveNQueensRecursive(n, 0);
        return res;
    }

    private void solveNQueensRecursive(int n, int row) {
        if (row == n) {
            addSolution(n);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                queens[row] = col;
                solveNQueensRecursive(n, row+1);
            }
        }
    }

    private void addSolution(int n) {
        List<String> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; j++) {
                sb.append(".");
            }
            sb.append("Q");
            for (int j = 0; j < n-1-col; j++) {
                sb.append(".");
            }
            s.add(sb.toString());
        }
        res.add(s);
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (col == queens[i] || Math.abs(col - queens[i]) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }
}
