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
    public boolean isValidBST(TreeNode root) {
        return rec(-1001, 1001, root);
    }

    public boolean rec(int min, int max, TreeNode node) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
    
        // Left side.
        boolean left = rec(min, node.val, node.left);
        boolean right = rec(node.val, max, node.right);
        return left && right;
    }
}
