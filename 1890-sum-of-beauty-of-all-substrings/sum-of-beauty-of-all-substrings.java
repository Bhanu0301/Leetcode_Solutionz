class Solution {
    public int beautySum(String s) {
        int ans = 0;
        for(int i = 0;i<s.length(); i++){
            int[] freq = new int[26];
            for(int j = i; j<s.length(); j++){
                freq[s.charAt(j)-'a']++;
                int min = getMinFreq(freq);
                int max = getMaxFreq(freq);
                ans = ans + (max - min);
            }
        }
        return ans;
    }
    private int getMinFreq(int[] freq){
        int minCount = Integer.MAX_VALUE;
        for(int i = 0;i<26; i++){
            if(freq[i]!=0)
                minCount = Math.min(freq[i], minCount);
        }
        return minCount;
    }
    private int getMaxFreq(int[] freq){
        int maxCount = Integer.MIN_VALUE;
        for(int i = 0;i<26; i++){
            if(freq[i]!=0)
                maxCount = Math.max(freq[i], maxCount);
        }
        return maxCount;
    }
}