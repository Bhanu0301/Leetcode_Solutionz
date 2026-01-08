class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //sort on end times
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        //if an interval starts after prev end -> good interval
        int end = intervals[0][1];
        int count = 1;
        for(int i = 1;i<intervals.length; i++){
            if(end<=intervals[i][0]){
                count++;
                end = intervals[i][1]; //we update end of good interval only
            }
        }
        //bad overlapping interval = total length - good intervals
        return intervals.length - count;

    }
}