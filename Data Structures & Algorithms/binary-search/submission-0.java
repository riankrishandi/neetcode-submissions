class Solution {
    public int search(int[] nums, int target) {
        return bst(nums, target, 0, nums.length);
    }

    public int bst(int[] nums, int target, int sIdx, int eIdx) {
        // Break point.
        if (eIdx - sIdx < 2) {
            return nums[sIdx] == target ? sIdx : -1;
        }

        int mIdx = (sIdx + eIdx)/2;
        if (target > nums[mIdx]) return bst(nums, target, mIdx, eIdx);
        else if (target < nums[mIdx]) return bst(nums, target, sIdx, mIdx);
        return mIdx;
    }
}
