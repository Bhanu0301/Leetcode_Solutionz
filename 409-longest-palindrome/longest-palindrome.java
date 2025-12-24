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
    // also check this solution : https://leetcode.com/problems/longest-palindrome/solutions/89604/simple-hashset-solution-java-by-charlieb-8z2c/
}