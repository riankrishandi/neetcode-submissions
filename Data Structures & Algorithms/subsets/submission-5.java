class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());

        for (var num : nums) {
            int size = results.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(results.get(i));
                temp.add(num);
                results.add(temp);
            }
        }
        return results;
    }
}
