// class Solution {
//     public String minWindow(String s, String t) {
//         //Frequency map for characters in t
//         Map<Character, Integer> targetFreq = new HashMap<>();
//         for (char c : t.toCharArray()) {
//             targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
//         }
//         //Number of unique characters required to match
//         int required = targetFreq.size();
//         //Left and right window pointers
//         int left = 0, right = 0;
//         //Tracks how many characters in current window match required frequency
//         int formed = 0;
//         //Frequency map for the current window
//         Map<Character, Integer> windowFreq = new HashMap<>();
//         //Minimum window length and starting index
//         int minLen = Integer.MAX_VALUE;
//         int minLeft = 0;
//         //Expand the window
//         while (right < s.length()) {
//             char c = s.charAt(right);
//             windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
//             // If character matches target frequency
//             if(targetFreq.containsKey(c) && windowFreq.get(c).intValue() == targetFreq.get(c).intValue()) {
//                 formed++;
//             }
//             // Try shrinking the window if all target characters matched
//             while (left <= right && formed == required) {
//                 if ((right - left + 1) < minLen) {
//                     minLen = right - left + 1;
//                     minLeft = left;
//                 }
//                 char leftChar = s.charAt(left);
//                 windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
//                 if (targetFreq.containsKey(leftChar) && windowFreq.get(leftChar) < targetFreq.get(leftChar)) {
//                     formed--;
//                 }
//                 left++;
//             }
//             right++;
//         }
//         return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
//     }
// }

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
        //Firstly we store all elem freq of string t
        for(int i = 0;i<t.length(); i++){
            freq[t.charAt(i)]++;
        }
        while(r<s.length() && l<=r){
            //check if curr elem of string s is part of string t
            //if yes count++;
            if(freq[s.charAt(r)]>0){
                count++;
            }
            //as you move forward freq of elem at 'r' of string s decrease
            freq[s.charAt(r)]--;

            //if count == t.length() => all elems of string t is present in window l to r
            while(count==t.length()){
                //update the window
                if(r-l+1<minLen){
                    minLen = r-l+1;
                    startIndex = l;
                }
                //decrease the window by pushing left to forward
                //once u reach freq of elem at 'l' == 0 => in prev 'freq[s.charAt(l++)]++;' elem at 'l' exhausted, now you have lost matching with t in next 'freq[s.charAt(l++)]++;'
                if(freq[s.charAt(l)]==0){
                    count--;
                }
                freq[s.charAt(l++)]++;
            }
            r++;
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(startIndex,startIndex+minLen);
    }
}