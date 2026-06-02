class Solution {
    public int characterReplacement(String s, int k) {        
        Map<Character, Integer> map = new HashMap<>(); 

        int l = 0, r = 0, kMax = 0, res = 0;
        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            kMax = Math.max(kMax, map.get(s.charAt(r)));

            // Adjust map.
            while ((r - l + 1) - kMax > k) {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }

            // Update res.
            res = Math.max(r - l + 1, res);
            r++;
        }
        return res;
    }
}
