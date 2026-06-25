class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (var num : nums) {
            tempMap.computeIfAbsent(num, key -> 0);
            tempMap.put(num, tempMap.get(num) + 1);            
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
            pq.add(entry);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
