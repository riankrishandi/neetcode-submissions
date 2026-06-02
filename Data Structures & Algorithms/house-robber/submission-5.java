class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i <= 1) {
                dp[i] = nums[i];
            }
            if (i - 2 >= 0) {
                dp[i] = Math.max(dp[i], nums[i] + dp[i-2]);
            }
            if (i - 1 >= 0) {
                dp[i] = Math.max(dp[i], dp[i-1]);
            }
        }
        return dp[nums.length - 1];
    }
}
