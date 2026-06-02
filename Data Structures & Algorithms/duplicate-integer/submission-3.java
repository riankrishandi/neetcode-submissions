class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> cache = new HashSet<>();
        for (var num : nums) {
            if (cache.contains(num)) return true;
            cache.add(num);
        }
        return false; 
    }
}