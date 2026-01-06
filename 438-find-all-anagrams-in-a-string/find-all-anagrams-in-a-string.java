class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapP = new HashMap<>();
        for(char c : p.toCharArray()){
            mapP.put(c, mapP.getOrDefault(c,0)+1);
        }
        //since we are finding the anagram, I know the boundary is fixed to length of p
        int l = 0;
        int k = p.length(); //window

        for(int r = 0;r<s.length();r++){
            mapS.put(s.charAt(r),mapS.getOrDefault(s.charAt(r),0)+1);
            if(r-l+1==k){
                if(mapP.equals(mapS)){
                    ans.add(l);
                }
                mapS.put(s.charAt(l),mapS.get(s.charAt(l))-1);
                if(mapS.get(s.charAt(l))==0){
                    mapS.remove(s.charAt(l));
                }
                l++;
            }
            
        }
        return ans;
    }
}