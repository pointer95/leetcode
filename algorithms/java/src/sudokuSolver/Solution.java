package sudokuSolver;

/**
 * source: https://leetcode-cn.com/problems/sudoku-solver/solution/
 * date: 2019/11/17
 */
class Solution {
    public void solveSudoku(char[][] board) {
        final int rcnt = 9;
        final int ccnt = 10;
        boolean[][] row = new boolean[rcnt][ccnt];
        boolean[][] col = new boolean[rcnt][ccnt];
        boolean[][] area = new boolean[rcnt][ccnt];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int num = board[i][j] - '0';
                if (num >= 1 && num <= 9) {
                    row[i][num] = true;
                    col[j][num] = true;
                    int areaIndex = (i / 3) * 3 + j / 3;
                    area[areaIndex][num] = true;
                }
            }
        }
        solveSudokuHelper(board, row, col, area, 0, 0);
    }

    private boolean solveSudokuHelper(char[][] board, boolean[][] row,
                                   boolean[][] col, boolean[][] area,
                                   int r, int c) {
        if (c == board[0].length) {
            c = 0;
            r++;
            if (r == board.length) {
                return true;
            }
        }
        if (board[r][c] == '.') {
                    int areaIndex = (r / 3) * 3 + c / 3;
                    for (int num = 1; num <= 9; num++) {
                        boolean notUse = !(row[r][num]
                                || col[c][num]
                                || area[areaIndex][num]);
                if (notUse) {
                    row[r][num] = true;
                    col[c][num] = true;
                    area[areaIndex][num] = true;
                    board[r][c] = (char) (num + '0');
                    if (solveSudokuHelper(board, row, col, area, r, c + 1)) {
                        return true;
                    }
                    board[r][c] = '.';
                    row[r][num] = false;
                    col[c][num] = false;
                    area[areaIndex][num] = false;
                }
            }
        } else {
            return solveSudokuHelper(board, row, col, area, r, c+1);
        }
        return false;
    }
}
