class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]!=0 || grid[n-1][m-1]!=0)return -1;
        int[][] dir = new int[][]{{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1},{1,0},{-1,0}};
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{0,0,1});
        vis[0][0] = true;
        while(!q.isEmpty()){
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            int dist = point[2];
            if(row==n-1 && col==m-1)return dist;
            for(int[] d : dir){
                int nrow = row + d[0];
                int ncol = col + d[1];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false
                && grid[nrow][ncol] == 0){
                    q.add(new int[]{nrow, ncol, dist+1});
                    vis[nrow][ncol] = true;
                }
            }
        }
        return -1;
    }
}