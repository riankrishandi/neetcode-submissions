/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        rec(root, res);
        return res[0];
    }

    public int rec(TreeNode node, int[] res) {
        if (node.left == null && node.right == null) return 0;
        int left = node.left == null ? 0 : 1 + rec(node.left, res);
        int right = node.right == null ? 0 : 1 + rec(node.right, res);
        res[0] = Math.max(res[0], left + right);
        return Math.max(left, right);
    }
}
