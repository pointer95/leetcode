package binaryTreeLevelOrderTraversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @author: pointer
 * @date: Created on 2020/1/21
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        levelOrderHelper(root, 0, res);
        return res;
    }

    private void levelOrderHelper(TreeNode root, int level, List<List<Integer>> res) {
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        if (root.left != null) {
            levelOrderHelper(root.left, level+1, res);
        }
        if (root.right != null) {
            levelOrderHelper(root.right, level+1, res);
        }
    }
}
