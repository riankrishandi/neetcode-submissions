class Solution {
    public int search(int[] nums, int target) {
        return bst(nums, target, 0, nums.length);
    }

    public int bst(int[] nums, int target, int start, int end) {
        if (end - start < 1) return -1;

        int mid = (start + end)/2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) return bst(nums, target, start, mid);
        else return bst(nums, target, mid+1, end);
    }
}
