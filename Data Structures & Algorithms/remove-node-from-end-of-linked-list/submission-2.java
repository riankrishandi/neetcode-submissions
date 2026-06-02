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
        ListNode curr = head;        
        int N = 0;
        while (curr != null) {
            N++;
            curr = curr.next;
        }
        System.out.println("Curr: " + N);

        int targetN = N - n + 1;
        System.out.println("Target N: " + targetN);


        int i = 0;
        ListNode dummy = new ListNode(0, head);
        curr = dummy;
        while (i < targetN) {
            if (i+1 == targetN) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
            i++;
        }
        return dummy.next;
    }
}

