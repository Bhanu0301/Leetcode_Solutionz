class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //eat -> eat, tea, ate
        //tan -> tan, nat
        //bat -> bat
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());     
            }
            map.get(sortedStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}