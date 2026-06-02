class Solution {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        results.add(new ArrayList<>());
        dfs(0, nums);
        return results;
    }

    public void dfs(int idx, int[] nums) {
        if (idx >= nums.length) return;
        
        temp.add(nums[idx]);
        results.add(new ArrayList<>(temp));
        
        // With.
        dfs(idx + 1, nums);
        // Without.
        temp.remove(temp.size() - 1);
        dfs(idx + 1, nums);
    }
}
