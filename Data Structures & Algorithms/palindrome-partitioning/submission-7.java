class Solution {
    private List<List<String>> res = new ArrayList<>();
    private List<String> temp = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        recursive(s, 0, 0);
        return res;
    }

    public void recursive(String s, int l, int r) {
        if (r >= s.length()) {
            if (l == r) res.add(new ArrayList<>(temp));
            return;
        } 

        if (isPalindrome(s.substring(l, r+1))) {
            temp.add(s.substring(l, r+1));
            recursive(s, r+1, r+1);
            temp.remove(temp.size() - 1);
        }

        // Expand the r.
        recursive(s, l, r+1);
    }

    public boolean isPalindrome(String param) {
        int l = 0, r = param.length() - 1;
        while (l <= r) {
            if (param.charAt(l) != param.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
