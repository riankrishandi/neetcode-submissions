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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (root.val == subRoot.val) {
            // Deep check.
            if (check(root, subRoot)) {
                return true;
            }
        }

        boolean leftSide = isSubtree(root.left, subRoot);
        boolean rightSide = isSubtree(root.right, subRoot);
        return leftSide || rightSide;
    }

    public boolean check(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) return n1 == null && n2 == null;
        if (n1.val != n2.val) return false;

        // Check left side.
        boolean left = check(n1.left, n2.left);
        boolean right = check(n1.right, n2.right);
        return left && right;
    }
}
