class Solution {
    public boolean hasAlternatingBits(int n) {
        //alternate bits -> 1010, shift bit to right by 1 0101, now XOR them u get all 1111--> 10000 & 01111 = 0
        int mask = n>>1;
        int a = (n ^ mask);
        int b = a+1;
        return (a&b)==0;
    }
}