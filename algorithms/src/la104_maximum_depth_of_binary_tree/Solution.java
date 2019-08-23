package la104_maximum_depth_of_binary_tree;

import common.TreeNode;

/**
 * source: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * date: 2019/8/19
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
