class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer curr = counter.getOrDefault(nums[i], 0);
            counter.put(nums[i], curr + 1);
        }

        int[] res = new int[k];
        int i = 0; 
        while (i < k) {
            Integer max = null;
            Integer number = null;
            for (var entry : counter.entrySet()) {
                if (max == null) {
                    max = entry.getValue();
                    number = entry.getKey();
                    continue;
                }

                if (entry.getValue() > max) {
                    max = entry.getValue();
                    number = entry.getKey();
                }
            }
            counter.remove(number);
            res[i] = number;
            i++;
        }
        return res;
    }
}
