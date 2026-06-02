class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() > s.length()) return "";

        // Count target.
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int targetScore = targetMap.size();

        String res = "";
        Map<Character, Integer> windowMap = new HashMap<>();
        int windowScore = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            // Get window character.
            Character windowChar = s.charAt(r);

            // Update window map.
            windowMap.put(windowChar, windowMap.getOrDefault(windowChar, 0) + 1);
            
            // Direct continue if char is not in the target.
            if (!targetMap.containsKey(windowChar)) {
                r++;
                continue;
            }

            // Update window score.
            if (windowMap.get(windowChar).equals(targetMap.get(windowChar))) {
                windowScore++;
            }

            // Check if window score already equals to target score.
            if (windowScore == targetScore) {
                // Trim l.
                while (l <= r) {
                    Character leftChar = s.charAt(l);
                    if (!targetMap.containsKey(leftChar)) {
                        windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                        l++;
                        continue;
                    }
                    if ((windowMap.get(leftChar) - 1) < targetMap.get(leftChar)) {
                        break;
                    }
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                    l++;
                }
                if (r - l + 1 < res.length() || res.equals("")) {
                    res = s.substring(l, r+1);
                }
            }
            r++;
        }
        return res;
    }
}
