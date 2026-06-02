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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       TreeNode[] res = new TreeNode[1];
       rec(res, root, p, q);
       return res[0];
    }

    public boolean rec (TreeNode[] res, TreeNode curr, TreeNode p, TreeNode q) {
        if (curr == null) return false;
        int n = 0;

        // Check current val.
        if (curr.val == p.val || curr.val == q.val) n++;

        boolean left = rec(res, curr.left, p, q);
        boolean right = rec(res, curr.right, p, q);

        if (left) n++;
        if (right) n++;

        if (n >= 2 && res[0] == null) {
            res[0] = curr;
        }
        return n >= 1;
    }
}
