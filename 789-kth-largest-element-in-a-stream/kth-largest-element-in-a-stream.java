class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for(int num : nums){
            add(num);//this will handle to have top k elems in pq
        }
    }
    
    public int add(int val) {
        if(pq.size()<k){
            pq.add(val);
        }
        else if(pq.peek()<val){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */