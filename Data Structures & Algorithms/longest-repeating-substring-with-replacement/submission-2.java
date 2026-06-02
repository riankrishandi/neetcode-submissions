class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;

        // Temporary variables.
        Map<Character, Integer> windowMap = new HashMap<>();
        int maxCharCount = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Update maxCharCount.
            var cCount = windowMap.getOrDefault(c, 0);
            maxCharCount = Math.max(maxCharCount, cCount+1);

            windowMap.computeIfAbsent(c, (key) -> 0);
            windowMap.put(c, cCount+1);
            
            if ((i - left + 1) - maxCharCount > k) {
                // Need to update the left.
                var currentLeft = s.charAt(left);
                var currentLeftCount = windowMap.get(currentLeft);

                // Reduce the map.
                windowMap.put(currentLeft, currentLeftCount - 1);
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
