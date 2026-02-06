class Solution {
    private void dfs(int[][] grid, int row, int col, int n, int m){
        grid[row][col]=0;
        int[][] dir = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        for(int[] d : dir){
            int nrow = row + d[0];
            int ncol = col + d[1];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol] == 1){
                dfs(grid, nrow, ncol, n, m);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        //we start from boundaries
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<n ;i++){
            for(int j = 0;j<m; j++){
                if((i==0||j==0||i==n-1||j==m-1) && grid[i][j]==1){
                    dfs(grid, i, j, n, m);
                }
            }
        }
        int count = 0;
        //now check the unvisited 1's
        for(int i = 0;i<n; i++){
            for(int j = 0;j<m; j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}