class Solution {
    public String reverseWords(String s) {
        String[] strArray = s.trim().split("\\s+");
        String sb = new String();
        for(int i = 0;i<strArray.length; i++){
            if(i==0){
                sb = strArray[i] + sb;
            }
            else{
                sb = strArray[i] + " " + sb;
            }
        }
        return sb.substring(0,sb.length());
    }
}