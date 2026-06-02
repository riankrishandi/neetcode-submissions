class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0, target);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> subset, int[] nums, int i, int left) {
        if (left <= 0) {
            if (left == 0) {
                res.add(new ArrayList<>(subset));
            }
            return;
        }
        if (i >= nums.length) return;
        
        // Add.
        subset.add(nums[i]);
        dfs(res, subset, nums, i, left - nums[i]);
        // Not add.
        subset.remove(subset.size() - 1);
        dfs(res, subset, nums, i + 1, left);
    }
}
