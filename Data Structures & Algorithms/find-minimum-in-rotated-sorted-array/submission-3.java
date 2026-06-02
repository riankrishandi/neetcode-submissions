class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[l] <= nums[mid] && nums[mid] <= nums[r]) return nums[l];
            if (nums[l] > nums[mid]) {
                r = mid; 
                continue;
            }
            l = mid + 1;
        }
        return nums[l];
    }
}
