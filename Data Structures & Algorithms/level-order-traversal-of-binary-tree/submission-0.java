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
        Deque<TreeNode> d = new ArrayDeque<>();
        d.add(root);
        rec(d, res);
        return res;
    }

    public void rec(Deque<TreeNode> deque, List<List<Integer>> res) {
        if (deque == null || deque.isEmpty()) return;
        // Create new deque.
        Deque<TreeNode> newDeque = new ArrayDeque<>();
        List<Integer> newList = new ArrayList<>(); 
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            newList.add(node.val);

            if (node.left != null) newDeque.addLast(node.left);
            if (node.right != null) newDeque.addLast(node.right);
        }
        res.add(newList);
        rec(newDeque, res);
    }
}