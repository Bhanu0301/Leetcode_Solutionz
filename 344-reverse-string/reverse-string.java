class Solution {
    private void swap(char[] s, int left, int right){
        while(left<=right){
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
    public void reverseString(char[] s) {
        swap(s, 0, s.length-1);
    }
}