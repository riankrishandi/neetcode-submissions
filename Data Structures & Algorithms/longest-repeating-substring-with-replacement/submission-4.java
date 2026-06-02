class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> counter = new HashMap<>();
        int l = 0, r = 0, frequent = 0, res = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            counter.put(c, counter.getOrDefault(c, 0) + 1);

            // Update frequent.
            frequent = Math.max(frequent, counter.get(c));

            // Check condition fulfill or not.
            int currSize = r - l + 1;
            if (currSize - frequent <= k) {
                res = Math.max(res, currSize);
            } else {
                char lChar = s.charAt(l);
                counter.put(lChar, counter.get(lChar) - 1);
                l++;
            }
            r++;
        }
        return res;
    }
}
