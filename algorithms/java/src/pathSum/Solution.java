package pathSum;

import common.TreeNode;

/**
 * source: https://leetcode-cn.com/problems/path-sum/
 * date: 2019/8/23
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSumHelper(root, sum, 0);
    }

    private boolean hasPathSumHelper(TreeNode root, int sum, int s) {
        if (root == null) return false;
        s += root.val;
        if (root.left == null && root.right == null) return s == sum;
        return (hasPathSumHelper(root.left, sum, s)) || (hasPathSumHelper(root.right, sum, s));
    }
}
