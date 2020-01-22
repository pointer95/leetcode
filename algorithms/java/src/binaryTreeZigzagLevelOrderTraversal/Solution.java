package binaryTreeZigzagLevelOrderTraversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * @author: pointer
 * @date: Created on 2020/1/22
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        zigzagLevelOrderHelper(root, 0, res);
        return res;
    }

    private void zigzagLevelOrderHelper(TreeNode root, int level,
                                        List<List<Integer>> res) {
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0, root.val);
        }
        if (root.left != null) {
            zigzagLevelOrderHelper(root.left, level+1, res);
        }
        if (root.right != null) {
            zigzagLevelOrderHelper(root.right, level+1, res);
        }
    }
}
