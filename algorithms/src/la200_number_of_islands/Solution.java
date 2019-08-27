package la200_number_of_islands;

/**
 * source: https://leetcode-cn.com/problems/number-of-islands/
 * date: 2019/8/27
 */
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int m, int n) {
        if (m < 0 || n < 0 || m > grid.length-1 || n > grid[0].length-1 || grid[m][n] == '0') {
            return;
        }
        grid[m][n] = '0';
        dfs(grid, m+1, n);
        dfs(grid, m-1, n);
        dfs(grid, m, n+1);
        dfs(grid, m, n-1);
    }
}
