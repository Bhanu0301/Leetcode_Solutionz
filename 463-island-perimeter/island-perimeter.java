class Solution {
    private int count = 0;
    public int islandPerimeter(int[][] grid) {
        if(grid == null)return 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length; i++){
            for(int j = 0;j<grid[0].length; j++){
                if(grid[i][j]==1)
                    //we return from here itself as we have only one land, it can be covered at once
                    return getPerimeter(grid, i, j, vis);
            }
        }
        return 0;
    }
    private int getPerimeter(int[][] grid, int  row, int col, boolean[][] vis){
        //we get a boundary only if the adjacent is a end or is surrounder by 0(water)
        if(row<0 || col>grid[0].length-1 || col<0 || row>grid.length-1){
            return 1;
        }
        if(grid[row][col]==0){
            return 1;
        }
        if(vis[row][col] == true){
            return 0;
        }
        vis[row][col] = true;
        int perimeter = 0;
        perimeter = perimeter + getPerimeter(grid, row+1, col,vis);
        perimeter = perimeter + getPerimeter(grid, row-1, col,vis);
        perimeter = perimeter + getPerimeter(grid, row, col+1,vis);
        perimeter = perimeter + getPerimeter(grid, row, col-1,vis);
        return perimeter;
    }

}