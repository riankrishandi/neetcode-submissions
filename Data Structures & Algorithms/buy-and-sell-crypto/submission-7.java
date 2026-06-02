class Solution {
    public int maxProfit(int[] prices) {
        int highestPrice = 0, maxProfit = 0;
        for (int i = prices.length - 1; i >= 0; i-- ) {
            highestPrice = Math.max(highestPrice, prices[i]);
            maxProfit = Math.max(maxProfit, highestPrice - prices[i]);
        }
        return maxProfit;
    }
}
