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
    Map<Integer, Integer> inorderMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return rec(preorder, inorder, 0, preorder.length, 0, inorder.length);    
    }

    public TreeNode rec(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        var node = new TreeNode(preorder[pStart]);
        if (pEnd - pStart < 2) return node;

        Integer currInorderIdx = inorderMap.get(node.val);

        // Handle left.
        // Get the size.
        int leftSize = currInorderIdx - iStart;
        if (leftSize != 0) {
            node.left = rec(preorder, inorder, pStart + 1, pStart + 1 + leftSize, iStart, currInorderIdx);
        }

        // Handle right.
        // Get the size.
        int rightSize = iEnd - (currInorderIdx+1);
        if (rightSize != 0) {
            node.right = rec(
                preorder, 
                inorder, 
                pStart + 1 + leftSize, 
                pStart + 1 + leftSize + rightSize, 
                currInorderIdx + 1, 
                iEnd
            );
        }

        return node;
    }
}
