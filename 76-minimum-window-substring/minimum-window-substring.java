class Solution {
    public String minWindow(String s, String t) {
        if(s==null||t==null||s.length()==0||t.length()==0||s.length()<t.length())
            return new String();
        int l = 0;
        int r = 0;
        int[] freq = new int[256];
        int count = 0;
        int startIndex = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        for(int i = 0;i<t.length(); i++){
            freq[t.charAt(i)]++;
        }
        while(r<s.length() && l<=r){
            if(freq[s.charAt(r)]>0){
                count++;
            }
            freq[s.charAt(r++)]--;
            while(count==t.length()){
                if(r-l+1<minLen){
                    minLen = r-l+1;
                    startIndex = l;
                }
                
                if(freq[s.charAt(l)]==0){
                    count--;
                }
                freq[s.charAt(l++)]++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(startIndex,startIndex+minLen-1);
    }
}