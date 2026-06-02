class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (var num : nums) {
            List<List<Integer>> resNew = new ArrayList<>();
            for (var perm : res) {
                for (int i = 0; i <= perm.size(); i++) {
                    List<Integer> permNew = new ArrayList<>(perm);
                    permNew.add(i, num);
                    resNew.add(permNew);
                }
            }
            res = resNew;
        }
        return res;
    }
}