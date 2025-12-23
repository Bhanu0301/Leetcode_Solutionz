class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int stone: stones)
            pq.add(stone);

        while(pq.size()>1){
            int f = pq.poll();
            int s = pq.poll();
            if(f!=s){
                pq.add(f-s);
            }
        }
        return pq.size()==0?0:pq.poll();
    }
}