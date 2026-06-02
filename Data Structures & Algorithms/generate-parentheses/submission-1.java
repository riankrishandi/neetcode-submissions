class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        // Init list.
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        // Init n of 0.
        dp.get(0).add("");

        // Using bottom up.
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                for (var leftStr : dp.get(j)) {
                    for (var rightStr : dp.get(i-j-1)) {
                        dp.get(i).add("(" + leftStr + ")" + rightStr);
                    }
                }
            }
        }
        return dp.get(n);
    }
}
