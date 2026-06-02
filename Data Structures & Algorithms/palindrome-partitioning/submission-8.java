class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> currPartition = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        dfs(s, 0, 0);
        return res;
    }

    public void dfs(String s, int l, int r) {
        if (r >= s.length()) {
            if (l == r) res.add(new ArrayList<>(currPartition));
            return;
        }

        // Create new partition.
        if (isPalin(s.substring(l, r+1))) {
            currPartition.add(s.substring(l, r+1));
            dfs(s, r+1, r+1);
            currPartition.remove(currPartition.size() - 1);
        }

        // Expand the current partition.
        dfs(s, l, r+1);        
    }

    public boolean isPalin(String s) {    
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

// if current palindrome, start new partition

// expand the size.
