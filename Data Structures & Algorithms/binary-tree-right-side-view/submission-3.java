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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        // Use BFS.
        List<Integer> arr = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int i = deque.size();
            
            while (i > 0) {
                TreeNode node = deque.poll();
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
                if (i == 1) arr.add(node.val);
                i--;
            }
        }
        return arr;
    }
}
