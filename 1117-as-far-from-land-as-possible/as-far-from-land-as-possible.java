class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean vis[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j,0});//row,col,dist(or)level
                    vis[i][j]=true;
                }
            }
        }
        int[][] dir = new int[][]{{0,1},{-1,0},{1,0},{0,-1}};
        int maxDist = -1; //if no land or no water default return maxDist = 1
        while(!q.isEmpty()){
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            int dist = point[2];
            for(int[] d: dir){
                int nrow = row + d[0];
                int ncol = col + d[1];
                if(nrow>=0 && nrow<n && 
                ncol>=0 && ncol<m &&
                grid[nrow][ncol]==0 && vis[nrow][ncol]==false){
                    q.add(new int[]{nrow, ncol, dist+1});
                    vis[nrow][ncol] = true;
                    maxDist = Math.max(maxDist, dist+1);
                }
            }
        }
        return maxDist;
    }
}