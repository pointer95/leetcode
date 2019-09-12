package minimumPathSum;

/**
 * source: https://leetcode-cn.com/problems/minimum-path-sum/
 * date: 2019/9/4
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] mem = new int[grid.length][grid[0].length];
        return minDist(grid, mem, grid.length-1, grid[0].length-1);
    }

    private int minDist(int[][] grid, int[][] mem, int i, int j) {
        if (i == 0 && j == 0) return grid[0][0];
        if (mem[i][j] > 0) return mem[i][j];
        int minUp = i - 1 >= 0 ? minDist(grid, mem, i-1, j) : Integer.MAX_VALUE;
        int minLeft = j - 1 >= 0 ? minDist(grid, mem, i, j-1) : Integer.MAX_VALUE;
        int current = grid[i][j] + Math.min(minUp, minLeft);
        mem[i][j] = current;
        return current;
    }
}
