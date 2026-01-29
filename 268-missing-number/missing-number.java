class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum1 = 0;
        for(int i = 0;i<nums.length; i++){
            sum1 = sum1 + nums[i];
        }
        int sum2 = (n * (n+1))/2;
        return sum2 - sum1;
    }
}