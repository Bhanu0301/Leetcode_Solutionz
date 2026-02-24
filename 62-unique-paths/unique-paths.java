class Solution {
    private int f(int r, int c, int m, int n, int[][] dp){
        if(r==m-1 && c==n-1){
            return 1;
        }
        if(r>m-1 || c>n-1)return 0;
        if(dp[r][c]!=-1)return dp[r][c];
        int right = f(r, c+1, m, n, dp);
        int down = f(r+1, c, m, n, dp);
        return dp[r][c] = right + down;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int r = m-1; r>=0; r--){
            for(int c = n-1; c>=0; c--){
                if(r==m-1 && c==n-1)dp[r][c] = 1;
                else{
                    int right = c<0? 0 : dp[r][c+1];
                    int down = r<0? 0 : dp[r+1][c];
                    dp[r][c] = right + down;
                }
            }
        }
        return dp[0][0];
    }
}