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
    List<Integer> arrList = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        if (arrList.size() < k) return -1;
        return arrList.get(k - 1);
    }

    public void dfs(TreeNode node, int k) {
        if (node == null) return;

        // Left.
        dfs(node.left, k);
        // Middle.
        arrList.add(node.val);
        if (arrList.size() >= k) return;
        // Right.
        dfs(node.right, k);
    }
}
