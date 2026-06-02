class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int l = 0, r = l, max = 0;
        while (r < s.length()) {
            Integer idx = m.get(s.charAt(r));
            if (idx != null && idx >= l) {
                l = idx + 1;
            }
            m.put(s.charAt(r), r);
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
