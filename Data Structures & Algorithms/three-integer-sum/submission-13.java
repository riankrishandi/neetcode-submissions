class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        int i = 0;
        int iMaxIdx = nums.length - 2;
        
        if (nums[i] > 0 || nums[nums.length - 1] < 0) return res;
        while (i < iMaxIdx) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) {
                i++;
                continue;
            }


            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int calc = nums[i] + nums[left] + nums[right];
                if (calc > 0) {
                    right--;
                } else if (calc < 0) {
                    left++;
                } else {
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    while(nums[left] == nums[left-1] && left < right) left++; 
                }
            }
            i++;
        }
        return res;
    }
}


// -4, -1, -1, 0, 1, 2

// start with i then loop through i + 1 and size of the array - 1
// loop the inner with:
// i < j and i > 0