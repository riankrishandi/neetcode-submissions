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
    int preorderIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1);    
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

    private TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r) return null;
        int val = preorder[preorderIndex++];
        int mid = inorderMap.get(val);
        var node = new TreeNode(val);
        node.left = dfs(preorder, l, mid-1);
        node.right = dfs(preorder, mid+1, r);
        return node;
    }
}
