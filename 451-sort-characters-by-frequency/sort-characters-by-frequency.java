class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->{
            if(map.get(a)==map.get(b)){
                return a.compareTo(b);
            }
            return map.get(b)-map.get(a);
        });
        for(Character c : map.keySet()){
            pq.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(String.valueOf(pq.peek()).repeat(map.get(pq.poll())));
        }
        return sb.toString();
    }
}