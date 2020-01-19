package uniqueBinarySearchTrees2;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * @author: pointer
 * @date: Created on 2020/1/19
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new LinkedList<>();
        return generateTreesHelper(1, n);
    }

    private List<TreeNode> generateTreesHelper(int low, int high) {
        List<TreeNode> res = new LinkedList<>();
        if (low > high || low <= 0) {
            res.add(null);
            return res;
        }
        if (low == high) {
            TreeNode node = new TreeNode(low);
            res.add(node);
            return res;
        }
        for (int i = low; i <= high; i++) {
            List<TreeNode> left = generateTreesHelper(low, i-1);
            List<TreeNode> right = generateTreesHelper(i+1, high);
            for (TreeNode nLeft : left) {
                for (TreeNode nRight : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = nLeft;
                    root.right = nRight;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
