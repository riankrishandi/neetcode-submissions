class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, res, new ArrayList<>(), 0, target);
        return res;
    }

    public void dfs(int[] candidates, List<List<Integer>> res, List<Integer> sub, int i, int remaining) {
        if (remaining == 0) {
            res.add(new ArrayList<>(sub));
            return;
        }
        if (remaining < 0 || i >= candidates.length) return;

        // Add.
        sub.add(candidates[i]);
        dfs(candidates, res, sub, i+1, remaining - candidates[i]);
        // No add.
        sub.remove(sub.size() - 1);
        while (i + 1 < candidates.length && candidates[i] == candidates[i+1]) {
            i++;
        }
        dfs(candidates, res, sub, i + 1, remaining);
    }
}
