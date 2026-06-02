class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        int[] steps = new int[]{1, 2};
        for (int i = 1; i <= n; i++) {
            for (var step : steps) {
                if (i - step >= 0) {
                    dp[i] = dp[i] + dp[i - step];
                }
            }
        }
        return dp[n];
    }
}
