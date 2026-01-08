class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> res = new LinkedList<>();
        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];
        //all intervals that end before new interval are always non-overlapping
        while(i<intervals.length && intervals[i][1]<start){
            res.add(intervals[i]);
            i++;
        }
        //overlapping until, end of new interval greater than start of other intervals
        while(i<intervals.length && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        //all rest intervals
        while(i<intervals.length){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[0][]);
    }
}