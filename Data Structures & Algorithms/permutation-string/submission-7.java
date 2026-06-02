class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        
        int[] count1 = new int[26], count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) matches++;
        }

        int l = 0, r = s1.length() - 1;
        while (r < s2.length()) {
            if (l == 0) {
                if (matches == 26) return true;
                l++;
                r++;
                continue;
            }

            // Update right.
            count2[s2.charAt(r) - 'a']++;
            if (count2[s2.charAt(r) - 'a'] == count1[s2.charAt(r) - 'a']) {
                matches++;
            } else if (count2[s2.charAt(r) - 'a'] == count1[s2.charAt(r) - 'a'] + 1) {
                matches--;
            }

            // Update left.
            count2[s2.charAt(l - 1) - 'a']--;
            if (count2[s2.charAt(l - 1) - 'a'] == count1[s2.charAt(l - 1) - 'a']) {
                matches++;
            } else if (count2[s2.charAt(l - 1) - 'a'] == count1[s2.charAt(l - 1) - 'a'] - 1) {
                matches--;
            }

            if (matches == 26) return true;
            l++;
            r++;
        }
        return false;
    }
}
