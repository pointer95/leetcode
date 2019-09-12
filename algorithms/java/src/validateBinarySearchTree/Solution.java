package validateBinarySearchTree;

import common.TreeNode;

/**
 * source: https://leetcode-cn.com/problems/validate-binary-search-tree/
 * date: 2019/8/19
 */
class Solution {

    private boolean firstNode = true;
    private int maxValue = 0;

    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }

    private boolean inOrder(TreeNode node) {
        if (node == null) return true;
        if (!inOrder(node.left)) return false;
        if (!firstNode && maxValue >= node.val) return false;
        firstNode = false;
        maxValue = node.val;
        if (!inOrder(node.right)) return false;
        return true;
    }
}
