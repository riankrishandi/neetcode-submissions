class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (temp.get(nums[i]) != null) {
                return true;
            }
            temp.put(nums[i], true);
        }
        return false;
    }
}
