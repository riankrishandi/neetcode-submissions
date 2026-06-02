class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, 100 + 1);
        dp[0] = 0;
        dp[1] = 0;

        int[] steps = new int[]{1, 2};

        for (int i = 2; i <= cost.length; i++) {
            for (var step : steps) {
                dp[i] = Math.min(dp[i], cost[i-step] + dp[i - step]);
            }
        }
        return dp[cost.length];
    }
}
