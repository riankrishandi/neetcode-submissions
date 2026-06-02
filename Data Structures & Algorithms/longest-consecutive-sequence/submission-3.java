class Solution {

    Map<Integer, Integer> m = new HashMap<>();

    public int longestConsecutive(int[] nums) {
        int max = 0;
        for (var num : nums) {
            if (m.containsKey(num)) continue;
            
            // Handle target.
            m.put(num, 1 + m.getOrDefault(num - 1, 0) + m.getOrDefault(num + 1, 0));
            // Handle left.
            m.put(num - m.getOrDefault(num - 1, 0), m.get(num));
            // Handle right.
            m.put(num + m.getOrDefault(num + 1, 0), m.get(num));

            max = Math.max(max, m.get(num));
        }
        return max;
    }

    // 1 2 3 
    // 2 2
}
