package searchA2DMatrix;

/**
 * source: https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @author: pointer
 * @date: Created on 2019/12/20
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        int left = 0, right = m * n - 1;
        while (left < right) {
            int midIndex = (left + right) / 2;
            int element = matrix[midIndex / n][midIndex % n];
            if (element == target) {
                return true;
            } else if (element > target) {
                right = midIndex;
            } else {
                left = midIndex + 1;
            }
        }
        return (matrix[left / n][left % n] == target)
                || (matrix[right / n][right % n] == target);
    }
}
