class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> tempMap = new HashMap<>();
        int maxLength = 0;
        int lastIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (tempMap.get(c) != null && tempMap.get(c) >= lastIdx) {
                lastIdx = tempMap.get(c) + 1;
            }
            tempMap.put(c, i);
            maxLength = Math.max(maxLength, i - lastIdx + 1);
        }
        return maxLength;
    }
}
