package spiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/spiral-matrix/
 * date: 2019/11/23
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) {
            return res;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return res;
        }
        for (int r = 0, c= 0;
             r < (row+1)/2 && c < (col+1)/2;
             r++, c++) {
            // left
            for (int i = c; i < col - c; i++) {
                res.add(matrix[r][i]);
            }
            // down
            for (int i = r+1; i < row - r; i++) {
                res.add(matrix[i][col-1-c]);
            }
            // right
            for (int i = col-1-(c+1); row-1-r != r && i >= c; i--) {
                res.add(matrix[row-1-r][i]);
            }
            // up
            for (int i = row-1-(r+1); col-1-c != c && i > r; i--) {
                res.add(matrix[i][c]);
            }
        }
        return res;
    }
}
