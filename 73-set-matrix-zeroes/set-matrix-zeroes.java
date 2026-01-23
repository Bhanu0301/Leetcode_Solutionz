class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length; 
        int m = matrix[0].length;

        boolean row = false;
        boolean col = false;
        //we will check the 0th row and col first
        for(int j = 0;j<m; j++){
            if(matrix[0][j] == 0){
                row = true; 
            }
        }
        for(int i = 0;i<n;i++){
            if(matrix[i][0] == 0){
                col = true;
            }
        }

        //now go through the rest of the matrix and set the corresponsing column and row starts to 0 as a sign of mark
        for(int i = 1;i<n;i++){
            for(int j = 1;j<m; j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //now check for 0th row and 0th cols and mark the corresponsing rows and cols to 0
        for(int i = 1; i<n; i++){
            if(matrix[i][0]==0){
                for(int j = 1;j<m; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 1;j<m; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i<n; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        //now let's cover the 0th row and col
        if(row){
            for(int i = 0;i<m;i++){
                matrix[0][i] = 0;
            }
        }
        if(col){
            for(int j=0;j<n;j++){
                matrix[j][0] = 0;
            }
        }
    }
}