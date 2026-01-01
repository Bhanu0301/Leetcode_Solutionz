class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isAlphabetic(c) || Character.isDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        int l = 0;
        int r = sb.length()-1;
        while(l<=r){
            if(sb.charAt(l++)!=sb.charAt(r--))
                return false;
        }
        return true;
    }
}