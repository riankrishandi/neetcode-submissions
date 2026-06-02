class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> tempMap = new HashMap<>();
        int lastIndex = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            Integer charIndex = tempMap.get(c);
            if (charIndex != null && charIndex >= lastIndex) {
                lastIndex = charIndex + 1;
            }

            // Update map.
            tempMap.put(c, i);
            max = Math.max(max, i - lastIndex + 1);
        }
        return max;
    }
}
