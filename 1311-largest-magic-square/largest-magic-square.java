class Solution {
    private boolean isValid(int i, int j, int k, int[][] grid){
        //it is valid if rowSum = colSum = diagSum

        int sum = 0;
        //rows
        //we will check if all rows sum is same or not
        for(int row = i; row<i+k; row++){
            int rowSum = 0;
            for(int ind = j; ind<j+k; ind++){
                rowSum = rowSum + grid[row][ind];
            }
            if(row == i)sum = rowSum;
            else if(sum!=rowSum)return false;
        }

        //col
        for(int col = j; col<j+k; col++){
            int colSum = 0;
            for(int ind = i; ind< i+k; ind++){
                colSum = colSum + grid[ind][col];
            }
            if(sum!=colSum)return false;
        }

        //left to right diagonal
        int diagSum = 0;
        for(int ind = 0; ind<k; ind++){
            diagSum = diagSum + grid[i+ind][j+ind];
        }
        if(diagSum!=sum)return false;
        //right to left
        int revdiagSum = 0;
        for(int ind = 0; ind<k; ind++){
            revdiagSum = revdiagSum + grid[i+ind][j+k-1-ind];
        }
        if(revdiagSum!=sum)return false;

        return true;
    }
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        //since we need the largest magic square and max we can have is Min(n, m), start here
        for(int k = Math.min(n,m); k>=2; k--){
            for(int i = 0;i+k <=n ; i++){
                for(int j = 0; j+k<=m ; j++){
                    if(isValid(i, j, k, grid)) return k;
                }
            }
        }
        return 1;
    }
}