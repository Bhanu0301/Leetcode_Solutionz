class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i = 0;i<=heights.length; i++){
            int ht = (i==heights.length)?0:heights[i];
            while(!st.isEmpty() && heights[st.peek()]>ht){
                int h = heights[st.peek()];
                st.pop();
                int right = i;
                int left = st.isEmpty()?-1:st.peek();
                maxArea = Math.max(maxArea, (right - left-1)*h);
            }
            st.add(i);
        }
        return maxArea;
    }
}