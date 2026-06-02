class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add("");

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                for (var left : dp.get(j)) {
                    for (var right : dp.get(i - j - 1)) {
                        dp.get(i).add(String.format("(%s)%s", left, right));
                    }
                }
            }
        }
        return dp.get(n);
    }
}
