class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int oranges = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<n; i++){
            for(int j = 0;j<m ;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i, j});
                }
                if(grid[i][j]!=0){
                    oranges++; //2s & 1s
                }
            }
        }
        if(oranges == 0) return 0;
        int count = 0; //oranges counter
        int minutes = 0;//minutes to make all rotten
        int[][] dir = new int[][]{{0,1},{-1,0},{1,0},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            count = count + size;
            for(int i = 0;i<size; i++){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                for(int[] d : dir){
                    int nrow = row + d[0];
                    int ncol = col + d[1];
                    if(nrow<n && nrow>=0 && ncol>=0 && ncol<m
                    && grid[nrow][ncol]==1){
                        grid[nrow][ncol] = 2;
                        q.add(new int[]{nrow, ncol});
                    }
                }
            }
            if(q.size()!=0)minutes++;
        }
        return (count==oranges)?minutes:-1;
    }
}