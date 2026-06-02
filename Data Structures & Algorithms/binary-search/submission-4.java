class Solution {
    public int search(int[] nums, int target) {
        return bst(nums, target, 0, nums.length);
    }

    public int bst(int[] nums, int target, int startIdx, int endIdx) {
        if (endIdx - startIdx < 1) return -1;
        int midIdx = (startIdx + endIdx) / 2;
        if (nums[midIdx] == target) return midIdx;
        if (nums[midIdx] > target) return bst(nums, target, startIdx, midIdx);
        return bst(nums, target, midIdx+1, endIdx);
    }
}
