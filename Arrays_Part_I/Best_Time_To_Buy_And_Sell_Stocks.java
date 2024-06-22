/*
    Problem Name: Best Time to Buy and Sell Stock
    Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
*/

public class Best_Time_To_Buy_And_Sell_Stocks {
    /*
        There is not brute, better, optimal solution for this, it's is a straight problem
        TC -> O(N)
        SC -> O(1)
    */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0, min = Integer.MAX_VALUE;
        for(int price: prices){
            min = Math.min(price, min);
            int profit = price - min;
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
    }
}
