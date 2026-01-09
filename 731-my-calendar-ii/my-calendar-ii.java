class MyCalendarTwo {
    TreeMap<Integer, Integer> map ;
    public MyCalendarTwo() {
        map = new TreeMap<>();//TreeMap stores in asc order reqd for sweep line technique
    }
    
    public boolean book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime, 0)+1);
        map.put(endTime, map.getOrDefault(endTime, 0)-1);
        int sum = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            sum = sum + e.getValue();
            if(sum>2){
                //undo the entry and return false
                map.put(startTime, map.get(startTime) - 1);
                // if(map.get(startTime)==0){
                //     map.remove(startTime);
                // }
                map.put(endTime, map.get(endTime) + 1);
                // if(map.get(endTime)==0){
                //     map.remove(endTime);
                // }
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */