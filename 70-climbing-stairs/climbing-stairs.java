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
        dp[0]=1;
        dp[1]=1;
        for(int i = 2;i<=n;i++){
            int oneStep = dp[i-1];
            int twoSteps = dp[i-2];
            dp[i] = oneStep + twoSteps;
        }
        return dp[n];
    }
}
/*
//we can either take 1 step or 2 steps
//base case 
if(n==2||n==1||n==0)return n;
return climbStairs(n-1) + climbStairs(n-2);
*/ 