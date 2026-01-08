class Solution {
    public int[][] merge(int[][] intervals) {
        //sort on start time
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        //initial start and end
        int start = intervals[0][0];
        int end = intervals[0][1];
        ArrayList<int[]> ans = new ArrayList<>();
        for(int i = 1; i<intervals.length; i++){
            int starti = intervals[i][0];
            int endi = intervals[i][1];
            //overlapping
            if(end>=starti){
                end = Math.max(endi, end);
            }
            //not overlapping
            else{
                ans.add(new int[]{start, end});
                start = starti;
                end = endi;
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[0][]);
    }
}