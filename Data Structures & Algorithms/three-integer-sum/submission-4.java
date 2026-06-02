class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return new ArrayList<>(); 
        Arrays.sort(nums);

        // Create a map of nums.
        Map<Integer, Integer> map = new HashMap<>();
        for (var num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Loop through nums.
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            if (nums[i] > 0) break;

            int j=i+1, k=nums.length-1;
            while (j<k) {
                int gap=nums[i]+nums[j]+nums[k];
                if (gap < 0) {
                    j++;
                } else if (gap > 0) {
                    k--;
                } else {
                    res.add(List.of(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while(j<k && (nums[j]==nums[j-1] || nums[k]==nums[k+1])){
                        if (nums[j]==nums[j-1]) j++;
                        if (nums[k]==nums[k+1]) k--;
                    }
                }
            }
        }
        return res;
    }
}


