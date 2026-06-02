/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeSort(0, lists.length, lists);
    }

    public ListNode mergeSort(int startIdx, int endIdx, ListNode[] lists) {
        if (endIdx - startIdx < 2) {
            return lists[startIdx];
        }
        
        int midIdx = (startIdx + endIdx) / 2;
        ListNode leftSide = mergeSort(startIdx, midIdx, lists);
        ListNode rightSide = mergeSort(midIdx, endIdx, lists);
        return mergeTwoNodes(leftSide, rightSide);
    }

    public ListNode mergeTwoNodes(ListNode leftNode, ListNode rightNode) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (leftNode != null && rightNode != null) {
            if (leftNode.val <= rightNode.val) {
                curr.next = leftNode;
                curr = curr.next;
                leftNode = leftNode.next;
                continue;
            }
            curr.next = rightNode;
            curr = curr.next;
            rightNode = rightNode.next;
        }

        if (leftNode != null) curr.next = leftNode;
        if (rightNode != null) curr.next = rightNode;
        return dummy.next;
    }
}
