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
    public int goodNodes(TreeNode root) {
        int[] res = new int[1];
        rec(res, -1000, root);
        return res[0];
    }

    public void rec(int[] res, int max, TreeNode node) {
        if (node == null) return; 
        // Check if good.
        if (node.val >= max) res[0]++;
        // Update max.
        max = Math.max(max, node.val);
        
        rec(res, max, node.left);
        rec(res, max, node.right);
    }
}
