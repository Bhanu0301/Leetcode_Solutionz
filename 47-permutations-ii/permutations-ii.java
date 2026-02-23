
class Solution {
    private void permutations(int[] nums, List<List<Integer>> ans, List<Integer> list, boolean[] used){
        int n = nums.length;
        if(list.size()==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(i>0 && nums[i-1]== nums[i] && used[i-1]==false)continue;
            if(!used[i]){
                used[i] = true;
                list.add(nums[i]);
                permutations(nums, ans, list, used);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
    }
    public List<List<Integer>>  permuteUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[n];
        permutations(nums, ans, list, used);
        return ans;
    }
}