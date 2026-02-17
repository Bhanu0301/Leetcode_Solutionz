class Solution {
    private int climbStairsHelp(int currStep, int[] dp){
        if(currStep == 0|| currStep == 1)return 1;
        if(dp[currStep]!=-1)return dp[currStep];
        int oneStep = climbStairsHelp(currStep-1, dp);
        int twoSteps = climbStairsHelp(currStep-2, dp);

        return dp[currStep] = oneStep + twoSteps;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+2];
        Arrays.fill(dp,-1);
        return climbStairsHelp(n,dp);
    }
}
/*
//we can either take 1 step or 2 steps
//base case 
if(n==2||n==1||n==0)return n;
return climbStairs(n-1) + climbStairs(n-2);
*/ 