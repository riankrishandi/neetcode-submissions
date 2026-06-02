class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = l;
            // Expand right.
            while (r + 1 < s.length() && s.charAt(l) == s.charAt(r+1)) r++;
            
            // Expand left and right.
            while (l-1 >= 0 && r+1 < s.length() && s.charAt(l-1) == s.charAt(r+1)) {
                l--;
                r++;
            }

            if (r-l+1 > res.length()) {
                res = s.substring(l, r+1);
            }
        }
        return res;
    }
}
