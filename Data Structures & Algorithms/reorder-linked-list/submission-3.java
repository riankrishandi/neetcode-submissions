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
        if (head.next == null) return;
        
        // Get the second half part of the list.
        ListNode slow = head, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        var secondHalfHead = slow.next;
        slow.next = null;

        System.out.println("Second: " + secondHalfHead == null ? -1 : secondHalfHead.val);

        // Reverse second half.
        secondHalfHead = reverse(secondHalfHead);

        System.out.println("After: " + secondHalfHead == null ? -1 : secondHalfHead.val);

        // Merge.
        ListNode dummy = new ListNode(0), curr = dummy;
        ListNode left = head, right = secondHalfHead;
        while (left != null && right != null) {
            curr.next = left;
            curr = curr.next;
            left = left.next;

            curr.next = right;
            curr = curr.next;
            right = right.next;
        }

        if (left != null) curr.next = left;
        if (right != null) curr.next = right;
        head = dummy.next;
    }

    public ListNode reverse(ListNode node) {
        if (node == null) return null;
        ListNode curr = node, prev = null;
        while (curr != null) {
            var temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
