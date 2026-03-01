class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[] freq = new int[26];

        for(int i = 0;i<len1; i++){
            freq[s1.charAt(i)-'a']++;
        }
        for(int i = 0;i<len2; i++){
            freq[s2.charAt(i)-'a']--;
            if(i-len1>=0)freq[s2.charAt(i-len1)-'a']++;
            if(allZeros(freq))return true;
        }
        return false;
    }
    private boolean allZeros(int[] freq){
        for(int i = 0;i<26; i++){
            if(freq[i]!=0)return false;
        }
        return true;
    }
}
