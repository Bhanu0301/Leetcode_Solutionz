class Solution {
    public int longestSubarray(int[] nums) {
        //longest subarray with max one 0
        int l = 0;
        int countZeros = 0;
        int maxLength = 0;
        for(int r = 0;r<nums.length; r++){
            if(nums[r]==0)countZeros++;
            while(countZeros>1){
                if(nums[l]==0)countZeros--;
                l++;
            }
            maxLength = Math.max(maxLength, r-l+1);
        }
        return maxLength-1;
    }
}