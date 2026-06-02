class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> subset, int[] candidates, int i, int rest) {
        if (rest <= 0) {
            if (rest == 0) res.add(new ArrayList<>(subset));
            return; 
        }
        if (i >= candidates.length) return;

        // include and add.
        subset.add(candidates[i]);
        dfs(res, subset, candidates, i+1, rest - candidates[i]);
        // exclude.
        subset.remove(subset.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i+1]) i++;
        dfs(res, subset, candidates, i+1, rest);
    }
}
