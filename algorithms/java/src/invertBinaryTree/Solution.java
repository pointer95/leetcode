package invertBinaryTree;

import common.TreeNode;

/**
 * source: https://leetcode-cn.com/problems/invert-binary-tree/
 * date: 2019/8/19
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
