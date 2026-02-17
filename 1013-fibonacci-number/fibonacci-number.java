class Solution {
    private int findFib(int n, int[] dp){
        if(n==0||n==1)return n;
        if(dp[n]!=-1)return dp[n];
        return dp[n]=findFib(n-1,dp)+findFib(n-2,dp);
    }
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return findFib(n, dp);
    }
}