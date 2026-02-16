class Solution {
    private int getProfit(int[] prices, int fee, int n, int ind, int buy, int[][] dp){
        if(ind==n)return 0;
        if(dp[ind][buy]!=-1)return dp[ind][buy];
        int profit = 0;
        if(buy == 0){
            profit = Math.max(0+getProfit(prices, fee,n,  ind+1, 0, dp),
                -prices[ind]+getProfit(prices, fee, n, ind+1, 1, dp));
        }
        else{
            profit = Math.max(0+getProfit(prices, fee,n,  ind+1, 1, dp),
                prices[ind]+getProfit(prices, fee, n, ind+1, 0, dp)-fee);
        }
        dp[ind][buy] = profit;
        return dp[ind][buy];
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        return (getProfit(prices, fee, n, 0, 0, dp));
    }
}