class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 1; i<nums.length; i=i+2){
            ans = ans + Math.min(nums[i], nums[i-1]);
        }
        return ans;
    }
}