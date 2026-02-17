class Solution {
    public int climbStairs(int n) {
        int prev2=1;
        int prev1=1;
        int curr=0;
        for(int i = 2;i<=n;i++){
            curr = prev2 + prev1;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
/*
//we can either take 1 step or 2 steps
//base case 
if(n==2||n==1||n==0)return n;
return climbStairs(n-1) + climbStairs(n-2);
*/ 