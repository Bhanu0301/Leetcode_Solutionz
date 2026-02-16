class Solution {
    private int getProfit(int[] prices, int n, int ind, int buy, int[][] dp){
        if(ind==n)return 0;
        if(dp[ind][buy]!=-1)return dp[ind][buy];
        int profit = 0;
        if(buy == 0){
            profit = Math.max(0+getProfit(prices,n,  ind+1, 0, dp),
                -prices[ind]+getProfit(prices, n, ind+1, 1, dp));
        }
        else{
            profit = Math.max(0+getProfit(prices,n,  ind+1, 1, dp),
                prices[ind]+getProfit(prices, n, ind+2, 0, dp));
        }
        dp[ind][buy] = profit;
        return dp[ind][buy];
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        for(int ind=n-1;ind>=0;ind--){
            for(int buy =0;buy<=1;buy++){
                int profit = 0;
                if(buy == 0){
                    profit = Math.max(0+dp[ind+1][0],
                        -prices[ind]+dp[ind+1][1]);
                }
                else{
                    profit = Math.max(0+dp[ind+1][1],
                        prices[ind]+dp[ind+2][0]);
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][0];
    }
}