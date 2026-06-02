class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> targetMap = new HashMap<>();
        for (var c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int currScore = 0, l = 0, r = 0;
        String res = "";
        while (r < s.length()) {
            // Get char.
            char c = s.charAt(r); 

            // Update window map and currScore.
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            // Update currScore.
            if (targetMap.containsKey(c) && targetMap.get(c).equals(windowMap.get(c))) {
                currScore++;
            }

            // Check condition. Adjust left.
            if (currScore == targetMap.size()) {
                while (l < r) {
                    char lChar = s.charAt(l);

                    // Add validation for break;
                    if (targetMap.containsKey(lChar) && windowMap.get(lChar) - 1 < targetMap.get(lChar)) {
                        break;
                    }

                    // Continue loop.
                    // Update map first.
                    windowMap.put(lChar, windowMap.get(lChar) - 1);
                    l++;
                }
                String sub = s.substring(l, r+1);
                if (res.equals("") || sub.length() < res.length()) {
                    res = sub;
                }
            }
            r++;
        }
        return res;
    }
}
