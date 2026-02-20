class Solution {
    private boolean targetSum(int nums[], int target){
        int n = nums.length;
        
        boolean[][] dp = new boolean[n+1][target+1];
        for(int i = 0;i<n; i++){
            dp[i][0] = true;
        }
        for(int ind = n-1;ind>=0; ind--){
            for(int sum = 1;sum<=target; sum++){
                boolean take = false;
                if(nums[ind]<=sum)take = dp[ind+1][sum-nums[ind]];
                boolean notTake = dp[ind+1][sum];
                dp[ind][sum] = (take || notTake);
            }
        }
        return dp[0][target];
    }
    public boolean canPartition(int[] nums) {
        //It is target sum where target = sum(nums)-sum(nums)/2;
        int sum = 0;
        for(int i = 0;i<nums.length; i++){
            sum = sum + nums[i];
        }
        if(sum%2!=0)return false; //odd sum array can never be equally partitioned
        int target = sum/2;
        return targetSum(nums, target);
    }
}