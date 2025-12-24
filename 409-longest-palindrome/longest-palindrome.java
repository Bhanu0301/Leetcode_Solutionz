class Solution {
    public int longestPalindrome(String s) {
        int freq[] = new int[256];

        for(char c : s.toCharArray()){
            freq[c]++;
        }
        int maxLen = 0;
        boolean hasOdd = false;
        for(int count : freq){
            if(count%2 == 0){
                maxLen = maxLen + count;
            }
            else{
                hasOdd = true;
                maxLen = maxLen + (count-1);
            }
        }
        return hasOdd==true?maxLen+1:maxLen;
    }
}