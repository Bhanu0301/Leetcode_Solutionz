class Solution {
    public int myAtoi(String s) {
        s = s.strip(); //remove trailing spaces

        if(s.isEmpty())return 0;
        int sign = s.charAt(0)=='-'?-1:1;
        long res = 0;
        if(s.charAt(0)=='-'||s.charAt(0)=='+')
            s = s.substring(1, s.length());

        for(int i= 0; i<s.length(); i++){
            if(!Character.isDigit(s.charAt(i)))break;
            int num = s.charAt(i) - '0';
            res = res*10 + num;

            if(sign*res>=Integer.MAX_VALUE)return Integer.MAX_VALUE;
            else if(sign*res<=Integer.MIN_VALUE)return Integer.MIN_VALUE;
        }
        return sign*(int)res;
    }
}