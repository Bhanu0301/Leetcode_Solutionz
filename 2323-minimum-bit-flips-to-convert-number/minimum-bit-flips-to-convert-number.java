class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        for(int i = 0;i<32; i++){
            if((start&1)!= (goal&1)){
                count++;
            }
            start = start>>>1;
            goal = goal>>>1;
        }
        return count;
        // int xor = (start^goal);
        // for(int i = 0;i<32; i++){
        //     if((xor&1)==1){
        //         count++;
        //     }
        //     xor = xor>>>1;
        // }
    }
}