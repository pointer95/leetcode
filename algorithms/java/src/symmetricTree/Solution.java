package symmetricTree;

import common.TreeNode;

/**
 * source: https://leetcode-cn.com/problems/symmetric-tree/
 * @author: pointer
 * @date: Created on 2020-01-05
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;
        if (leftNode.val != rightNode.val) return false;
        return isSymmetricHelper(leftNode.left, rightNode.right)
                && isSymmetricHelper(leftNode.right, rightNode.left);
    }
}
