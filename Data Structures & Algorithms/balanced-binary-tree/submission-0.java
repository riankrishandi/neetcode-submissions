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
    public boolean isBalanced(TreeNode root) {
        int[] gap = new int[1];
        checkHeight(root, gap);
        return gap[0] < 2;
    }

    public int checkHeight(TreeNode node, int[] gap) {
        if (node == null) return 0;
        int left = checkHeight(node.left, gap);
        int right = checkHeight(node.right, gap);
        gap[0] = Math.max(Math.abs(left-right), gap[0]);
        return Math.max(left, right) + 1;
    }
}
