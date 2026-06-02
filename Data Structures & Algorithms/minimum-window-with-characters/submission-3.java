class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        // Target map.
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.computeIfAbsent(t.charAt(i), k -> 0);
            tMap.compute(t.charAt(i), (k, v) -> v + 1);
        }
        int tScore = tMap.size();

        String res = "";
        int l = 0, r = 0, wScore = 0;
        Map<Character, Integer> wMap = new HashMap<>();
        while (r < s.length()) {
            // Check the character if it is a part of t.
            // If no, then we can directly continue.
            if (!tMap.containsKey(s.charAt(r))) {
                r++;
                continue;
            }

            // Further handling.

            // Update the window map.
            // Check if wScore == tScore;
            wMap.computeIfAbsent(s.charAt(r), k -> 0);
            wMap.compute(s.charAt(r), (k, v) -> v+1);
            if (tMap.get(s.charAt(r)) == wMap.get(s.charAt(r))) wScore++;
            if (wScore < tScore) {
                r++;
                continue;
            }

            // Find the shortest substring by moving the l since wScore is equal to tScore;
            // Loop until wScore is not equal to tScore;
            while (l < r) {
                // Check if the l can be removed.
                // 1. is not in the tMap.
                // 2. impacting the wScore.
                if (!tMap.containsKey(s.charAt(l))) {
                    l++;
                    continue;
                }

                if (wMap.get(s.charAt(l)) - 1 >= tMap.get(s.charAt(l))) {
                    wMap.compute(s.charAt(l), (k, v) -> v - 1);
                    l++;
                    continue;
                }
                break;
            }

            // At the end, we can update our res or substring.
            if (res.equals("") || r - l + 1 < res.length()) {
                res = s.substring(l, r+1);
            }
            r++;
        }
        return res;
    }
}
