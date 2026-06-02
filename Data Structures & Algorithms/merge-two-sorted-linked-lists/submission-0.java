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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode n1 = list1, n2 = list2, prev = null, head = null;
        while (n1 != null || n2 != null) {
            ListNode lower;
            if (n1 == null) {
                lower = n2;
                n2 = n2.next;
            } else if (n2 == null) {
                lower = n1;
                n1 = n1.next;
            } else if (n1.val <= n2.val) {
                lower = n1;
                n1 = n1.next;
            } else {
                lower = n2;
                n2 = n2.next;
            }
            
            if (prev != null) {
                prev.next = lower;
            } else {
                head = lower;
            } 
            prev = lower;
        }
        return head;
    }
}