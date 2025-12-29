class Solution {
    public int findDuplicate(int[] nums) {
        //if we analyze this problem is similar to LL cycle 2 where we need to find the node where cycle starts
        int slow = nums[0];
        int fast = nums[0];
        //there is cycle for sure.
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        //now the met at a point , next step is to find their start point.
        fast = nums[0];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}