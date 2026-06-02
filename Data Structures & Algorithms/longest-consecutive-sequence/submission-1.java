class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) continue;

            m.put(nums[i], 1 + m.getOrDefault(nums[i] - 1, 0) + m.getOrDefault(nums[i] + 1, 0));
            m.put(nums[i] - m.getOrDefault(nums[i] - 1, 0), m.get(nums[i]));
            m.put(nums[i] + m.getOrDefault(nums[i] + 1, 0), m.get(nums[i]));
            max = Math.max(max, m.get(nums[i]));
        }
        return max;
    }
}
