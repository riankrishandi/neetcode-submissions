/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> map = new HashMap<>();
    Deque<Node> queue = new LinkedList<>();
    Set<Integer> set = new HashSet<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        queue.addLast(node);
        set.add(node.val);

        while(!queue.isEmpty()) {
            Node oldNode = queue.pollFirst();

            // Get from map or create one.
            map.computeIfAbsent(oldNode.val, k -> new Node(oldNode.val));
            Node newNode = map.get(oldNode.val);
            if (newNode.neighbors == null) {
                newNode.neighbors = new ArrayList<>();
            }

            // Neighbors.
            for (var n : oldNode.neighbors) {
                map.computeIfAbsent(n.val, k -> new Node(n.val));
                newNode.neighbors.add(map.get(n.val));
                if (!set.contains(n.val)) {
                    queue.addLast(n);
                    set.add(n.val);
                }
            }
        }
        return map.get(1);
    }
}