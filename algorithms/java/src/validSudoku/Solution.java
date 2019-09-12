package validSudoku;

/**
 * source: https://leetcode-cn.com/problems/valid-sudoku/
 * date: 2019/8/27
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int cnt = 9;
        boolean[][] row = new boolean[cnt][cnt];
        boolean[][] col = new boolean[cnt][cnt];
        boolean[][] area = new boolean[cnt][cnt];

        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                if (board[i][j] == '.') continue;
                int index = board[i][j] - '0' - 1;

                if (row[i][index]) {
                    return false;
                }
                row[i][index] = true;
                if (col[j][index]) {
                    return false;
                }
                col[j][index] = true;

                int areaIndex = (i / 3) * 3 + j / 3;
                if (area[areaIndex][index]) {
                    return false;
                }
                area[areaIndex][index] = true;
            }
        }
        return true;
    }
}
