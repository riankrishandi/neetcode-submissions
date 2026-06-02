class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, max = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            if (prices[i] > max) continue;
            profit = Math.max(profit, max-prices[i]);
        }
        return profit;
    }
}
