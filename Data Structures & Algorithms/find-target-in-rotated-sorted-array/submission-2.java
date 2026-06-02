class Solution {
    // Use lower bound.
    public int search(int[] nums, int target) {
        // Find the deflection.
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l+r)/2;
            if (nums[l] <= nums[mid] && nums[mid] <= nums[r]) break;
            if (nums[l] > nums[mid]) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        System.out.println("Index 0: " + l);

        // l is the lowest.
        int sIdx = 0, eIdx = nums.length - 1;
        if (l > 0) {
            if (target <= nums[nums.length - 1]) {
                sIdx = l;
                eIdx = nums.length - 1;
            } else {
                sIdx = 0;
                eIdx = l-1;
            }
        }
        System.out.println("sIdx: " + sIdx);
        System.out.println("eIdx: " + eIdx);

        while (sIdx < eIdx) {
            int mid = (sIdx+eIdx)/2;
            if (nums[mid] == target) return mid;
            if (target > nums[mid]) {
                sIdx = mid + 1;
                continue;
            }
            eIdx = mid;
        }
        return nums[sIdx] == target ? sIdx : -1;
    }
}
