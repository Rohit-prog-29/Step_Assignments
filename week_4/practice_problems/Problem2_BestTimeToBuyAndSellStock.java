/**
 * Week 4 Practice - Problem L2: Best Time to Buy and Sell Stock
 * Scenario: Investor optimizing stock profit in a single pass.
 * 
 * Tracks the lowest price seen so far and calculates maximum profit.
 */
public class Problem2_BestTimeToBuyAndSellStock {

    /**
     * Computes maximum profit from a single buy-sell transaction.
     * 
     * @param prices Daily stock prices
     * @return Maximum achievable profit (0 if prices only fall)
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Week 4 Practice - L2. Best Time to Buy & Sell Stock");
        System.out.println("==================================================");

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Input:  prices = [7, 1, 5, 3, 6, 4]");
        System.out.println("Output: " + maxProfit(prices1));

        System.out.println("--------------------------------------------------");

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Input:  prices = [7, 6, 4, 3, 1]");
        System.out.println("Output: " + maxProfit(prices2));

        System.out.println("==================================================\n");
    }
}
