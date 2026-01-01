class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int ptr = 0;
        int n = chars.length;

        while(i<n){
            char curr = chars[i];
            int count = 0;
            while(i<n && chars[i]==curr){
                count++;
                i++;
            }
            chars[ptr++] = curr;
            if(count!=1){
                for(char ch : Integer.toString(count).toCharArray()){
                    chars[ptr++] = ch;
                }
            }
        }
        return ptr;
    }
}