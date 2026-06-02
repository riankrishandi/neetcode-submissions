class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int res = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            if (charMap.containsKey(s.charAt(r)) && charMap.get(s.charAt(r)) >= l) {
                l = charMap.get(s.charAt(r)) + 1;
            }
            charMap.put(s.charAt(r), r);
            res = Math.max(res, r-l+1);
            r++;
        }
        return res;
    }
}
