/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    // public class TreeNode {

    // int val;
    // TreeNode left;
    // TreeNode right;

    // TreeNode() {
    // }

    // TreeNode(int val) {
    // this.val = val;
    // }

    // TreeNode(int val, TreeNode left, TreeNode right) {
    // this.val = val;
    // this.left = left;
    // this.right = right;
    // }
    // }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int d = 0;
        return max(root, d);
    }

    public int max(TreeNode root, int d) {
        if (root == null) {
            return d;
        }
        d++;
        return Math.max(max(root.left, d), max(root.right, d));
    }

}
// @lc code=end
