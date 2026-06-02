class Solution {    
    List<List<String>> res = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        dfs(s, 0, 0);
        return res;
    }

    private void dfs(String s, int l, int r) {
        if (r >= s.length()) {
            if (l == r) res.add(new ArrayList<>(temp));
            return;
        }

        if (isPalindrome(s.substring(l, r+1))) {
            temp.add(s.substring(l, r+1));
            dfs(s, r+1, r+1);
            temp.remove(temp.size()-1);
        }

        dfs(s, l, r+1);
    }

    private boolean isPalindrome(String param) {
        int l = 0, r = param.length() - 1;
        while (l <= r) {
            if (param.charAt(l) != param.charAt(r)) return false;
            l++;
            r--;
        } 
        return true;
    }
}

