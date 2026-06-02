class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        // Validate if nums looks good.
        if (nums[0] > 0) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            
            int j = i+1, k = nums.length - 1;
            while (j < k) {
                int res = nums[i] + nums[j] + nums[k];
                if (res > 0) {
                    k--;
                } else if (res < 0) {
                    j++;
                } else {
                    list.add(List.of(nums[i], nums[j++], nums[k--]));
                    // Adjust j and k.
                    while (j < k && nums[j-1] == nums[j]) {
                        j++;
                    }
                    while (j < k && nums[k+1] == nums[k]) {
                        k--;
                    }
                }
            }            
        }
        return list;
    }
}
