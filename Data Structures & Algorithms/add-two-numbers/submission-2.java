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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int total = getNumber(l1) + getNumber(l2);
        if (total == 0) return new ListNode(0);

        System.out.println("Total: " + total);

        ListNode head = null, curr = null;            
        while (total != 0) {
            System.out.println("Total in loop: " + total);
            int number = total % 10;

            // New node.
            ListNode node = new ListNode(number);
            if (curr == null) {
                head = node;
                curr = node;
            } else {
                curr.next = node;
                curr = curr.next;
            }

            // Update total.
            total /= 10;
        }
        return head;
    }

    public int getNumber(ListNode l1) {
        if (l1 == null) return 0;

        int multiplier = 1, total = 0;
        ListNode curr = l1;
        while (curr != null) {
            total += multiplier * curr.val;
            curr = curr.next;
            multiplier *= 10;
        }
        return total;
    }
}
