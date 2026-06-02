/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            // Val.
            map.computeIfAbsent(curr, (k) -> new Node(0));
            map.get(curr).val = curr.val;

            // Random.
            if (curr.random != null) {
                map.computeIfAbsent(curr.random, (k) -> new Node(0));
                map.get(curr).random = map.get(curr.random);
            }

            // Next.
            if (curr.next != null) {
                map.computeIfAbsent(curr.next, (k) -> new Node(0));
                map.get(curr).next = map.get(curr.next);
            }
            curr = curr.next;
        }
        return map.get(head);
    }
}
