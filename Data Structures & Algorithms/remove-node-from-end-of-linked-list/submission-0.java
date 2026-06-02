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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        recur(dummy, n);
        return dummy.next;
    }

    public int recur(ListNode prevHead, int n) {
        ListNode currHead = prevHead.next;
        if (currHead == null) return 0;

        int count = recur(currHead, n) + 1;
        if (count == n) {
            prevHead.next = currHead.next;
        }
        return count;
    }
}
