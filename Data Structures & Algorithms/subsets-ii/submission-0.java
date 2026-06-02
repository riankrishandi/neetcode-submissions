class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        res.add(new ArrayList<>());

        if (nums == null) return res.stream().toList();
        Arrays.sort(nums);

        for (var num : nums) {
            Set<List<Integer>> newSet = new HashSet<>(res);
            for (var arr : res) {
                List<Integer> newArr = new ArrayList<>(arr);
                newArr.add(num);
                newSet.add(newArr);
            }
            res = newSet;
        }
        return res.stream().toList();
    }
}