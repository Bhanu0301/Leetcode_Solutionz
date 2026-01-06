class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1); //Imp step
        for(int i = 0;i<nums.length; i++){
            sum = sum + nums[i];
            int rem = sum - k;
            if(map.containsKey(rem)){
                count = count + map.get(rem);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}