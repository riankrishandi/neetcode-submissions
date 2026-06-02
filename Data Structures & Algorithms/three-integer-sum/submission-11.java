class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                int res = nums[i] + nums[j] + nums[k];
                if (res < 0) {
                    j++;
                } else if (res > 0) {
                    k--;
                } else {
                    arr.add(List.of(nums[i], nums[j++], nums[k--]));
                    while(j < k && nums[j] == nums[j-1]) j++;
                }
            } 
        }
        return arr;
    }
}


// // -4, -1, -1, 0, 1, 2

// - 4, -1, 2 = -3
// - 4, 1, 2 = - 1
// -1, -1, 2 = OK
// -1, 0, 1 = OK
// 0

