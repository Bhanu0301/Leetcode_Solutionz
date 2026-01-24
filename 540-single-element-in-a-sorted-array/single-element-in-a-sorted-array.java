class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 2;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(mid%2==0){
                if(nums[mid]==nums[mid+1]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            else{
                if(nums[mid]==nums[mid+1]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
        }
        return nums[low];
    }
}