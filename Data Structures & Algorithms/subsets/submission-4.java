class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null) return res;
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> sub, int[] nums, int i) {
        if (i >= nums.length) return;

        sub.add(nums[i]);
        res.add(new ArrayList<>(sub));
        dfs(res, sub, nums, i+1);

        sub.remove(sub.size() - 1);
        dfs(res, sub, nums, i+1);
    }
}
