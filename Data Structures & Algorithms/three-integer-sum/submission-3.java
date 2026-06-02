class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
    
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
        
            int j = i+1, k = nums.length-1;
            while (j < k) {
                // Get the gap.
                int gap = nums[i] + nums[j] + nums[k];
                if (gap < 0) {
                    j++;
                } else if (gap > 0) {
                    k--;
                } else {
                    res.add((List.of(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) {
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
