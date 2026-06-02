class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }

    public void dfs(String s, int charIdx, List<String> state, List<List<String>> res) {
        if (charIdx >= s.length()) {
            if (isPalindrome(state.get(state.size() - 1))) {
                res.add(new ArrayList<>(state));
            }
            return;
        }
        
        // Append new.
        if (
            state.isEmpty() 
                || isPalindrome(state.get(state.size() - 1))
        ) {
            state.add(String.valueOf(s.charAt(charIdx)));
            dfs(s, charIdx + 1, state, res);
            state.remove(state.size() - 1);
        }

        if (state.isEmpty()) {
            return;
        }

        // Add to last string in the state.
        state.set(state.size() - 1, state.get(state.size() - 1) + s.charAt(charIdx));
        dfs(s, charIdx + 1, state, res);
    }

    public boolean isPalindrome(String param) {
        if (param == null) return false;
        int l = 0, r = param.length() - 1;
        while (l <= r) {
            if (param.charAt(l) != param.charAt(r)) {
                return false;    
            }
            l++;
            r--;
        }
        return true;
    }
}
