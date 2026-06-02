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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        
        while (!deque.isEmpty()) {
            int i = deque.size();
            List<Integer> row = new ArrayList<>();
            while (i > 0) {
                TreeNode node = deque.poll();
                row.add(node.val);

                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);

                i--;
            }
            res.add(row);
        }

        return res;
    }
}