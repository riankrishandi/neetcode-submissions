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
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head, fast = slow;
        while (true) {
            if (slow == null) break;
            slow = slow.next;

            if (fast == null) break;
            fast = fast.next;
            if (fast == null) break;
            fast = fast.next;

            if (slow == fast) return true;
        }
        return false;
    }
}
