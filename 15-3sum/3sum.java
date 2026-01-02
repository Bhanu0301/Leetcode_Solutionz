class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2; i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum<0){
                    left++;
                }
                else if(sum>0){
                    right--;
                }
                else{
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    ans.add(triplet);
                    while(left<right && nums[left] == nums[left+1])left++;
                    while(left<right && nums[right] == nums[right-1])right--;
                    left++;
                    right--;
                }
            }
            while(i<nums.length-2 && nums[i]==nums[i+1])i++;
        }
        return ans;
    }
}