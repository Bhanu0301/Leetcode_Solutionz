class Solution {
    private int[] countZerosOnes(String str){
        int zeros = 0;
        int ones = 0;
        char[] strChars = str.toCharArray();
        for(char c : strChars){
            if(c=='0'){
                zeros++;
            }
        }
        ones = str.length() - zeros;
        return new int[]{zeros, ones};
    }
    private int helper(String[] strs, int m, int n, int ind, int[][][] dp){
        if(ind==strs.length)return 0;
        if(dp[ind][m][n]!=-1)return dp[ind][m][n];
        int[] count = countZerosOnes(strs[ind]);
        int z = count[0];
        int o = count[1];
        int take = 0;
        if(m>=z && n>=o)
            take = 1 + helper(strs, m-z, n-o, ind+1, dp);
        int notTake = helper(strs, m, n, ind+1, dp);
        return dp[ind][m][n] = Math.max(take, notTake);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        //each time we can either take or notTake the curr index str
        //if take ->1 + m = m - noOfZeros(strs[i]), n= n-noOfOnes(strs[i]), ind+1;
        //if notTake -> m = m, n=n, just ind+1
        int len = strs.length;
        int[][][] dp = new int[len+1][m+1][n+1];
        for(int i = 0; i<len+1; i++){
            for(int j = 0; j<m+1; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(strs, m, n, 0, dp);
    }
}