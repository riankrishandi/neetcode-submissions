class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            tempMap.put(
                s.charAt(i), 
                tempMap.getOrDefault(s.charAt(i), 0) + 1
            );
        }

        // Validate.
        for (int j = 0; j < t.length(); j++) {
            Character c = t.charAt(j);
            Integer count = tempMap.get(c);
            if (count == null) {
                return false;
            }

            if (--count == 0) {
                tempMap.remove(c);
                continue;
            }
            tempMap.put(c, count);
        }

        if (tempMap.size() == 0) {
            return true;
        }
        return false;
    }
}
