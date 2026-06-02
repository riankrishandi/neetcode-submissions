class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (var num : nums) {
            int currSize = res.size();
            for (int i = 0; i < currSize; i++) {
                List<Integer> newArr = new ArrayList<>(res.get(i));
                newArr.add(num);
                res.add(newArr);
            }
        }
        return res;
    }
}
