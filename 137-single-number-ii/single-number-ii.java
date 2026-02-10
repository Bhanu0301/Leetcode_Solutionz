class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        //idea -> 
        /* 
        1st time -> ones
        2nd time -> twos
        3rd time -> remove

        0^a = a, a^a = 0 --> this toggleness is used
        if(not present in ones, we can add (0^a=a))
        else(remove from ones and add in twos)(a^a=0)->ones
            (0^a)->twos
        */
        for(int num : nums){
            ones = (ones ^ num) & (~twos); 
            twos = (twos ^ num) & (~ones); //in twos if not in ones
        }
        return ones;
        // int res = 0;
        // for(int i = 0; i<32; i++){
        //     int sum = 0;
        //     for(int num : nums){
        //         //check if bit 'i' is set
        //         if(((num>>i)&1)==1){
        //             sum++;
        //         }
        //     }
        //     if(sum%3!=0){
        //         res = (res|(1<<i));
        //     }
        // }
        // return res;
    }
}