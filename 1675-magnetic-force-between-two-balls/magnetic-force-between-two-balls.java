class Solution {
    private boolean isPossible(int[] position, int m, int dist){
        int count = 1;
        int prev = 0;
        for(int i = 0;i<position.length; i++){
            if(position[i]-position[prev]>=dist){
                prev = i;
                count++;
            }
        }
        return count>=m;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length-1]-position[0];
        int ans = 0;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(isPossible(position, m, mid)){
                ans = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return ans;
    }
}