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
        ListNode curr = head;
        int lastIndex = -1;
        while(curr != null) {
            // Loop break;
            if (curr.val < lastIndex) return true;
            lastIndex = curr.val;
            if (curr.val == - 1 || curr.next == null) return false;
            curr = curr.next;
        }
        return false;
    }
}
