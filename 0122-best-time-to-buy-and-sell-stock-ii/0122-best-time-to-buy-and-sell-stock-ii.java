class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        // apporach : compare second day with first day if greater than sell it and add to profit 
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit = maxProfit + (prices[i] - prices[i - 1]);
            }
        }

        return maxProfit;
    }
}