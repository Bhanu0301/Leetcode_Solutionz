class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i<32; i++){
            int sum = 0;
            for(int num : nums){
                //check if bit 'i' is set
                if(((num>>i)&1)==1){
                    sum++;
                }
            }
            if(sum%3!=0){
                res = (res|(1<<i));
            }
        }
        return res;
    }
}