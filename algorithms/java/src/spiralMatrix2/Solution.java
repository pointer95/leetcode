package spiralMatrix2;

import java.util.ArrayList;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/spiral-matrix-ii/
 * @author: pointer
 * @date: Created on 2019-12-04
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[][];
        if (n <= 0) {
            return matrix;
        }
        int cnt = 1;
        for (int r = 0, c= 0;
             r < (n+1)/2 && c < (n+1)/2;
             r++, c++) {
            // left
            for (int i = c; i < n - c; i++) {
                matrix[r][i] = cnt++;
            }
            // down
            for (int i = r+1; i < n - r; i++) {
                matrix[i][n-1-c] = cnt++;
            }
            // right
            for (int i = n-1-(c+1); n-1-r != r && i >= c; i--) {
                matrix[n-1-r][i] = cnt++;
            }
            // up
            for (int i = n-1-(r+1); n-1-c != c && i > r; i--) {
                matrix[i][c] = cnt++;
            }
        }
        return matrix;
    }
}
