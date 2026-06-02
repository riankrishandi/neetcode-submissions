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
    public void reorderList(ListNode head) {
        ListNode slowNode = head, fastNode = head.next;
        while (fastNode != null && fastNode.next != null) {
            int i = 0;
            while (fastNode != null && i < 2) {
                fastNode = fastNode.next;
                i++;
            }
            slowNode = slowNode.next;
        }
        ListNode secondHalfListHead = slowNode.next;
        // System.out.println("Res get second half head: " + secondHalfListHead.val);
    
        // Update last first half list node next to null.
        slowNode.next = null;

        // Reverse second half list.
        ListNode currReverse = secondHalfListHead, prevReverse = null;
        while (currReverse != null) {
            ListNode temp = currReverse.next;
            currReverse.next = prevReverse;
            prevReverse = currReverse;
            currReverse = temp;
        }

        // Update second half head.
        secondHalfListHead = prevReverse;

        // Merge first half and second half.
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        ListNode leftNode = head, rightNode = secondHalfListHead;
        while (leftNode != null && rightNode != null) {
            // Add left.
            res.next = leftNode;
            leftNode = leftNode.next;
            res = res.next;

            // Add right.
            res.next = rightNode;
            rightNode = rightNode.next;
            res = res.next;
        }

        if (leftNode != null) res.next = leftNode;
        if (rightNode != null) res.next = rightNode;
        
        head = dummy.next;
    }
}
