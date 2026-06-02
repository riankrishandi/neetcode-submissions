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
        // Find the middle using slow and fast.
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse the second half list.
        ListNode secondCurr = slow.next, prevSecond = null;
        slow.next = null;
        while (secondCurr != null) {
            ListNode temp = secondCurr.next;
            secondCurr.next = prevSecond;
            prevSecond = secondCurr;
            secondCurr = temp;
        }

        // Merge the first and second.
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode leftNode = head, rightNode = prevSecond;
        while (leftNode != null || rightNode != null) {
            if (leftNode != null) {
                curr.next = leftNode;
                curr = curr.next;
                leftNode = leftNode.next;
            }

            if (rightNode != null) {
                curr.next = rightNode;
                curr = curr.next;
                rightNode = rightNode.next;
            }
        }
        head = dummy.next;
    }
}
