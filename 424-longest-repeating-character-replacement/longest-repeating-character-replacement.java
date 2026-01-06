class Solution {
    public int characterReplacement(String s, int k) {
        //we are chasing at max k diff chars in the window
        int l = 0;
        int count = 0;
        int maxLength = 0;
        int maxCount = 0;
        int[] freq = new int[26];
        for(int r = 0;r<s.length(); r++){
            //I need to replace k chars
            //AABA -> B
            //for next B if I take it, the number of characters apart from leading becomes > k
            //So I need to maintain count of leading char
            //Number of minority chars = window Size - count of leading char
            freq[s.charAt(r)-'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(r)-'A']);
            //remaning elem count = r-l-maxCount+1
            while(r-l-maxCount+1>k){ //=> diff chars > k
                freq[s.charAt(l)-'A']--;
                l++;
            }
            maxLength = Math.max(maxLength, r-l+1);
        }
        return maxLength;
    }
}