class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int i = 0;i<nums.length; i++)
            sum = sum + getContribution(nums[i]);
        return sum;
    }
    private int getContribution(int num){
        int count = 0;
        int sum = 0;
        for(int i = 1;i*i<=num; i++){
            if(num%i==0){
                if(i*i==num)count++;
                else count = count + 2;
                sum = sum + i;
                if(i*i!=num)sum = sum + num/i;
            }
        }
        return (count==4)?sum : 0;
    }
}