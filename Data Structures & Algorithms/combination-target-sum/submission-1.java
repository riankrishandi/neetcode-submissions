class Solution {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return results;
    }

    public void dfs(int[] nums, int target, int total, int idx) {
        if (total == target) {
            results.add(new ArrayList<>(temp));
            return;
        }
        if (total > target || idx >= nums.length) return;

        // With.
        temp.add(nums[idx]);
        dfs(nums, target, total + nums[idx], idx);
        // Without.
        temp.remove(temp.size() - 1);
        dfs(nums, target, total, idx + 1);
    }
}
