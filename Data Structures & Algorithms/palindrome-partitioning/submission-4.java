class Solution {
    private List<List<String>> res = new ArrayList<>();
    private List<String> part = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        dfs(0, 0, s);
        return res;
    }

    public void dfs(int l, int r, String s) {
        if (r >= s.length()) {
            if (l == r) res.add(new ArrayList<>(part));
            return;
        }

        if (isPalindrome(s.substring(l, r + 1))) {
            part.add(s.substring(l, r + 1));
            dfs(r + 1, r + 1, s);
            part.remove(part.size() - 1);
        }

        dfs(l, r + 1, s);
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

