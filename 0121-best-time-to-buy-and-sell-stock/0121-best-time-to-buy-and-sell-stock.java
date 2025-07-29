class Solution {
    public int maxProfit(int[] prices) {
          // calling brute force appoarch
        // return bruteForceApporach(prices);

        // calling twoPointersApporach
        return twoPointersApporach(prices);
    }
        // we can solve this using brute force appoarach
    // time complexity: O(N^2)
    static int bruteForceApporach(int[] prices) {
        /*
         * apporach : buy one day stock and make difference rest of days profit=selling
         * price- buyed price
         */
        int maxProfit = 0;
        // outer loop
        for (int day = 0; day < prices.length; day++) {

            // inner loop
            for (int sellerDay = day + 1; sellerDay < prices.length; sellerDay++) {
                int profit = prices[sellerDay] - prices[day];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }

            }
        }
        return maxProfit;
    }

    // WE can solve this problem using two pointers apporach
    static int twoPointersApporach(int[] prices) {
        /*
         * Apporach : considder left=0 and right= 1
         * profit=right-left
         * if(right<left) : then update left = right
         * else : compare max profit with profit and update right
         */

        /*
         * NOTE: LEFT= BUY AND RIGHT=SELL
         * 
         */
        int left = 0;
        int maxProfit=0; // to store profit
        // right is travcerse each day no need to increment right
        for (int right = 1; right < prices.length; right++) {
            int profit = prices[right] - prices[left]; // calculating profit 

            // Checking if prices[right] is less than the prices[left] (selling < buyed price)
            if(prices[right]<prices[left]){ // if true then update  left with right 
                left=right;  

            }
            else{ // compare profit with max profit
                if(profit>maxProfit){
                    maxProfit=profit;
                }

            }

        }
        return maxProfit;
    }
}