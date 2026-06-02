class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> m = new HashMap<>();
        for (var num : nums) {
            if (m.containsKey(num)) return true;
            m.put(num, true);
        }
        return false;
    }
}