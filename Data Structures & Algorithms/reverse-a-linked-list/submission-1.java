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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        List<ListNode> arr = new ArrayList<>();

        var node = head;
        while (node != null) {
            arr.add(node);
            node = node.next;
        }

        for (int i = arr.size() - 1 ; i > 0; i--) {
            arr.get(i).next = arr.get(i-1);
        }
        arr.get(0).next = null;
        return arr.get(arr.size()-1);
    }
}
