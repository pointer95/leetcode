package wordSearch;

/**
 * source: https://leetcode-cn.com/problems/word-search/
 * @author: pointer
 * @date: Created on 2019/12/25
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length <= 0 || word.length() <= 0) return false;
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(existHelper(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existHelper(char[][] board, String word,
                                int index, int row, int col) {
        if (row < 0 || row >= board.length
                || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(index)) {
            return false;
        }
        if (index+1 == word.length()) return true;
        board[row][col] = '.';
        if (existHelper(board, word, index+1, row+1, col)
                || existHelper(board, word, index+1, row-1, col)
                || existHelper(board, word, index+1, row, col+1)
                || existHelper(board, word, index+1, row, col-1)) {
            return true;
        }
        board[row][col] = word.charAt(index);
        return false;
    }
}
