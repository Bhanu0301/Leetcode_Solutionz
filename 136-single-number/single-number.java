class Solution {
    public int singleNumber(int[] nums) {
        //a^a=0
        int ans = 0;
        for(int num : nums){
            ans = ans ^ num;
        }
        return ans;
    }
}