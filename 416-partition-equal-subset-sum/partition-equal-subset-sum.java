class Solution {
    private boolean helper(int[] nums, int target, int ind, int n, Boolean[][] dp){
        if(target==0)return true;
        if(ind==n || target<0)return false;
        if(dp[ind][target]!=null)return dp[ind][target];
        boolean take = helper(nums, target-nums[ind],ind+1,n, dp);
        boolean notTake = helper(nums, target, ind+1, n, dp);
        return dp[ind][target] = (take || notTake);
    }
    private boolean targetSum(int nums[], int target){
        int n = nums.length;
        Boolean[][] dp = new Boolean[n][target+1];
        // for(int arr[]: dp){
        //     Arrays.fill(arr, false);
        // }
        return helper(nums, target, 0, n, dp);
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