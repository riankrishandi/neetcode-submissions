class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            // Check i.
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            // Check j.
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            // Check if they are same.
            if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) return false;
        }
        return true;
    }
}
